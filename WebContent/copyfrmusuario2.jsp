<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="br.com.pazimpots.jdbc.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastro de Usuários</title>
</head>
<body>

   <%
   Usuario usuario = (Usuario) request.getAttribute("usuario");
   %>
   
   

  <form action="usucontroller.do" method="post">
	
	<label>ID: </label>
	 <input type="text" name="id" value="<%= (usuario!= null) ?  usuario.getId() : "" %>"><br>
	 <hr>
	
	<label>Nome: </label>
	<input type="text" name="nome" value="<%=usuario.getNome()%>"" size="20"/><br>
	
	<label>Login: </label>
	<input type="text" name="login" value="<%=usuario.getLogin()%>"" size="20"/><br>

	<label> Senha: </label>
	<input type="password" name="senha" value="<%=usuario.getSenha()%>"" maxlength="6"/><br>
	
	<input type="submit"  value="salvar"/> <br> 
	
	
 </form>


</body>
</html>