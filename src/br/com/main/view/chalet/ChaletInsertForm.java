package br.com.main.view.chalet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.main.controller.ChaleController;
import br.com.main.model.Chale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ChaletInsertForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldLocalizacao;
    private JTextField textFieldCapacidade;
    private JTextField textFieldValorAltaEstacao;
    private JTextField textFieldValorBaixaEstacao;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChaletInsertForm frame = new ChaletInsertForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ChaletInsertForm() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String localizacao = textFieldLocalizacao.getText();
                    Integer capacidade = Integer.parseInt(textFieldCapacidade.getText());
                    Double valorAltaEstacao = Double.parseDouble(textFieldValorAltaEstacao.getText());
                    Double valorBaixaEstacao = Double.parseDouble(textFieldValorBaixaEstacao.getText());

                    Chale chale = new Chale(0, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao);

                    ChaleController cc = new ChaleController();

                    cc.inserir(chale); 
                    JOptionPane.showMessageDialog(null, "Chalé salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    ChaletInsertForm.this.dispose(); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar chalé: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar chalé: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(new Color(0, 0, 255));

        JButton btnCancel = new JButton("cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChaletInsertForm.this.dispose();
            }
        });
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(new Color(255, 0, 51));

        JLabel lblLocalizacao = new JLabel("Localização:");
        textFieldLocalizacao = new JTextField();
        textFieldLocalizacao.setColumns(10);

        JLabel lblCapacidade = new JLabel("Capacidade:");
        textFieldCapacidade = new JTextField();
        textFieldCapacidade.setColumns(10);

        JLabel lblValorAltaEstacao = new JLabel("Valor Alta Estação:");
        textFieldValorAltaEstacao = new JTextField();
        textFieldValorAltaEstacao.setColumns(10);

        JLabel lblValorBaixaEstacao = new JLabel("Valor Baixa Estação:");
        textFieldValorBaixaEstacao = new JTextField();
        textFieldValorBaixaEstacao.setColumns(10);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap(258, Short.MAX_VALUE)
                    .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblLocalizacao)
                        .addComponent(lblCapacidade)
                        .addComponent(lblValorAltaEstacao)
                        .addComponent(lblValorBaixaEstacao))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(textFieldLocalizacao, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(textFieldCapacidade, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(textFieldValorAltaEstacao, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(textFieldValorBaixaEstacao, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
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
                    .addContainerGap(9, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(227, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnCancel))
                    .addPreferredGap(ComponentPlacement.RELATED))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
