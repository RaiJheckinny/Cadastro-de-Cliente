package br.com.raijheckinny.service;

import br.com.raijheckinny.domain.Cliente;
import br.com.raijheckinny.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void alterarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscarTodosCliente() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
