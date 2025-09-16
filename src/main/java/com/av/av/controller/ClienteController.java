package com.av.av.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Optional<ClienteDTO> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPortId(id);
    }

    @PostMapping("/")
    public ClienteDTO criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }
    
}
