package br.com.main.view.stay;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.main.model.Hospedagem;
import br.com.main.controller.ChaleController;
import br.com.main.controller.ClienteController;
import br.com.main.controller.HospedagemController;
import br.com.main.model.Chale;
import br.com.main.model.Cliente;

public class StayInsertForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEstado;
    private JFormattedTextField textFieldDataInicio;
    private JFormattedTextField textFieldDataFim;
    private JTextField textFieldQtdPessoas;
    private JTextField textFieldDesconto;
    private JTextField textFieldValorFinal;
    private JComboBox<String> cbxCodChale;
    private JComboBox<String> cbxCodCliente;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StayInsertForm frame = new StayInsertForm();
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
    public StayInsertForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400); // Adjusted size to be similar to ClientInsertForm
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        cbxCodChale = new JComboBox<>();
        cbxCodCliente = new JComboBox<>();
        
        ChaleController chc = new ChaleController();
        ClienteController cc = new ClienteController();

        for (Chale c : chc.listarTodos()) {
            cbxCodChale.addItem(c.getLocalizacao() + " Id#" + String.valueOf(c.getCodChale()));
        }

        for (Cliente c : cc.listarTodos()) {
            cbxCodCliente.addItem(c.getNomeCliente() + " Id#" + String.valueOf(c.getCodCliente()));
        }

        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer codChale = 0;
            	Integer codCliente = 0;
                LocalDate dataInicio = null;
                LocalDate dataFim = null;
                int qtdPessoas = 0;
                double desconto = 0.0;
                double valorFinal = 0.0;

                try {
                    dataInicio = LocalDate.parse(textFieldDataInicio.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    dataFim = LocalDate.parse(textFieldDataFim.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in dd/MM/yyyy format.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    qtdPessoas = Integer.parseInt(textFieldQtdPessoas.getText());
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for 'Quantidade Pessoas'. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    desconto = Double.parseDouble(textFieldDesconto.getText());
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for 'Desconto'. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    valorFinal = Double.parseDouble(textFieldValorFinal.getText());
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for 'Valor Final'. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    String codChaleStr = cbxCodChale.getSelectedItem().toString();                   
                    String numberStr = codChaleStr.substring(codChaleStr.lastIndexOf("#") + 1);    
                    codChale = Integer.parseInt(numberStr);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for 'Cod Chale'. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                    
                } catch (StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Input format is incorrect. Make sure the item contains '#' followed by a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Please select an item from the list.", "Selection Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                    String codClienteStr = cbxCodCliente.getSelectedItem().toString(); 
                    String numberStr = codClienteStr.substring(codClienteStr.lastIndexOf("#") + 1); 
                    codCliente = Integer.parseInt(numberStr);
  
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for 'Cod Cliente'. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                    
                } catch (StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Input format is incorrect. Make sure the item contains '#' followed by a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Please select an item from the list.", "Selection Error", JOptionPane.ERROR_MESSAGE);
                }



                Hospedagem stay = new Hospedagem(
                	0,
                    codChale,
                    Integer.parseInt(cbxCodCliente.getSelectedItem().toString()),
                    textFieldEstado.getText(),
                    dataInicio,
                    dataFim,
                    qtdPessoas,
                    desconto,
                    valorFinal
                );

                HospedagemController hc = new HospedagemController();

                try {
                    hc.inserir(stay); 
                    JOptionPane.showMessageDialog(null, "Hospedagem salva com sucesso!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    StayInsertForm.this.dispose(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar hospedagem: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(new Color(0, 0, 255));

        JButton btnCancel = new JButton("cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StayInsertForm.this.dispose();
            }
        });
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(new Color(255, 0, 51));

        JLabel lblCodChale = new JLabel("Código Chale:");
        JLabel lblCodCliente = new JLabel("Código Cliente:");
        JLabel lblEstado = new JLabel("Estado:");
        JLabel lblDataInicio = new JLabel("Data Início:");
        JLabel lblDataFim = new JLabel("Data Fim:");
        JLabel lblQtdPessoas = new JLabel("Quantidade Pessoas:");
        JLabel lblDesconto = new JLabel("Desconto:");
        JLabel lblValorFinal = new JLabel("Valor Final:");

        try {
            textFieldDataInicio = new JFormattedTextField(new MaskFormatter("##/##/####"));
            textFieldDataFim = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException e) {
            System.err.println("Error creating date formatter: " + e.getMessage());
        }
        textFieldDataInicio.setColumns(10);
        textFieldDataFim.setColumns(10);

        textFieldEstado = new JTextField();
        textFieldEstado.setColumns(10);
        textFieldQtdPessoas = new JTextField();
        textFieldQtdPessoas.setColumns(10);
        textFieldDesconto = new JTextField();
        textFieldDesconto.setColumns(10);
        textFieldValorFinal = new JTextField();
        textFieldValorFinal.setColumns(10);

        GroupLayout gl_panel = new GroupLayout(contentPane);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
        					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblCodChale)
        						.addComponent(lblCodCliente)
        						.addComponent(lblEstado)
        						.addComponent(lblDataInicio)
        						.addComponent(lblDataFim)
        						.addComponent(lblQtdPessoas)
        						.addComponent(lblDesconto)
        						.addComponent(lblValorFinal))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbxCodChale, 0, 248, Short.MAX_VALUE)
        						.addComponent(cbxCodCliente, 0, 248, Short.MAX_VALUE)
        						.addComponent(textFieldEstado, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        						.addComponent(textFieldDataInicio, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        						.addComponent(textFieldDataFim, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        						.addComponent(textFieldQtdPessoas, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        						.addComponent(textFieldDesconto, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        						.addComponent(textFieldValorFinal, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addComponent(btnCancel)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnSave)))
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCodChale)
        				.addComponent(cbxCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCodCliente)
        				.addComponent(cbxCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEstado)
        				.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDataInicio)
        				.addComponent(textFieldDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDataFim)
        				.addComponent(textFieldDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblQtdPessoas)
        				.addComponent(textFieldQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDesconto)
        				.addComponent(textFieldDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblValorFinal)
        				.addComponent(textFieldValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSave)
        				.addComponent(btnCancel)))
        );
        contentPane.setLayout(gl_panel);
    }
}
