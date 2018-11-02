package TipoDatos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class NoAgrupado{
	public ArrayList<Integer> list = new ArrayList<>();
	public float media;
	public float mediana;

	public NoAgrupado(){
		this.menu();
	}

	public void menu(){
		//2,55,51,60,56,64,56,63,63,61,57,63,50,49,70,72,54,48,53,58,66,68,45,74,65,58,61,62,59,64,57,63,52,67
		int[] lista = {1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,23,3,3,3,3,1,1,1,4,4,5,5,5,2};
		for (int i = 0 ; i < lista.length; i++ ) {
			list.add(lista[i]);
		}
		//this.ingreso();
		Collections.sort(this.list);
		this.listar();
		this.media();
		this.mediana();
		this.moda();
	}
	public void ingreso(){
		Scanner entrada = new Scanner(System.in);
		char i = 'y';

		do{
			System.out.println("Hola ingresa un dato entero nuevo");
			this.list.add(entrada.nextInt());
			System.out.println("Quieres continuar ingresando [Y/n]");
			i = entrada.next().charAt(0);
		}while(i == 'y' || i == 'Y');
	}

	public void listar(){
		System.out.println(Arrays.toString(list.toArray()));

	}

	public void media(){
		int suma = 0;
		for (int i = 0; i < this.list.size() ; i++ ) {
			suma += list.get(i);
		}	
		this.media = (float)suma / this.list.size();
		System.out.printf("La media es: %.2f", this.media);
	}

	public void mediana(){
		if(this.list.size() % 2 == 0){
			int mitad = this.list.size() / 2;
			System.out.println("\n1 \n" + this.list.get(mitad - 1) + " \n1 \n" + this.list.get(mitad));
			this.mediana = (float)(this.list.get(mitad - 1) + this.list.get(mitad)) / 2;
		}else{
			int mitad = (this.list.size() + 1) / 2;
			this.mediana = this.list.get(mitad - 1);
		}

		System.out.printf("La mediana es: %.2f \n", this.mediana);
	}

	public void moda(){
		int mayor = 0;
		int cantMayor = 0;
		for (int i = 0; i < this.list.size(); i++) {
			int cantidad = 0;
			for (int o = 0; o < this.list.size(); o++ ) {
				if(this.list.get(i) == this.list.get(o)){
					cantidad++;
				}
			}
			System.out.println(this.list.get(i) + " " + cantidad);
			if(cantidad > cantMayor){
				mayor = this.list.get(i);
				cantMayor = cantidad;
			}else if(cantidad == cantMayor){
				
			}

		}
		if(mayor == 0)
			System.out.println("La moda no existe");
		else
			System.out.println("La moda es: " + mayor);
	}

}