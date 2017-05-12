package br.com.pcinfo.javaweb.mvc;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcinfo.javaweb.Contato;
import br.com.pcinfo.javaweb.ContatoDao;
import br.com.pcinfo.javaweb.mvc.logica.Logica;

public class AdicionaContatoLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		
		dao.adiciona(contato);
		
		return "WEB-INF/jsp/adiciona-contato.jsp";
	}
}
