package br.com.main.view.client;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.com.main.model.Cliente;

public class ClientAlterForm extends JFrame {

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
					ClientAlterForm frame = new ClientAlterForm("0","","","","","","","","");
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
	public ClientAlterForm(String id, String nome, String rg, String endereco, String bairro, String cidade, 
            String estado, String cep, String nascimento) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAlter = new JButton("ALTER");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: implement alter
				
				LocalDate nascimento = null;
				Integer codClient = null;

				try {
				    nascimento = LocalDate.parse(textFieldNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    codClient = Integer.parseInt(id);

				} catch (DateTimeParseException ex) {
				    JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in dd/MM/yyyy format.", "Input Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(null, "Invalid ID.", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				Cliente client = new Cliente(
				        codClient,
				        textFieldNome.getText(),
				        textFieldRg.getText(),
				        textFieldEndereco.getText(),
				        textFieldBairro.getText(),
				        textFieldCidade.getText(),
				        textFieldEstado.getText(),
				        textFieldCep.getText(),
				        nascimento
				    );

				 // ClienteController cc = new ClienteController();

				JOptionPane.showMessageDialog(null, "Log.", "cc.alterar(client)", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAlter.setForeground(Color.WHITE);
		btnAlter.setBackground(new Color(0, 0, 255));
		
		JPanel panel = new JPanel();
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(255, 0, 51));
		
		JButton btnDelete = new JButton("X");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: delete action 
				
				Cliente client = new Cliente();

				//ClienteController cc = new ClienteController();
			    

				try {
				    client.setCodClient(Integer.parseInt(id));

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
			    

			    Object[] options = { "Yes", "No" };
			    int response = JOptionPane.showOptionDialog(
			        null, 
				    "Do you want to delete this user: " + textFieldNome.getText() + "?",
			        "Deletion", 
			        JOptionPane.YES_NO_OPTION, 
			        JOptionPane.QUESTION_MESSAGE, 
			        null, 
			        options, 
			        options[1]
			    );
			    
			    if (JOptionPane.YES_OPTION == response) {
			    	JOptionPane.showMessageDialog(null, "Log", "cc.excluir()", JOptionPane.INFORMATION_MESSAGE);
			    	System.exit(0);
			    }
			}
		});
		btnDelete.setBackground(new Color(204, 0, 0));
		
		JLabel lblId = new JLabel("Id#" + id);
		lblId.setForeground(new Color(0, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAlter, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(112, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
							.addComponent(btnDelete))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlter)
						.addComponent(btnCancel)))
		);
		
		textFieldNome = new JTextField();
	    textFieldNome.setColumns(10);
	    textFieldNome.setText(nome);
	    
	    textFieldRg = new JTextField();
	    textFieldRg.setColumns(10);
	    textFieldRg.setText(rg);
	    
	    textFieldEndereco = new JTextField();
	    textFieldEndereco.setColumns(10);
	    textFieldEndereco.setText(endereco);
	    
	    textFieldBairro = new JTextField();
	    textFieldBairro.setColumns(10);
	    textFieldBairro.setText(bairro);
	    
	    textFieldCidade = new JTextField();
	    textFieldCidade.setColumns(10);
	    textFieldCidade.setText(cidade);
	    
	    textFieldEstado = new JTextField();
	    textFieldEstado.setColumns(10);
	    textFieldEstado.setText(estado);
	    
	    textFieldCep = new JTextField();
	    textFieldCep.setColumns(10);
	    textFieldCep.setText(cep);
	    
	    textFieldNascimento = new JTextField();
	    textFieldNascimento.setColumns(10);
	    textFieldNascimento.setText(nascimento);
	    
	    JLabel lblNome = new JLabel("Nome:");
	    JLabel lblRg = new JLabel("RG:");
	    JLabel lblEndereco = new JLabel("Endereço:");
	    JLabel lblBairro = new JLabel("Bairro:");
	    JLabel lblCidade = new JLabel("Cidade:");
	    JLabel lblEstado = new JLabel("Estado:");
	    JLabel lblCep = new JLabel("CEP:");
	    JLabel lblNascimento = new JLabel("Nascimento:");

		
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