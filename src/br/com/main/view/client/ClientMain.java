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
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class ClientMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUsers;
	private JButton btnAction;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
					frame.setVisible(true);
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
		
		mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNewMenuItem.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Insert");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmNewMenuItem_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_3 = new JMenuItem("Refresh");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchUsers();
			}
		});
		mntmNewMenuItem_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel PanelTbl = new JPanel();
		PanelTbl.setBorder(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblUsers = new JTable();
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
		
		// fetch data dynamically
        Timer timer = new Timer(2000, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchUsers();
            }
        });
        timer.start();
	}
	
	public void fetchUsers() {
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
