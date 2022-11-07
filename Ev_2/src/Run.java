
public class Run {

	public static double PI = 3.14159;
	
	public static double calcularCircuferencia(int radio) {
		double circuferencia = 0;
		circuferencia = 2*PI*radio;
		return circuferencia;
	}

	public static void main(String[] args) {
      
	 String[] nombreCompleto = new String[4];
      nombreCompleto[0] = "Andres";
      nombreCompleto[1] = "Alejandro";
      nombreCompleto[2] = "Briseno";
      nombreCompleto[3] = "Cristerna";

      String[][] alumnos = new String[35][4];
      
      alumnos[0][0] = "Andres";
      alumnos[0][1] = "Alejandro";
      alumnos[0][2] = "Briseño";
      alumnos[0][3] = "Cristerna";
      
System.out.println(nombreCompleto[0]);
System.out.println(nombreCompleto[1]);
System.out.println(nombreCompleto[2]);
System.out.println(nombreCompleto[3]);

	}
}
