package br.com.resource.webapp.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.resource.webapp.livraria.dao.DaoCliente;
import br.com.resource.webapp.livraria.entidades.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private DaoCliente daoCliente;

	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("clientes", daoCliente.buscaClienteOrdenado());
		model.addAttribute("cliente", new Cliente());
		
		return "cliente";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Cliente cliente) {
		
		daoCliente.save(cliente);
		
		return "redirect:/cliente";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAltera(@PathVariable int id, Model model) {
		model.addAttribute("clientes", daoCliente.buscaClienteOrdenado());
		model.addAttribute("cliente", daoCliente.findById(id).get());
		
		return "cliente";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		daoCliente.deleteById(id);
		return "redirect:/cliente";
	}
}
