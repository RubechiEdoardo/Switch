package it.edu.iisvolta;

public class SolSwitch {
	private String[] porte= new String [5];
	private String[] messaggi= new String [5];
	private int stato;
	
	public SolSwitch () {
		for (int i=0; i<5;i++) {
			porte[i]= "";
			messaggi[i]="";
		}
		stato=0;
	}
	
	public void accendi() {
		if(stato ==0) 
			stato=1;
		else
			System.out.println("Switch già acceso.");			
	}
	
	public void spegni() {
		if(stato ==1) 
			stato=0;
		else
			System.out.println("Switch già spento.");			
	}
	
	public void invia (
			int porta, String MacAddressSrc, String MacAddressDes, String messaggio) {
		if(stato==0) {
			System.out.println("Lo switch è spento");
		}else if(porta<0 || porta>4) {
			System.out.println("Porta non valida");
		}else {
			if(!porte[porta].isEmpty() &&  				// non è vuota
			   !porte[porta].equals(MacAddressSrc)) 	// sulla porta c'è un mac address diverso da quello della sorgente
				System.out.println("Mac address sorgente non valido!");
		else if(porte[porta].isEmpty())  				// Se la stringa è vuota
				porte[porta]= MacAddressSrc;            //memorizzo mac address della sorgente			
		// cerco nel vettore delle porte il Mac Dest.
		int pos=-1;
		for(int i=0;i<5;i++)
			if(porte[i].equals(MacAddressDes))
				pos=i;  							   //memorizzo la posizione dove ho trovato il mac address
			
			if(pos<0) { 							   //Mac Dest. non presente
				for(int i=0; i<5;i++) {                //Mando il messaggio su tutte le porte tranne quella di ingresso
					if(i!=porta)
						messaggi[i]=messaggio;
				}
			}else {									   //Mac Dest. presente
				messaggi[pos]= messaggio;		       //Mando il messaggio sulla porta dove ho trovato il Mac Address Dest.
			}
		}	
	}
	public String getStato() {
		if (stato==0)
			return "SPENTO";
		else
			return "ACCESO";
	}
	
	public String getMacAddress(int porta) {
		return porte[porta];
	}
	public String getMessage(int messaggio) {
		return messaggi[messaggio];
	}
}
