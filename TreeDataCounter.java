import java.util.*;
public class TreeDataCounter<E extends Comparable<E>,V> implements DataCounter<E,V>{
	// AF : albero: E -> V;
	//		&& forall data appartenente a E albero.get(data)-> V tale che
	//      albero.get(data)=valore con valore != null
	// IR : albero != null && forall i tc 0<=data_i<albero.size()
	//		albero.get(data_i)>0
	
	private TreeMap<E,Integer> albero;
	
	// metodo costruttore
	public TreeDataCounter() {
		albero = new TreeMap<E,Integer>();
	}
	
	public void incCount(E data)throws NullPointerException{
		if(data == null)throw new NullPointerException();
		int fal;
		fal= (albero.get(data).intValue()+1);
		albero.replace(data,fal);
	}
	// REQUIRES: data != null
	// MODIFIES: albero.get(data)
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: incrementa albero.get(data);
	
	public int getSize(){
		return albero.size();
	}
	// EFFECTS: restituisce la dimensione del dominio E

	public int getCount(E data)throws NullPointerException{
		if(data == null)throw new NullPointerException();
		if(albero.containsKey(data)==true)return albero.get(data).intValue();
		else return 0;
	}
	// REQUIRES: data!=null
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: restituisce albero(data) se data è presente in 
	//			albero altrimenti restituisce 0
	
	public Iterator<E> getIterator(){
		Iterator<E> itr = new TreeIterator<E,Integer>(albero);
		return itr;
	}
	// EFFECTS: resituisce un iteratore per la collezione
	public void put(E data)throws NullPointerException{
		if(data == null)throw new NullPointerException();
		if(albero.containsKey(data))this.incCount(data);
		else {
				albero.put(data,1);
				
		}
	}
	// REQUIRES: data != null
	// THROWS: lancia NullpointerException se data == null
	// 		   (unchecked)
	// MODIFIES: albero
	// EFFECTS: se dizionario contiene data allora incremento
	// 			dizionario.get(data) altrimenti aggiungo
	// 	

}