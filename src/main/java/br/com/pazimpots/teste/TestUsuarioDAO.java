package br.com.pazimpots.teste;

import java.util.List;

import br.com.pazimpots.jdbc.Usuario;
import br.com.pazimpots.jdbc.UsuarioDAO;

public class TestUsuarioDAO {
	
	public static void main(String []args) {
	
		//testAutenticar();
		testBuscarPorId();
	//testBuscarTodos();
	//testCadastrar();
	//testAlterar();
	  //testExcluir();
		
	}

	private static void testBuscarTodos() {
	UsuarioDAO usuDao = new UsuarioDAO();
	List<Usuario> listaResultado = usuDao.buscarTodos();
	
	for (Usuario u: listaResultado) {
		System.out.println(u.getId()+" "+ u.getNome() + " "+ u.getLogin()+ " "+ u.getSenha());
	}
	}
		
	public static void testAutenticar() {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("Maria");
		usuario.setSenha("123");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		System.out.println(usuDao.Autenticar(usuario));
		
		
	}
	
	public static void testBuscarPorId(){
		UsuarioDAO usuDao = new UsuarioDAO();
		//System.out.println(usuDao.buscarPorId(7).getNome());
		
		Usuario usuRetorno = usuDao.buscarPorId(7);
		if(usuRetorno!=null) {
		System.out.println("nome:"+usuRetorno.getNome());
		}
		
		
	}
	
	private static void testCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Adailton");
		usu.setLogin("aa");
		usu.setSenha("3332");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.Cadastrar(usu);
	}
		
	public static void testAlterar() {
		
		Usuario usu = new Usuario();
		usu.setId(7);
		usu.setNome("Jão da Silva");
		usu.setLogin("jj");
		usu.setSenha("556");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.Alterar(usu);
		
	}
	
	public static void testExcluir() {
		Usuario usu = new Usuario();
		usu.setId(6);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.Excluir(usu);
	}
}
