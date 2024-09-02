package br.com.main.view.stay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.com.main.controller.ChaleController;
import br.com.main.controller.ClienteController;
import br.com.main.controller.HospedagemController;
import br.com.main.model.Chale;
import br.com.main.model.Cliente;
import br.com.main.model.Hospedagem;
import br.com.main.view.client.ClientAlterForm;


public class StayAlterForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldQtdPessoas;
    private JTextField textFieldDesconto;
    private JTextField textFieldValorFinal;
    private JTextField textFieldEstado;
    private JComboBox<String> cbxCodChale;
    private JComboBox<String> cbxCodCliente;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StayAlterForm frame = new StayAlterForm("0", "", "", "", "", "", "");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StayAlterForm(String id, String dataInicio, String dataFim, String qtdPessoas, String desconto, String valorFinal, String estado) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
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
            cbxCodCliente.addItem( c.getNomeCliente() + " Id#" + String.valueOf(c.getCodCliente()));
        }

        JButton btnAlter = new JButton("Alter");
        btnAlter.addActionListener(new ActionListener() {
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
                    Integer.parseInt(id),
                    codChale,
                    codCliente,
                    textFieldEstado.getText(),
                    dataInicio,
                    dataFim,
                    qtdPessoas,
                    desconto,
                    valorFinal
                );

                 HospedagemController hc = new HospedagemController();

                 try {
 					hc.alterar(stay); 
 		            JOptionPane.showMessageDialog(null, "Hospedagem alterado com sucesso", "Sucess", JOptionPane.INFORMATION_MESSAGE);
 		            StayAlterForm.this.dispose(); 
 		        } catch (Exception ex) {
 		            JOptionPane.showMessageDialog(null, "Erro ao alterar a hospedagem: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
 		        }
            }
        });
        btnAlter.setForeground(Color.WHITE);
        btnAlter.setBackground(new Color(0, 0, 255));

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StayAlterForm.this.dispose();
            }
        });
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(new Color(255, 0, 51));

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Hospedagem stay = new Hospedagem();

                try {
                    stay.setCodHospedagem(Integer.parseInt(id));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object[] options = { "Yes", "No" };
                int response = JOptionPane.showOptionDialog(
                    null,
                    "Do you want to delete this stay with ID: " + id + "?",
                    "Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]
                );
                
                HospedagemController hc = new HospedagemController();

                if (JOptionPane.YES_OPTION == response) {
                	hc.excluir(stay);
                	JOptionPane.showMessageDialog(null, "Hospedagem excluído com sucesso!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    StayAlterForm.this.dispose();
                }
            }
        });
        btnDelete.setBackground(new Color(204, 0, 0));

        JLabel lblId = new JLabel("Id#" + id);
        lblId.setForeground(new Color(0, 153, 255));

        JLabel lblDataInicio = new JLabel("Data Inicio:");
        JLabel lblDataFim = new JLabel("Data Fim:");
        JLabel lblQtdPessoas = new JLabel("Qtd Pessoas:");
        JLabel lblDesconto = new JLabel("Desconto:");
        JLabel lblValorFinal = new JLabel("Valor Final:");
        JLabel lblEstado = new JLabel("Estado:");

        textFieldDataInicio = new JTextField();
        textFieldDataInicio.setColumns(10);
        textFieldDataInicio.setText(dataInicio);

        textFieldDataFim = new JTextField();
        textFieldDataFim.setColumns(10);
        textFieldDataFim.setText(dataFim);

        textFieldQtdPessoas = new JTextField();
        textFieldQtdPessoas.setColumns(10);
        textFieldQtdPessoas.setText(qtdPessoas);

        textFieldDesconto = new JTextField();
        textFieldDesconto.setColumns(10);
        textFieldDesconto.setText(desconto);

        textFieldValorFinal = new JTextField();
        textFieldValorFinal.setColumns(10);
        textFieldValorFinal.setText(valorFinal);

        textFieldEstado = new JTextField();
        textFieldEstado.setColumns(10);
        textFieldEstado.setText(estado);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblId)
                            .addGap(108)
                            .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblDataInicio)
                                .addComponent(lblDataFim)
                                .addComponent(lblQtdPessoas)
                                .addComponent(lblDesconto)
                                .addComponent(lblValorFinal)
                                .addComponent(lblEstado)
                                .addComponent(cbxCodChale)
                                .addComponent(cbxCodCliente))
                            .addGap(18)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(textFieldDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(105, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(235, Short.MAX_VALUE)
                    .addComponent(btnAlter, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(btnCancel)
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblId)
                        .addComponent(btnDelete))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblDataInicio)
                        .addComponent(textFieldDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblDataFim)
                        .addComponent(textFieldDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblQtdPessoas)
                        .addComponent(textFieldQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblDesconto)
                        .addComponent(textFieldDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblValorFinal)
                        .addComponent(textFieldValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblEstado)
                        .addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnAlter))
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}
