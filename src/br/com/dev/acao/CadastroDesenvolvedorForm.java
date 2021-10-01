package br.com.dev.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroDesenvolvedorForm implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		if (session.getAttribute("usuarioLogado") == null) {
//			return "redirect:entrada?acao=FormLogin";
//		}
		
		 return "forward:form.jsp";
	}
}
