
public class EdadException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518647914349462336L;
	
	public EdadException() {
		
	}
	
	public EdadException(String mensaje) {
		super(mensaje);
	}
	
	public EdadException(int edad) throws EdadException{
		this.validarEdad(edad);
	}
	
	public void validarEdad(int edad) throws EdadException {
		if(!(edad>=18 && edad<=45)) {
		System.out.println(" La edad capturada no pertenece al rango permitido (18 a 45 años)");
		throw new EdadException("Error de edad.");	
		}
	}
	
	

}
