import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import TipoDatos.*;

public class Main{
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Eliga el tipo de operación que desea hacer");
		System.out.println("No | Opción");
		System.out.println("1  | No Agrupados");
		System.out.println("2  | Agrupados");
		System.out.print("Ingrese el numero de la opción que desea realizar -> ");
		int op = entrada.nextInt();

		switch(op){
			case 1:
				NoAgrupado b = new NoAgrupado();
				break;
			case 2:
				Agrupado a = new Agrupado();
				break;
			default:
				System.out.println("Opcion invalida");
				break;
		}
		
	}
}