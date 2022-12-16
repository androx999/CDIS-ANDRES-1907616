package com.CDISBANCOAABC.springboot.app.models.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.CDISBANCOAABC.springboot.app.models.dao.ICuentaDao;
import com.CDISBANCOAABC.springboot.app.models.entity.Cuenta;


@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@GetMapping
	@RequestMapping(path="/lista-cuentas", method =RequestMethod.GET)
	public String cuentaLista(Model model) {
		model.addAttribute("titulo", "Lista de cuentas");
		model.addAttribute("cuentas",cuentaDao.findAll());
		return "/lista-cuentas";
	}
	
	@RequestMapping(path = "/form-cuenta")
	public String crear(Map<String, Object> model) {
		Cuenta cuenta = new Cuenta();
		model.put("cuenta", cuenta);
		model.put("titulo", "Nueva cuenta, llene los datos");
		return "form-cuenta";
	}
	
	@RequestMapping(path="c{id}")
	public String editar(@PathVariable(value="id")Long id,Map<String, Object> model) {
		Cuenta cuenta = null;
		
		if(id > 0) {
			cuenta = cuentaDao.findOne(id);
		}else {
			return "redirect:/lista";
		}
		model.put("cuenta", cuenta);
		model.put("titulo", "Edite la cuenta");
		return "form-cuenta";
	}
	
	@RequestMapping(path="form-cuenta",method = RequestMethod.POST)
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
		model.addAttribute("titulo","Formulario de tarjeta");	
		return "form-cuenta";
		}
		
		cuentaDao.save(cuenta);
		status.setComplete();
		
		return "redirecr:index";
	}
	
	 @RequestMapping(path="/eliminarcuenta/{id}")
	public String eliminar(@PathVariable(value="id")Long id) {
		
		 if(id > 0) {
			 cuentaDao.delete(id);
		 } 
		 return "redirect:index";
	}

}
