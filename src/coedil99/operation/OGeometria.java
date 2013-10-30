package coedil99.operation;

import coedil99.model.Geometria;
import coedil99.model.IModelComponent;

public class OGeometria implements IOperation{

	private Geometria geometria;
	
	public OGeometria(Geometria g){
		this.geometria = g;
	}
	
	public String toString(){
		return this.geometria.getBase()+" x "+this.geometria.getLunghezza()+" x "+this.geometria.getAltezza();
	}

	@Override
	public IModelComponent getModel() {
		return this.geometria;
	}

	@Override
	public void setModel(IModelComponent m) {
		// TODO Auto-generated method stub
		
	}
}
