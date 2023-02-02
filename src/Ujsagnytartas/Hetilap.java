package Ujsagnytartas;

public class Hetilap extends Ujsag {
	
	private byte megjelenesNapja;

	public Hetilap(String megnevezes, String kiado, int ar, byte megjelenesNapja) {
		super(megnevezes, kiado, ar);
		setMegjelenesNapja(megjelenesNapja);
	}

	public byte getMegjelenesNapja() {
		return megjelenesNapja;
	}
	
	public String toString() {
		return "A hetilap neve: " + getMegnevezes() + ", kiadó neve: " + getKiado() + ", a hetilap ára: " + getAr() + ", megjelenés napja: " + megjelenesNapja;
	}

	public void setMegjelenesNapja(byte megjelenesNapja) {
		if (megjelenesNapja >= 1 && megjelenesNapja <= 7) {
			this.megjelenesNapja = megjelenesNapja;
		}
		else {
			throw new IllegalArgumentException("1 és 7 közötti számot írhat be!");
		}
		
	}

	
}
