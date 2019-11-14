package br.com.udemy.unidade3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AcessoDB {
	
	final static String url = "jdbc:mysql://localhost:3306/curso_java?useTimezone=true&serverTimezone=UTC";
	final static String usuario = "curso_java";
	final static String senha = "schema";
	
	static Connection conn = null;
	
	public static void connectToDB() throws SQLException
	{
		conn = DriverManager.getConnection(url, usuario, senha);
		conn.setAutoCommit(false);
	}
	
	public static void consultaCliente() throws SQLException
	{
		String consulta = "SELECT * FROM cliente";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(consulta);
		
		while(rs.next()) {
			String msg = "cpf: " + rs.getInt(1) + " nome: " + rs.getString(2) +
					" email: " + rs.getString(3);
			
			JOptionPane.showMessageDialog(null, msg);
		}
	}
	
	public static void showMetaInfoDataBase() throws SQLException
	{
		DatabaseMetaData meta = conn.getMetaData();
		String fabricante = meta.getDatabaseProductName();
		String versao = meta.getDatabaseProductVersion();
		
		JOptionPane.showMessageDialog(null, fabricante + "<===>" + versao);
	}
	
	
	public static void main(String[] args) {
		try {
			connectToDB();
			showMetaInfoDataBase();
			consultaCliente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
