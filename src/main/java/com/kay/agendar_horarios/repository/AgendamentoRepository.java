package com.kay.agendar_horarios.repository;

import com.kay.agendar_horarios.entity.Agendamento;
import com.kay.agendar_horarios.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    //fazer métodos de busca especifica [findByServicoHoraAgendamento],[deletarbyAgendamento],[findByAgengementos],[findAgendamentoCliente]

    Agendamento findByServicoHoraAgendamento(LocalDateTime horaAgendamento,LocalDateTime fimHoraAgendamento,String servico);

    @Transactional
    void deletarbyAgendamento (Long id);

    //List<Agendamento> findByAgengementos(LocalDateTime horaAgendamento,LocalDateTime fimHoraAgendamento);

    Agendamento findbyAgendamentoCliente (Agendamento agendamento , Cliente cliente);
}
