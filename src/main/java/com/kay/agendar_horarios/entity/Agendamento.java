package com.kay.agendar_horarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String servico;
    private String profissional;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime fimHoraAgendamento;

    @ManyToOne
    private Cliente cliente;
    private String telefoneCliente = cliente.getTelefone();

    private LocalDateTime dataDoAgendamento = LocalDateTime.now();

}
