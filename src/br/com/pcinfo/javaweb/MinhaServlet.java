package br.com.pcinfo.javaweb;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		log("Iniciando Servlet");
	}
	
	public void destroy() {
		super.destroy();
		log("Destruindo Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
