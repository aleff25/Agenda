package br.com.pcinfo.javaweb.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcinfo.javaweb.mvc.logica.Logica;

public class PrimeiraLogica implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica....");
		System.out.println("Retornando o nome da página JSP");
		
		return "WEB-INF/jsp/primeira-logica.jsp";
	}
	
}
