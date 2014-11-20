package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum;

public class Knoten<S, W> {
	
	private W wert;
	private S schluessel;
	private Knoten<S, W> links;
	private Knoten<S, W> rechts;
	
	public Knoten(S schluessel, W wert) {
		this.wert = wert;
		this.schluessel = schluessel;
	}
	
	public W getWert() {
		return this.wert;
	}
	
	public void setWert(W wert) {
		this.wert = wert;
	}
	
	public S getSchluessel() {
		return this.schluessel;
	}
	
	public void setSchluessel(S schluessel) {
		this.schluessel = schluessel;
	}
	
	public Knoten<S, W> getLinks() {
		return this.links;
	}
	
	public void setLinks(Knoten<S, W> links) {
		this.links = links;
	}
	
	public Knoten<S, W> getRechts() {
		return this.rechts;
	}
	
	public void setRechts(Knoten<S, W> rechts) {
		this.rechts = rechts;
	}
	
}
