package Ujsagnytartas;

import java.io.IOException;



public class FoProgramUjsag {

	public static void main(String[] args) throws IOException {
	
	//verziokovetes proba
		
		FajlkezelesUjsag beolvasasObj = new FajlkezelesUjsag();
	
		Ujsag[] ujsagok = new Ujsag[7];
		
		ujsagok = beolvasasObj.probaBeolvasas("ujsagok.csv", "-");
		
		System.out.println("Feladat IV.:");
		
		for (int i = 0; i < ujsagok.length; i++) {
			
			if (ujsagok[i] instanceof Hetilap) {
				
				System.out.println("Hetilap neve: " + ujsagok[i].getMegnevezes() + ", kiadó neve: " + ujsagok[i].getKiado() + ", hetilap ára: " + ujsagok[i].getAr() + " Ft, megjelenés napja: " + ((Hetilap) ujsagok[i]).getMegjelenesNapja() + "-dik nap.");
			}
		}
		
		System.out.println();
		System.out.println("Feladat V.:");
		
		for (int i = 0; i < ujsagok.length; i++) {
			
			if ((ujsagok[i] instanceof Napilap) && ((Napilap) ujsagok[i]).getHetiMegjelenesSzama() >= 6) {
				
				System.out.println("Napilap neve: " + ujsagok[i].getMegnevezes() + ", kiadó neve: " + ujsagok[i].getKiado() + ", napilap ára: " + ujsagok[i].getAr() + " Ft, megjelenések száma egy héten: " + ((Napilap) ujsagok[i]).getHetiMegjelenesSzama());
			}
		}
		
		System.out.println();
		System.out.println("Feladat VI.:");
		
		byte ujsagSzamlalo = 0;
		
		for (int i = 0; i < ujsagok.length; i++) {
			
			if (!(ujsagok[i] instanceof Napilap) && !(ujsagok[i] instanceof Hetilap)) {
				
				ujsagSzamlalo++;
				
			}
		}
		
		System.out.println("Az általános újságok darabszáma a nyilvántartásban: " + ujsagSzamlalo);

		System.out.println();
		System.out.println("Feladat VII.:");
		
		int maxAr = 0;
		
		for (int i = 1; i < ujsagok.length; i++) {
			
			if (ujsagok[i].getAr() > ujsagok[maxAr].getAr()) {
				
				maxAr = i;
			}
			
		}
		System.out.print("A legdrágább újság neve: " + ujsagok[maxAr].getMegnevezes());
		
		//System.out.printf(", áfatartalma %.0f ", ujsagok[maxAr].afaTartalomSzamit(ujsagok[maxAr].getAr()));
		System.out.printf(", áfatartalma %.0f ", ujsagok[maxAr].afaTartalomSzamit());
		
		System.out.print("Ft.");
		
		System.out.println("\n");
		System.out.println("Feladat VIII.:");
		
		int i = 0;
		
		while (i < ujsagok.length && !(ujsagok[i] instanceof Napilap)) {
			
			i++;
			
		//az első napilap megjelenítése (utolsó feladat) csak véletlenül ad jó eredményt, mert a feltételt a ciklus után kell megadni! Ha nem pont a 2. újság a napilap, akkor elszáll a program.
			
		}//ide kellett a ciklust lezáró zárójel
		
			if (i < ujsagok.length) {
				
				System.out.println("A nyilvántartásban előforduló első napilap neve: "+ ujsagok[i].getMegnevezes() + ", heti költsége: " + ((Napilap) ujsagok[i]).hetiArkalkulacio() + " Ft.");
			} //hetiArkalkulacio(ujsagok[i].getAr())
		
		System.out.println("\n");
		System.out.println("Feladat IX.:");//Bővítse a programot -osztályszinten ellenőrzött- adatbekérési lehetőséggel
		
		AdatbekeresUjsag ujbekeres = new AdatbekeresUjsag();
		
		Ujsag beolvasottUjsag = ujbekeres.adatbekeres();
		
		ujbekeres.fajlbaIratas("ujsagok.csv", "-", beolvasottUjsag);
	
		}

}
