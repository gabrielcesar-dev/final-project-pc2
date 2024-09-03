package br.com.main.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.main.view.chalet.ChaletMain;
import br.com.main.view.client.ClientMain;
import br.com.main.view.stay.StayMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    public Main() {
        setResizable(false);
        setTitle("Main Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;
            private Image logo;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (logo != null) {
                    g.drawImage(logo, 0, 0, getWidth(), getHeight(), this);
                }
            }

            {
                URL imageUrl = getClass().getResource("/br/com/main/resources/images/image.png");
                if (imageUrl != null) {
                    logo = Toolkit.getDefaultToolkit().getImage(imageUrl);
                } else {
                    System.out.println("Image not found!");
                }
            }
        };

        panel.setLayout(null);

        JButton btnClient = new JButton("Client");
        JButton btnStay = new JButton("Stay");
        JButton btnChalet = new JButton("Chalet");

        btnClient.setFont(new Font("Arial", Font.BOLD, 18));
        btnClient.setForeground(Color.BLACK); 
        btnClient.setBackground(Color.WHITE); 
        btnClient.setBorderPainted(true); 
        btnClient.setBounds(29, 100, 150, 50);

        btnStay.setFont(new Font("Arial", Font.BOLD, 18));
        btnStay.setForeground(Color.BLACK); 
        btnStay.setBackground(Color.WHITE); 
        btnStay.setBorderPainted(true); 
        btnStay.setBounds(216, 100, 150, 50);

        btnChalet.setFont(new Font("Arial", Font.BOLD, 18));
        btnChalet.setForeground(Color.BLACK); 
        btnChalet.setBackground(Color.WHITE); 
        btnChalet.setBorderPainted(true); 
        btnChalet.setBounds(411, 100, 150, 50);

        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientMain().setVisible(true);
                dispose(); 
            }
        });

        btnStay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StayMain().setVisible(true);
                dispose(); 
            }
        });

        btnChalet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChaletMain().setVisible(true);
                dispose(); 
            }
        });

        panel.add(btnClient);
        panel.add(btnStay);
        panel.add(btnChalet);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
