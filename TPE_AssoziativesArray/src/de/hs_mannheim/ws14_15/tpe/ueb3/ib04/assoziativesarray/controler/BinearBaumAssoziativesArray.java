package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.controler;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.AssociativeArray;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.BinaerBaum;
import de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model.binaerbaum.Knoten;

public class BinearBaumAssoziativesArray<S, W> extends BinaerBaum implements AssociativeArray {

	@Override
	public void clear() {
		setWurzel(null);
	}

	@Override
	public boolean containsValue(Object wert) {
		return false;
	}

	@Override
	public boolean containsKey(Object schluessel) {
		return false;
	}

	@Override
	public Object get(Object schluessel) {
		return null;
	}

	@Override
	public void isEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void put(Object schluessel, Object wert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putAll(AssociativeArray Array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(Object schluessel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Object schluessel, Object wert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forEach(BiConsumer consumer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AssociativeArray extractAll(AssociativeArray Array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssociativeArray map(BiFunction function) {
		// TODO Auto-generated method stub
		return null;
	}

}
