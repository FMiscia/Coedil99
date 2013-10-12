package coedil99.operation;

import coedil99.model.Geometria;

public class OGeometria {

	private Geometria geometria;
	
	public OGeometria(Geometria g){
		this.geometria = g;
	}
	
	public Geometria getGeometria(){
		return this.geometria;
	}
	
	public String toString(){
		return this.geometria.getBase()+" x "+this.geometria.getLunghezza()+" x "+this.geometria.getAltezza();
	}
}
