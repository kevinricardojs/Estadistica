package TipoDatos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;

public class NoAgrupado{
	public ArrayList<Integer> list = new ArrayList<>();
	public float media;
	public float mediana;

	public NoAgrupado(){
		this.menu();
	}

	public void menu(){
		
		//int[] lista = {1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,23,3,3,3,3,1,1,1,4,4,5,5,5,2};
		int[] lista = {5,22,60,56,64,56,63,63,61,57,63,50,49,70,72,54,48,53,58,66,68,45,74,65,58,61,62,59,64,57,63,52,67};
		//int[] lista = {15,17,16,16,15,17,15,18,17,16,15};		
		for (int i = 0 ; i < lista.length; i++ ) {
			list.add(lista[i]);
		}
		//this.ingreso();
		Collections.sort(this.list);
		this.listar();
		this.media();
		this.mediana();
		this.moda();
		this.quartiles();
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
			this.mediana = (float)(this.list.get(mitad - 1) + this.list.get(mitad)) / 2;
		}else{
			int mitad = (this.list.size() + 1) / 2;
			this.mediana = this.list.get(mitad - 1);
		}

		System.out.printf("\nLa mediana es: %.2f \n", this.mediana);
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
			if(cantidad > cantMayor){
				mayor = this.list.get(i);
				cantMayor = cantidad;
			}
		}
		ArrayList<Integer> l = new ArrayList<>();
		l.addAll(this.list);
		ArrayList<Integer> unic = new ArrayList<>();
		HashSet hs = new HashSet();
		hs.addAll(l);
		l.clear();
		l.addAll(hs);

		for (int i = 0; i < l.size(); i++) {
			int cantidad = 0;

			for (int o = 0; o < this.list.size(); o++ ) {
				if(l.get(i) == this.list.get(o)){
					cantidad++;
				}
			}

			if(cantidad == cantMayor){
				unic.add(l.get(i));
			}
		}	
		if(unic.size() > 1){
			System.out.println("La moda son los siguientes numeros: " + Arrays.toString(unic.toArray()));
			System.out.println("Que se repiten " + cantMayor + " veces");
		}
		else{
			System.out.println("La mayor es: " + cantMayor);
			System.out.println("La moda es: " + mayor);
		}
	}

	public void quartiles(){
		int q;
		float q1, q2, q3;
		int size = this.list.size(); 
		System.out.println("Tamaño del array" + size);
		if((size)% 2 == 0){
			q1 = (1 * (size + 1))/4;
			q2 = (2 * (size + 1))/4;
			q3 = (3 * (size + 1))/4;
		}
		else{
			q = ((1 * (size + 1))/4) - 1;
			q1 = (float)(this.list.get(q) + this.list.get(q +1)) / 2;
			q2 = ((2 * (size + 1))/4) - 1;
			q = ((3 * (size + 1))/4) - 1;
			q1 = (float)(this.list.get(q) + this.list.get(q +1)) / 2;
			System.out.println(q1 + " " +q2 + " " +q3);
			System.out.println("Q1 = " + q1 + "\nQ2 = "+ this.list.get(q2) + "\nQ3 = "+ q3);
		}
	}
}