package com.CDISBANCOAABC.springboot.app.models.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CDISBANCOAABC.springboot.app.models.dao.ICuentaDao;
import com.CDISBANCOAABC.springboot.app.models.dao.ITarjetaDao;
import com.CDISBANCOAABC.springboot.app.models.entity.Cuenta;
import com.CDISBANCOAABC.springboot.app.validator.CuentaValidator;


@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@Autowired
	private CuentaValidator cuentaValidator;
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(cuentaValidator);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "diaCreacion", new CustomDateEditor(dateFormat, false));
	}
	
	//@GetMapping
	@RequestMapping(path="/lista-cuentas", method =RequestMethod.GET)
	public String cuentaLista(Model model) {
		model.addAttribute("titulo", "Lista de cuentas");
		model.addAttribute("cuentas",cuentaDao.findAll());
		return "lista-cuentas";
	}
	
	@RequestMapping(path = "/form-cuenta")
	public String crear(Map<String, Object> model) {
		Cuenta cuenta = new Cuenta();
		model.put("cuenta", cuenta);
		model.put("titulo", "Nueva cuenta, llene los datos");
		return "form-cuenta";
	}
	
	@RequestMapping(path="/form-cuenta/{id}")
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
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		
		//cuentaValidator.validate(cuenta, result);
		
		if(result.hasErrors()) {
		model.addAttribute("titulo","Formulario de tarjeta");	
		model.addAttribute("result",result.hasErrors());
		model.addAttribute("mensaje","Error al registrar la cuenta");	
		//model.addAttribute("errList",result.getFieldErrors());	
		return "form-cuenta";
		}else {
			model.addAttribute("result",false);
			model.addAttribute("errList","");	
		}
		//model.addAttribute("titulo","Formulario de tarjeta");	
		//model.addAttribute("mensaje","Se guardo la cuenta correctamente");
		flash.addAttribute("completeMsj", "Se guardo correctamente");
		cuentaDao.save(cuenta);
		status.setComplete();
		
		return "redirect:form-cuenta";
	}
	
	 @RequestMapping(path="/eliminarcuenta/{id}")
	public String eliminar(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		
		 if (id != null && id > 0) {
				if (tarjetaDao.findByCuentaId(id.toString()).isEmpty()) {
					System.out.println("La lista esta vacia");
					cuentaDao.delete(id);
				} else {
					flash.addFlashAttribute("mensaje", "La cuenta tiene tarjetas pendientes por eliminar");
				}
		 } 
		 return "redirect:/lista-cuentas";
	}

}
