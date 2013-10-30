package coedil99.model;

import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.Item;

public class MItem implements IModel{

public Item item;
	
	public MItem(Item i){
		this.item = i;
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

	@Override
	public IPersistentModel getModel() {
		return this.item;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}

}