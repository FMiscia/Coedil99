package coedil99.operation;

import coedil99.model.IModelComponent;
import coedil99.model.Item;

public class OItem implements IOperation{

public Item item;
	
	public OItem(Item i){
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
	public IModelComponent getModel() {
		return this.item;
	}

	@Override
	public void setModel(IModelComponent m) {
		// TODO Auto-generated method stub
		
	}

}