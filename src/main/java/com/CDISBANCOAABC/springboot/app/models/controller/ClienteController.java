package com.CDISBANCOAABC.springboot.app.models.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CDISBANCOAABC.springboot.app.models.dao.IClienteDao;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping
	@RequestMapping(path="/listaCliente",method = RequestMethod.GET)
	public String clienteLista(Model model) {
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("clientes",clienteDao.findAll());
		return "lista";
		
	}

}
