package it.edu.iisvolta;

import java.net.PasswordAuthentication;
import java.util.Scanner;

public class SolSwitchMain {

	public static void main(String[] args) {
		String scelta;
		Scanner s= new Scanner(System.in);
		SolSwitch sw = new SolSwitch();
		do {
			Console.clear();
			System.out.println("*** SWITCH SIMULATOR ***");
			System.out.println();
			System.out.println("1) accendi");
			System.out.println("2) spegni");
			System.out.println("3) invia");
			System.out.println("4) ricevi");
			System.out.println("9) esci");
			System.out.println();
			System.out.println("Inserisci la tua scelta: ");
			scelta= s.nextLine();
			switch(scelta) {
			case "1":
				sw.accendi();
				break;
			case "2":
				sw.spegni();
				break;
			case "3":
				int porta;
				String MacAddressSrc, MacAddressDes, messaggio;
				System.out.println("Inserisci la porta: ");
				porta = Integer.parseInt(s.nextLine());
				System.out.println("Inserisci il MAC sorgente: ");
				MacAddressSrc = s.nextLine();
				System.out.println("Inserisci il MAC destinazione: ");
				MacAddressDes = s.nextLine();
				System.out.println("Inserisci il messaggio: ");
				messaggio = s.nextLine();
				sw.invia(porta, MacAddressSrc, MacAddressDes, messaggio);
				break;
			case "4":
				break;
			case "9":
				System.out.println("Arrivederci.");
				break;
			default:
				System.out.println("Scelta non valida!");
				break;
			}		
			System.out.println();
			System.out.println("Premi enter per continuare...");
			s.nextLine();
		}while(!scelta.equals("9"));
	}	
	public static void stampaSwitch (SolSwitch sw, int posX, int posY) {
		Console.setCursorPosition(posX, posY);
		System.out.println("Stato: "+ sw.getStato());
		Console.setCursorPosition(posX+1, posY);
		System.out.println("MAC ADDRESS: ");
		for (int i=0; i<5; i++) {
			System.out.println(sw.getMacAddress(i));		
			}
	}
}
