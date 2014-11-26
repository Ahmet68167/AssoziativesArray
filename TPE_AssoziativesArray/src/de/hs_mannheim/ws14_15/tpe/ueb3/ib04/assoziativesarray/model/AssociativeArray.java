package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model;
 
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinearBaumAssoziativesArray;

/**
 * Interface für das AssociativeArray
 * 
 * @author Ahmet
 *
 * @param <S> Datentyp der Schluessel
 * @param <W> Datentyp der Werte
 */
public interface AssociativeArray<S, W> {

	/**
	 * Löscht den Inhalt des AssociativeArrays
	 */
	public abstract void clear();
	
	/**
	 * Prueft ob der uebergebene Wert im AssociativeArray enthalten ist
	 * 
	 * @param wert - Der gesuchte Wert
	 * @return true, falls gefunden und false, falls nicht gefunden
	 */
	public abstract boolean containsValue(W wert);
	
	/**
	 * Prueft ob der uebergebene Schluessel im AssociativeArray enthalten ist
	 * 
	 * @param schluessel - Der gesuchte Schluessel
	 * @return true, falls gefunden und false, falls nicht gefunden
	 */
	public abstract boolean containsKey(S schluessel);
	
	/**
	 * Gibt den Wert des gesuchten Schluessels zurueck
	 * 
	 * @param schluessel - Schluessel zum gesuchten Wert
	 * @return falls der Schluessel gefunden wird gibt er den Wert zurueck, 
	 * 			ansonsten gibt er "null" zurueck
	 */
	public abstract W get(S schluessel);
	
	/**
	 * Prueft ob das AssociativeArray leer ist
	 * 
	 * @return true, falls das AssociativeArray leer ist und false, falls nicht
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Speichert den Schluessel und den Wert im AssociativeArray ab 
	 * 
	 * @param schluessel - Schluessel
	 * @param wert - Wert
	 */
	public abstract void put(S schluessel, W wert);
	
	/**
	 * Fuegt das uebergebene AssociativeArray dem AssociativeArray hinzu
	 * 
	 * @param array - AssociativesArray
	 */
	public abstract void putAll(BinearBaumAssoziativesArray<S, W> array);
	
	/**
	 * Gibt den Wert des angegebenen Schluessels zurueck und entfernt es danach
	 * 
	 * @param schluessel - Schluessel des zu entfernenden Wertes
	 * @return den Wert, der geloescht werden soll
	 */
	public abstract W remove(S schluessel);
	
	/**
	 * Gibt die Anzahl der Schluessel - Wert Paare zurueck
	 * 
	 * @return die Anzahl der Schluessel - Wert Paare
	 */
	public abstract int size();
	
	/**
	 * Den Wert des uebergebenen Schluessels mit dem uebergebenen Wert aktualisieren
	 * 
	 * @param schluessel - Schluessel des zu aktualisierenden Wertes
	 * @param wert - neuer Wert
	 */
	public abstract void update(S schluessel, W wert);
	
	/**
	 * Soll den BiConsumer fuer alle Schluessel - Wert Paare ausfuehren
	 * 
	 * @param consumer BiConsumer
	 */
	public abstract void forEach(BiConsumer<S, W> consumer);
	
	/**
	 * Fuegt dem uebergebenen AssociativeArray das aktuelle AssociativeArray hinzu
	 * 
	 * @param array - AssociativeArray 
	 * @return ein AssociativeArray 
	 */
	public abstract BinearBaumAssoziativesArray<S, W> extractAll(BinearBaumAssoziativesArray<S, W> array);
	
	/**
	 * soll die uebergebene BiFunction fuer alle Schluessel-Wert-Paare des 
	 * assoziativen Arrays ausfuehren
	 * 
	 * @param function - BiFunction
	 * @return ein AssociativeArray
	 */
	public abstract BinearBaumAssoziativesArray<S, W> map(BiFunction<S, W, W> function);
	
	
}
