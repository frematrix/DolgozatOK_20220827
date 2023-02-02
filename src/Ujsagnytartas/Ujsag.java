package Ujsagnytartas;

public class Ujsag {
	
	private String megnevezes;
	private String kiado;
	private int ar;
	
	public Ujsag(String megnevezes, String kiado, int ar) {
		setMegnevezes(megnevezes);
		setKiado(kiado);
		setAr(ar);
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		if (!megnevezes.isEmpty() || (megnevezes!=null)) {
			this.megnevezes = megnevezes;
		}
	}
		
	public String getKiado() {
		return kiado;
	}

	public void setKiado(String kiado) {
		if (!kiado.isEmpty() || (kiado!=null)) {
			this.kiado = kiado;
		}
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		if (ar >= 0) {
			this.ar = ar;
		}
	}
	
	public String toString() {
		return "Az általános újság neve: " + getMegnevezes() + ", kiadó neve: " + getKiado() + ", az újság ára: " + getAr();
	}

	//public double afaTartalomSzamit(int ar) {
	public double afaTartalomSzamit() {
		//nem hiba, csak jelzem, hogy egyik metódusnál sincs szükség paraméterben átadni az árat, hiszen az az objektum adattagjaként elérhető
		
		double afa = ar*(double)5/100;
		return afa;
	
	}

}
