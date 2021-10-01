<%@page import="java.util.List , br.com.dev.modelo.DevInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="formulario.css" media="">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-generico.html"/>
	Usuario:${usuarioLogado.login}
	<%-- <c:forEach items="${devs}" var="nome"> --%>
	<h1>Desenvolvedor cadastrado</h1>
	<h2>Nº: ${nome.id}</h2>
	<hr width="50%">

	<label for="nome"><strong>Nome:</strong></label> ${nome.nome}
	${nome.sobrenome}
	<hr width="50%">
	<label for="email"><strong>Email:</strong></label> ${nome.email}
	<hr width="50%">
	<label><strong>Desenvolvedor:</strong></label> ${nome.devWeb}
	<hr width="50%">
	<label for="senioridade"><strong>Senioridade:</strong></label>
	${nome.select}
	<hr width="50%">
	<label><strong>Tecnologias que utilizo:</strong></label>

	<ul>
		<li>${nome.tec1}
		<li>${nome.tec2}
		<li>${nome.tec3}
		<li>${nome.tec4}
		<li>${nome.tec5}
		<li>${nome.tec6}
		<li>${nome.tec7}
	</ul>

	<h2>Experiência:</h2>
	<textarea rows="6" style="resize: none;" cols="50" maxlength="200"
		disabled="disabled">${nome.exp}</textarea>
	<hr width="50%">
	
	<a href="/cadastro-de-devs-com-servlets/entrada?acao=ListaDeUsuarios"><button
			id="bt" class="botao" type="submit" onsubmit="">Inicio</button></a>
				
	<a href="/cadastro-de-devs-com-servlets/entrada?acao=MostraDesenvolvedor&id=${nome.id}"><button
			id="bt" class="botao" type="submit" onsubmit="">Alterar</button></a>
			
	<a href="/cadastro-de-devs-com-servlets/entrada?acao=DeletandoDesenvolvedor&id=${nome.id}"><button
			id="bt" class="botao" type="submit" onsubmit="">Deletar</button></a>
			
	<a href="/cadastro-de-devs-com-servlets/entrada?acao=CadastroDesenvolvedorForm"><button
			id="bt" class="botao" type="submit" onsubmit="">Novo</button></a>
<%-- 	</c:forEach> --%>
</body>
</html>