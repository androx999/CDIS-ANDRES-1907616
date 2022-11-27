import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nombre;
		String civil;
		String sexo;
		int resp, personas = 0,edad=0,mas=0,fem=0,mas_cas=0,fem_cas=0,mas_sol=0,fem_sol=0,nsexo=0;
		
		do {
		System.out.println("Por favor escriba su nombre: ");
		nombre = entrada.nextLine();
		System.out.println("\nDigite su edad: ");
		edad = entrada.nextInt();
		//Sexo
		System.out.println("\nPor favor digite su sexo (Masculino o Femenino): ");
		sexo = entrada.nextLine();
		if(sexo == "Masculino") {
			mas++;
		}else if(sexo == "Femenino") {
			fem++;
		}
		//Estado civil
		System.out.println("\nDigite su estado civil: (Casado, Soltero, Divorciado, Viudo): ");
		civil = entrada.nextLine();
		if(civil == "Casado" && sexo == "Masculino") {
			mas_cas++;
		}else if(civil == "Casado" && sexo == "Femenino") {
			fem_cas++;
		}else if(civil == "Soltero" && sexo == "Masculino") {
			mas_sol++;
		}else if(civil == "Soltero" && sexo == "Femenino") {
			fem_sol++;
		}
		
		System.out.println("\nDesea agragar a otra persona?: ");
		System.out.println("\n1. Si");
		System.out.println("\n2.No");
		resp = entrada.nextInt();
		personas++;
		edad++;
		nsexo++;
		}while(resp == 1);
		
		System.out.println("\nEl numero de personas capturadas son "+personas);
		System.out.println("\nEl promedio de las edades es de: "+(edad/personas));
		System.out.println("\nEL porcentaje de Hombres es de: "+(mas*0.1)+"%");
		System.out.println("\nEL porcentaje de Mujeres es de: "+(fem*0.1)+"%");
		System.out.println("\nEL porcentaje de Hombres Casados es de: "+(mas_cas*0.1)+"%");
		System.out.println("\nEL porcentaje de Mujeres Casadas es de: "+(fem_cas*0.1)+"%");
		System.out.println("\nEL porcentaje de Hombres Solteros es de: "+(mas_sol*0.1)+"%");
		System.out.println("\nEL porcentaje de Mujeres Solteras es de: "+(mas_sol*0.1)+"%");


	}
}
