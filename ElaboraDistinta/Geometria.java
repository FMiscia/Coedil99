package ElaboraDistinta;

public class Geometria {

	private float base;
	private float altezza;
	private float lunghezza;

	public Geometria(float b, float a, float l){
		this.base = b;
		this.altezza = a;
		this.lunghezza = l;
	}
	
	public float getBase() {
		return this.base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getAltezza() {
		return this.altezza;
	}

	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}

	public float getLunghezza() {
		return this.lunghezza;
	}

	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}

}