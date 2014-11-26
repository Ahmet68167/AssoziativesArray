package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinearBaumAssoziativesArray;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.Knoten;

/**
 * Erstellt ein Dictionary
 * 
 * @author Ahmet
 *
 */
public class Dictionary extends StringAssociativeArray<String> {
	
	/**
	 * legt ein Dictionary an
	 * 
	 */
	public Dictionary() {
		
	}
	
	/**
	 * Gibt alle Schluessel des Dictionarys als Array zurueck
	 * 
	 * @return alle Schluessel als Array
	 */
	public String[] keys() {
		String[] schluessel = new String[size()];
		return keysRek(schluessel, getWurzel(), 0);
	}
	
	private String[] keysRek(String[] schluessel, Knoten<String, String> knoten, int size) {

		if(knoten != null) {
			schluessel[size] = knoten.getSchluessel();
			
			if(knoten.getLinks() != null)
				keysRek(schluessel, knoten.getLinks(), size+1);
			if(knoten.getRechts() != null)
				keysRek(schluessel, knoten.getRechts(), size+1);
		}
		
		return schluessel;
	}
	
	/**
	 * Alle Werte des Dictionarys als Array
	 * 
	 * @return alle Werte als Array
	 */
	public String[] values() {
		String[] werte = new String[size()];
		return valuesRek(werte, getWurzel(), 0);
	}
	
	private String[] valuesRek(String[] werte, Knoten<String, String> knoten, int size) {

		if(knoten != null) {
			werte[size] = knoten.getWert();
			
			if(knoten.getLinks() != null)
				valuesRek(werte, knoten.getLinks(), size+1);
			if(knoten.getRechts() != null)
				valuesRek(werte, knoten.getRechts(), size+1);
		}
		
		return werte;
	}

}
