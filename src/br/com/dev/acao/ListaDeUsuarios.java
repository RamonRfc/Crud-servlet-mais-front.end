package br.com.dev.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dev.modelo.Banco;
import br.com.dev.modelo.DevInfo;

public class ListaDeUsuarios implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();

		List<DevInfo> lista = banco.getDev();
		request.setAttribute("devs", lista);

		return "forward:listaDeUsuarios.jsp";
		
	}

	
}
