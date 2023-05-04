package Projet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Login extends JFrame  {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(0, 0, 490, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBackground(Color.PINK);
		labelLogin.setForeground(Color.WHITE);
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogin.setBounds(131, 11, 213, 33);
		panel.add(labelLogin);
		
		JLabel label1 = new JLabel("Username:");
		label1.setForeground(new Color(51, 0, 255));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(35, 89, 78, 21);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Password:");
		label2.setForeground(new Color(51, 0, 255));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(35, 127, 78, 21);
		contentPane.add(label2);
		
		textUsername = new JTextField();
		textUsername.setBounds(148, 89, 232, 21);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(148, 127, 232, 21);
		contentPane.add(textPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textUsername.getText().equals("")||textPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SVP entrez vos informations", "information",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					PreparedStatement st; 
					ResultSet resultat;
					String username = textUsername.getText();
					String password = textPassword.getText();
					String requette = "SELECT * FROM gestion.users WHERE username=? AND password=?";
					try {
						st = ConnectionBD.getConnection().prepareStatement(requette);
						st.setString(1,username);
						st.setString(2,password);
						resultat=st.executeQuery();
						if(resultat.next()) {
							Gestion gestion = new Gestion();
							gestion.setVisible(true);
							gestion.setLocationRelativeTo(null);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "username ou password incorrect", 
									"incorrect information", JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas "
								+ "reussite");
					}
				}
			}
		});
		
		btnLogin.setForeground(new Color(0, 0, 255));
		btnLogin.setBackground(new Color(173, 216, 230));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(181, 189, 109, 29);
		contentPane.add(btnLogin);
		
		//ajouer un nouveau compte
		JLabel labelRegistre = new JLabel("Cliquer ici pour creer un nouveau compte");
		labelRegistre.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) { //si je clique sur creer un nouveau compte
				Registre registre = new Registre(); //on cree un JFrame de type Regitre
				registre.setVisible(true); //je l'affiche
				registre.setLocationRelativeTo(null); 
				dispose();//fermer la fenetre Login
			}
		});
		labelRegistre.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegistre.setForeground(new Color(255, 0, 0));
		labelRegistre.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelRegistre.setBounds(81, 264, 328, 21);
		contentPane.add(labelRegistre);
		
		
	}
}
