package com.CDISBANCOAABC.springboot.app.errors;

public class DataBaseBancoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5519635378053823460L;

	
	public DataBaseBancoException() {
		super("Contacte con la administracion, hubo un error con la base de datos");
	}
}
