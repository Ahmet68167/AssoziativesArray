package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.controler;

import static org.junit.Assert.*;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.junit.Test;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.Dictionary;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.IntegerAssociativeArray;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.StringAssociativeArray;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinearBaumAssoziativesArray;

public class Test_AssociativeArray {

	@Test
	public void test_Dictionary() {
		Dictionary dictionary = new Dictionary();
		dictionary.put("A", "Armeise");
		dictionary.put("B", "Berg");
		dictionary.put("C", "Cafe");
		dictionary.put("D", "Dach");
		
		String[] keys = { "A", "B", "C", "D" };
		String[] values = { "Armeise", "Berg", "Cafe", "Dach" };
		
		assertEquals(keys, dictionary.keys());
		assertEquals(values, dictionary.values());
		
	}
	
	@Test
	public void test_BinaerBaumAssoziativesArray() {
		
		BinearBaumAssoziativesArray<String, Integer> baum = new BinearBaumAssoziativesArray<>();
		BinearBaumAssoziativesArray<String, Integer> ast = new BinearBaumAssoziativesArray<>();
		BinearBaumAssoziativesArray<String, Integer> blatt = new BinearBaumAssoziativesArray<>();
		BinearBaumAssoziativesArray<String, Integer> neu = new BinearBaumAssoziativesArray<>();
		
		ast.put("A", 3);
		ast.put("B", 5);
		ast.put("C", 12);
		ast.put("D", 25);
		ast.put("E", 321);
		
		blatt.put("K", 3);
		
		//********************** TOSTRING & PUT **********************
		
		baum.put("A", 3);
		assertEquals("{A=3}", baum.toString());
		
		baum.put("B", 1);
		assertEquals("{A=3, B=1}", baum.toString());
		
		//********************** REMOVE **********************
		
		int entfernt = baum.remove("B");

		assertEquals(1, entfernt);
		assertEquals("{A=3}", baum.toString());
		
		baum.remove("A");
		assertEquals("{}", baum.toString());
		
		//********************** CLEAR **********************
		
		baum.put("A", 1);
		baum.put("B", 3);
		baum.clear();
		assertEquals("{}", baum.toString());
		
		//********************** CONTAINSVALUE **********************
		
		assertEquals(true, ast.containsValue(3));
		assertEquals(true, ast.containsValue(25));
		assertEquals(false, ast.containsValue(2225));
		
		//********************** CONTAINSKEY **********************
		
		assertEquals(true, ast.containsKey("A"));
		assertEquals(true, ast.containsKey("B"));
		assertEquals(false, ast.containsKey("a"));
		
		//********************** GET **********************
		
		assertEquals(3, (int) ast.get("A"));
		assertEquals(12, (int) ast.get("C"));
		assertEquals(null, ast.get("k"));
		
		//********************** ISEMPTY **********************
		
		assertEquals(true, baum.isEmpty());
		assertEquals(false, ast.isEmpty());
		
		//********************** PUTALL **********************
		
		baum.putAll(ast);
		assertEquals(ast.toString(), baum.toString());
		
		baum.putAll(ast);
		assertEquals(ast.toString(), baum.toString());
		
		baum.clear();
		baum.put("A", 1);
		baum.put("B", 2);

		baum.putAll(blatt);
		assertEquals("{A=1, B=2, K=3}", baum.toString());
		
		//********************** SIZE **********************
		
		assertEquals(3, baum.size());
		assertEquals(1, blatt.size());
		
		blatt.clear();
		assertEquals(0, blatt.size());
		
		//********************** UPDATE **********************
		
		baum.update("B", 12);
		assertEquals(12, (int) baum.get("B"));
		
		//********************** FOREACH **********************
		
		BiConsumer print = (x,y) -> System.out.print(x + "=" + y + ", ");
		
		baum.forEach(print);
		
		//********************** EXTRACTALL **********************
		
		blatt.put("O", 3);
		baum.extractAll(blatt);
		assertEquals("{A=1, B=12, K=3, O=3}", blatt.toString());
		
		//********************** MAP **********************
		
		blatt.clear();
		blatt.put("P", 2);
		blatt.put("L", 5);
		
		BiFunction add = (x, y) -> (int) y + 2;
		neu = blatt.map(add);
		assertEquals("{L=7, P=4}", neu.toString());
		
	}
	
	@Test
	public void test_IntegerAssociativeArray() {
		
		IntegerAssociativeArray<String> array = new IntegerAssociativeArray<>();
		
		array.put("A", 2);
		array.put("B", 3);
		assertEquals("{A=2, B=3}", array.toString());
		
	}
	
	@Test
	public void test_StringAssociativeArray() {
		
		StringAssociativeArray<Double> array = new StringAssociativeArray<>();
		
		array.put("A", 2.0);
		array.put("B", 3.5);
		assertEquals("{A=2.0, B=3.5}", array.toString());
		
	}

}
