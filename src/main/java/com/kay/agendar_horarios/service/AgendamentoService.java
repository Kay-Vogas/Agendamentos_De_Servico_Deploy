package com.kay.agendar_horarios.service;

import com.kay.agendar_horarios.entity.Agendamento;
import com.kay.agendar_horarios.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    //métodos de regra de negócio[salvar+validação de dados , deletar , buscar e alterar]

    public Agendamento salvarAgendamento(Agendamento agendamento) {

        LocalDateTime horaInicioAgendada = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFimAgendada = agendamento.getDataHoraAgendamento();


        Agendamento agendados = agendamentoRepository.findByServicoHoraAgendamento(horaInicioAgendada,horaFimAgendada,agendamento.getServico());

        if(agendados.equals(agendamento)) {
            throw new RuntimeException("Este horário já está marcado!!");
        }

        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(Agendamento agendamento) {
         agendamentoRepository.delete(agendamento);
    }

    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }


}
