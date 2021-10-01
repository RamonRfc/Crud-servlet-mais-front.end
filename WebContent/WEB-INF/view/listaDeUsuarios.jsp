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
	<h1>Lista de Desenvolvedores</h1>
	<table>
	<tr>
        <td>Id</td>
        <td style="width: 300px;" > Nome </td>
        <td>Acao</td>
    </tr>
	<c:forEach items="${devs}" var="nome">
	<tr>
        <td>
        	${nome.id}	
        </td>
        <td>
	        ${nome.nome}
	        ${nome.sobrenome}
		</td>
	
	    <td>

			<a href="/cadastro-de-devs-com-servlets/entrada?acao=MostraDesenvolvedor&id=${nome.id}"><button
					id="bt" class="botao" type="submit" onsubmit="">Alterar</button></a>
			
			<a href="/cadastro-de-devs-com-servlets/entrada?acao=ListaDesenvolvedor&id=${nome.id}"><button
					id="bt" class="botao" type="submit" onsubmit="">Visualizar</button></a>
					
		</td>
	</tr>
	</c:forEach>
	
	</table>
	<br>
	<a href="/cadastro-de-devs-com-servlets/entrada?acao=CadastroDesenvolvedorForm"><button
					id="bt" class="botao" type="submit" onsubmit="">Novo Cadastro</button></a>
			
</body>
</html>