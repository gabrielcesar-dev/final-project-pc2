package br.com.main.view.chalet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import br.com.main.controller.ChaleController;
import br.com.main.model.Chale;

public class ChaletAlterForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldLocalizacao;
    private JTextField textFieldCapacidade;
    private JTextField textFieldValorAltaEstacao;
    private JTextField textFieldValorBaixaEstacao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChaletAlterForm frame = new ChaletAlterForm("0", "", 0, 0.0, 0.0);
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
    public ChaletAlterForm(String id, String localizacao, int capacidade, double valorAltaEstacao, double valorBaixaEstacao) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 296);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JButton btnAlter = new JButton("ALTER");
        btnAlter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Chale chalet = null;
                try {
                    String localizacao = textFieldLocalizacao.getText();
                    Integer capacidade = Integer.parseInt(textFieldCapacidade.getText());
                    Double valorAltaEstacao = Double.parseDouble(textFieldValorAltaEstacao.getText());
                    Double valorBaixaEstacao = Double.parseDouble(textFieldValorBaixaEstacao.getText());

                    chalet = new Chale(0, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao);

                    ChaleController cc = new ChaleController();
                    cc.alterar(chalet);
                    
                    JOptionPane.showMessageDialog(null, "Chalé alterado com sucesso!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ChaletAlterForm.this.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar chalé: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar chalé: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAlter.setForeground(Color.WHITE);
        btnAlter.setBackground(new Color(0, 0, 255));

        JButton btnCancel = new JButton("cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChaletAlterForm.this.dispose();
            }
        });
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(new Color(255, 0, 51));

        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Chale chale = new Chale();
                ChaleController cc = new ChaleController();

                try {
                    chale.setCodChale(Integer.parseInt(id));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object[] options = { "Yes", "No" };
                int response = JOptionPane.showOptionDialog(
                        null,
                        "Do you want to delete this chalet: " + textFieldLocalizacao.getText() + "?",
                        "Deletion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (JOptionPane.YES_OPTION == response) {
                    cc.excluir(chale);
                    JOptionPane.showMessageDialog(null, "Chalet successfully deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ChaletAlterForm.this.dispose();
                }
            }
        });
        btnDelete.setBackground(new Color(204, 0, 0));

        JLabel lblId = new JLabel("ID#" + id);
        lblId.setForeground(new Color(0, 153, 255));

        JLabel lblLocalizacao = new JLabel("Localização:");
        JLabel lblCapacidade = new JLabel("Capacidade:");
        JLabel lblValorAltaEstacao = new JLabel("Valor Alta Estação:");
        JLabel lblValorBaixaEstacao = new JLabel("Valor Baixa Estação:");

        textFieldLocalizacao = new JTextField();
        textFieldLocalizacao.setColumns(10);
        textFieldLocalizacao.setText(localizacao);

        textFieldCapacidade = new JTextField();
        textFieldCapacidade.setColumns(10);
        textFieldCapacidade.setText(String.valueOf(capacidade));

        textFieldValorAltaEstacao = new JTextField();
        textFieldValorAltaEstacao.setColumns(10);
        textFieldValorAltaEstacao.setText(String.valueOf(valorAltaEstacao));

        textFieldValorBaixaEstacao = new JTextField();
        textFieldValorBaixaEstacao.setColumns(10);
        textFieldValorBaixaEstacao.setText(String.valueOf(valorBaixaEstacao));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblLocalizacao)
        								.addComponent(lblCapacidade)
        								.addComponent(lblValorAltaEstacao)
        								.addComponent(lblValorBaixaEstacao))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(textFieldLocalizacao)
        								.addComponent(textFieldCapacidade)
        								.addComponent(textFieldValorAltaEstacao)
        								.addComponent(textFieldValorBaixaEstacao, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        						.addComponent(lblId))
        					.addGap(16))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(btnDelete)
        				.addComponent(btnAlter, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblId)
        				.addComponent(btnDelete))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblLocalizacao)
        				.addComponent(textFieldLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCapacidade)
        				.addComponent(textFieldCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblValorAltaEstacao)
        				.addComponent(textFieldValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblValorBaixaEstacao)
        				.addComponent(textFieldValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnAlter)
        				.addComponent(btnCancel)))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
