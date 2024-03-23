<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="br.com.pazimpots.jdbc.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de Usuários</title>
</head>
<body>

<%
String nome = (String) request.getAttribute("meunome");
out.println(nome);

%>


<table border="1">
 <tr bgcolor="#ccccc">
 	<th>ID</th> 
 	<th>Nome</th> 
 	<th>Login</th> 
 	<th>Senha</th>
 	<th>Acao</th>
 	<% //<th>Alterar</th> %>
 
 
 </tr>

<%
		//Scriptlet
	  List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");

		for(Usuario usu: lista ){
%>		
			
	<tr>
	
	<td><%= usu.getId() %></td>
	<td><%out.print(usu.getNome()); %></td> 
	<td><%= usu.getLogin() %></td>
	<td><%= usu.getSenha() %></td>
	<td>
	
	<a href="usucontroller.do?acao=exc&id=<%=usu.getId()%>">Excluir</a>
	<a href="usucontroller.do?acao=alt&id=<%=usu.getId()%>">Alterar</a>
	
	</td>
	
	
	</tr>


<% }%>


</table>
</body>
</html>