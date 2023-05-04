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
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class Gestion_Clients extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textAge;
	private JTextField textNumSSociale;
	private JTextField textAdresseLivraison;
	private JTextField textAdresseFacturation;
	private JTextField textTel;
	private JTextField textEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textRechercher;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Clients frame = new Gestion_Clients();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Gestion_Clients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(0, 0, 748, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Gestion des clients");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(178, 0, 393, 33);
		panel.add(label);
		
		JLabel label2 = new JLabel("Nom:");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setForeground(Color.BLUE);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(55, 110, 146, 22);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Prenom:");
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setForeground(Color.BLUE);
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setBounds(55, 141, 146, 20);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Age:");
		label4.setHorizontalAlignment(SwingConstants.LEFT);
		label4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label4.setForeground(Color.BLUE);
		label4.setBounds(55, 168, 146, 22);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("Num de securite sociale:");
		label5.setHorizontalAlignment(SwingConstants.LEFT);
		label5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label5.setForeground(Color.BLUE);
		label5.setBounds(55, 201, 175, 26);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("Adresse de livraison:");
		label6.setHorizontalAlignment(SwingConstants.LEFT);
		label6.setForeground(Color.BLUE);
		label6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label6.setBounds(55, 226, 175, 30);
		contentPane.add(label6);
		
		JLabel label7 = new JLabel("Adresse de facturation:");
		label7.setHorizontalAlignment(SwingConstants.LEFT);
		label7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label7.setForeground(Color.BLUE);
		label7.setBounds(55, 259, 175, 26);
		contentPane.add(label7);
		
		JLabel label8 = new JLabel("Tel:");
		label8.setForeground(Color.BLUE);
		label8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label8.setHorizontalAlignment(SwingConstants.LEFT);
		label8.setBounds(55, 292, 146, 26);
		contentPane.add(label8);
		
		JLabel label1 = new JLabel("id:");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setForeground(Color.BLUE);
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(55, 79, 146, 20);
		contentPane.add(label1);
		
		JLabel label9 = new JLabel("Email:");
		label9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label9.setForeground(Color.BLUE);
		label9.setHorizontalAlignment(SwingConstants.LEFT);
		label9.setBounds(55, 323, 146, 26);
		contentPane.add(label9);
		
		textId = new JTextField();
		textId.setBounds(265, 80, 309, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(265, 112, 309, 20);
		contentPane.add(textNom);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(265, 141, 309, 20);
		contentPane.add(textPrenom);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(265, 170, 309, 20);
		contentPane.add(textAge);
		
		textNumSSociale = new JTextField();
		textNumSSociale.setColumns(10);
		textNumSSociale.setBounds(265, 205, 309, 20);
		contentPane.add(textNumSSociale);
		
		textAdresseLivraison = new JTextField();
		textAdresseLivraison.setColumns(10);
		textAdresseLivraison.setBounds(265, 232, 309, 20);
		contentPane.add(textAdresseLivraison);
		
		textAdresseFacturation = new JTextField();
		textAdresseFacturation.setColumns(10);
		textAdresseFacturation.setBounds(265, 265, 309, 20);
		contentPane.add(textAdresseFacturation);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(265, 296, 309, 20);
		contentPane.add(textTel);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(265, 327, 309, 20);
		contentPane.add(textEmail);
		
		JRadioButton rdbtnHomme = new JRadioButton("Homme");
		buttonGroup.add(rdbtnHomme);
		rdbtnHomme.setBounds(265, 356, 88, 23);
		contentPane.add(rdbtnHomme);
		
		JRadioButton rdbtnFemme = new JRadioButton("Femme");
		buttonGroup.add(rdbtnFemme);
		rdbtnFemme.setBounds(385, 354, 88, 23);
		contentPane.add(rdbtnFemme);
		
		JLabel label10 = new JLabel("sexe:");
		label10.setForeground(Color.BLUE);
		label10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label10.setBounds(55, 356, 72, 23);
		contentPane.add(label10);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setForeground(Color.RED);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Est-ce que vous voulez vraiment supprimer ce client?")==0)
				{
					PreparedStatement s;
					String id = textId.getText();
					String req = "DELETE from clients WHERE id=?";
					try {
						s = ConnectionBD.getConnection().prepareStatement(req);
						s.setString(1, id);
						if(textId.getText().length() != 0) {
							s.execute();
							JOptionPane.showMessageDialog(null, "Le client est supprime");
						}
						else {
							JOptionPane.showMessageDialog(null, "Veuillez remplire le champs id!");
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Le client n'est pas supprime");
				}
			}
		});
		btnSupprimer.setBounds(529, 402, 106, 40);
		contentPane.add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.setForeground(Color.RED);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirmer la modification?")==0)
				{
					PreparedStatement ps;
					String id = textId.getText();
					String nom = textNom.getText();
					String prenom = textPrenom.getText();
					String age = textAge.getText();
					String numSSociale = textNumSSociale.getText();
					String adresseLivraison = textAdresseLivraison.getText();
					String adresseFacturation = textAdresseFacturation.getText();
					String tel = textTel.getText();
					String email = textEmail.getText();
					String requette1 = "UPDATE clients SET nom=?,prenom=?,age=?,numSSociale=?,adresseLivraison=?,"
							+ "adresseFacturation=?,tel=?,email=? WHERE id='"+id+"' ";
					
					try {
						ps = ConnectionBD.getConnection().prepareStatement(requette1);
						ps.setString(1, nom);
						ps.setString(2, prenom);
						ps.setString(3, age);
						ps.setString(4, numSSociale);
						ps.setString(5, adresseLivraison);
						ps.setString(6, adresseFacturation);
						ps.setString(7, tel);
						ps.setString(8, email);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Modification avec succes");
						
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
					}
				}
			    else {
			    	JOptionPane.showMessageDialog(null, "La modification n'est pas faite");
			    }
			}
		});
		btnModifier.setBounds(327, 402, 106, 40);
		contentPane.add(btnModifier);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechercher.setForeground(Color.RED);
		btnRechercher.setBackground(UIManager.getColor("Button.light"));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement s;
				String id = textRechercher.getText();
				String req = "SELECT * from clients where id=?";
				ResultSet resultat;
				try {
					s = ConnectionBD.getConnection().prepareStatement(req);
					s.setString(1, id);
					resultat=s.executeQuery();
					if(resultat.next()) {
						textId.setText(resultat.getString(1));
						textNom.setText(resultat.getString(2));
						textPrenom.setText(resultat.getString(3));
						textAge.setText(resultat.getString(4));
						textNumSSociale.setText(resultat.getString(5));
						textAdresseLivraison.setText(resultat.getString(6));
						textAdresseFacturation.setText(resultat.getString(7));
						textTel.setText(resultat.getString(8));
						textEmail.setText(resultat.getString(9));
					}
					else {
						JOptionPane.showMessageDialog(null, "Ce client n'existe pas ");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
				}
			}
		});
		btnRechercher.setBounds(95, 43, 106, 22);
		contentPane.add(btnRechercher);
		
		textRechercher = new JTextField();
		textRechercher.setBounds(202, 44, 399, 20);
		contentPane.add(textRechercher);
		textRechercher.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.setForeground(Color.RED);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement s;
				String id = textId.getText();
				String req = "SELECT * from clients where id=?";
				ResultSet resultat;
				try {
					s = ConnectionBD.getConnection().prepareStatement(req);
					s.setString(1, id);
					resultat=s.executeQuery();
					if(resultat.next()) {
						JOptionPane.showMessageDialog(null, "Client connu ");
					}else{
	                    PreparedStatement st; 
						
						String nom = textNom.getText();
						String prenom = textPrenom.getText();
						String age = textAge.getText();
						String numSSociale = textNumSSociale.getText();
						String adresseLivraison = textAdresseLivraison.getText();
						String adresseFacturation = textAdresseFacturation.getText();
						String tel = textTel.getText();
						String email = textEmail.getText();
						
						
							
						String requette = "INSERT INTO clients(nom,prenom,age,numSSociale,adresseLivraison,adresseFacturation"
										+ ",tel,email) VALUES(?,?,?,?,?,?,?,?)";
						try {
								st = ConnectionBD.getConnection().prepareStatement(requette);
									
				     			st.setString(1, nom);
								st.setString(2, prenom);
								st.setString(3, age);
								st.setString(4, numSSociale);
								st.setString(5, adresseLivraison);
								st.setString(6, adresseFacturation);
								st.setString(7, tel);
								st.setString(8, email);
								st.execute();
								JOptionPane.showMessageDialog(null, "votre client est ajoute", "Succes",
											JOptionPane.PLAIN_MESSAGE);
								
							
							
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas "
									+ "reussite");
						}
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas "
							+ "reussite");
				}
				
				}
		});
		btnAjouter.setBounds(124, 402, 106, 40);
		contentPane.add(btnAjouter);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion gestion = new Gestion();
				gestion.setVisible(true);
				gestion.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnHome.setBackground(UIManager.getColor("Button.light"));
		btnHome.setForeground(Color.RED);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setBounds(644, 43, 82, 33);
		contentPane.add(btnHome);
	}
}
