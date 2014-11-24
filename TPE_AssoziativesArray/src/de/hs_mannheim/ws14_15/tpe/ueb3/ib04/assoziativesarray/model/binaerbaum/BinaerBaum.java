package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum;

public class BinaerBaum<S, W> {

	private Knoten<S, W> wurzel;
	
	public BinaerBaum() {

	}
	
	public void hinzufuegen(S schluessel, W wert) {
		boolean eingefuegt = true;
		Knoten<S, W> neuerKnoten = new Knoten<>(schluessel, wert);
		
		if(getWurzel() == null)
			setWurzel(neuerKnoten);
		else {
			Knoten<S, W> fokKnoten = getWurzel();
			Knoten<S, W> ElternKnoten;
			
			while(eingefuegt) {
				ElternKnoten = fokKnoten;
				
				if(schluessel.hashCode() < fokKnoten.getSchluessel().hashCode()) {
					fokKnoten = fokKnoten.getLinks();
					
					if(fokKnoten == null) {
						ElternKnoten.setLinks(neuerKnoten);
						eingefuegt = false;
					}
					
				} else {
					
					fokKnoten = fokKnoten.getRechts();
					
					if(fokKnoten == null) {
						ElternKnoten.setRechts(neuerKnoten);
						eingefuegt = false;
					}
					
				}
				
			}
			
		}
		
	}
	
	public Knoten<S, W> getWurzel() {
		return this.wurzel;
	}
	
	public void setWurzel(Knoten<S, W> wurzel) {
		this.wurzel = wurzel;
	}
	
	public String toString() {
		String txt = "{";
		String tmp = "";
		txt += ausgeben(getWurzel());
		
		// Entfernt das letzte Komma im String
		for(int i = 0; i < txt.length() - 2; i++)
			tmp += txt.charAt(i);
		
		
		tmp += "}";
		return tmp;
	}
	
	public String ausgeben(Knoten<S, W> knoten) {
		String txt = "";
		
		if(knoten != null) {
			txt += ausgeben(knoten.getLinks());
			txt += knoten.getSchluessel() + "=" + knoten.getWert() + ", ";
			txt += ausgeben(knoten.getRechts());
		}
		
		return txt;	
	}
			 
}
