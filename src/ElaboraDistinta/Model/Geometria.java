package ElaboraDistinta.Model;

public class Geometria {

	private float base;
	private float altezza;
	private float lunghezza;

	public Geometria(float b, float a, float l){
		this.base = b;
		this.altezza = a;
		this.lunghezza = l;
	}
	
	public Geometria(Object valueAt, Object valueAt2, Object valueAt3) {
		// TODO Auto-generated constructor stub
		this.base = Float.parseFloat((String) valueAt);
		this.altezza = Float.parseFloat((String) valueAt2);
		this.lunghezza = Float.parseFloat((String) valueAt3);
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