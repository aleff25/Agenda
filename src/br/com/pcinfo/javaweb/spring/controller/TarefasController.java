package br.com.pcinfo.javaweb.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pcinfo.javaweb.spring.java.JdbcTarefaDao;
import br.com.pcinfo.javaweb.spring.java.Tarefa;

@Controller
public class TarefasController {
	
	private JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefas/formulario";
	}

	@RequestMapping(value = "adicionaTarefa", method = RequestMethod.POST)
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) throws ClassNotFoundException {
		if (StringUtils.isEmpty(tarefa.getDescricao())) {
			return "tarefas/formulario";
		}
		dao.adiciona(tarefa);
		return "tarefas/adicionada";
	}

	@RequestMapping("listaTarefa")
	public String lista(Model model) throws ClassNotFoundException {
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefas/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) throws ClassNotFoundException {
		dao.remove(tarefa);
		return "redirect:listaTarefa";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) throws ClassNotFoundException {
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscarPorId(id));
		return "tarefas/finalizada";
	}
}
