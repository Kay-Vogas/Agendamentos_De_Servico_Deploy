package com.kay.agendar_horarios.service;

import com.kay.agendar_horarios.entity.Agendamento;
import com.kay.agendar_horarios.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public void deletarAgendamento(Long id) {
        agendamentoRepository.deletarbyAgendamento(id);
    }

    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarAgendamentosAgendados() {
        return agendamentoRepository.findAll();
    }

    public Boolean findByIdAgendamento(Long id) {
        return agendamentoRepository.findById(id).isPresent();
    }


}
