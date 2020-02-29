import  java.util.*;
public class HashDataCounter<E extends Comparable<E>,V> implements DataCounter<E,V> {
	// AF : dizionario : E -> V; 
	// 	    && forall data appartente a E dizionario.get(data)-> V tale che
	//      dizionario.get(data)=valore con valore != null
	// IR : dizionario != null && forall i tc 0<= data_i <dizionario.size()
	//      dizionario.get(data_i)>0

	private Hashtable<E,Integer> dizionario;
	
	// metodo costruttore
	public HashDataCounter() {
		dizionario = new Hashtable<E,Integer>();
		
	}
	
	public void incCount(E data)throws NullPointerException{
		int fal=0;
		if(data == null)throw new NullPointerException();
		fal= (dizionario.get(data)).intValue()+1;
		dizionario.put(data,fal);
		
	}
	// REQUIRES: data != null
	// MODIFIES: dizionario.get(data)
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: incrementa dizionario.get(data);
	
	public int getSize(){
		return dizionario.size();
	}
	// EFFECTS: restituisce la dimensione del dominio E
	
	public int getCount(E data)throws NullPointerException{
		if(data == null)throw new NullPointerException();
		if(dizionario.containsKey(data))return dizionario.get(data).intValue();
		else return 0;
	}
	// REQUIRES: data!=null
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: restituisce dizionario.get(data) se data è presente in 
	//			dizionario altrimenti restituisce 0
	
	public Iterator<E> getIterator(){
		Iterator<E> itr = new HashIterator<E,Integer>(dizionario);
		return itr;
	}
	// EFFECTS: resituisce un iteratore per la collezione
	public void put(E data)throws NullPointerException{
		if(data == null)throw new NullPointerException();
		if(dizionario.containsKey(data))this.incCount(data);
		else {
				dizionario.put(data,1);
				
		}
	}
	// REQUIRES: data != null
	// THROWS: lancia NullpointerException se data == null
	// 		   (unchecked)
	// MODIFIES: dizionario
	// EFFECTS: se dizionario contiene data allora incremento
	// 			dizionario.get(data) altrimenti aggiungo
	// 			a dizionario data e do dizionario.get(data) = 1 
	
}