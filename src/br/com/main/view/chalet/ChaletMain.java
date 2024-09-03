package br.com.main.view.chalet;

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
import br.com.main.model.Chale;

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

public class ChaletMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tblChalets;
    private JMenuBar menuBar;
    private JMenuItem mntmHome;
    private JMenuItem mntmNew;
    private JMenuItem mntmExit;
    private JMenuItem mntmRefresh;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChaletMain frame = new ChaletMain();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ChaletMain() {
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
                ChaletInsertForm form = new ChaletInsertForm();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
            }
        });
        mntmNew.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuBar.add(mntmNew);

        mntmRefresh = new JMenuItem("Refresh");
        mntmRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Util.fetchChalet(tblChalets);
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

        JPanel panelTbl = new JPanel();
        panelTbl.setBorder(null);

        JScrollPane scrollPane = new JScrollPane();

        tblChalets = new JTable();
        tblChalets.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblChalets.getSelectedRow();
                if (row != -1) {
                    String codChale = tblChalets.getValueAt(row, 0).toString();
                    String localizacao = tblChalets.getValueAt(row, 1).toString();
                    String capacidade = tblChalets.getValueAt(row, 2).toString();
                    String valorAltaEstacao = tblChalets.getValueAt(row, 3).toString();
                    String valorBaixaEstacao = tblChalets.getValueAt(row, 4).toString();

                    ChaletAlterForm form = new ChaletAlterForm(codChale, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao);
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                }
            }
        });
        tblChalets.setBorder(null);
        tblChalets.setFillsViewportHeight(true);
        tblChalets.setForeground(Color.BLACK);
        tblChalets.setBackground(Color.WHITE);
        tblChalets.setFont(new Font("Dialog", Font.ITALIC, 12));
        tblChalets.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "codChale", "localizacao", "capacidade", "valorAltaEstacao", "valorBaixaEstacao"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Integer.class, String.class, Integer.class, Double.class, Double.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                false, true, true, true, true
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tblChalets.getColumnModel().getColumn(0).setResizable(false);

        scrollPane.setViewportView(tblChalets);
        GroupLayout gl_panelTbl = new GroupLayout(panelTbl);
        gl_panelTbl.setHorizontalGroup(
            gl_panelTbl.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
        );
        gl_panelTbl.setVerticalGroup(
            gl_panelTbl.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
        );
        panelTbl.setLayout(gl_panelTbl);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panelTbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panelTbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(gl_contentPane);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Util.fetchChalet(tblChalets);
            }
        });

        timer.start();
    }
}
