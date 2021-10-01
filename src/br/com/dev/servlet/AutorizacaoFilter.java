package br.com.dev.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servRequest, ServletResponse servResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servRequest;
		HttpServletResponse response = (HttpServletResponse) servResponse;

		String acaoParam = request.getParameter("acao");

		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
		boolean paginasLiberadas = !(acaoParam.equals("FormLogin") || acaoParam.equals("Login"));

		if (usuarioNaoEstaLogado && paginasLiberadas) {
			response.sendRedirect("entrada?acao=FormLogin");
			return;
		}

		chain.doFilter(request, response);
	}

}
