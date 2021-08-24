package br.com.example.api.service;

import br.com.example.api.entity.Cliente;
import br.com.example.api.repository.ClienteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listClient() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void deleteId(Long id) {
        clienteRepository.deleteById(id);
    }

}
