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
	
		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		//Captura parâmetro da tela
		
		
		if(acao!=null && acao.equals("exc")) {
			
			//Captura parâmetro da tela
			String id = request.getParameter("id");
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			
			usuarioDAO.Excluir(usuario);
		}
		
		//PEDIR UMA LISTA
		
		
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		//ENCANMINHANDO AO JSP
		//ENGAVETAR A LISTA NO REQUEST
		request.setAttribute("lista", lista);
		request.setAttribute("meunome","Adailton");
		
		
		
		//ENCANMINHAR AO JSP
		
		RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
		saida.forward(request, response);
		
		
		
		/*String htmlsaida = "<html> <body> <table border='1'>" +
		"<tr> <td> Id</td><td> Nome</td> <td> Login</td> <td> Senha</td> </tr>";
		
		for(Usuario usu : lista) {
			htmlsaida += "<tr> <td>" + usu.getId()+  " </td> <td>" +usu.getNome()+  " </td> <td>" +usu.getLogin()+  "</td> <td>" +usu.getSenha()+ "</td> </tr>";
		}
		
		htmlsaida += "</table> <body><html>";
		
		
		
		PrintWriter saida = response.getWriter();
		saida.println(htmlsaida); */
		
	
	
	
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
