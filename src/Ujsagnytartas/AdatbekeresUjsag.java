package Ujsagnytartas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class AdatbekeresUjsag {
	
	public Ujsag adatbekeres () throws IOException {
		
		String megnevezes;
		char tipus;
		String kiado;
		int ar;
		byte hetiMegjelenesSzama;
		byte megjelenesNapja;
		
		Ujsag ujUjsag = null;
		
		boolean adatokRendben = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			System.out.println("K�rem az �j adatokat: ");
			
			try {
				
				System.out.println("K�rem az �js�g nev�t:");
				megnevezes = br.readLine();
				
				
				System.out.println("K�rem a kiad� nev�t:");
				kiado = br.readLine();
				
				
				System.out.println("K�rem az �js�g �r�t:");
				ar = Integer.parseInt(br.readLine());
				
				
				do {
					System.out.println("K�rem az �js�g t�pus�t (U/N/H):");
					tipus = br.readLine().charAt(0);
				} while (Character.toUpperCase(tipus) != 'U' && Character.toUpperCase(tipus) != 'N' && Character.toUpperCase(tipus) != 'H');
				
				
				if (Character.toUpperCase(tipus) == 'U') {
					
					ujUjsag = new Ujsag(megnevezes, kiado, ar);
				}
				
				else if (Character.toUpperCase(tipus)  == 'N') {
					System.out.println("K�rem a napilap egy h�ten bel�li megjelen�seinek sz�m�t:");
					hetiMegjelenesSzama = Byte.parseByte(br.readLine());
					ujUjsag = new Napilap(megnevezes, kiado, ar, hetiMegjelenesSzama);
				}
				
				else if (Character.toUpperCase(tipus)  =='H') {
					System.out.println("K�rem a hetilap megjelen�si napj�t sz�mk�nt (1-7):");
					megjelenesNapja = Byte.parseByte(br.readLine());
					ujUjsag = new Hetilap(megnevezes, kiado, ar, megjelenesNapja);
					
				}
				
				adatokRendben = true;
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IllegalArgumentException e) {
					
					System.err.println(e.getMessage());//amit setteren kereszt�l be�rtunk figyelmeztet� �zenetet...
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while (!adatokRendben);
		
		br.close();
		
		return ujUjsag;
	}
	
	public void fajlbaIratas (String fajlnev, String elvalaszto, Ujsag ujUjsag) throws IOException {
		
		 OutputStreamWriter kiir = new OutputStreamWriter(new FileOutputStream (fajlnev, true), "UTF-8");
		
		 String kiiras = ujUjsag.getMegnevezes() + elvalaszto + ujUjsag.getKiado() + elvalaszto + ujUjsag.getAr();
		 
		 if (ujUjsag instanceof Ujsag) {
			 
			 kiiras = "Ujsag" + elvalaszto + kiiras + "\n"; 
		 }
		 
		 else if (ujUjsag instanceof Napilap) {
			 
			 kiiras = "Napilap" + elvalaszto + kiiras + elvalaszto + ((Napilap) ujUjsag).getHetiMegjelenesSzama() + "\n";
		 }
		 
		 else if (ujUjsag instanceof Hetilap) {
			 
			 kiiras = "Hetilap" + elvalaszto + kiiras + elvalaszto + ((Hetilap) ujUjsag).getMegjelenesNapja() + "\n";
		 }
		 
		 kiir.write(kiiras);
		 
		 kiir.close();

	}

}
