package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.Geometria;
import coedil99.persistentmodel.GeometriaFactory;
import coedil99.persistentmodel.IPersistentModel;

public class MGeometria implements IModel{

	private Geometria geometria;
	
	/**
	 * Costruttore senza parametri
	 * 
	 */
	public MGeometria(){
		this.geometria = GeometriaFactory.createGeometria();
	}
	
	/**
	 * Costruttore con parametro ID
	 * @param ID
	 */
	public MGeometria(int ID){
		try {
			this.geometria = GeometriaFactory.getGeometriaByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return this.geometria.getBase()+" x "+this.geometria.getLunghezza()+" x "+this.geometria.getAltezza();
	}

	public Geometria getPersistentModel() {
		return this.geometria;
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.geometria = (Geometria) m;
	}

	@Override
	public void save() {
		try {
			this.geometria.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(){
		try {
			this.geometria.delete();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
