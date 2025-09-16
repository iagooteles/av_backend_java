package com.av.av.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.av.av.dto.ClienteDTO;
import com.av.av.entity.Cliente;
import com.av.av.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> listarTodosClientes() {
        List<Cliente> clientesListados = clienteRepository.findAll();
        return clientesListados.stream()
                               .map(this::toDTO)
                               .toList();
    }

    public ClienteDTO salvarCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return toDTO(clienteSalvo);
    }



    // outros métodos 

    
    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setEmail(cliente.getEmail());
        dto.setDataNascimento(cliente.getDataNascimento());
        dto.setEndereco(cliente.getEndereco());
        dto.setTelefone(cliente.getTelefone());

        return dto;
    }
}
