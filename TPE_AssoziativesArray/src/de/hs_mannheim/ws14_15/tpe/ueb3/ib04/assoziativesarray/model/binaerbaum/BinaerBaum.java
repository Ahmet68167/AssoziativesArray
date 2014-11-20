package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum;

public class BinaerBaum<S, W> {

	private Knoten<S, W> wurzel;
	private int groesse;
	
	public BinaerBaum() {
		this.groesse = 0;
	}
	
	public void hinzufuegen(S schluessel, W wert) {
		Knoten<S, W> neuerKnoten = new Knoten<>(schluessel, wert);
		
		if(getWurzel() == null)
			setWurzel(neuerKnoten);
		else {
			Knoten<S, W> fokKnoten = getWurzel();
			Knoten<S, W> ElternKnoten;
			
			while(true) {
				ElternKnoten = fokKnoten;
				
				if(schluessel.hashCode() < fokKnoten.getSchluessel().hashCode()) {
					fokKnoten = fokKnoten.getLinks();
					
					if(fokKnoten == null) {
						Knoten<S, W> links = ElternKnoten.getLinks();
						links = neuerKnoten;
						return;
					}
					
				} else {
					
					fokKnoten = fokKnoten.getRechts();
					
					if(fokKnoten == null) {
						Knoten<S, W> rechts = ElternKnoten.getRechts();
						rechts = neuerKnoten;
						return;
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
	

	 public void inOrderTraverseTree(Knoten<S, W> focusNode) { 
		 if (focusNode != null) { 
			 inOrderTraverseTree(focusNode.getLinks()); 
			 System.out.println(focusNode); 
			 inOrderTraverseTree(focusNode.getRechts()); 
		 }
	 }
			 
}
