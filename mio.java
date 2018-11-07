public class Main{
	public static void main(String[] args){
		float mediana;
		int[] lista = {6,5,22,60,56,64,56,63,63,61,57,63,50,49,70,72,54,48,53,58,66,68,45,74,65,58,61,62,59,64,57,63,52,67};
		if(lista.length % 2 == 0){
			int mitad = lista.length / 2;
			mediana = (float)(lista[mitad - 1] + lista[mitad]) / 2;
			if((mitad % 2) == 0)
				System.out.println("dividir");
			else
				System.out.println("k");
		}else{
			int mitad = (lista.length + 1) / 2;
			mediana = lista[mitad - 1];
			//System.out.println("exacto");
		}

		System.out.printf("\nLa mediana es: %.2f \n", mediana);
	}
}
