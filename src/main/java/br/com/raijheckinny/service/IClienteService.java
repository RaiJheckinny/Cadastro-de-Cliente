package br.com.raijheckinny.service;

import br.com.raijheckinny.domain.Cliente;

import java.util.List;

public interface IClienteService {
    public void cadastrarCliente(Cliente cliente);
    public void alterarCliente(Cliente cliente);
    public void excluirCliente(Long id);
    public List<Cliente> buscarTodosCliente();
    public Cliente buscarClientePorId(Long id);
}
