<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	
    <div>
        <h1 id="titulo">Login!!!</h1>
        <p id="subtitulo"><strong>Seja Bem vindo!</strong></p>
        <br>
    </div>

    <form action="/cadastro-de-devs-com-servlets/entrada?acao=Login" method="Post">
 <fieldset class="grupo">
            <div class="campo">
                <label for="login"><strong>Login</strong></label>
                <input type="text" name="login" id="login" >
            </div>

            <div class="campo">
                <label for="senha"><strong>Senha</strong></label>
                <input type="password" name="senha" id="senha">
            </div>
</fieldset>
            <button id= "bt" class="botao" type="submit" onsubmit="">Entrar</button>
</form>
</body>
</html>