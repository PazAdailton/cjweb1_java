package br.com.pazimpots.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	Connection con = Conexao.getConnection();
	
	public List<Usuario> buscarTodos(){
		
		String sql = "select * from usuario1";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				
				lista.add(usu);
				
				System.out.println("Busca feita com sucesso");
			}
			
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return lista;	
		
		
	}
	
	
	public void salvar(Usuario usuario) {
		
		
		if(usuario.getId()!=null && usuario.getId()!=0) {
		
			Alterar(usuario);
		} else  {
			Cadastrar(usuario);
			System.out.println("Salvo com sucesso");
		}
		
		
	}
	
	public Usuario buscarPorId(Integer id) {
		String sql = "select * from usuario1 where id=?";
		Usuario usuario = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usuario;
	}
	
	public  List<Usuario> buscarPorNome(String nome) {
		String sql = "select * from usuario1 where nome like ?";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+nome+"%");
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	
	public Usuario Autenticar(Usuario usuario) {
		String sql = "select * from usuario1 where login = ? and senha = ?";
		Usuario usuarioRetorno = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				usuarioRetorno = new Usuario();
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setLogin(resultado.getString("login"));
				usuarioRetorno.setSenha(resultado.getString("senha"));
			
				
				System.out.println("Autenticado com sucesso");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usuarioRetorno;
	}
	
	
	
	
	
	
	
	public  void Cadastrar(Usuario usuario) {
		
		
	String sql = "Insert into usuario1 (nome, login,senha) values (?,?,?)";
		
	try {
		
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, usuario.getNome());
		preparador.setString(2, usuario.getLogin());
		preparador.setString(3, usuario.getSenha());
		preparador.execute();
		preparador.close();
	
		System.out.println("Cadastrado com sucesso");
		
	} catch (SQLException e) {
	e.printStackTrace();	
	}
			
}
	
	
	public  void Alterar(Usuario usuario) {
		
		
		String sql = "update  usuario1  set nome=?, login=?,senha=? where id=?";
			
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			preparador.execute();
			preparador.close();
		
			System.out.println("Alterado com sucesso");
			
		} catch (SQLException e) {
		e.printStackTrace();	
		}
				
	}
	
	public void Excluir(Usuario usuario) {
		
		String sql = "delete from usuario1 where id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			preparador.execute();
			preparador.close();
		
		System.out.println("Excluído com sucesso");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
