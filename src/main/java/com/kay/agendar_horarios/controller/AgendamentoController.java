package com.kay.agendar_horarios.controller;

import com.kay.agendar_horarios.entity.Agendamento;
import com.kay.agendar_horarios.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    //métodos que iram chamar o service para processar e validadar daods + retornar para "Status Code" do agendamentos
    // [ResponseEntity - 200 ,201 , 403 , 404 ,501... ]

    @PostMapping("/agendar")
    public ResponseEntity<Agendamento> agendarAgendamento (@RequestBody Agendamento agendamento) {

        try{
            return ResponseEntity.ok(agendamentoService.salvarAgendamento(agendamento));
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAgendamento (@PathVariable Long id) {

        if(agendamentoService.findByIdAgendamento(id) == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            agendamentoService.deletarAgendamento(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@RequestBody Agendamento agendamento) {

        //Agendamento agendamentoEncontrado = agendamentoService.findByIdAgendamento(id);
        
        try{
            return atualizarAgendamento(agendamentoService.salvarAgendamento(agendamento));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/agendados")
    public ResponseEntity<List<Agendamento>> listarAgendados() {
        try{
            return ResponseEntity.ok(agendamentoService.listarAgendamentosAgendados());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
