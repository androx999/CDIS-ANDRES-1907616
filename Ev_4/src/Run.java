import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		
		boolean salir = true;
		
		@SuppressWarnings("resource")
		Scanner number = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner text = new Scanner(System.in);
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		EdadException edE = new EdadException();
		
		do {
			try {
			//Desea registrar un usuario?
			salir = true;
			System.out.println("Desea ingresar empleado(0) o programador(1)?");
			if(number.nextInt()==1) {
				//Ingresara programador
				Programador progAux = new Programador();
				System.out.println("Indique el nombre:");
				progAux.setNombre(text.nextLine());
				
				System.out.println("Indique la edad: ");
				progAux.setEdad(number.nextInt()); 
				edE.validarEdad(progAux.getEdad());
				
				empleados.add(progAux);
				
			} else {
				//Ingresa empleado
				Empleado empAux = new Empleado();
				System.out.println("Indique el nombre: ");
				empAux.setNombre(text.nextLine());
				
				System.out.println("Indique la edad: ");
				empAux.setEdad(number.nextInt()); 
				edE.validarEdad(empAux.getEdad());
				
				empleados.add(empAux);
			}
			
			System.out.println("Desea ingresar otro empleado?(si:1/ no:0): ");
			if(number.nextInt()==1) {
				salir = true;
			}else {
				salir = false;
			}	
			}catch(InputMismatchException ex) {
				System.out.println("Tome la decision correcta");
				ex.printStackTrace();
				salir = false;
			} catch(EdadException ex) {
				salir = false;
			}
			
		}while(salir);
		
		for(int i = 0; i<empleados.size();i++) {
			System.out.println("\nEmpleado: "+i);
			System.out.println(empleados.get(i).getNombre());
		}
  }
}

