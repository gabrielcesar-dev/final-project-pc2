package br.com.main.view.client;

import java.sql.Connection;
import br.com.main.persistence.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if (con != null) {
			System.out.println("OK");
			ConnectionFactory.close(con);
		}
	}
}