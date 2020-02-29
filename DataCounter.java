import java.util.*;
public interface DataCounter<E,V> {
	// OVERVIEW: Tipo modificabile di funzione parziale con dominio insieme finito di elementi E e 
	//			codominio insieme finito di valori
	// Typical Element: f:E->V con E e V finiti ma modificabili
	
	// incrementa il valore associato all'elemento di tipo E
	
	public void incCount(E data)throws NullPointerException;
	// REQUIRES: data!=null
	// MODIFIES: f(data);
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: incrementa il valore di f(data)
	
	
	// restituisce il numero degli elementi presenti nella collezione
	
	public int getSize();
	// EFFECTS: restituisce la dimensione del dominio E
	
	// restituisce il valore corrente associato al parametro data,
	// e 0 se data non appartiene alla collezione
	
	public int getCount(E data)throws NullPointerException;
	// REQUIRES: data!=null
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: restituisce l'intero associato a f(data) se data presente
	// 			in collezione altrimenti restituisce 0
	// restituisce un iteratore (senza remove) per la collezione
	
	public Iterator<E> getIterator();
	// EFFECTS: resituisce un iteratore per la collezione

	public void put(E data)throws NullPointerException;
	// REQUIRES: data!=null
	// THROWS: lancia NullPointerException (Unchecked) se data == null
	// EFFECTS: aggiunge data a f se non è contenuto già sennò
	// 			incrementa this.get(data)

}