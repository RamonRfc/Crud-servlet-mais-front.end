package br.com.dev.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<DevInfo> lista = new ArrayList<>();
	private static List<LoginUsuario> listaUsuario = new ArrayList<>();
	private static Integer chaveprimaria = 1;

	static {

		LoginUsuario log = new LoginUsuario();
		log.setLogin("admin");
		log.setSenha("123");

		listaUsuario.add(log);

		DevInfo userUm = new DevInfo();
		userUm.setId(chaveprimaria++);
		userUm.setNome("Francisco");
		userUm.setSobrenome("Marinho");
		userUm.setEmail("fran_marinho@gmail");

		DevInfo userDois = new DevInfo();
		userDois.setId(chaveprimaria++);
		userDois.setNome("Rian");
		userDois.setSobrenome("Ramon");
		userDois.setEmail("rian_rah@gmail");

		lista.add(userUm);
		lista.add(userDois);

	}

	public void adicionaDev(DevInfo dev) {
		dev.setId(chaveprimaria++);
		lista.add(dev);
		System.out.println(lista);
	}

	public void deletar(Integer id) {
		Iterator<DevInfo> it = lista.iterator();

		while (it.hasNext()) {
			DevInfo dev = it.next();
			if (dev.getId() == id) {
				it.remove();
			}
		}
	}

	public List<DevInfo> getDev() {
		return Banco.lista;
	}

	public DevInfo buscaDevId(Integer id) {
		for (DevInfo devInfo : lista) {
			if (devInfo.getId() == id) {
				return devInfo;
			}
		}
		return null;
	}

	public LoginUsuario existeUsuario(String paramLogin, String paramSenha) {
		for (LoginUsuario log : listaUsuario) {
			if (log.ehIguall(paramSenha, paramLogin)) {
				return log;
			}
		}
		return null;
	}
}
