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
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		try {
			this.productdescription.save();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		try {
			this.productdescription.deleteAndDissociate();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
