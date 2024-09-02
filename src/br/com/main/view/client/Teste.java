package br.com.main.view.client;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.main.model.Chale;
import br.com.main.model.Cliente;
import br.com.main.model.Hospedagem;
import br.com.main.persistence.ClienteDAOImpl;
import br.com.main.persistence.ConnectionFactory;
import br.com.main.controller.*;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if (con != null) {
			System.out.println("OK");
			ConnectionFactory.close(con);
		}
		Cliente cliente = new Cliente();
		cliente.setCodCliente(1);
        cliente.setNomeCliente("João Silva");
        cliente.setRgCliente("123456789");
        cliente.setEnderecoCliente("Rua das Flores, 123");
        cliente.setBairroCliente("Centro");
        cliente.setCidadeCliente("Cidade Exemplo");
        cliente.setEstadoCliente("SP");
        cliente.setCepCliente("12345-678");
        cliente.setNascimentoCliente(LocalDate.of(1980, 1, 1));
        
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        String resultado = clienteDAO.alterar(cliente);
        System.out.println(resultado); 
	}
}