package br.com.dev.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dev.modelo.Banco;

public class DeletandoDesenvolvedor implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		banco.deletar(id);
		
		return "redirect:entrada?acao=ListaDeUsuarios";
		
	}

	
}
