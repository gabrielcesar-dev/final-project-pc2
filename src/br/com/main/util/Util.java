package br.com.main.util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.main.model.Cliente;

public class Util {
	public static void fetchUsers(JTable tblClients) {
		// TODO: fetch data
		
		List<Cliente> clients = new ArrayList<>();
		
		// ClienteController cc = new ClienteController();
		
		//clients = cc.listAll();
		
		DefaultTableModel tbl = (DefaultTableModel) tblClients.getModel();
		for (int i = tbl.getRowCount() - 1; i >= 0; i--) {
			tbl.removeRow(i);
		}
		
		int row = 0;
		for (Cliente client : clients) {
            tbl.setValueAt(client.getCodClient(), row, 0);
            tbl.setValueAt(client.getNomeCliente(), row, 1);
            tbl.setValueAt(client.getRgCliente(), row, 2);
            tbl.setValueAt(client.getEnderecoCliente(), row, 3);
            tbl.setValueAt(client.getBairroCliente(), row, 4);
            tbl.setValueAt(client.getCidadeCliente(), row, 5);
            tbl.setValueAt(client.getEstadoCliente(), row, 6);
            tbl.setValueAt(client.getCepCliente(), row, 7);
            tbl.setValueAt(client.getNascimentoCliente().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), row, 8);
            
			row++;
		}		
	}
}
