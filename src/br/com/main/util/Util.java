package br.com.main.util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.main.controller.ClienteController;
import br.com.main.controller.HospedagemController;
import br.com.main.model.Cliente;
import br.com.main.model.Hospedagem;

public class Util {
	/*public static void fetchClient(JTable tblClients) {
		// TODO: fetch data
		
		List<Cliente> clients = new ArrayList<>();
		
		ClienteController cc = new ClienteController();
		
		clients = cc.listarTodos();
		
		DefaultTableModel tbl = (DefaultTableModel) tblClients.getModel();
		for (int i = tbl.getRowCount() - 1; i >= 0; i--) {
			tbl.removeRow(i);
		}
		
		int row = 0;
		for (Cliente client : clients) {
            tbl.setValueAt(client.getCodCliente(), row, 0);
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
	}*/
	
	// gxpytz mode
	public static void fetchClient(JTable tblClients) {
	    List<Cliente> clients = new ArrayList<>();
	    
	    ClienteController cc = new ClienteController();
	    clients = cc.listarTodos();
	    
	    DefaultTableModel tbl = (DefaultTableModel) tblClients.getModel();
	    
	    // Remove todas as linhas existentes na tabela
	    tbl.setRowCount(0);

	    // Adiciona os clientes na tabela
	    for (Cliente client : clients) {
	        Object[] rowData = {
	            client.getCodCliente(),
	            client.getNomeCliente(),
	            client.getRgCliente(),
	            client.getEnderecoCliente(),
	            client.getBairroCliente(),
	            client.getCidadeCliente(),
	            client.getEstadoCliente(),
	            client.getCepCliente(),
	            client.getNascimentoCliente().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
	        };
	        tbl.addRow(rowData);  // Adiciona uma nova linha à tabela
	    }
	}

    public static void fetchStay(JTable tblStays) {
        // TODO: fetch data
        
        List<Hospedagem> stays = new ArrayList<>();
        
        HospedagemController hc = new HospedagemController();
        stays = hc.listarTodos();
        
        DefaultTableModel tbl = (DefaultTableModel) tblStays.getModel();
        for (int i = tbl.getRowCount() - 1; i >= 0; i--) {
            tbl.removeRow(i);
        }
        
        int row = 0;
        for (Hospedagem stay : stays) {
            tbl.setValueAt(stay.getCodHospedagem(), row, 0);
            tbl.setValueAt(stay.getCodChale(), row, 1);
            tbl.setValueAt(stay.getCodCliente(), row, 2);
            tbl.setValueAt(stay.getEstado(), row, 3);
            tbl.setValueAt(stay.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), row, 4);
            tbl.setValueAt(stay.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), row, 5);
            tbl.setValueAt(stay.getQtdPessoas(), row, 6);
            tbl.setValueAt(stay.getDesconto(), row, 7);
            tbl.setValueAt(stay.getValorFinal(), row, 8);
            
            row++;
        }       
    }
}
