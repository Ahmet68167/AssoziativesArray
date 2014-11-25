package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinearBaumAssoziativesArray;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.Knoten;

public class Dictionary extends StringAssociativeArray<String> {
	
	public Dictionary() {
		
	}
	
	public String[] keys() {
		String[] schluessel = new String[size()];
		String[] schluessel2 = new String[size()];
		schluessel = keysRek(schluessel, getWurzel(), size());
		
		for(int i = 0; i < size(); i++) {
			schluessel2[i] = schluessel[size()-1-i];
		}
		return schluessel2;
	}
	
	private String[] keysRek(String[] schluessel, Knoten<String, String> knoten, int size) {
		String[] schluessel1 = new String[size()];
		
		if(knoten != null) {
			schluessel[size-1] = knoten.getSchluessel();
			schluessel1 = schluessel;
			if(knoten.getLinks() != null)
				keysRek(schluessel1, knoten.getLinks(), size-1);
			if(knoten.getRechts() != null)
				keysRek(schluessel1, knoten.getRechts(), size-1);
		}
		
		return schluessel1;
	}
	
	public String[] values() {
		String[] werte = new String[size()];
		String[] werte2 = new String[size()];
		werte = valuesRek(werte, getWurzel(), size());
		
		for(int i = 0; i < size(); i++) {
			werte2[i] = werte[size()-1-i];
		}

		return werte2;
	}
	
	private String[] valuesRek(String[] werte, Knoten<String, String> knoten, int size) {
		String[] werte1 = new String[size()];
		
		if(knoten != null) {
			werte[size-1] = knoten.getWert();
			werte1 = werte;
			if(knoten.getLinks() != null)
				valuesRek(werte1, knoten.getLinks(), size-1);
			if(knoten.getRechts() != null)
				valuesRek(werte1, knoten.getRechts(), size-1);
		}
		
		return werte1;
	}

}
