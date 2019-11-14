package br.com.udemy.unidade3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AcessoDB {

	public static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static String usuario = "curso_java";
	public static String senha = "schema";
	
	public static Connection conn = null;
	
	public static void connectToDB() throws SQLException
	{
		conn = DriverManager.getConnection(url, usuario, senha);
		conn.setAutoCommit(false);
	}
	
	public static void consultaClientes() throws SQLException 
	{
		String query = "SELECT * FROM CLIENTE";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			JOptionPane.showMessageDialog(null, "cpf: " + rs.getInt(1) + " nome: " + rs.getString(2) +
					" e-mail: " + rs.getString(3));
		}
	}
	
	
	public static void showMetadatabase() throws SQLException 
	{
		DatabaseMetaData meta = conn.getMetaData();
		String fabri = meta.getDatabaseProductName();
		String vers = meta.getDatabaseProductVersion();
		
		JOptionPane.showMessageDialog(null, fabri + " <===> " + vers);
	}
	
	public static void main(String[] args) {
		try {
			connectToDB();
			showMetadatabase();
			consultaClientes();
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
