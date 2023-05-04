package Projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Gestion extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 0, 0));
		panel1.setBounds(0, 0, 737, 67);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblGectionDesVentes = new JLabel("Gection des ventes");
		lblGectionDesVentes.setForeground(Color.WHITE);
		lblGectionDesVentes.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGectionDesVentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGectionDesVentes.setBounds(162, 0, 413, 67);
		panel1.add(lblGectionDesVentes);
		
		JButton btnClient = new JButton("");
		btnClient.setIcon(new ImageIcon("C:\\Users\\pci\\Pictures\\img\\client.jpg"));
		btnClient.setBounds(53, 117, 160, 146);
		contentPane.add(btnClient);
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Clients gestionC = new Gestion_Clients();
				gestionC.setVisible(true);
				gestionC.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnCommande = new JButton("");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Commandes gestionCM = new Gestion_Commandes();
				gestionCM.setVisible(true);
				gestionCM.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCommande.setIcon(new ImageIcon("C:\\Users\\pci\\Pictures\\img\\commande.png"));
		btnCommande.setBounds(250, 179, 213, 204);
		contentPane.add(btnCommande);
		
		JButton btnArticle = new JButton("");
		btnArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Articles gestionA = new Gestion_Articles();
				gestionA.setVisible(true);
				gestionA.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnArticle.setIcon(new ImageIcon("C:\\Users\\pci\\Pictures\\img\\article.png"));
		btnArticle.setBounds(518, 92, 171, 171);
		contentPane.add(btnArticle);
		btnArticle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Gestion des clients");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(53, 279, 160, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des articles");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(518, 279, 181, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion des commandes");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(250, 394, 213, 42);
		contentPane.add(lblNewLabel_2);
	}
}
