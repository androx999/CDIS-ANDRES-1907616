
public class Piloto implements IProfesionista{
	
	private String nombre = "";
	private String aniosVolando = "";
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAniosVolando() {
		return aniosVolando;
	}
	
	public void setAniosVolando(String aniosVolando) {
		this.aniosVolando = aniosVolando;
	}

	@Override
	public void encenderHerramienta() {
		System.out.println("El piloto esta encendiendo la nave\n nombre: "+this.getNombre());
		
	}

}
