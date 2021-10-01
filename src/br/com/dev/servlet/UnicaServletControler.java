package br.com.dev.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dev.acao.Acao;

//@WebServlet("/entrada")
public class UnicaServletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acaoParam = request.getParameter("acao");
		System.out.println("Unica servlet dev");
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
		boolean paginasLiberadas = !(acaoParam.equals("FormLogin") || acaoParam.equals("Login"));

		System.out.println("acao " + acaoParam);
		System.out.println("usuarioNaoEstaLogado " + usuarioNaoEstaLogado);
		System.out.println("paginasLiberadas " + paginasLiberadas);

		if (usuarioNaoEstaLogado && paginasLiberadas) {
			response.sendRedirect("entrada?acao=FormLogin");
			return;
		}

		String nomeDaClasse = "br.com.dev.acao." + acaoParam;
		String nome;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] Endereco = nome.split(":");
		if (Endereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + Endereco[1]);
			rd.forward(request, response);

		} else {
			response.sendRedirect(Endereco[1]);

		}

	}

}
