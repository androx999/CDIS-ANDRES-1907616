package com.CDISBANCOAABC.springboot.app.models.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CDISBANCOAABC.springboot.app.editors.CuentaPropertyEditor;
import com.CDISBANCOAABC.springboot.app.errors.DataBaseBancoException;
import com.CDISBANCOAABC.springboot.app.models.dao.ICuentaDao;
import com.CDISBANCOAABC.springboot.app.models.dao.ITarjetaDao;
import com.CDISBANCOAABC.springboot.app.models.entity.Cuenta;
import com.CDISBANCOAABC.springboot.app.models.entity.Tarjeta;

@Controller
@SessionAttributes("tarjeta")
public class TarjetaController {

	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
@Autowired
	private CuentaPropertyEditor cuentaEditor;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Cuenta.class, "cuenta",cuentaEditor);
	}
	
	
	@RequestMapping(path="/tarjetas-lista",method =RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());
		return "tarjetas-lista";
	}
	
	@RequestMapping(path="/formtarjeta")
	public String crear(Map<String, Object> model, Model modelList) {
	    Tarjeta tarjeta = new Tarjeta();
	    List<Cuenta> listaCuentas = cuentaDao.findAll();
	    model.put("tarjeta", tarjeta);
	    modelList.addAttribute("listaCuentas",listaCuentas);
	    model.put("titulo", "Llenar los datos de una tarjeta");
		return "formtarjeta";
	}
	
	@RequestMapping(path = "/formtarjeta/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Tarjeta tarjeta = null;
		
		if(id > 0 && id !=null) {
			tarjeta = tarjetaDao.findOne(id);
		}else {
			return "index";
		}
		model.put("tarjeta", tarjeta);
		model.put("titulo", "Editar tarjeta");
		return "formtarjeta";
	}
	
	@RequestMapping(path="/formtarjeta",method = RequestMethod.POST)
	public String guardar(@Valid Tarjeta tarjeta, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llene correctamente los campos");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al enviar los datos, por favor escriba correctamente los campos");
			return "formtarjeta";
		} else {
			model.addAttribute("result",false);
		}
		//Cuenta cuenta = cuentaDao.findOne(tarjeta.getIdCuentaAux());
		model.addAttribute("titulo","Formulario de tarjeta");
		model.addAttribute("mensaje", "Se envio la informacion correctamente");
		try {
			tarjetaDao.save(tarjeta);
		} catch (DataBaseBancoException e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		status.setComplete();
		return "redirect:formtarjeta";
	}
	
	@RequestMapping(path="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0 & id != null) {
			tarjetaDao.delete(id);
		}
		
		return "redict:/tarjetas-lista";
	}
}
