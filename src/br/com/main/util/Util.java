package br.com.main.util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.main.controller.ChaleController;
import br.com.main.controller.ClienteController;
import br.com.main.controller.HospedagemController;
import br.com.main.model.Chale;
import br.com.main.model.Cliente;
import br.com.main.model.Hospedagem;

public class Util {
	public static void fetchClient(JTable tblClients) {
	    List<Cliente> clients = new ArrayList<>();
	    
	    ClienteController cc = new ClienteController();
	    clients = cc.listarTodos();
	    
	    DefaultTableModel tbl = (DefaultTableModel) tblClients.getModel();
	    
	    tbl.setRowCount(0);

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
	        tbl.addRow(rowData);
	    }
	}

	public static void fetchStay(JTable tblStays) {
	    List<Hospedagem> stays = new ArrayList<>();
	    
	    HospedagemController hc = new HospedagemController();
	    stays = hc.listarTodos();
	    
	    DefaultTableModel tbl = (DefaultTableModel) tblStays.getModel();
	    
	    tbl.setRowCount(0);
	    
	    for (Hospedagem stay : stays) {
	        Object[] rowData = {
	            stay.getCodHospedagem(),
	            stay.getCodChale(),
	            stay.getCodCliente(),
	            stay.getEstado(),
	            stay.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	            stay.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	            stay.getQtdPessoas(),
	            stay.getDesconto(),
	            stay.getValorFinal()
	        };
	        tbl.addRow(rowData);
	    }
	}


    public static void fetchChalet(JTable tblChalets) {
        List<Chale> chales = new ArrayList<>();
        
        ChaleController cc = new ChaleController();
        chales = cc.listarTodos();
        
        DefaultTableModel tbl = (DefaultTableModel) tblChalets.getModel();
        
        tbl.setRowCount(0);

        for (Chale chalet : chales) {
            Object[] rowData = {
                chalet.getCodChale(),
                chalet.getLocalizacao(),
                chalet.getCapacidade(),
                chalet.getValorAltaEstacao(),
                chalet.getValorBaixaEstacao()
            };
            tbl.addRow(rowData);
        }
    }

}
