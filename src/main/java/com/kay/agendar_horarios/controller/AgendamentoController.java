package com.kay.agendar_horarios.controller;

import com.kay.agendar_horarios.service.AgendamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    AgendamentoService agendamentoService;

    //métodos que iram chamar o service para processar e validadar daods + retornar para "Status Code" do agendamentos
    // [ResponseEntity - 200 ,201 , 403 , 404 ,501... ]
}
