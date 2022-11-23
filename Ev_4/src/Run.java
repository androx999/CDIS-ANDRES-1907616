import java.util.ArrayList;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		
		boolean salir = true;
		
		@SuppressWarnings("resource")
		Scanner number = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner text = new Scanner(System.in);
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		do {
			//Desea registrar un usuario?
			salir = true;
		
			System.out.println("Desea ingresar empleado(0) o programador(1)?");
			if(number.nextInt()==1) {
				//Ingresara programador
				Programador progAux = new Programador();
				System.out.println("Indique el nombre:");
				progAux.setNombre(text.nextLine());
				
				empleados.add(progAux);
				
			} else {
				//Ingresa empleado
				Empleado empAux = new Empleado();
				System.out.println("Indique el nombre: ");
				empAux.setNombre(text.nextLine());
				
				empleados.add(empAux);
			}
			
			System.out.println("Desea ingresar otro empleado?(si:1/ no:0): ");
			if(number.nextInt()==1) {
				salir = true;
			}else {
				salir = false;
			}
		}while(salir);
		
		for(int i = 0; i<empleados.size();i++) {
			System.out.println("\nEmpleado: "+i);
			System.out.println(empleados.get(i).getNombre());
		}
	}
}
