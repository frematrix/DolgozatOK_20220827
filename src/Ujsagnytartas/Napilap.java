package Ujsagnytartas;

public class Napilap extends Ujsag {
	
	private byte hetiMegjelenesSzama;

	public Napilap(String megnevezes, String kiado, int ar, byte hetiMegjelenesSzama) {
		super(megnevezes, kiado, ar);
		setHetiMegjelenesSzama(hetiMegjelenesSzama);
	}

	public byte getHetiMegjelenesSzama() {
		return hetiMegjelenesSzama;
	}

	public void setHetiMegjelenesSzama(byte hetiMegjelenesSzama) {
		if (hetiMegjelenesSzama >= 4) {
			this.hetiMegjelenesSzama = hetiMegjelenesSzama;
		}
		
		else {
			throw new IllegalArgumentException("A heti megjelenések száma legalább 4 nap!");
		}
	}
	
	public String toString() {
		return "A napilap neve: " + getMegnevezes() + ", kiadó neve: " + getKiado() + ", a napilap ára: " + getAr() + " Ft, a heti megjelenés száma: " + hetiMegjelenesSzama;
	}

	//public final int hetiArkalkulacio(int ar) {
	public int hetiArkalkulacio() {
		//return ar*7; -- ez volt a beadott dolgozatban
		//return ar*hetiMegjelenesSzama;
		return getAr() *hetiMegjelenesSzama;
	}
	
	

}
