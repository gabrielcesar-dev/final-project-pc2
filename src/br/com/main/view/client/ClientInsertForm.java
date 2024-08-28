package br.com.main.view.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClientInsertForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRg;
	private JTextField textFieldEndereco;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldCep;
	private JTextField textFieldNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInsertForm frame = new ClientInsertForm();
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
	public ClientInsertForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public	 void actionPerformed(ActionEvent e) {
				// TODO: implement save action
				/*
				Empregado emp = new Empregado();
			    EmpregadoController ec = new EmpregadoController();
			    
			    // Obtendo os valores dos campos de texto e definindo no objeto Empregado
			    emp.setNome(textFieldNome.getText());
			    emp.setRg(textFieldRg.getText());
			    emp.setEndereco(textFieldEndereco.getText());
			    emp.setBairro(textFieldBairro.getText());
			    emp.setCidade(textFieldCidade.getText());
			    emp.setEstado(textFieldEstado.getText());
			    emp.setCep(textFieldCep.getText());
			    emp.setNascimento(textFieldNascimento.getText());
			    
			    try {
			        // Exemplo de campo numérico, se necessário
			    } catch (NumberFormatException ex) {
			    JOptionPane.showConfirmDialog(null, "invalid input");
			        return;
			    }
			    
			    // Limpa a mensagem e exibe o resultado da operação de alteração

			   JOptionPane.showConfirmDialog(null, ec.inserir(emp));
			    
			    Util.fetchUser();
			    
			    */
				
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(0, 0, 255));
		
		JPanel panel = new JPanel();
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(255, 0, 51));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(258, Short.MAX_VALUE)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel)))
		);
		
		JLabel lblNome = new JLabel("Nome:");
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		textFieldRg = new JTextField();
		textFieldRg.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		textFieldNascimento = new JTextField();
		textFieldNascimento.setColumns(10);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblRg)
						.addComponent(lblEndereco)
						.addComponent(lblBairro)
						.addComponent(lblCidade)
						.addComponent(lblEstado)
						.addComponent(lblCep)
						.addComponent(lblNascimento))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldRg, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldEndereco, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldBairro, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldCidade, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldEstado, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldCep, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(textFieldNascimento, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRg)
						.addComponent(textFieldRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereco)
						.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro)
						.addComponent(textFieldBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(textFieldCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCep)
						.addComponent(textFieldCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNascimento)
						.addComponent(textFieldNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(9, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

}
