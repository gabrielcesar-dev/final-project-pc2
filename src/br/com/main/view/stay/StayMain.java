package br.com.main.view.stay;

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

public class StayMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tblStays;
    private JMenuBar menuBar;
    private JMenuItem mntmHome;
    private JMenuItem mntmNew;
    private JMenuItem mntmExit;
    private JMenuItem mntmRefresh;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StayMain frame = new StayMain();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StayMain() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        mntmHome = new JMenuItem("Home");
        mntmHome.setBorder(new LineBorder(new Color(0, 0, 0)));
        mntmHome.setHorizontalTextPosition(SwingConstants.CENTER);
        mntmHome.setFont(new Font("Dialog", Font.BOLD, 12));
        mntmHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuBar.add(mntmHome);

        mntmNew = new JMenuItem("New");
        mntmNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StayInsertForm form = new StayInsertForm();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
            }
        });
        mntmNew.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuBar.add(mntmNew);

        mntmRefresh = new JMenuItem("Refresh");
        mntmRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Util.fetchStay(tblStays); 
            }
        });
        mntmRefresh.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuBar.add(mntmRefresh);

        mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mntmExit.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuBar.add(mntmExit);

        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel PanelTbl = new JPanel();
        PanelTbl.setBorder(null);

        JScrollPane scrollPane = new JScrollPane();

        tblStays = new JTable();
        tblStays.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblStays.getSelectedRow();
                if (row != -1) {
                    String codHospedagem = tblStays.getValueAt(row, 0).toString();
                    String codChale = tblStays.getValueAt(row, 1).toString();
                    String codCliente = tblStays.getValueAt(row, 2).toString();
                    String estado = tblStays.getValueAt(row, 3).toString();
                    String dataInicio = tblStays.getValueAt(row, 4).toString();
                    String dataFim = tblStays.getValueAt(row, 5).toString();
                    String qtdPessoas = tblStays.getValueAt(row, 6).toString();
                    String desconto = tblStays.getValueAt(row, 7).toString();
                    String valorFinal = tblStays.getValueAt(row, 8).toString();

                    //StayAlterForm form = new StayAlterForm(codHospedagem, codChale, codCliente, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal);
                    //form.setVisible(true);
                    //form.setLocationRelativeTo(null);
                }
            }
        });
        tblStays.setBorder(null);
        tblStays.setFillsViewportHeight(true);
        tblStays.setForeground(Color.BLACK);
        tblStays.setBackground(Color.WHITE);
        tblStays.setFont(new Font("Dialog", Font.ITALIC, 12));
        tblStays.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "codHospedagem", "codChale", "codCliente", "estado", "dataInicio", "dataFim", "qtdPessoas", "desconto", "valorFinal"
            }
        ) {
            Class[] columnTypes = new Class[] {
                String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
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
        tblStays.getColumnModel().getColumn(0).setResizable(false);

        scrollPane.setViewportView(tblStays);
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

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Util.fetchStay(tblStays); 
            }
        });

        timer.start();
    }
}
