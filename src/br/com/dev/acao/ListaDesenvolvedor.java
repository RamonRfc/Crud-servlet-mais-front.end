package br.com.dev.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dev.modelo.Banco;
import br.com.dev.modelo.DevInfo;

public class ListaDesenvolvedor implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idParam = request.getParameter("id"); Integer id =
		Integer.valueOf(idParam);
		 
		Banco banco = new Banco();
		DevInfo nome = banco.buscaDevId(id);
		
		request.setAttribute("nome", nome);
		return "forward:listaDev.jsp";
		
	}

	
}
