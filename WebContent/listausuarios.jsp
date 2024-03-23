<%@page import="br.com.pazimpots.jdbc.UsuarioDAO"%>
<%@page import="br.com.pazimpots.jdbc.Usuario"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de Usuários/JSTL</title>
</head>
<body>


${requestScope.meunome} 



<table border="1">
 <tr bgcolor="#ccccc">
 	<th>ID</th> 
 	<th>Nome</th> 
 	<th>Login</th>
 	<th>Senha</th>
 	<th>Acao</th>
 	<% //<th>Alterar</th> %>
 
 
 </tr>

<c:forEach items="${requestScope.lista}" var="usu">
			
	<tr>
	 
	<td>${usu.id}</td>
	<td>${usu.nome}</td> 
	<td>${usu.login}</td>
	<td>${usu.senha}</td>
	<td>
	
	<a href="usucontroller.do?acao=exc&id=${usu.id}">Excluir</a>
	<a href="usucontroller.do?acao=alt&id=${usu.id}">Alterar</a>
	
	</td>
	
	
	</tr>

</c:forEach>

</table>
</body>
</html>