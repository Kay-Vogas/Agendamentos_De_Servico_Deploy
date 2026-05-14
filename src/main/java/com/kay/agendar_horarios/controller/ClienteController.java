package com.kay.agendar_horarios.controller;

import com.kay.agendar_horarios.entity.Cliente;
import com.kay.agendar_horarios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registar")
    public ResponseEntity<Cliente> salvarCliente(Cliente cliente){
        try{
            return ResponseEntity.ok(clienteService.salvarCliente(cliente));
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
