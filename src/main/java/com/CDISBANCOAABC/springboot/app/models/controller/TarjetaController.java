package com.CDISBANCOAABC.springboot.app.models.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CDISBANCOAABC.springboot.app.models.dao.ITarjetaDao;

@Controller
public class TarjetaController {

	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@GetMapping
	@RequestMapping(path="/listaTarjeta",method =RequestMethod.GET)
	public String tarjetaLista(Model model) {
		model.addAttribute("titulo", "Lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());
		return "lista";
		
	}
}
