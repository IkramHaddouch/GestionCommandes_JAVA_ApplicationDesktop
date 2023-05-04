package Projet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registre extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textUsername;
	private JTextField textPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registre frame = new Registre();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(0, 0, 434, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Veuillez entrer vos informations");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(57, 11, 315, 25);
		panel.add(label);
		
		JLabel label1 = new JLabel("Name:");
		label1.setForeground(Color.BLUE);
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(35, 97, 71, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Username:");
		label2.setForeground(Color.BLUE);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(35, 143, 91, 17);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Password:");
		label3.setForeground(Color.BLUE);
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setBounds(35, 187, 91, 17);
		contentPane.add(label3);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setForeground(new Color(255, 255, 255));
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals("")||textUsername.getText().equals("")||
						textPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SVP entrez vos informations", "information",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					String name = textName.getText();
					String username = textUsername.getText();
					String password = textPassword.getText();
					PreparedStatement st;
					String requette = "INSERT INTO gestion.users(name,username,password) values(?,?,?)";
					try {
						st = ConnectionBD.getConnection().prepareStatement(requette);
						st.setString(1, name);
						st.setString(2, username);
						st.setString(3, password);
						if(st.executeUpdate()!=0) {
							JOptionPane.showMessageDialog(null, "votre compte est cree", "Succes",
									JOptionPane.PLAIN_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "votre compte n'est pas cree", "Failed",
									JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception  ex) {
						JOptionPane.showMessageDialog(null, "La connexion avec la base de donnees "
								+ "n'est pas reussite", "Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		
		btnConfirmer.setBackground(new Color(135, 206, 235));
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmer.setBounds(150, 278, 128, 31);
		contentPane.add(btnConfirmer);
		
		textName = new JTextField();
		textName.setBounds(164, 96, 193, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(164, 143, 193, 20);
		contentPane.add(textUsername);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(164, 187, 193, 20);
		contentPane.add(textPassword);
		
		JLabel labelRetour = new JLabel("Cliquer ici pour retourner a la page login");
		labelRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		labelRetour.setForeground(Color.GREEN);
		labelRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelRetour.setHorizontalAlignment(SwingConstants.CENTER);
		labelRetour.setBounds(64, 335, 293, 23);
		contentPane.add(labelRetour);
	}
}
