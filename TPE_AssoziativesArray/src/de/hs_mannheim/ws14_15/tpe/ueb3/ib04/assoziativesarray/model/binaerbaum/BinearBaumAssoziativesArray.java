package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.AssociativeArray;

public class BinearBaumAssoziativesArray<S, W> implements AssociativeArray<S, W> {

	private Knoten<S, W> wurzel;
	private int anzahl;
	
	public BinearBaumAssoziativesArray() {
		this.anzahl = 0;
	}
	
	@Override
	public void clear() {
		setWurzel(null);
	}

	@Override
	public boolean containsValue(W wert) {
		if(findValue(wert) == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean containsKey(S schluessel) {
		if(findKey(schluessel) == null)
			return false;
		else
			return true;
	}

	@Override
	public W get(S schluessel) {
		if(!containsKey(schluessel))
			return null;
		else
			return findKey(schluessel).getWert();
	}

	@Override
	public boolean isEmpty() {
		if(getWurzel() == null)
			return true;
		else
			return false;
	}

	@Override
	public void put(S schluessel, W wert) {
		boolean eingefuegt = false;
		Knoten<S, W> neuerKnoten = new Knoten<>(schluessel, wert);
		
		if(getWurzel() == null) {
			setWurzel(neuerKnoten);
			this.anzahl++;
		} else {
			Knoten<S, W> fokKnoten = getWurzel();
			Knoten<S, W> ElternKnoten;
			
			while(!eingefuegt) {
				ElternKnoten = fokKnoten;
				
				if(schluessel.hashCode() < fokKnoten.getSchluessel().hashCode()) {
					fokKnoten = fokKnoten.getLinks();
					
					if(fokKnoten == null) {
						ElternKnoten.setLinks(neuerKnoten);
						eingefuegt = true;
						this.anzahl++;
					}
					
				} else if(schluessel.hashCode() == fokKnoten.getSchluessel().hashCode()) {
					eingefuegt = true;
				}else {
					
					fokKnoten = fokKnoten.getRechts();
					
					if(fokKnoten == null) {
						ElternKnoten.setRechts(neuerKnoten);
						eingefuegt = true;
						this.anzahl++;
					}
					
				}
				
			}
			
		}
		
	}

	@Override
	public void putAll(BinearBaumAssoziativesArray array) {
		putAll(array.getWurzel());
	}
	
	private void putAll(Knoten<S,W> knoten) {
		if(knoten != null) {
			put(knoten.getSchluessel(), knoten.getWert());
			putAll(knoten.getLinks());
			putAll(knoten.getRechts());
		}
	}

	@Override
	public W remove(S schluessel) {
		W removed;
		
		if(isEmpty())
			removed = null;
		else {
			if(containsKey(schluessel)) {
				removed = findKey(schluessel).getWert();
				remove(getWurzel(), schluessel);
			} else
				removed = null;
		}
		
		return removed;
	}
	
	private void remove(Knoten<S, W> knoten, S schluessel) {
		if(getWurzel().getSchluessel() == schluessel) {
			if(getWurzel().getLinks() != null) {
				Knoten<S, W> k = getWurzel().getRechts();
				setWurzel(getWurzel().getLinks());
				putAll(k);
			} else if(getWurzel().getRechts() != null) {
				setWurzel(getWurzel().getRechts());
			} else
				setWurzel(null);
			
		} else if(knoten.getLinks() != null && knoten.getLinks().getSchluessel() == schluessel) {
			if(knoten.getLinks().getLinks() != null) {
				Knoten<S, W> h = knoten.getLinks().getRechts();
				knoten.setLinks(knoten.getLinks().getLinks());
				putAll(h);
			} else if(knoten.getLinks().getRechts() != null) {
				knoten.setLinks(knoten.getLinks().getRechts());
			} else
				knoten.setLinks(null);
			
		} else if(knoten.getRechts() != null && knoten.getRechts().getSchluessel() == schluessel) {
			if(knoten.getRechts().getLinks() != null) {
				Knoten<S, W> o = knoten.getRechts().getRechts();
				knoten.setRechts(knoten.getRechts().getLinks());
				putAll(o);
			} else if(knoten.getRechts().getRechts() != null) {
				knoten.setLinks(knoten.getRechts().getRechts());
			} else
				knoten.setRechts(null);
	
		} else {
			if(knoten.getLinks() != null)
				remove(knoten.getLinks(), schluessel);
			if(knoten.getRechts() != null)
				remove(knoten.getRechts(), schluessel);
		}
			
	}

	@Override
	public int size() {
		return getAnzahl();
	}

	@Override
	public void update(S schluessel, W wert) {
		findKey(schluessel).setWert(wert);
	}

	@Override
	public void forEach(BiConsumer consumer) {
		forEachRek(consumer, getWurzel());
	}
	
	private void forEachRek(BiConsumer consumer, Knoten<S, W> knoten) {
		if(knoten != null)
			consumer.accept(knoten.getSchluessel(), knoten.getWert());
		if(knoten.getLinks() != null)
			forEachRek(consumer, knoten.getLinks());
		if(knoten.getRechts() != null)
			forEachRek(consumer, knoten.getRechts());
	}

	@Override
	public BinearBaumAssoziativesArray extractAll(BinearBaumAssoziativesArray array) {
		array.putAll(getWurzel());
		return array;
	}

	@Override
	public BinearBaumAssoziativesArray map(BiFunction function) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Knoten<S, W> findKey(S schluessel) {
		return findKey(getWurzel(), schluessel);
	}
	
	private Knoten<S, W> findValue(W wert) {
		return findValue(getWurzel(), wert);
	}
	
	private Knoten<S, W> findKey(Knoten<S, W> knoten, S schluessel) {
		Knoten<S, W> enthalten;
		
		if(knoten == null)
			enthalten = null;
		else if(knoten.getSchluessel() == schluessel)
			enthalten = knoten;
		else {
			enthalten = findKey(knoten.getLinks(), schluessel);
			if(enthalten == null)
				enthalten = findKey(knoten.getRechts(), schluessel);
		}
		
		return enthalten;
	}
	
	private Knoten<S, W> findValue(Knoten<S, W> knoten, W wert) {
		Knoten<S, W> enthalten;
		
		if(knoten == null)
			enthalten = null;
		else if(knoten.getWert() == wert)
			enthalten = knoten;
		else {
			enthalten = findValue(knoten.getLinks(), wert);
			if(enthalten == null)
				enthalten = findValue(knoten.getRechts(), wert);
		}
		
		return enthalten;
	}
	
	public Knoten<S, W> getWurzel() {
		return this.wurzel;
	}
	
	public void setWurzel(Knoten<S, W> wurzel) {
		this.wurzel = wurzel;
	}
	
	public int getAnzahl() {
		return this.anzahl;
	}
	
	public String toString() {
		String txt = "";
		String tmp = "";
		txt += ausgeben(getWurzel());
		
		// Entfernt das letzte Komma im String
		for(int i = 0; i < txt.length() - 2; i++)
			tmp += txt.charAt(i);
		
		
		tmp = "{" + tmp + "}";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wurzel == null) ? 0 : wurzel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinearBaumAssoziativesArray other = (BinearBaumAssoziativesArray) obj;
		if (wurzel == null) {
			if (other.wurzel != null)
				return false;
		} else if (!wurzel.equals(other.wurzel))
			return false;
		return true;
	}
	

}
