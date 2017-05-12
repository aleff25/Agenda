package br.com.pcinfo.javaweb.mvc;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcinfo.javaweb.Contato;
import br.com.pcinfo.javaweb.ContatoDao;
import br.com.pcinfo.javaweb.mvc.logica.Logica;

public class RemoveContatoLogic implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));

		List<Contato> contatos = new ContatoDao().getLista();
		req.setAttribute("contato", contatos);

		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);

		System.out.println("Excluindo contato...");

//		Contato encontrado = null;
//
//		for (Contato contato : contatos) {
//			if (contato.getId() == id) {
//				encontrado = contato;
//			}
//		}
//
//		if (encontrado != null) {
//			dao.remove(encontrado);
//		}

		contatos.stream().filter(c -> c.getId() == id).findFirst().ifPresent(dao::remove);

		return new ListaContatosLogic().executa(req, res);
	}
}
