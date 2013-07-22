package elaboradistinta.model;

public class Geometria {
	private int _iD;
	private float _base;
	private float _altezza;
	private float _lunghezza;

	public Geometria(float aB, float aA, float aL) {
		throw new UnsupportedOperationException();
	}

	public Geometria(Object aValueAt, Object aValueAt2, Object aValueAt3) {
		throw new UnsupportedOperationException();
	}

	public void setBase(float aBase) {
		this._base = aBase;
	}

	public float getBase() {
		return this._base;
	}

	public void setAltezza(float aAltezza) {
		this._altezza = aAltezza;
	}

	public float getAltezza() {
		return this._altezza;
	}

	public void setLunghezza(float aLunghezza) {
		this._lunghezza = aLunghezza;
	}

	public float getLunghezza() {
		return this._lunghezza;
	}
}