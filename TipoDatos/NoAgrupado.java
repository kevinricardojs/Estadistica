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
		//int[] lista = {1,2,2,2,5,5,7,8,8,9,12,12,12,13,14,15,17,17,19,20,20,23,24,25,26,26,27,28,29,29,29,30,34,38,38,40,40,41,42,43,45,46,47,47,49,49,50,51,52,52,53,53,54,55,55,58,59,59,61,61,62,63,63,63,64,66,66,67,68,69,69,69,72,72,74,76,78,78,78,78,79,79,80,81,82,82,85,85,86,87,88,88,88,91,92,93,93,95,95,99};
		//int[] lista = {13,15,17,16,16,15,17,15,18,17,16,15,12,33};		
		int[] lista = {2,2,5,8,8,11,14,18,19,25,26,27};
		for (int i =  0 ; i < lista.length; i++ ) {
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
		
		int size = this.list.size(); 
		System.out.println("Tamaño del array" + size);
		
		/*
		if((size)% 2 == 0){
			int q, q1, q3;
			float  q2;
			q1 = (1 * (size + 1))/4;
			q = ((2 * (size + 1))/4) - 1;
			q2 = (float)(this.list.get(q) + this.list.get(q +1)) / 2;
			q3 = (3 * (size + 1))/4;
			System.out.println(q1 + " " +q2 + " " +q3);
			System.out.println("Q1 = " + this.list.get(q1) + "\nQ2 = "+ q2 + "\nQ3 = "+ this.list.get(q3));
		}
		else{
			int q, q2;
			float q1, q3;
			q = ((1 * (size + 1))/4) - 1;
			q1 = (float)(this.list.get(q) + this.list.get(q +1)) / 2;
			q2 = ((2 * (size + 1))/4) - 1;
			q = (	(3 * (size + 1))/4) - 1;
			q3 = (float)(this.list.get(q) + this.list.get(q +1)) / 2;
			System.out.println(q1 + " " +q2 + " " +q3);
			System.out.println("Q1 = " + q1 + "\nQ2 = "+ this.list.get(q2) + "\nQ3 = "+ q3);
		}
		*/
		int mitad = size / 2;
		if(size % 2 == 0){
			System.out.println("par");
			if(((mitad - 1) % 2) == 0){
				System.out.println("par");
				System.out.println("Q1 = " + (float)(this.list.get((size / 4) - 1) + this.list.get(size / 4)) / 2);
				this.mediana();
				System.out.println("Q3 = " + (float)(this.list.get((size / 4) + (mitad) - 1) + this.list.get(size / 4) + (mitad)) / 2);
			}
			else{
				System.out.println("impar");
				System.out.println("Q1 = " + this.list.get((size / 4) - 1));
				this.mediana();
				System.out.println("Q3 = " + this.list.get((size / 4) + (mitad  + 1 ) - 1));
			}
		}else{
			System.out.println("impar");
			if(((mitad - 1) % 2) == 0){
				System.out.println("Q1 = " + (float)(this.list.get((size / 4) - 1) + this.list.get(size / 4)) / 2);
				this.mediana();
				System.out.println("Q3 = " + (float)(this.list.get((size / 4) + (mitad) - 1) + this.list.get(size / 4) + (mitad)) / 2);
			}
			else{
				System.out.println("par");
				System.out.println("impar");
				System.out.println("Q1 = " + this.list.get((size / 4) - 1));
				this.mediana();
				System.out.println("Q3 = " + this.list.get((size / 4) + (mitad) - 1));
			}
		}
		/*double q1, q2, q3;
		q1 =  ((size) * 0.25) - 0.5;
		q2 =  ((size) * 0.5) - 0.5;
		q3 =  ((size) * 0.75) - 0.5;
		System.out.println("q1 " + q1 );
		System.out.println("q2 " + q2 );
		System.out.println("q3 " + q3 );*/
	}
}