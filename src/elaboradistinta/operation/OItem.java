package elaboradistinta.operation;

import elaboradistinta.model.Item;

public class OItem {

	public Item item;
	
	public OItem(Item i){
		this.item = i;
	}
	
	public Item getItem(){
		return this.item;
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
}
