package br.com.pcinfo.javaweb.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcinfo.javaweb.Contato;
import br.com.pcinfo.javaweb.ContatoDao;
import br.com.pcinfo.javaweb.mvc.logica.Logica;

public class ListaContatosLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<Contato> contatos = new ContatoDao().getLista();
		
		req.setAttribute("contatos", contatos);
	
		return "WEB-INF/jsp/lista-contatos.jsp";
	}
}