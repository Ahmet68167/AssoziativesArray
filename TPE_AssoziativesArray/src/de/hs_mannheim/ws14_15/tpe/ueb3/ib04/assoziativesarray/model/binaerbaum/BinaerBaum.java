package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum;

public class BinaerBaum<S, W> {

	private Knoten<S, W> wurzel;
	private int groesse;
	
	public BinaerBaum() {
		this.groesse = 0;
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
	
	public int getGroesse() {
		return this.groesse;
	}
	
	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}
	
	
	// TRASH
	public void ausgabe() {
		
		System.out.println(getWurzel().getSchluessel() + " " + getWurzel().getWert());
		System.out.println(getWurzel().getLinks().getSchluessel() + " " + getWurzel().getLinks().getWert());
		System.out.println(getWurzel().getRechts().getSchluessel() + " " + getWurzel().getRechts().getWert());
		System.out.println(getWurzel().getLinks().getLinks().getSchluessel() + " " + getWurzel().getLinks().getLinks().getWert());
	}
	
			 
}
