package elaboradistinta.operation;

import elaboradistinta.model.Item;
import elaboradistinta.model.Magazzino;

public class OMagazzino {

	private Magazzino magazzino;
	
	public OMagazzino(Magazzino m){
		this.magazzino = m;
	}
	
	public Magazzino getMagazzino(){
		return this.magazzino;
	}
	
	public void addItem(Item item){
		Integer oldValue = this.magazzino.getItems().get(item);
		this.magazzino.getItems().put(item, ++oldValue);
	}
	
	public void removeItem(Item item){
		if(this.magazzino.getItems().containsKey(item) && this.magazzino.getItems().get(item) > 0)
			this.magazzino.getItems().put(item, this.magazzino.getItems().get(item)-1);
	}
	
}
