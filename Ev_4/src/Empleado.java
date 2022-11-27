
public class Empleado {
	private String nombre = "";
	private int edad = 0;
	private boolean est_civil = false;
	private String calificacion = "";
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isEst_civil() {
		return est_civil;
	}
	public void setEst_civil(boolean est_civil) {
		this.est_civil = est_civil;
	}
	
	  public void asignarCalif() {
		if(this.getEdad()<=21) {
			this.calificacion="Principiante";
		}else if(this.getEdad()<=35 && this.getEdad()>=22) {
			this.calificacion="Intermedio";
		}else if(this.getEdad()>35) {
			this.calificacion = "Senior";
		}
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", est_civil=" + est_civil + ", calificacion="
				+ calificacion + "]";
	}
	

}
