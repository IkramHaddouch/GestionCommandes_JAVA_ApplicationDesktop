package Projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tp11_baseDonnees.Voiture;

public class ConnectionBD {
	
	public static Connection getConnection() {
		Connection connexion = null;
		//etap1:tester l'accessibilite du driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver accessible?... Ok");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver accessible?... Non");
					System.exit(0);
					e.printStackTrace();
				}
				//etape2: test de connexion avec le serveur 
				try {
					connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
					System.out.println("Serveur base de donnees accessible?... Ok");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Connnexion n'est pas resussite");
					System.exit(0);
				}
				return connexion;
	}
	
}
