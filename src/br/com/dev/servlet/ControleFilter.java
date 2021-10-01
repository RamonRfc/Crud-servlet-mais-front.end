package br.com.dev.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dev.acao.Acao;

/**
 * Servlet Filter implementation class ControleFilter
 */
@WebFilter("/entrada")
public class ControleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servRequest, ServletResponse servResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servRequest;
		HttpServletResponse response = (HttpServletResponse) servResponse;

		String acaoParam = request.getParameter("acao");

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
