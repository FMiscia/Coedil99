package coedil99.model;

import coedil99.persistentModel.Geometria;
import coedil99.persistentModel.IPersistentModel;

public class MGeometria implements IModel{

	private Geometria geometria;
	
	public MGeometria(Geometria g){
		this.geometria = g;
	}
	
	public String toString(){
		return this.geometria.getBase()+" x "+this.geometria.getLunghezza()+" x "+this.geometria.getAltezza();
	}

	@Override
	public IPersistentModel getModel() {
		return this.geometria;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}
}
