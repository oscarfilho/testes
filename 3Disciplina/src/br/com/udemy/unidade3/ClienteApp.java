package br.com.udemy.unidade3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClienteApp {

	public static String url = "jdbc:mysql://localhost:3306/curso_java?useTimezone=true&serverTimezone=UTC";
	public static String user = "curso_java";
	public static String pass = "schema";
	
	public static Connection conn = null;
	
	public static void connect() throws SQLException {
		conn = DriverManager.getConnection(url, user, pass);
		conn.setAutoCommit(false);
	}
	
	
	public static Boolean inserir(long cpf, String nome, String email) throws SQLException {
		final String sql = "INSERT INTO cliente(cpf, nome, email) VALUES(" + 
						   cpf + ", '" + 
						   nome + "','" + 
						   email + "')";
		
		Statement stmt = conn.createStatement();
		
		Boolean r = stmt.execute(sql);
		
		conn.commit();
		
		return r;
	}
	
	public static int editar(long cpf, String nome, String email) throws SQLException {
		final String sql = "UPDATE cliente SET nome = '" + nome + "', email = '" +  email + "' WHERE cpf = " + cpf;

		Statement stmt = conn.createStatement();

		int r = stmt.executeUpdate(sql);
		
		conn.commit();
		
		return r;
	}
	
	public static int remover(long cpf) throws SQLException {
		final String sql = "DELETE FROM cliente WHERE cpf = " + cpf;

		Statement stmt = conn.createStatement();

		int r = stmt.executeUpdate(sql);
		
		conn.commit(); 
		
		return r;
	}
	
	public static void consultar(long cpf) throws SQLException {
		final String sql = "SELECT * FROM cliente WHERE cpf = " + cpf;

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		int cont = 0;
		
		while(rs.next()) {
			cont++;
			String msg = "cpf: " + rs.getInt(1) + 
					" nome: " + rs.getString(2) + 
					" email: " + rs.getString(3);
			
			System.out.println(msg);
		}
		if(cont == 0) {
			System.out.println("Nenhum cliente encontrado!");
		}
	}
	
	public static void consultarTodos() throws SQLException {
		final String sql = "SELECT * FROM cliente";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		int cont = 0;
		
		while(rs.next()) {
			cont++;
			String msg = "cpf: " + rs.getInt(1) + 
					" nome: " + rs.getString(2) + 
					" email: " + rs.getString(3);
			
			System.out.println(msg);
		}
		if(cont == 0) {
			System.out.println("Nenhum cliente encontrado!");
		}else {
			System.out.println("Foi encontrado " + cont + " clientes!");
		}
	}
	
	public static void desconectar() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			connect();
		
			Scanner scan = new Scanner(System.in);
			
			int opcao = 0;
			
			long cpf;
			String nome, email;
			
			while(opcao != 6) {
				System.out.println("Sistema de Gerenciamento de Clientes");
				System.out.println("====================================");
				System.out.println("Digite [1] para Consultar Todos Clientes");
				System.out.println("Digite [2] para Consultar um Cliente Específico");
				System.out.println("Digite [3] para Cadastrar um Novo Cliente");
				System.out.println("Digite [4] para Editar um Cliente");
				System.out.println("Digite [5] para Remover um Cliente");
				System.out.println("Digite [6] para Sair");
				
				opcao = scan.nextInt();
				
				switch(opcao) {
					case 1:
					{
						System.out.println("[1] Consultar Todos");
						consultarTodos();
						break;
					}
					case 2:
					{
						System.out.println("[2] Consultar um Cliente Específico");
						System.out.println("Informe o CPF >>> ");
						long cpf_consulta = scan.nextLong();
						consultar(cpf_consulta);
						break;
					}
					case 3:
					{
						System.out.println("[3] Cadastrar um Novo Cliente");
						System.out.println("Informe o CPF >>> ");
						cpf = scan.nextLong();
						scan.nextLine(); //esvazia buffer do teclado
						System.out.println("Informe o Nome >>> ");
						nome = scan.nextLine();
						System.out.println("Informe o Email >>> ");
						email = scan.nextLine();
						inserir(cpf, nome, email);
						break;
					}
					case 4:
					{
						System.out.println("[4] Editar um Cliente");
						System.out.println("Informe o CPF a alterar >>> ");
						cpf = scan.nextLong();
						scan.nextLine();
						System.out.println("Informe o Nome >>> ");
						nome = scan.nextLine();
						System.out.println("Informe o Email >>> ");
						email = scan.nextLine();
						editar(cpf, nome, email);
						break;
					}
					case 5:
					{
						System.out.println("[5] Remover um Cliente");
						System.out.println("Informe o CPF para excluir >>> ");
						cpf = scan.nextLong();
						remover(cpf);
						break;
					}
					case 6:
					{
						System.out.println("[6] Saindo do sistema....");
						break;
					}
					default:
						System.out.println("Opção Inválida!");
						break;
				}
			}
			
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
