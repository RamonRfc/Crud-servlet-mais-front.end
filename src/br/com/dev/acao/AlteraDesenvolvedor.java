package br.com.dev.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dev.modelo.Banco;
import br.com.dev.modelo.DevInfo;

public class AlteraDesenvolvedor implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String devWeb = request.getParameter("devweb");
		String select = request.getParameter("select");
		String tec1 = request.getParameter("tec1");
		String tec2 = request.getParameter("tec2");
		String tec3 = request.getParameter("tec3");
		String tec4 = request.getParameter("tec4");
		String tec5 = request.getParameter("tec5");
		String tec6 = request.getParameter("tec6");
		String tec7 = request.getParameter("tec7");
		String exp = request.getParameter("exp");

		Banco banco = new Banco();
		DevInfo dev = banco.buscaDevId(id);
		
		dev.setNome(nome);
		dev.setSobrenome(sobrenome);
		dev.setEmail(email);
		dev.setDevWeb(devWeb);
		dev.setSelect(select);
		dev.setTec1(tec1);
		dev.setTec2(tec2);
		dev.setTec3(tec3);
		dev.setTec4(tec4);
		dev.setTec5(tec5);
		dev.setTec6(tec6);
		dev.setTec7(tec7);
		dev.setExp(exp);


		
		
		request.setAttribute("nome", dev);
		
		 return "forward:listaDev.jsp";

	}

}
