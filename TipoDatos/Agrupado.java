package TipoDatos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;

public class Agrupado{
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String ROJO = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	private ArrayList<Dato> list = new ArrayList<>();
	private int intervalo;
	private double media;
	private float mediana;
	private double varianza;
	private double desviacion;
	private int frecuenciA;
	private double suma;

	public Agrupado(){
		System.out.println(this.intervalo);
		if(this.intervalo == 0)
			this.def_intevalo();
		this.menu();
	}


	public void menu(){
		Scanner in = new Scanner(System.in);
		int op, c = 0;

		while(c == 0){

			System.out.println("Menu de datos Agrupados");
			System.out.println("#  | Opcion");
			System.out.println("1  - Ingresar datos");

			if(this.list.size() != 0){
				System.out.println("2  - Mostrar tabla completa de datos");
				System.out.println("3  - Calcular Media");
				System.out.println("4  - Calcular Mediana");
				System.out.println("5  - Calcular Moda");
				System.out.println("6  - Calcular Cuartiles Q1 Q2 Q3");
				System.out.println("7  - Calcular Varianza");
				System.out.println("8  - Calcular Desviacion Estandar");
			}

			System.out.println("0  — Salir");

			System.out.println("Ingresa el numero de la opcion que desea seleccionar ->");
			op = in.nextInt();

			switch(op){
				case 1:
				this.ingreso();
				break;
				case 2:
				this.tablaCompleta();
				System.out.println("Presiona cualquier tecla para continuar...");
				break;
				case 3:
				System.out.printf(GREEN + "Media: %.2f  %s\n" , this.media(), RESET);
				break;
				case 4:
				this.mediana();
				break;
				case 5:
				this.moda();
				break;
				case 6:
				this.quartiles();
				break;
				case 7:
				System.out.printf("Varianza: %.2f \n", this.varianza());
				break;
				case 8:
				System.out.printf("Desviacion Estandar: %.2f \n", this.desviacion());
				break;
				case 0:
				c = 1;
				break;
				default:
				System.out.println("Opcion invalida");
				break;
			}
			System.out.println("Para continuar presione cualquier tecla...");
			new java.util.Scanner(System.in).nextLine();
		}
	}
	public void def_intevalo(){
		Scanner entrada = new Scanner(System.in);
		System.out.println("Debes de definir un intervalo");
		System.out.print("intervalo = ");
		this.intervalo = entrada.nextInt();
	}

	public void ingreso(){
		System.out.println(GREEN + "Ingresa datos que se te piden a continuacion");
		Scanner entrada = new Scanner(System.in);
		char i = 'y';

		do{
			Dato d = new Dato();
			System.out.println("Nueva fila!" + RESET);
			System.out.println("Limite inferior");
			d.linf(entrada.nextInt());
			System.out.println("Limite superior");
			d.lsup(entrada.nextInt());
			System.out.println("Frecuencia");
			d.frecuencia(entrada.nextInt());

			if((d.lsup_() - d.linf_() + 1) == this.intervalo && this.list.size() == 0){
				this.frecuenciA += d.frecuencia_();
				d.fa(this.frecuenciA);
				list.add(d);	
			}
			else if((d.lsup_() - d.linf_() + 1) == this.intervalo && d.linf_() > this.list.get(this.list.size() - 1).lsup_()){
				this.frecuenciA += d.frecuencia_();
				d.fa(this.frecuenciA);
				list.add(d);	
			}
			else{
				System.out.println(ROJO + "-> El rango no pudo ser guardado ya que sobrepasa el intervalo definido\n-> O su limite inferior es igual o menor que el limite superior de la ultima fila" + RESET);
			}

			this.listar();
			System.out.println("Quieres continuar ingresando [Y/n]");
			i = entrada.next().charAt(0);
		}while(i == 'y' || i == 'Y');

	}

	public void listar(){
		System.out.println(BLUE + "| Linf\t| Lsup\t|   f\t|   F\t|" + RESET);
		System.out.println("|-\t|-\t|-\t|-\t|");
		for (int i = 0 ; i < this.list.size() ; i++) {
			System.out.printf("|%d \t|%d\t|%d\t|%d\t|\n", this.list.get(i).linf_(), this.list.get(i).lsup_(), this.list.get(i).frecuencia_(), this.list.get(i).fa_());			
		}

	}

	public void tablaCompleta(){
		System.out.println(BLUE + "| Linf\t| Lsup\t|   f\t|   F\t|  Lri\t| Lrsup\t|   x\t| (x - 𐤍‏) * f\t|" + RESET);
		System.out.println("|-\t|-\t|-\t|-\t|-\t|-\t|-\t|-\t\t|");

		for (int i = 0 ; i < this.list.size() ; i++) {
			System.out.printf("|%d \t|%d\t|%d\t|%d\t|%.2f\t|%.2f\t|%.2f\t|\t%.2f\t|\n", this.list.get(i).linf_(), this.list.get(i).lsup_(), this.list.get(i).frecuencia_(), this.list.get(i).fa_(), this.list.get(i).lri_(), this.list.get(i).lrsup_(), this.list.get(i).x(), this.list.get(i).x_u_pow2(this.media()));			
		}

	}

	public double suma(){
		this.suma = 0;
		for (int i = 0 ; i < this.list.size() ; i++) {
			this.suma += this.list.get(i).x_f();
		}
		return this.suma;
	}
	public double media(){
		this.media = this.suma() / this.frecuenciA;
		return this.media;
	}	

