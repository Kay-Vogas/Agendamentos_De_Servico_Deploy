package com.kay.agendar_horarios.controller;

import com.kay.agendar_horarios.entity.Agendamento;
import com.kay.agendar_horarios.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    AgendamentoService agendamentoService;

    //métodos que iram chamar o service para processar e validadar daods + retornar para "Status Code" do agendamentos
    // [ResponseEntity - 200 ,201 , 403 , 404 ,501... ]

    @PostMapping("/agendar")
    public ResponseEntity<Agendamento> agendarAgendamento (@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAgendamento (@PathVariable Long id) {

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

        return atualizarAgendamento(agendamentoService.salvarAgendamento(agendamento));
    }


}
