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
		return "A hetilap neve: " + getMegnevezes() + ", kiad� neve: " + getKiado() + ", a hetilap �ra: " + getAr() + ", megjelen�s napja: " + megjelenesNapja;
	}

	public void setMegjelenesNapja(byte megjelenesNapja) {
		if (megjelenesNapja >= 1 && megjelenesNapja <= 7) {
			this.megjelenesNapja = megjelenesNapja;
		}
		else {
			throw new IllegalArgumentException("1 �s 7 k�z�tti sz�mot �rhat be!");
		}
		
	}

	
}
