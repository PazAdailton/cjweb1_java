package br.com.pazimpots.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	
	public static Connection getConnection() {
		Connection con = null;
		
		
		try {
			Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cjweb1", "postgres", "postgresql");
		System.out.println("Conectado com sucesso");	
		
		} catch (Exception e) {
		
			
			System.out.println("Não pode conectar:" + e.getMessage());
		}
		
		
		
		return con;
	}
	
	
}
