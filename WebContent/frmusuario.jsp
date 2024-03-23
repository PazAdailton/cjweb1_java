
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastro de Usuários EL</title>
</head>
<body>

  <form action="usucontroller.do" method="post">
	
	<label>ID: </label>
	 <input type="text" name="id" value="${requestScope.usuario.id}" size="" /> <br>
	 <hr>
	
	<label>Nome: </label>
	<input type="text" name="nome" value="${requestScope.usuario.nome}"  size="20"/> <br>
	
	<label>Login: </label>
	<input type="text" name="login" value="${requestScope.usuario.login}" size="20"/> <br>

	<label> Senha: </label>
	<input type="password" name="senha" value="${requestScope.usuario.senha}" maxlength="6"/> <br>
	
	<input type="submit"  value="salvar"/> <br> 
	
	
 </form>


</body>
</html>