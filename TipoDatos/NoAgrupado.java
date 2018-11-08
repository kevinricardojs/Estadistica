package TipoDatos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;

public class NoAgrupado{
	private ArrayList<Integer> list = new ArrayList<>();
	private float media;
	private float mediana;
	private double varianza;
	private double desviacion;

	public NoAgrupado(){
		this.menu();
	}

	public void menu(){
		/*
		//int[] lista = {1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,23,3,3,3,3,1,1,1,4,4,5,5,5,2};
		int[] lista = {1,2,2,2,5,5,7,8,8,9,12,12,12,13,14,15,17,17,19,20,20,23,24,25,26,26,27,28,29,29,29,30,34,38,38,40,40,41,42,43,45,46,47,47,49,49,50,51,52,52,53,53,54,55,55,58,59,59,61,61,62,63,63,63,64,66,66,67,68,69,69,69,72,72,74,76,78,78,78,78,79,79,80,81,82,82,85,85,86,87,88,88,88,91,92,93,93,95,95,99};
		//int[] lista = {13,15,17,16,16,15,17,15,18,17,16,15,12,33};		
		//int[] lista = {2,5,8,8,11,14,18,19,25,26,27};
		for (int i =  0 ; i < lista.length; i++ ) {
			list.add(lista[i]);
		}

		for (int i =  1 ; i <= 100; i++ ) {
			list.add(i);
		}*/
		this.ingreso();
		Collections.sort(this.list);
		this.listar();
		System.out.printf("Media: %.2f \n", this.media());
		System.out.println("Mediana: " + this.mediana());
		this.moda();
		this.quartiles();
		System.out.printf("Varianza: %.2f \n", this.varianza());
		System.out.printf("Desviacion Estandar: %.2f \n", this.desviacion());
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

	public double media(){
		int suma = 0;
		for (int i = 0; i < this.list.size() ; i++ ) {
			suma += list.get(i);
		}	
		this.media = (float)suma / this.list.size();
		return this.media;
	}	

	public double mediana(){
		if(this.list.size() % 2 == 0){
			int mitad = this.list.size() / 2;
			this.mediana = (float)(this.list.get(mitad - 1) + this.list.get(mitad)) / 2;
		}else{
			int mitad = (this.list.size() + 1) / 2;
			this.mediana = this.list.get(mitad - 1);
		}

		return this.mediana;
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
		System.out.println("Tamaño del array " + size);
		int mitad = size / 2;
		if(size % 2 == 0){
			if(((mitad) % 2) == 0){
				System.out.println("Q1 = " + (float)(this.list.get((size / 4) - 1) + this.list.get(size / 4)) / 2);
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + ((float)(this.list.get(((size / 4) + mitad) - 1) + this.list.get(((size / 4) + mitad)))/ 2));
			}
			else{
				System.out.println("Q1 = " + this.list.get((1 * (size +1)/4) - 1));
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + this.list.get((3 * (size +1)/4) - 1));
			}
		}
		else{
			if(((mitad) % 2) == 0){
				System.out.println("Q1 = " + (float)(this.list.get((size / 4) - 1) + this.list.get(size / 4)) / 2);
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + ((size / 4) + mitad - 1) +  " " + ((size / 4) + mitad) );
				System.out.println("Q3 = " + ((float)(this.list.get(((size / 4) + mitad) - 1) + this.list.get(((size / 4) + mitad)))/ 2));
			}
			else{
				System.out.println("Q1 = " + this.list.get((1 * (size +1)/4) - 1));
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + this.list.get((3 * (size +1)/4) - 1));
			}
		}
	}

	public double varianza(){
		double suma = 0;
		for (int i = 0 ; i < this.list.size(); i++) {
			suma += Math.pow((this.list.get(i) - this.media), 2);
		}
		this.varianza = (suma / this.list.size());
		return this.varianza;
	}

	public double desviacion(){
		this.desviacion = Math.sqrt(this.varianza);
		return this.desviacion;
	}
}