package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.IPersistentModel;
import coedil99.persistentmodel.ProductDescription;
import coedil99.persistentmodel.ProductDescriptionFactory;

public class MProductDescription implements IModel {

	ProductDescription productdescription;
	
	/**
	 * Costruttore
	 */
	public MProductDescription(){
		this.productdescription = ProductDescriptionFactory.createProductDescription();
	}
	
	/**
	 * Costruttore
	 * @param ID
	 */
	public MProductDescription(int ID){
		try {
			this.productdescription = ProductDescriptionFactory.loadProductDescriptionByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.productdescription = (ProductDescription)m;

	}
	
	public ProductDescription getPersistentModel(){
		return this.productdescription;
	}

	@Override
	public void save() {
		try {
			this.productdescription.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		MGeometria geometria = new MGeometria(this.productdescription.getGeometria().getID());
		try {
			this.productdescription.deleteAndDissociate();
			geometria.delete();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

}
