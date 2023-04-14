package it.edu.iisvolta;

import java.util.Scanner;

public class MainSwitch {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);		
		Switch s1= new Switch();
		String scelta;
		
		s1.accendi();
		do {
			System.out.println("Digitare indirizzo MAC del destinatario: ");
			String MacDest=s.next();
			System.out.println("Digitare la porta da cui inviare il messaggio: ");
			int p = s.nextInt();
			System.out.println("Digitare indirizzo MAC di partenza: ");
			String MacSrc = s.next();
			System.out.println("Digitare il messaggio: ");
			String Msn = s.next();
			s1.invia(p, MacSrc, MacDest,Msn);
			System.out.println("Digitare la porta da cui ricevere il messaggio: ");
			int r = s.nextInt();
			System.out.println("Digitare indirizzo MAC del destinatario: ");
			String MacDest1= s.next();
			s1.ricevi(r, MacDest1);
			//s1.StatoSwitch();
			System.out.println("Desideri ancora utilizzare lo Switch?");
			scelta = s.next();
		}while (scelta.equals("si"));
		
	}

}
