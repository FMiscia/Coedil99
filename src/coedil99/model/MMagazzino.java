package coedil99.model;

import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.Item;
import coedil99.persistentModel.Magazzino;

public class MMagazzino implements IModel{

private Magazzino magazzino;
	
	public MMagazzino(Magazzino m){
		this.magazzino = m;
	}
	
	public void addItem(Item item){
		Integer oldValue = this.magazzino.getItems().get(item);
		this.magazzino.getItems().put(item, ++oldValue);
	}
	
	public void removeItem(Item item){
		if(this.magazzino.getItems().containsKey(item) && this.magazzino.getItems().get(item) > 0)
			this.magazzino.getItems().put(item, this.magazzino.getItems().get(item)-1);
	}

	@Override
	public IPersistentModel getModel() {
		return this.magazzino;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}
}