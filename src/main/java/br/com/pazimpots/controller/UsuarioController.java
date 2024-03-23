package br.com.pazimpots.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pazimpots.jdbc.Usuario;
import br.com.pazimpots.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	 //System.out.println("Chamando metódo doGET");
	
	//String nome = request.getParameter("nome");
	//String idade = request.getParameter("idade");
	
	//System.out.println("nome: " + nome);
	//System.out.println("idade: " + idade);
	
	//PrintWriter saida =  response.getWriter();
	//saida.println("nome: " + nome + "idade: " + idade);
	
		//captura parâmetro na tela
		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		//Captura parâmetro da tela
		
		
		
		
		if(acao!=null && acao.equals("exc")) {
			
			//Captura parâmetro da tela
			String id = request.getParameter("id");
			
		//UsuarioDAO usuarioDAO2 = new UsuarioDAO(); pode ser aqui ou ali em cima 
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			
			usuarioDAO.Excluir(usuario);
			
			//redirecionando pelo cliente (browser) após excluuir o usuário
			response.sendRedirect("usucontroller.do?acao=lis");		
			//alternativa
			//acao="lis";
			
		}
		
		if(acao!=null && acao.equals("alt")){
			 //captura parametro da tela
			 String id = request.getParameter("id");
			 //busca objeto usuário no banco
			 Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			 //seta atributo no request com objeto usuário
			 request.setAttribute("usuario", usuario);
			 //encaminha objeto usuário para tela
			 RequestDispatcher saida = request.getRequestDispatcher("/frmusuario.jsp");
			saida.forward(request, response);
		}
		
		 if(acao!=null && acao.equals("lis")){
		//PEDIR UMA LISTA
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		
		//ENCANMINHANDO AO JSP
		//ENGAVETAR A LISTA NO REQUEST
		request.setAttribute("lista", lista);
		request.setAttribute("meunome","Adailton");
		
		//ENCANMINHAR AO JSP
		
		RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
		saida.forward(request, response);
		
		 }
		 
		 if(acao!=null && acao.equals("cad")) {
			 
			 Usuario usuario = new Usuario();
			 usuario.setId(0);
			 usuario.setNome("");
			 usuario.setLogin("");
			 usuario.setSenha("");
			 
			 request.setAttribute("usuario", usuario);
			 
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
			 
			 
			 
		 }
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
		System.out.println("Chamando metódo doPOST");
	///recebe dados da tela
	String id = request.getParameter("id");
	String nome = request.getParameter("nome");
	String login = request.getParameter("login");
	String senha = request.getParameter("login");
	
	//cria objeto usuario e seta os valores vindo da tela
	Usuario usuario = new Usuario();
	
	if(id!=null && id!="" && id!="0") {
		
		usuario.setId(Integer.parseInt(id));
	}
	
	usuario.setNome(nome);
	usuario.setLogin(login);
	usuario.setSenha(senha);
	
	
	//pede para o usuario cadastrar no banco de dados
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	usuarioDAO.salvar(usuario);
	
	//saída do Browser
	PrintWriter saida = response.getWriter();
	saida.println("Cadastrado com sucesso");
	
	
	}

}
