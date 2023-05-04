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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Gestion_Commandes extends JFrame {
	 DefaultTableModel model;

	private JPanel contentPane;
	private JTextField textIdClient;
	private JTextField textIdArticle;
	private JTextField textLivraison;
	private JTextField textQuantiteC;
	private JTextField textDate;
	private JTextField textReference;
	private JTable table;
	private JTextField textRechercher;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Commandes frame = new Gestion_Commandes();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Gestion_Commandes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 805, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Gestion des commandes");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(235, 0, 375, 48);
		panel.add(label);
		
		JLabel label1 = new JLabel("IdClient:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setForeground(Color.BLUE);
		label1.setBounds(41, 107, 113, 24);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("IdArticle:");
		label2.setForeground(Color.BLUE);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(41, 142, 113, 24);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Etat de livraison:");
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setForeground(Color.BLUE);
		label3.setBounds(41, 177, 156, 24);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Quantite de Commande:");
		label4.setForeground(Color.BLUE);
		label4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label4.setBounds(41, 218, 169, 24);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("Date de commande:");
		label5.setForeground(Color.BLUE);
		label5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label5.setBounds(41, 253, 169, 24);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("Reference:");
		label6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label6.setForeground(Color.BLUE);
		label6.setBounds(41, 288, 113, 24);
		contentPane.add(label6);
		
		textIdClient = new JTextField();
		textIdClient.setBounds(226, 111, 169, 20);
		contentPane.add(textIdClient);
		textIdClient.setColumns(10);
		
		textIdArticle = new JTextField();
		textIdArticle.setBounds(226, 146, 169, 20);
		contentPane.add(textIdArticle);
		textIdArticle.setColumns(10);
		
		textLivraison = new JTextField();
		textLivraison.setColumns(10);
		textLivraison.setBounds(226, 181, 169, 20);
		contentPane.add(textLivraison);
		
		textQuantiteC = new JTextField();
		textQuantiteC.setColumns(10);
		textQuantiteC.setBounds(226, 219, 169, 20);
		contentPane.add(textQuantiteC);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(225, 257, 169, 20);
		contentPane.add(textDate);
		
		textReference = new JTextField();
		textReference.setColumns(10);
		textReference.setBounds(226, 292, 169, 20);
		contentPane.add(textReference);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHome.setForeground(Color.RED);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion gestion = new Gestion();
				gestion.setVisible(true);
				gestion.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnHome.setBounds(10, 59, 89, 33);
		contentPane.add(btnHome);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setForeground(Color.RED);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel)table.getModel();
				int ligne = table.getSelectedRow();
				if(ligne!=-1) {
					supprimer();
					if(JOptionPane.showConfirmDialog(null, "Est-ce que vous voulez vraiment supprimer cette ligne de "
							+ "commande?")==0)
					{
						PreparedStatement s;
						String reference = textReference.getText();
						String req = "DELETE from commandes WHERE reference=?";
						try {
							s = ConnectionBD.getConnection().prepareStatement(req);
							s.setString(1, reference);
							if(textReference.getText().length() != 0) {
								s.execute();
								JOptionPane.showMessageDialog(null, "La ligne de commandes est supprimee ");
							}
							else {
								JOptionPane.showMessageDialog(null, "Veuillez remplire le champs reference!");
							}
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas "
									+ "reussite");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "La commandes  n'est pas supprimee");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner dans le tableau la ligne que vous "
							+ "voulez supprimer");
				}
			}
		});
		btnSupprimer.setBounds(210, 359, 103, 33);
		contentPane.add(btnSupprimer);
		
		
		String[] article = {"Dacia","Ford_Fiesta","Volvo"};
		JComboBox comboBox = new JComboBox(article);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setForeground(Color.RED);
		comboBox.setBackground(new Color(245, 222, 179));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dacia", "Ford_Fiesta", "Volvo"}));
		comboBox.setBounds(496, 364, 113, 22);
		contentPane.add(comboBox);
		
		
		
		table = new JTable();
		table.setBackground(new Color(255, 222, 173));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"IdClient", "IdArticle", "Livraision", "Date", "Quantite", "Reference"},
			},
			new String[] {
				"IdClient", "IdArticle", "Livraison", "Date", "Quantite", "Reference"
			}
		));
		table.setBounds(405, 63, 390, 249);
		contentPane.add(table);
		
		model = (DefaultTableModel)table.getModel();
		PreparedStatement s;
		String requette = "select * from commandes";
		ResultSet resultat;
		try {
			s = ConnectionBD.getConnection().prepareStatement(requette);
			resultat=s.executeQuery(requette);
			while(resultat.next()) { 
				model.addRow(new Object[] {resultat.getInt(1),resultat.getInt(2),resultat.getString(3),resultat.getString(4),
						resultat.getInt(5),resultat.getInt(6)});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
			System.out.println(e.getMessage());
		}
		contentPane.add(table);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.setForeground(Color.RED);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel)table.getModel();
				int ligne = table.getSelectedRow();
				if(ligne!=-1) {
					modifier();
					if(JOptionPane.showConfirmDialog(null, "Confirmer la modification?")==0)
					{
						PreparedStatement ps;
						String reference = textReference.getText();
						String idClient = textIdClient.getText();
						String idArticle = textIdArticle.getText();
						String livraison = textLivraison.getText();
						String date = textDate.getText();
						String quantiteCommande = textQuantiteC.getText();
						String marque = comboBox.getSelectedItem().toString();
						String requette1 = "UPDATE commandes SET idClient=?,idArticle=?,livraison=?,date=?,quantiteCommande=?,"
								+ "marque=? WHERE reference='"+reference+"' ";
						
						try {
							ps = ConnectionBD.getConnection().prepareStatement(requette1);
							ps.setString(1, idClient);
							ps.setString(2, idArticle);
							ps.setString(3, livraison);
							ps.setString(4, date);
							ps.setString(5, quantiteCommande);
							ps.setString(6, marque);
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
				else {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner dans le tableau la ligne que vous "
							+ "voulez modifier");
				}
			}
		});
		btnModifier.setBounds(65, 359, 99, 33);
		contentPane.add(btnModifier);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValider.setForeground(Color.RED);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter();
				PreparedStatement s;
				String reference = textReference.getText();
				String req = "SELECT * from commandes where reference=?";
				ResultSet resultat;
				try {
					s = ConnectionBD.getConnection().prepareStatement(req);
					s.setString(1, reference);
					resultat=s.executeQuery();
					if(resultat.next()) {
						JOptionPane.showMessageDialog(null, "Cette ligne de cammande est deja existe!");
					}else{
	                    PreparedStatement st; 
						
						String idClient = textIdClient.getText();
						String idArticle = textIdArticle.getText();
						String livraison = textLivraison.getText();
						String date = textDate.getText();
						String quantiteCommande = textQuantiteC.getText();
						String marque = comboBox.getSelectedItem().toString();
						
						String requette = "INSERT INTO commandes(idClient,idArticle,livraison"
										+ ",date,quantiteCommande,marque) VALUES(?,?,?,?,?,?)";
						try {
								st = ConnectionBD.getConnection().prepareStatement(requette);
									
				     			st.setString(1, idClient);
								st.setString(2, idArticle);
								st.setString(3, livraison);
								st.setString(4, date);
								st.setString(5, quantiteCommande);
								st.setString(6, marque);
								st.execute();
								JOptionPane.showMessageDialog(null, "votre ligne de commande est ajoute", "Succes",
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
		btnValider.setBounds(353, 360, 102, 31);
		contentPane.add(btnValider);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechercher.setForeground(Color.RED);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement s;
				String reference = textRechercher.getText();
				String req = "SELECT * from commandes where reference=?";
				ResultSet resultat;
				try {
					s = ConnectionBD.getConnection().prepareStatement(req);
					s.setString(1, reference);
					resultat=s.executeQuery();
					if(resultat.next()) {
						textIdClient.setText(resultat.getString(1));
						textIdArticle.setText(resultat.getString(2));
						textLivraison.setText(resultat.getString(3));
						textDate.setText(resultat.getString(4));
						textQuantiteC.setText(resultat.getString(5));
						textReference.setText(resultat.getString(6));
					}
					else {
						JOptionPane.showMessageDialog(null, "Cette ligne de commande n'existe pas ");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
				}
			}
		});
		btnRechercher.setBounds(101, 64, 103, 23);
		contentPane.add(btnRechercher);
		
		textRechercher = new JTextField();
		textRechercher.setBounds(200, 65, 194, 20);
		contentPane.add(textRechercher);
		textRechercher.setColumns(10);
	}
	private void ajouter() {
		model = (DefaultTableModel)table.getModel();
		
		if(textReference.getText().equals("")||textIdClient.getText().equals("")||textIdArticle.getText().equals("")||
				textLivraison.getText().equals("")||textQuantiteC.getText().equals("")||textDate.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Remplissez tous les champs SVP!", "Champs vides",JOptionPane.ERROR_MESSAGE);
		}
		else {
			PreparedStatement s;
			String reference = textReference.getText();
			String req = "SELECT * from commandes where reference=?";
			ResultSet resultat;
			try {
				s = ConnectionBD.getConnection().prepareStatement(req);
				s.setString(1, reference);
				resultat=s.executeQuery();
				if(resultat.next()) {
					
				}
				else{
			        model.addRow(new Object[] {textReference.getText(),textIdClient.getText(),textIdArticle.getText()
					,textLivraison.getText(),textQuantiteC.getText(),textDate.getText()});
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	private void supprimer() {
		model = (DefaultTableModel)table.getModel();
		int ligne = table.getSelectedRow();
		if(ligne!=-1) {
			model.removeRow(ligne);
		}
		
	}
	
	 private void modifier() {
		 model = (DefaultTableModel)table.getModel();
			int ligne = table.getSelectedRow();
			if(ligne!=-1) {
				model.setValueAt(textLivraison.getText(), ligne, 2);
				model.setValueAt(textDate.getText(), ligne, 3);
				model.setValueAt(textQuantiteC.getText(), ligne, 4);
			}	
	 }
}