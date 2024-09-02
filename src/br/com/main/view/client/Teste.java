package br.com.main.view.client;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.main.model.Chale;
import br.com.main.model.Cliente;
import br.com.main.model.Hospedagem;
import br.com.main.persistence.ConnectionFactory;
import br.com.main.controller.*;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if (con != null) {
			System.out.println("OK");
			ConnectionFactory.close(con);
		}
        HospedagemController hospedagemController = new HospedagemController();
        
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setCodChale(1); // Substitua pelo ID do chalé
        hospedagem.setCodCliente(1); // Substitua pelo ID do cliente
        hospedagem.setEstado("Ativo");
        hospedagem.setDataInicio(LocalDate.of(2024, 8, 29));
        hospedagem.setDataFim(LocalDate.of(1111, 1, 1));
        hospedagem.setQtdPessoas(2);
        hospedagem.setDesconto(Double.valueOf(50.00));
        hospedagem.setValorFinal(Double.valueOf(0.00)); // Exemplo de valor final
        
        String resultado = hospedagemController.alterar(hospedagem);
        System.out.println(resultado);
	}
}