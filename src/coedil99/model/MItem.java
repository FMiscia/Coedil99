package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.IPersistentModel;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemFactory;

public class MItem implements IModel{

public Item item;

	public MItem(){
		this.item = new ItemFactory().createItem();
	}
	
	public MItem(int ID){
		try {
			this.item = ItemFactory.getItemByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		String i = "";
		i = i + "Descrizione: " + this.item.getDescrizione() + " Prezzo: "
				+ this.item.getPrezzo() + " Altezza: "
				+ this.item.getGeometria().getAltezza() + " Base: "
				+ this.item.getGeometria().getBase() + " Lunghezza: "
				+ this.item.getGeometria().getLunghezza() +"\n";
		return i;
	}
	
	public float getAltezza(){
		return this.item.getGeometria().getAltezza();
	}

	public float getBase(){
		return this.item.getGeometria().getBase();
	}
	
	public float getLunghezza(){
		return this.item.getGeometria().getLunghezza();
	}

	public Item getPersistentModel() {
		return this.item;
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.item = (Item) m;
	}

	@Override
	public void save() {
		try {
			this.item.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(){
		try {
			this.item.delete();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}