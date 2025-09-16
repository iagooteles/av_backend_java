package com.av.av.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av.av.dto.ClienteDTO;
import com.av.av.entity.Cliente;
import com.av.av.services.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarTodosClientes();
    }

    @PostMapping("/")
    public ClienteDTO salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }
}
