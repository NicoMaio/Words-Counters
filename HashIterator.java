import java.util.*;
import java.io.*;
import java.lang.Integer;
public class HashIterator<E extends Comparable<E>,V extends Integer> implements Iterator<E> {
	// OVERVIEW: tipo modificabile di coppia <key,index>
	// AF : {<ultima.get(i),i>...<ultima.get(ultima.size()-1),ultima.size()-1>}
	// IR : forall i tc 0<=i<ultima.size() ultima.get(i)!=null
	int index;
	Vector<E> ultima;

	// metodo costruttore
	public HashIterator(Hashtable<E,Integer> a){
		ultima = new Vector<E>();
		Set<E> ecco=a.keySet();
		Vector<E> v = new Vector<E>();
		
		for(E elem:ecco){
			v.add(elem);
		}
		int max=0;
		for(int i=0;i<v.size();i++){
			if(a.get(v.get(i))>max){
				max=a.get(v.get(i));
			}
		}
		int occ=max;
		
		
		while(occ>0){
			Vector<E> nuovo=new Vector<E>();
			for(int i=0;i<v.size();i++){
				if(a.get(v.get(i))==occ){
					nuovo.add(v.get(i));
				}
			}
			Collections.sort(nuovo);
			for(int i=0;i<nuovo.size();i++){
				ultima.add(nuovo.get(i));
			}
			occ--;
		}
		index=-1;
		
		
	}
	public boolean hasNext() {
		return index<ultima.size()-1;
	}
	// EFFECTS: se index < ultima.size()-1 restituisce true
	// 			else restituisce false
	
	public E next() {
		index++;
		return ultima.get(index);
	}
	// EFFECTS: restituisce ultima.get(index)

	public void remove() {
		throw new UnsupportedOperationException("remove");
	}
	// EFFECTS: operazione remove non consentita 
	//          restituisce eccezzione UnsupportedOperationException("remove")
	//			(unchecked)
}