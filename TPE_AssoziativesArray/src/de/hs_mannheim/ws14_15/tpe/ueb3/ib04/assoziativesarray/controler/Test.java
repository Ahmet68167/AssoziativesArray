package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.controler;

import java.util.HashMap;
import java.util.Map;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinaerBaum;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.Knoten;

public class Test {

	public static void main(String[] args) {
		BinaerBaum<Integer, String> a = new BinaerBaum<>();
		
		a.hinzufuegen(30, "A");
		a.hinzufuegen(20, "B");
		a.hinzufuegen(10, "C");
		a.hinzufuegen(50, "D");
		a.hinzufuegen(70, "E");
		a.hinzufuegen(60, "F");
		a.hinzufuegen(90, "G");
		a.hinzufuegen(40, "K");
		a.hinzufuegen(35, "O");
		
		System.out.println(a.toString());
		
		a.setWurzel(null);
		System.out.println(a.toString());
		
	}
	
}
