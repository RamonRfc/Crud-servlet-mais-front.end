package br.com.dev.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dev.modelo.Banco;
import br.com.dev.modelo.LoginUsuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");
		
		Banco banco = new Banco();
		LoginUsuario loginUsuario = banco.existeUsuario(paramLogin , paramSenha);
		
		
		if (loginUsuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", loginUsuario);
			return "redirect:entrada?acao=ListaDeUsuarios";
		}
		
		return "redirect:entrada?acao=FormLogin";
	}

}
