package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.controler;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinearBaumAssoziativesArray;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.Knoten;

public class Test {

	public static void main(String[] args) {
		BinearBaumAssoziativesArray<Integer, String> a = new BinearBaumAssoziativesArray<>();
		BinearBaumAssoziativesArray<Integer, String> b = new BinearBaumAssoziativesArray<>();
		
		a.put(30, "A");
		a.put(20, "B");
		a.put(10, "C");
		a.put(50, "D");
		a.put(70, "E");
		a.put(60, "F");
		a.put(90, "G");
		a.put(40, "K");
		a.put(35, "O");
		
		System.out.println(a);

		b.put(21, "KI");
		b.put(42, "AL");
		b.put(54, "OP");
		b.put(86, "OI");
		
		System.out.println(a.remove(900));
		
		System.out.println(a);
		
	}
	
}
