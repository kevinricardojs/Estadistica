import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import TipoDatos.*;

public class Main{
	public static final String MORADO = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String RESET = "\u001B[0m";
	public static final String ROJO = "\u001B[31m";
	public static final String AZUL = "\u001B[34m";
	public static final String VERDE = "\u001B[32m";

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int i = 0;
		while(i == 0){
			System.out.println(AZUL +"Eliga el tipo de operación que desea hacer");
			System.out.println("No | Opción" + RESET);
			System.out.println(CYAN + "1  - Datos Simples\t(Parcial 1)" + RESET);
			System.out.println(MORADO + "2  - Datos Agrupados\t(Parcial 2)" + RESET);
			System.out.println("0  - Salir");
			System.out.print("Ingrese el numero de la opción que desea realizar -> ");
			int op = entrada.nextInt();

			switch(op){
				case 1:
				NoAgrupado b = new NoAgrupado();
				break;
				case 2:
				Agrupado a = new Agrupado();
				break;
				case 0:
					i = 1;
					System.out.println(VERDE + "Has salido del sistema..."+ RESET);
					break;
				default:
				System.out.println(ROJO + "Opcion invalida" + RESET);
				break;
			}
		}
		
	}
}