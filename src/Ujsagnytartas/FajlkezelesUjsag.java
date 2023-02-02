package Ujsagnytartas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FajlkezelesUjsag {
	
	public Ujsag[] probaBeolvasas (String fajlnev, String elvalaszto) throws IOException {
	
		Ujsag[] ujsagok = new Ujsag[tombokSorokSzama(fajlnev)];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));
		
		for (int i = 0; i < ujsagok.length; i++) {
			
			String[] sor = br.readLine().split(elvalaszto);
			
			if (sor[0].equals("Ujsag")) {
				
				Ujsag ujsagObj = new Ujsag(sor[1], sor[2], Integer.parseInt(sor[3]));
				
				ujsagok[i] = ujsagObj;
			}
			
			else if (sor[0].equals("Napilap")) {
				
				Napilap napilapObj = new Napilap(sor[1], sor[2], Integer.parseInt(sor[3]), Byte.parseByte(sor[4]));
				
				ujsagok[i] = napilapObj;
			}
			
			else {
				Hetilap hetilapObj = new Hetilap(sor[1], sor[2], Integer.parseInt(sor[3]), Byte.parseByte(sor[4]));
				
				ujsagok[i] = hetilapObj;
			}
			
		}
		
		br.close();
		
		return ujsagok;
	}
	
	private int tombokSorokSzama(String fajlnev) throws IOException {

		Path utvonal = Paths.get(fajlnev);
		long sorokszama = Files.lines(utvonal).count();

		return (int) sorokszama;
		
	}
	
}


/*
 Ujsag[] ujsagok = new Ujsag[7];
		
		Scanner sc = new Scanner(new File(fajlnev));
		
		sc.useDelimiter("-");//setting comma as delimiter pattern
		
		while (sc.hasNext()) {
		      System.out.print(sc.next() + ", ");
		    }
		sc.close();
		
		return ujsagok;
		
*/
	
