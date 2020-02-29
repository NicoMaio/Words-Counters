import java.io.*;
import java.util.*;
public class Application{
	public static void main(String[] args)throws IOException {
		
		System.out.println("Scegliere quale struttura dati utilizzare");
		int v;
		System.out.println("-0 Hashtable");
		System.out.println("-1 Treemap");
		Scanner si = new Scanner(System.in);
		System.out.println("Inserire 0 oppure 1 per selezionare struttura dati desiderata");
		v=si.nextInt();
		DataCounter<String,Integer> conta;
		if(v== 0 ){
			conta = new HashDataCounter<String,Integer>();
		}else{
			conta = new TreeDataCounter<String,Integer>();
		}

		//HashDataCounter<String> conta= new HashDataCounter<String>();
		int wordscount=0;
		// variabile conta parole
		
		int charactercount=0;
		// variabile conta caratteri esclusi spazi
		
		int charactercount2=0;
		// variabile conta caratteri inclusi spazi


		
		// aquisisco in input il file di cui analizzo il testo
		FileReader f;
		f=new FileReader("prova1.txt");
		Scanner sc = new Scanner(f);


		String temp;
		String prima[];
		
		while(sc.hasNextLine()) {
			temp=sc.nextLine();

			prima=temp.split(" ");
			// separa tutte le stringhe ogni qualvolta incontra " "
			
			Utils.conta(prima);
			// conta i caratteri di ogni stringa di prima
			
			charactercount=charactercount+Utils.getChar();
			charactercount2=charactercount2+Utils.getChar2();
			// aggiorna i conteggi dei caratteri inclusi spazi
			// ed esclusi spazi
			
			temp=temp.replaceAll("'"," ");
			temp=temp.replaceAll("<"," ");
			// rimpiazza tutti gli apostrofi e simboli minori con " "
			temp=temp.replaceAll("[\\p{Punct}]","");
			// rimpiazza tutta la punteggiatura restante con ""
			
			prima=temp.split(" ");
			// separa tutte le stringhe ogni qualvolta incontra " "
			for(int i=0;i<prima.length;i++){
				prima[i]=prima[i].toLowerCase();
				// trasformo ogni lettera maiuscola in minuscola

				conta.put(prima[i]);
				// inserisco stringa in HashDataCounter<String,Integer>

			}
			wordscount+=prima.length;
			// continuo conteggio parole
			
			
		}
		
		charactercount2--;
		// decremento conteggio caratteri con spazi per eliminare
		// il conteggio dello spazio finale
		
		System.out.println("Number of characters (including spaces) "+charactercount2);
		System.out.println("Number of characters (without spaces) "+charactercount);
		System.out.println("Number of words "+wordscount);
		// stampo le variabili interessate


		int c=0;
		Iterator<String> itr = conta.getIterator();
		
		// ciclo che scorre iteratore per stampare tabella
		System.out.format("%-6s%3s%-30s%3s%-10s","Indice"," - ","Parola"," - ","Occorrenza");
		System.out.println();
		while(itr.hasNext()!=false){
			c++;
			String curr=itr.next();
			System.out.format("%-6s%3s%-30s%3s%-10s",c," - ",curr," - ",conta.getCount(curr));
			System.out.println();
			
		}
		
	}
}	