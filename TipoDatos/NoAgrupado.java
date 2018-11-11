package TipoDatos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;

public class NoAgrupado{
	public static final String RESET = "\u001B[0m";
	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AZUL = "\u001B[34m";
	private ArrayList<Integer> list = new ArrayList<>();
	private float media;
	private float mediana;
	private double varianza;
	private double desviacion;

	public NoAgrupado(){
		this.menu();
	}

	public void menu(){
		Scanner in = new Scanner(System.in);
		int op, c = 0;
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
	while(c == 0){

		System.out.println(VERDE + "Menu de datos Simples" + RESET);
		System.out.println("#  | Opcion");
		System.out.println("1  - Ingresar datos");
		if(this.list.size() != 0){
			System.out.println("2  - Calcular Media");
			System.out.println("3  - Calcular Mediana");
			System.out.println("4  - Calcular Moda");
			System.out.println("5  - Calcular Cuartiles Q1 Q2 Q3");
			System.out.println("6  - Calcular Varianza");
			System.out.println("7  - Calcular Desviacion Estandar");
		}
		System.out.println("0  — Salir");
		System.out.println(AZUL + "Ingresa el numero de la opcion que desea seleccionar: " + RESET );
		op = in.nextInt();
		switch(op){
			case 1:
				this.ingreso();
				Collections.sort(this.list);
				this.listar();
				break;
			case 2:
				System.out.printf(VERDE + "Media: %.2f \n" + RESET, this.media());
				break;
			case 3:
				System.out.println(VERDE + "Mediana: " + this.mediana() + RESET);
				break;
			case 4:
				this.moda();
				break;
			case 5:
				System.out.println(VERDE);
				this.quartiles();
				System.out.println(RESET);
				break;
			case 6:
				System.out.printf(VERDE + "Varianza: %.2f \n" + RESET, this.varianza());
				break;
			case 7:
				System.out.printf(VERDE + "Desviacion Estandar: %.2f \n" + RESET, this.desviacion());
				break;
			case 0:
				c = 1;
				break;
			default:
				System.out.println(ROJO + "Opcion invalida" + RESET);
				break;

		}
		System.out.println("Presiona cualquier tecla para continuar...");
         new java.util.Scanner(System.in).nextLine();
	}
	}

	public void ingreso(){
		System.out.println(VERDE + "Ingresa datos con la siguiente sintaxix -> 1,2,3,4,8,9" + RESET);
		Scanner entrada = new Scanner(System.in);
		String[] str = entrada.nextLine().split(",");
		for (int i =  0 ; i < str.length; i++ ) {
			list.add(Integer.parseInt(str[i]));
		}
		//System.out.println(Arrays.toString(str));
		/*
		char i = 'y';

		do{
			System.out.println("Hola ingresa un dato entero nuevo");
			this.list.add(entrada.nextInt());
			System.out.println("Quieres continuar ingresando [Y/n]");
			i = entrada.next().charAt(0);
		}while(i == 'y' || i == 'Y');
		*/
	}

	public void listar(){
		System.out.println(VERDE + "Los datos ingresados son los siguientes: " + Arrays.toString(list.toArray()) + RESET);

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
			System.out.println(VERDE + "La moda son los siguientes numeros: " + Arrays.toString(unic.toArray()));
			System.out.println("Que se repiten " + cantMayor + " veces" + RESET);
		}
		else{
			System.out.println(VERDE + "La mayor es: " + cantMayor);
			System.out.println("La moda es: " + mayor + RESET);
		}
	}

	public void quartiles(){
		
		int size = this.list.size(); 
		int mitad = size / 2;
		if(size % 2 == 0){
			if(((mitad) % 2) == 0){
				System.out.println("Q1 = " + (float)(this.list.get((size / 4) - 1) + this.list.get(size / 4)) / 2);
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + ((float)(this.list.get(((size / 4) + mitad) - 1) + this.list.get(((size / 4) + mitad)))/ 2));
			}
			else{
				System.out.println("Q1 = " + this.list.get((1 * (size +1)/4)));
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + this.list.get((3 * (size +1)/4) - 1));
			}
		}
		else{
			if(((mitad) % 2) == 0){
				System.out.println("Q1 = " + (float)(this.list.get((size / 4) - 1) + this.list.get(size / 4)) / 2);
				System.out.println("Q2 = " + this.mediana());
				System.out.println("Q3 = " + ((float)(this.list.get(((size / 4) + mitad)) + this.list.get(((size / 4) + mitad + 1)))/ 2));
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