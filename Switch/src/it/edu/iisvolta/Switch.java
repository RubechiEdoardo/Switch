package it.edu.iisvolta;

public class Switch {
	
	private String [] porte = new String [5];
	private String [] messaggi = new String [5];
	private int stato;
	
	
	public Switch () { 											// Costruttore
		for(int i=0; i<5; i++) {
		this.porte[i] =  "";
		this.messaggi[i] = "";
		}
		this.stato = 0;
	}
	
	public void accendi () { 									// Accendi
		if (stato == 0)
			stato = 1;
		else
			System.out.println("Switch già acceso");
	}
	
	public void spegni () { 									//Spegni
		if (stato == 1)
			stato = 0;
		else
			System.out.println("Switch già spento");
	}
	
	public int getStato() {										// Stato
		return stato;
	}
	
	/*public String getMacAddress() {
		return porte;
		}*/
	
	
	public void invia (int porta, String MacAddressSrc, String MacAddressDest, String messaggio) {	
		if(stato == 1) {
			for (int i = 0; i<5; i++) {
				if (porte[porta] == "") {
					porte[porta]= MacAddressSrc;
					System.out.println(porte[porta]);
					break;
				}else if(porte[porta]!= "") {
					System.out.println("Porta non valida.");
				}else {
					for (int l=0; l<5; l++) {
						if (porte[l] == MacAddressDest) {
							messaggi[l]= messaggio;
							System.out.println(messaggi[l]);
						}else 
							for(int g=0; g<5;g++) {
								porte[g]= messaggio;
								if(porte[g]== MacAddressSrc) {
									
								}
							}
						}//chiude il secondo ciclo
				}			
			}// chiude il primo ciclo
		}else
			System.out.println("Lo switch è spento.");
	}//chiude il metodo
	
	public void ricevi (int porta, String MacAddress) {
		for (int i=0; i<5;i++) {
			if (porte[porta]== MacAddress) {
				System.out.println(messaggi[porta]);
				messaggi[porta]= "";
			}else if(porte[porta]== "") {
				porte[porta] = MacAddress;
			}else
				System.out.println("Indirizzo non valido!");				
		}
	}
	public static void StatoSwitch () {
			
	}
}

