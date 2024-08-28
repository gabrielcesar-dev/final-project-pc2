package br.com.main.view.client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.main.util.Util;

import java.awt.Font;
import java.awt.Color;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

public class ClientMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUsers;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItemHome;
	private JMenuItem mntmNewMenuItemNew;
	private JMenuItem mntmNewMenuExit;
	private JMenuItem mntmNewMenuItemRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientMain() {
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmNewMenuItemHome = new JMenuItem("Home");
		mntmNewMenuItemHome.setBorder(new LineBorder(new Color(0, 0, 0)));
		mntmNewMenuItemHome.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNewMenuItemHome.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItemHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItemHome);
		
		mntmNewMenuItemNew = new JMenuItem("New");
		mntmNewMenuItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientInsertForm form = new ClientInsertForm();
				form.setVisible(true);
				form.setLocationRelativeTo(null);
			}
		});
		mntmNewMenuItemNew.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuItemNew);
		
		mntmNewMenuItemRefresh = new JMenuItem("Refresh");
		mntmNewMenuItemRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util.fetchUsers(tblUsers);
			}
		});
		mntmNewMenuItemRefresh.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuItemRefresh);
		
		mntmNewMenuExit = new JMenuItem("Exit");
		mntmNewMenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuExit.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuExit);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel PanelTbl = new JPanel();
		PanelTbl.setBorder(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblUsers = new JTable();
		tblUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = tblUsers.getSelectedRow();
			        if (row != -1) { 
			            String id = tblUsers.getValueAt(row, 0).toString();
			            String nome = tblUsers.getValueAt(row, 1).toString();
			            String rg = tblUsers.getValueAt(row, 2).toString();
			            String endereco = tblUsers.getValueAt(row, 3).toString();
			            String bairro = tblUsers.getValueAt(row, 4).toString();
			            String cidade = tblUsers.getValueAt(row, 5).toString();
			            String estado = tblUsers.getValueAt(row, 6).toString();
			            String cep = tblUsers.getValueAt(row, 7).toString();
			            String nascimento = tblUsers.getValueAt(row, 8).toString();

			            ClientAlterForm form = new ClientAlterForm(id, nome, rg, endereco, bairro, cidade, estado, cep, nascimento);
			            form.setVisible(true); 
			            form.setLocationRelativeTo(null);
			        }
			}
		});
		tblUsers.setBorder(null);
		tblUsers.setFillsViewportHeight(true);
		tblUsers.setForeground(Color.BLACK);
		tblUsers.setBackground(Color.WHITE);
		tblUsers.setFont(new Font("Dialog", Font.ITALIC, 12));
		tblUsers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nome", "rg", "endereco", "bairro", "cidade", "estado", "CEP", "nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblUsers.getColumnModel().getColumn(0).setResizable(false);
		
		scrollPane.setViewportView(tblUsers);
		GroupLayout gl_PanelTbl = new GroupLayout(PanelTbl);
		gl_PanelTbl.setHorizontalGroup(
			gl_PanelTbl.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
		);
		gl_PanelTbl.setVerticalGroup(
			gl_PanelTbl.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
		);
		PanelTbl.setLayout(gl_PanelTbl);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(PanelTbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(PanelTbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		contentPane.setLayout(gl_contentPane);
		
        Util.fetchUsers(tblUsers);
	}
}
