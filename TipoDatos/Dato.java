package TipoDatos;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;

public class Dato{
	private int lsup;
	private int linf;
	private int frecuencia;
	private double lri; 
	private double lrsup;
	private double x;
	private int fa;

	public void Dato(){

	}

	public void lsup(int sup){
		lsup = sup;
	}

	public void linf(int inf){
		linf = inf;
	}

	public void frecuencia(int frec){
		frecuencia = frec;
	}	

	public int lsup_(){
		return lsup;
	}

	public int linf_(){
		return linf;
	}

	public int frecuencia_(){
		return frecuencia;
	}	

	public double lri_(){
		lri = linf - 0.5;
		return lri;
	}

	public double lrsup_(){
		lrsup = lsup + 0.5;
		return lrsup;
	}

	public double x(){
		this.x = (float)(this.linf + this.lsup) / 2;
		return this.x;
	}

	public void fa(int f){
		this.fa = f;
	}
	
	public int fa_(){
		return this.fa;
	}

	public double x_f(){
		 return this.x() * this.frecuencia_();
	}
	public double x_u_pow2(double m){
		 return Math.pow((this.x() - m), 2) * this.frecuencia_();
	}

}