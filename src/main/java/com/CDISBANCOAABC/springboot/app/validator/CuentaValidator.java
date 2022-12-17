package com.CDISBANCOAABC.springboot.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.CDISBANCOAABC.springboot.app.models.entity.Cuenta;

@Component
public class CuentaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//Con este metodo aseguramos que esta clase es asignable
		return Cuenta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Cuenta cuenta = (Cuenta)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.cuenta.nombre");

		if(!cuenta.getNombre().matches("[a-z,A-Z]{1,15}?[]?[a-z,A-Z]{1,15}")) {
			errors.rejectValue("nombre", "format.cuenta.nombre");
		}
		
		if(cuenta.getSaldo() <= 99.0) {
			errors.rejectValue("saldo", "MinRequerido.cuenta.saldo");
		}
		
		if(!cuenta.getNumeroTelefono().matches("[0-9]{10}")) {
			errors.rejectValue("num_tel", "Format.cuenta.num_tel");
		}
		
		if(cuenta.getDiaCreacion() == null) {
			errors.rejectValue("diaCreacion", "typeMismatch.cuenta.diaCreacion");
		}
	}

}
