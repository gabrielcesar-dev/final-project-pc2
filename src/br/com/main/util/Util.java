package br.com.main.util;

import javax.swing.JTable;

public class Util {
	public static void fetchUsers(JTable tblUsers) {
		/* TODO: fetch data
		
		List<user> users = new ArrayList<>();
		UserController ec = new UserController();
		users = ec.listAll();
		
		DefaultTableModel tbm = (DefaultTableModel) tblUsers.getModel();
		
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		
		int row = 0;
		for (User user : users) {
			tblUsers.setValueAt(user.getId(), row, 0);
			tblUsers.setValueAt(user.getNome(), row, 1);
			tblUsers.setValueAt(user.getRg(), row, 2);
			tblUsers.setValueAt(user.getEndereco(), row, 3);
			tblUsers.setValueAt(user.getBairro(), row, 4);
			tblUsers.setValueAt(user.getCidade(), row, 5);
			tblUsers.setValueAt(user.getEstado(), row, 6);
			tblUsers.setValueAt(user.getCep(), row, 7);
			tblUsers.setValueAt(user.getNascimento(), row, 8);
			row++;
		}
		
		*/	
	}
}