	public double mediana(){
		if(this.list.size() > 1){
			int d = 0;
			double mitad = (float)this.frecuenciA / 2;
			for (int i = 0; i < this.list.size(); i++) {
				if(mitad <= this.list.get(i).fa_()){
					d = i;
					break;
				}

			}
			System.out.println(BLUE + "| Linf\t| Lsup\t|   f\t|   F\t|  Lri\t| Lrsup\t|");
			System.out.printf("|%d \t|%d\t|%d\t|%d\t|%.2f\t|%.2f\t|\n", this.list.get(d).linf_(), this.list.get(d).lsup_(), this.list.get(d).frecuencia_(), this.list.get(d).fa_(), this.list.get(d).lri_(), this.list.get(d).lrsup_());
			//System.out.printf("|%d \t|%d\t|%d\t|%d\t|\n", this.list.get(d).linf_(), this.list.get(d).lsup_(), this.list.get(d).frecuencia_(), this.list.get(d).fa_());
			System.out.println(GREEN + "Mediana = " + this.list.get(d).lri_() + " + (((( " +  this.frecuenciA + ") / 2 )" +"  -  " + this.list.get(d - 1).fa_() + ") / " + this.list.get(d).frecuencia_() + ") * " + this.intervalo );
			double total = (this.frecuenciA + 1) / 2 ;
			total = total - this.list.get(d - 1).fa_();
			total = total / this.list.get(d).frecuencia_();
			total = total * this.intervalo;
			total = total + this.list.get(d).lri_();
			System.out.printf("La mediana es : %.2f %s\n ", total, RESET);
		}
		else{
			System.out.println(ROJO + "La mediana no puede ser calculada ya que no se cuenta con la frecuencia del intervalo anterior porque no existe" + RESET);	
		}
		return this.mediana;	
	}


	public void moda(){
		int mayor = 0;
		int cantMayor = 0;

		ArrayList<Integer> l = new ArrayList<>();
		for(int i = 0; i < this.list.size(); i++){
			l.add(this.list.get(i).frecuencia_());
		}

		ArrayList<Integer> unic = new ArrayList<>();
		HashSet hs = new HashSet();
		hs.addAll(l);
		l.clear();
		l.addAll(hs);

		Collections.sort(l);

		for (int i = 0; i < this.list.size(); i++ ) {
			if(l.get(l.size() - 1) == this.list.get(i).frecuencia_()){
				unic.add(i);
			}
		}

		
		if(unic.size() > 1){
			System.out.println(BLUE + "La moda se encuentran en los siguientes intervalos: ");
			System.out.println("| Linf\t| Lsup\t|   f\t|" + GREEN  );
			for(int i = 0 ; i < unic.size(); i++)
				System.out.printf("|%d \t|%d\t|%d\t|\n", this.list.get(unic.get(i)).linf_(), this.list.get(unic.get(i)).lsup_(), this.list.get(unic.get(i)).frecuencia_());
			System.out.println("Que se repiten " + l.get(l.size() - 1) + " veces" + RESET);
		}
		else{
			System.out.println(BLUE + "La moda esta en el siguiente intervalo ");
			System.out.println("| Linf\t| Lsup\t|   f\t|" + GREEN);
			System.out.printf("|%d \t|%d\t|%d\t|%s\n", this.list.get(unic.get(0)).linf_(), this.list.get(unic.get(0)).lsup_(), this.list.get(unic.get(0)).frecuencia_(), RESET);
		}
		
	}

	public void quartiles(){
		if(this.list.size() > 5){
			int[] q = {1,2,3};

			for(int i = 0; i < q.length; i++ ){
				int d = 0;
				double mitad = (float)(q[i] * this.frecuenciA) / 4;
				for (int o = 0; o < this.list.size() - 1; o++) {
					if(mitad <= this.list.get(o).fa_()){
						d = o;
						break;
					}
				}
				System.out.println("| Linf\t| Lsup\t|   f\t|   F\t|");
				System.out.printf("|%d \t|%d\t|%d\t|%d\t|\n", this.list.get(d).linf_(), this.list.get(d).lsup_(), this.list.get(d).frecuencia_(), this.list.get(d).fa_());
				System.out.println("Q" + q[i] + " =" +this.list.get(d).lri_() + "+ (((( " + q[i] + " * " + this.frecuenciA + ") / 4 )" + "  -  " + this.list.get(d - 1).fa_() + " ) / " + this.list.get(d).frecuencia_() + ") * " + this.intervalo + ")");
				double total = (q[i] * this.frecuenciA + 1) / 4 ;
				total = total - this.list.get(d - 1).fa_();
				total = total / this.list.get(d).frecuencia_();
				total = total * this.intervalo;
				total = total + this.list.get(d).lri_();
		//mediana = (float) (this.list.get(d).lri_() + ((( (this.frecuenciA / 2 ) -  this.list.get(d - 1).fa_() ) / this.list.get(d).frecuencia_() ) * this.intervalo));
				System.out.printf("Q%d es %.2f\n", q[i], total);
			}
		}
		else{
			System.out.println(ROJO + "Debes ingresar mas filas ya que no se pueden calcular cuartiles sino existen intervalos sus intervalos anteriores" + RESET);
		}
	}

	public double varianza(){
		varianza = 0;
		for(int i = 0; i < this.list.size(); i++){
			varianza += this.list.get(i).x_u_pow2(this.media());
		}
		varianza = varianza / this.frecuenciA;

		return this.varianza;
	}

	public double desviacion(){
		
		this.desviacion = Math.sqrt(this.varianza());
		
		return this.desviacion;

	}



}