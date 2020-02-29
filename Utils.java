public class Utils{
	private static int character;
	private static int character2;
	
	// metodo costruttore
	public Utils(){
		character=0;
		character2=0;
	}
	
	public static void conta(String prima[])throws NullPointerException{
		if(prima== null)throw new NullPointerException();
		for(int i=0;i<prima.length;i++){
			character=character+prima[i].length();
			character2=character2+prima[i].length()+1;
		}
	}
	//	REQUIRES: prima!=null
	//	THROWS: se prima == null lancia NullPointerException (unchecked)
	//	EFFECTS: somma a character tutti i caratteri di ogni stringa prima[i]
	//			 con 0<=i<prima.length esclusi gli spazi e a character2 tutti
	//			 i caratteri inclusi gli spazi

	public static int getChar(){
		return character;
	}
	//	EFFECTS: restituisce character
	public static int getChar2(){
		return character2;
	}
	//	EFFECTS: restituisce character2
}