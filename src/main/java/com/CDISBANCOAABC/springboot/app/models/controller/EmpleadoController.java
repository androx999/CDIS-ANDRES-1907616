package com.CDISBANCOAABC.springboot.app.models.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CDISBANCOAABC.springboot.app.models.dao.IEmpleadoDao;

@Controller
public class EmpleadoController {

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@GetMapping
	@RequestMapping(path="/listaEmpleado", method=RequestMethod.GET)
	public String empleadoLista(Model model) {
		model.addAttribute("titulo", "Lista de empleados");
		model.addAttribute("empleados", empleadoDao.findAll());
		return "lista";
	}
}
