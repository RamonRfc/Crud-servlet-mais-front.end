<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="formulario.css" media="">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Cadrastro</title>
</head>
<body>
	<c:import url="logout-generico.html"/>
	Usuario:${usuarioLogado.login}
    <div>
        <h1 id="titulo">Cadastro de DEVs</h1>
        <p id="subtitulo"><strong>Complete suas informações</strong></p>
        <br>
    </div>

    <form action="/cadastro-de-devs-com-servlets/entrada?acao=AlteraDesenvolvedor&id=${altera.id}" method="Post">
        <fieldset class="grupo">
            <div class="campo">
            <input type="hidden" name="id" value="${altera.id}">
                <label for="nome"><strong>Nome</strong></label>
                <input type="text" name="nome" id="nome" value="${altera.nome}">
            </div>

            <div class="campo">
                <label for="sobrenome"><strong>Sobrenome</strong></label>
                <input type="text" name="sobrenome" id="sobrenome" value="${altera.sobrenome}" required>
            </div>
        </fieldset>

        <div class="campo">
            <label for="email"><strong>Email</strong></label>
            <input type="text" name="email" id="email" value="${altera.email}" required>
        </div>

        <div class="campo">
            <label><strong>De qual lado da aplicação você desenvolve?</strong></label>
            <label>
                <input type="radio" name="devweb" value="frontend">Frontend
            </label>
            <label>
                <input type="radio" name="devweb" value="backend"checked>Backend
            </label>
            <label>
                <input type="radio" name="devweb" value="fullstack">Fullstack
            </label>
        </div>

        <div class="campo">
            <label for="senioridade"><strong>Senioridade</strong></label>
                <select name="select" id="senioridade">
                <option value="Junior">Junior</option>
                <option value="Pleno">Pleno</option>
                <option value="Senior">Senior</option>
            </select>
        </div>

        <fieldset class="grupo">
            <div id="check">
                <label><strong>Selecione as tecnologias que utiliza:</strong></label><br><br>
                <input type="checkbox" name="tec1" id="tec1" value="HTML">
                <label for="tec1">HTML</label>
                <input type="checkbox" name="tec2" id="tec2" value="CSS">
                <label for="tec2">CSS</label>
                <input type="checkbox" name="tec3" id="tec3" value="Javascript">
                <label for="tec3">JavaScript</label>
                <input type="checkbox" name="tec4" id="tec4" value="Java">
                <label for="tec4">Java</label>
                <input type="checkbox" name="tec5" id="tec5" value="PHP">
                <label for="tec5">PHP</label>
                <input type="checkbox" name="tec6" id="tec6" value="C#">
                <label for="tec6">C#</label>
                <input type="checkbox" name="tec7" id="tec7" value="Kotlin">
                <label for="tec7">Kotlin</label>
            </div>
        </fieldset>
            <div class="campo">
                <br>
                <label for="exp"><strong>Conte um pouco da sua experiencia:</strong></label>
                <textarea rows="6" style="width: 27em"  id="exp" maxlength="200" name="exp"></textarea>
            </div>
			<button
					id="bt" class="botao" type="submit" onsubmit="">Concluido</button>
            <!-- <button id= "bt" class="botao" type="submit" onsubmit="">Concluido</button> -->
</form>
</body>
</html>