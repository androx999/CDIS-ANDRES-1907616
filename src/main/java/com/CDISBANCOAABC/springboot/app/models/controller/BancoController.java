package com.CDISBANCOAABC.springboot.app.models.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CDISBANCOAABC.springboot.app.models.dao.IBancoDao;

@Controller
public class BancoController {
	
	@Autowired
	private IBancoDao bancoDao;
	
	@GetMapping
	@RequestMapping(path="/listaBanco",method=RequestMethod.GET)
	public String bancoLista(Model model) {
		model.addAttribute("titulo", "Lista del banco");
		model.addAttribute("banco", bancoDao.findAll());
		return "lista";
	}

}
