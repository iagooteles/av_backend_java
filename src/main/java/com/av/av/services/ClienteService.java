package com.av.av.services;

import java.util.List;
import java.util.Optional;

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

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientesListados = clienteRepository.findAll();
        return clientesListados.stream()
                               .map(this::toDTO)
                               .toList();
    }

    public Optional<ClienteDTO> buscarPortId(Long id) {
        return clienteRepository.findById(id).map(this::toDTO);
    }

    public ClienteDTO criarCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return toDTO(clienteSalvo);
    }

    public ClienteDTO atualizarCliente(Long id, Cliente updatedCliente) {
        return clienteRepository.findById(id)
                .map( cliente -> {
                    cliente.setNome(updatedCliente.getNome());
                    cliente.setCpf(updatedCliente.getCpf());
                    cliente.setEmail(updatedCliente.getEmail());
                    cliente.setDataNascimento(updatedCliente.getDataNascimento());
                    cliente.setEndereco(updatedCliente.getEndereco());
                    cliente.setTelefone(updatedCliente.getTelefone());
                    cliente.setSenha(updatedCliente.getSenha());

                    Cliente clienteSaved = clienteRepository.save(cliente);
                    return toDTO(clienteSaved);

                }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
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
