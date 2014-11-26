package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum;

/**
 * Legt einen Knoten an mit den Attributen:
 * Wert
 * Schluessel
 * Links
 * Rechts
 * 
 * @author 1410650
 *
 * @param <S> Der angegebene Datentyp für die Schluessel
 * @param <W> Der angegebene Datentyp für die Werte
 */
public class Knoten<S, W> {
	
	private W wert;
	private S schluessel;
	private Knoten<S, W> links;
	private Knoten<S, W> rechts;
	
	/**
	 * Initialisiert einen Knoten mit den angegebenen Parametern
	 * 
	 * @param schluessel - Schluessel des Knotens
	 * @param wert - Wert des Knotens
	 */
	protected Knoten(S schluessel, W wert) {
		this.wert = wert;
		this.schluessel = schluessel;
	}
	
	/**
	 * Gibt den Wert des Knotens zurueck
	 * 
	 * @return den Wert des Knotens
	 */
	public W getWert() {
		return this.wert;
	}
	
	/**
	 * Setzt den Wert des Knotens
	 * 
	 * @param wert - Wert des Knotens
	 */
	protected void setWert(W wert) {
		this.wert = wert;
	}
	
	/**
	 * Gibt den Schluessel des Knotens zurueck
	 * 
	 * @return den Schluessel des Knotens
	 */
	public S getSchluessel() {
		return this.schluessel;
	}
	
	/**
	 * Setzt den Schluessel des Knotens
	 * 
	 * @param schluessel - Schluessel des Knotens
	 */
	protected void setSchluessel(S schluessel) {
		this.schluessel = schluessel;
	}
	
	/**
	 * Gibt den linken Knoten zurueck
	 * 
	 * @return den linken Knoten
	 */
	public Knoten<S, W> getLinks() {
		return this.links;
	}
	
	/**
	 * Setzt den linken Knoten
	 * 
	 * @param links - linker Knoten
	 */
	protected void setLinks(Knoten<S, W> links) {
		this.links = links;
	}
	
	/**
	 * Gibt den rechten Knoten zurueck
	 * 
	 * @return den rechten Knoten
	 */
	public Knoten<S, W> getRechts() {
		return this.rechts;
	}
	
	/**
	 * Setzt den rechten Knoten
	 * 
	 * @param rechts - rechter Knoten
	 */
	protected void setRechts(Knoten<S, W> rechts) {
		this.rechts = rechts;
	}


}
