package de.hs_mannheim.ws14_15.tpe.ueb3.ib04.assoziativesarray.model;
 
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public interface AssociativeArray<S, W> {

	public abstract void clear();
	
	public abstract boolean containsValue(W wert);
	
	public abstract boolean containsKey(S schluessel);
	
	public abstract W get(S schluessel);
	
	public abstract void isEmpty();
	
	public abstract void put(S schluessel, W wert);
	
	public abstract void putAll(AssociativeArray Array);
	
	public abstract W remove(S schluessel);
	
	public abstract int size();
	
	public abstract void update(S schluessel, W wert);
	
	public abstract void forEach(BiConsumer consumer);
	
	public abstract AssociativeArray<S, W> extractAll(AssociativeArray Array);
	
	public abstract AssociativeArray<S, W> map(BiFunction function);
	
	
}