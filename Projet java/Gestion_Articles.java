package Projet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class Gestion_Articles extends JFrame {
    DefaultTableModel model;

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textLibelle;
	private JTextField textPrix;
	private JTextField textMarque;
	private JTextField textQuantite;
	private JTextField textTVA;
	private JTextField textRechercher;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Articles frame = new Gestion_Articles();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public Gestion_Articles() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(0, 0, 787, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Gestions des articles");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(221, 0, 303, 46);
		panel.add(label);
		
		JLabel label1 = new JLabel("id:");
		label1.setForeground(new Color(0, 0, 255));
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(39, 101, 117, 24);
		contentPane.add(label1);
		
		textId = new JTextField();
		textId.setBounds(197, 105, 200, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel label2 = new JLabel("Libelle:");
		label2.setForeground(new Color(0, 0, 255));
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(39, 133, 117, 23);
		contentPane.add(label2);
		
		textLibelle = new JTextField();
		textLibelle.setColumns(10);
		textLibelle.setBounds(197, 136, 200, 20);
		contentPane.add(textLibelle);
		
		textPrix = new JTextField();
		textPrix.setColumns(10);
		textPrix.setBounds(197, 167, 200, 20);
		contentPane.add(textPrix);
		
		textMarque = new JTextField();
		textMarque.setColumns(10);
		textMarque.setBounds(197, 198, 200, 20);
		contentPane.add(textMarque);
		
		textQuantite = new JTextField();
		textQuantite.setColumns(10);
		textQuantite.setBounds(197, 230, 200, 20);
		contentPane.add(textQuantite);
		
		textTVA = new JTextField();
		textTVA.setColumns(10);
		textTVA.setBounds(197, 262, 200, 20);
		contentPane.add(textTVA);
		
		JLabel label3 = new JLabel("Prix:");
		label3.setForeground(new Color(0, 0, 255));
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setBounds(39, 171, 119, 20);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Marque:");
		label4.setForeground(new Color(0, 0, 255));
		label4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label4.setBounds(39, 196, 119, 20);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("Quantite en stock:");
		label5.setForeground(new Color(0, 0, 255));
		label5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label5.setBounds(39, 228, 139, 20);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("TVA:");
		label6.setForeground(new Color(0, 0, 255));
		label6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label6.setBounds(39, 260, 119, 20);
		contentPane.add(label6);
		
			
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechercher.setForeground(new Color(255, 0, 0));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement s;
				String id = textRechercher.getText();
				String req = "SELECT * from articles where id=?";
				ResultSet resultat;
				try {
					s = ConnectionBD.getConnection().prepareStatement(req);
					s.setString(1, id);
					resultat=s.executeQuery();
					if(resultat.next()) {
						textId.setText(resultat.getString(1));
						textLibelle.setText(resultat.getString(2));
						textPrix.setText(resultat.getString(3));
						textMarque.setText(resultat.getString(4));
						textQuantite.setText(resultat.getString(5));
						textTVA.setText(resultat.getString(6));
					}
					else {
						JOptionPane.showMessageDialog(null, "Cet article n'existe pas ");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
				}
			}
		});
		btnRechercher.setBounds(77, 57, 101, 21);
		contentPane.add(btnRechercher);
		
		textRechercher = new JTextField();
		textRechercher.setBounds(179, 58, 218, 20);
		contentPane.add(textRechercher);
		textRechercher.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.setBackground(UIManager.getColor("Button.light"));
		btnAjouter.setForeground(new Color(255, 0, 0));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter();
				if(textLibelle.getText().equals("")||textPrix.getText().equals("")||textMarque.getText().equals("")
						||textQuantite.getText().equals("")||textTVA.getText().equals("")) {
				}
				else {
					PreparedStatement s;
					String id = textId.getText();
					String req = "SELECT * from articles where id=?";
					ResultSet resultat;
					try {
						s = ConnectionBD.getConnection().prepareStatement(req);
						s.setString(1, id);
						resultat=s.executeQuery();
						if(resultat.next()) {
							JOptionPane.showMessageDialog(null, "Client connu ");
						}else{
		                    PreparedStatement st; 
							
							String libelle = textLibelle.getText();
							String prix = textPrix.getText();
							String marque = textMarque.getText();
							String quantiteStock = textQuantite.getText();
							String tva = textTVA.getText();
							
							String requette = "INSERT INTO articles(libelle,prix,marque,quantiteStock,tva) VALUES(?,?,?,?,?)";
							try {
									st = ConnectionBD.getConnection().prepareStatement(requette);
										
					     			st.setString(1, libelle);
									st.setString(2, prix);
									st.setString(3, marque);
									st.setString(4, quantiteStock);
									st.setString(5, tva);
									st.execute();
									JOptionPane.showMessageDialog(null, "cet article est ajoute", "Succes",
												JOptionPane.PLAIN_MESSAGE);
									
								
								
							}catch(Exception ex) {
								JOptionPane.showMessageDialog(null, "Pas de connexion avec la base de donnees  ");
							}
						}
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas "
								+ "reussite");
					}
				}
			}
		});
		btnAjouter.setBounds(23, 347, 101, 35);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setForeground(new Color(255, 0, 0));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel)table.getModel();
				int ligne = table.getSelectedRow();
				if(ligne!=-1) {
					supprimer();
					if(JOptionPane.showConfirmDialog(null, "Est-ce que vous voulez vraiment supprimer cet article?")==0)
					{
						PreparedStatement s;
						String id = textId.getText();
						String req = "DELETE from articles WHERE id=?";
						try {
							s = ConnectionBD.getConnection().prepareStatement(req);
							s.setString(1, id);
							if(textId.getText().length() != 0) {
								s.execute();
								JOptionPane.showMessageDialog(null, "L'article est supprime");
							}
							else {
								JOptionPane.showMessageDialog(null, "Veuillez remplire le champs id!");
							}
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "L'article n'est pas supprime");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner dans le tableau la ligne que vous "
							+ "voulez supprimer");
				}
			}
		});
		btnSupprimer.setBounds(158, 347, 101, 35);
		contentPane.add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.setForeground(new Color(255, 0, 0));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel)table.getModel();
				int ligne = table.getSelectedRow();
				if(ligne!=-1) {
					modifier();
					if(JOptionPane.showConfirmDialog(null, "Confirmer la modification?")==0)
					{
						PreparedStatement ps;
						String id = textId.getText();
						String libelle = textLibelle.getText();
						String prix = textPrix.getText();
						String marque = textMarque.getText();
						String quantiteStock = textQuantite.getText();
						String tva = textTVA.getText();
						String requette1 = "UPDATE articles SET libelle=?,prix=?,marque=?,quantiteStock=?,tva=?"
								+ " WHERE id='"+id+"' ";
						
						try {
							ps = ConnectionBD.getConnection().prepareStatement(requette1);
							ps.setString(1, libelle);
							ps.setString(2, prix);
							ps.setString(3, marque);
							ps.setString(4, quantiteStock);
							ps.setString(5, tva);
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
		btnModifier.setBounds(290, 347, 101, 35);
		contentPane.add(btnModifier);
		
		table = new JTable();
		table.setBackground(new Color(255, 228, 181));
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id", "Libelle", "Prix", "Marque", "Quantite", "TVA"},
			},
			new String[] {
				"Id", "Libelle", "Prix", "Marque", "Quantite", "TVA"
			}
			
		));
		table.setBounds(407, 57, 370, 328);
		contentPane.add(table);
		
		model = (DefaultTableModel)table.getModel();
		PreparedStatement s;
		String requette = "select * from articles";
		ResultSet resultat;
		try {
			s = ConnectionBD.getConnection().prepareStatement(requette);
			resultat=s.executeQuery(requette);
			while(resultat.next()) { 
				model.addRow(new Object[] {resultat.getInt(1),resultat.getString(2),resultat.getFloat(3),resultat.getString(4),
						resultat.getInt(5),resultat.getInt(6)});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connexion avec la base de donnees n'est pas reussite");
			System.out.println(e.getMessage());
		}
		contentPane.add(table);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion gestion = new Gestion();
				gestion.setVisible(true);
				gestion.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnHome.setForeground(Color.RED);
		btnHome.setBounds(0, 51, 71, 33);
		contentPane.add(btnHome);
	}


	private void ajouter() {
		model = (DefaultTableModel)table.getModel();
		
		if(textId.getText().equals("")||textLibelle.getText().equals("")||textPrix.getText().equals("")||
				textMarque.getText().equals("")||textQuantite.getText().equals("")||textTVA.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Remplissez tous les champs SVP!", "Champs vides",JOptionPane.ERROR_MESSAGE);
		}
		else {
			PreparedStatement s;
			String id = textId.getText();
			String req = "SELECT * from articles where id=?";
			ResultSet resultat;
			try {
				s = ConnectionBD.getConnection().prepareStatement(req);
				s.setString(1, id);
				resultat=s.executeQuery();
				if(resultat.next()) {
					
				}
				else{
			        model.addRow(new Object[] {textId.getText(),textLibelle.getText(),textPrix.getText(),textMarque.getText()
					,textQuantite.getText(),textTVA.getText()});
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
				model.setValueAt(textLibelle.getText(), ligne, 1);
				model.setValueAt(textPrix.getText(), ligne, 2);
				model.setValueAt(textMarque.getText(), ligne, 3);
				model.setValueAt(textQuantite.getText(), ligne, 4);
				model.setValueAt(textTVA.getText(), ligne, 5);
				
			}	
	 }
}
