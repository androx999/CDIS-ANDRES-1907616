
public class Programador extends Empleado{
	private String lenguajeDominante = "";
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}
	
	@Override
	public int getEdad() {
		// TODO Auto-generated method stub
		return super.getEdad();
	}

	@Override
	public boolean isEst_civil() {
		// TODO Auto-generated method stub
		return super.isEst_civil();
	}

	@Override
	public void setEst_civil(boolean est_civil) {
		// TODO Auto-generated method stub
		super.setEst_civil(est_civil);
	}

	@Override
	public void asignarCalif() {
		// TODO Auto-generated method stub
		super.asignarCalif();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+this.getLenguajeDominante();
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}
	
	@Override
	public void setEdad(int edad) {
		// TODO Auto-generated method stub
		super.setEdad(edad);
	}

	public String getLenguajeDominante() {
		return lenguajeDominante;
	}

	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	
	

}
