package br.com.raijheckinny;

import br.com.raijheckinny.domain.Cliente;
import br.com.raijheckinny.service.ClienteService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ClienteTest {

	@Autowired
	ClienteService clienteService;

	Cliente cliente;
	Cliente cliente2;


	@BeforeEach
	public void init() {
		// Inicializando dados do cliente para cada teste
		cliente = new Cliente();
		cliente.setNome("Raijheckinny");
		cliente.setCpf(11231123L);
		cliente.setTel(23422443L);
		cliente.setEmail("admin@admin.com");
		cliente.setEndereco("Roberto Carlos");
		cliente.setNumero(12L);
		cliente.setCidade("São Paulo");
		cliente.setEstado("São Paulo");

		cliente2 = new Cliente();
		cliente2.setNome("Lucas");
		cliente2.setCpf(32112312L);
		cliente2.setTel(24234443L);
		cliente2.setEmail("root@admin.com");
		cliente2.setEndereco("Luam Santana");
		cliente2.setNumero(87L);
		cliente2.setCidade("Rio Janeiro");
		cliente2.setEstado("Rio Janeiro");
	}

	@Test
	@Transactional
	public void cadastroDeClienteTest() {
		// Cadastro do cliente
		clienteService.cadastrarCliente(cliente);

		// Verificação se o cliente foi salvo corretamente no banco
		Cliente clienteBD = clienteService.buscarClientePorId(cliente.getId());
		Assertions.assertNotNull(clienteBD, "O cliente deve ser encontrado no banco de dados após cadastro.");
		Assertions.assertEquals(cliente.getId(), clienteBD.getId(), "cliente cadastrado deve ser iqual a o clienteBD do banco de dados");

		// Exclusão do cliente
		clienteService.excluirCliente(cliente.getId());

		// Verificação se o cliente foi realmente removido do banco
		Cliente clienteRemovido = clienteService.buscarClientePorId(cliente.getId());
		Assertions.assertNull(clienteRemovido, "O cliente removido deve ser nulo após a exclusão.");
	}
	@Test
	@Transactional
	public void alterarClienteTest(){
		// Cadastro do cliente
		clienteService.cadastrarCliente(cliente);

		//Verificando se o cliente foi cadastrado
		Cliente clienteBD = clienteService.buscarClientePorId(cliente.getId());
		Assertions.assertNotNull(clienteBD,"O cliente deve ser encontrado no banco de dados após cadastro.");
		Assertions.assertEquals(cliente.getId(), clienteBD.getId(), "cliente cadastrado deve ser iqual a o clienteBD do banco de dados");

		// Alterando o cliente
		Cliente clienteAlterado = clienteService.buscarClientePorId(cliente.getId());
		clienteAlterado.setNome("Pedro");

		//Verificando se o cliente foi alterado
		clienteService.alterarCliente(clienteAlterado);
		Cliente clienteAlteradoBD = clienteService.buscarClientePorId(cliente.getId());
		Assertions.assertEquals("Pedro", clienteAlteradoBD.getNome(), "O cliente alterado do banco deve ter o nome alterado");

		//Removendo Cliente
		clienteService.excluirCliente(cliente.getId());
		Cliente clienteExcluido = clienteService.buscarClientePorId(cliente.getId());
		Assertions.assertNull(clienteExcluido, "O cliente removido deve ser nulo após a exclusão.");
	}
	@Test
	@Transactional
	public void buscarTodosOsClienteTest(){
		//Cadasto dos clientes
		clienteService.cadastrarCliente(cliente);
		clienteService.cadastrarCliente(cliente2);

		//Verficar se cliente e cliente 2 foi cadastrado
		Cliente clienteBD = clienteService.buscarClientePorId(cliente.getId());
		Cliente cliente2BD = clienteService.buscarClientePorId(cliente2.getId());
		Assertions.assertNotNull(clienteBD, "clienteBD retornado do banco nao pode ser nulo");
		Assertions.assertNotNull(cliente2BD, "clienteBD2 retornado do banco nao pode ser nulo");
		Assertions.assertEquals(cliente.getId(), clienteBD.getId(),"cliente cadastrado deve ser iqual a o clienteBD do banco de dados");
		Assertions.assertEquals(cliente2.getId(), cliente2BD.getId(),"cliente2 cadastrado deve ser iqual a o clienteBD2 do banco de dados");

		//Verificando se list de cliente e igual ao cliente cadastrado
		List<Cliente> listCliente = clienteService.buscarTodosCliente();
		for( Cliente clienteDaLista : listCliente){
			Assertions.assertNotNull(clienteDaLista, "cliente retornado da list do banco nao pode ser nulo");

			Cliente clienteBDLista = clienteService.buscarClientePorId(clienteDaLista.getId());
			Assertions.assertEquals(clienteDaLista.getId(), clienteBDLista.getId(), "clienteBDList do banco de dados deve der igual ao clienteDaLista");
		}

		// Remover e Verifica se foi removido do banco de dados
		for (Cliente clienteDaLista : listCliente) {
			clienteService.excluirCliente(clienteDaLista.getId());
			Cliente clienteExcluido = clienteService.buscarClientePorId(clienteDaLista.getId());
			Assertions.assertNull(clienteExcluido);
		}
	}
}
