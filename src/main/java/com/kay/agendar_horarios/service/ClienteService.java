package com.kay.agendar_horarios.service;

import com.kay.agendar_horarios.entity.Cliente;
import com.kay.agendar_horarios.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
