package coedil99.operation;

import coedil99.model.IModelComponent;
import coedil99.model.Item;
import coedil99.model.Magazzino;

public class OMagazzino implements IOperation{

private Magazzino magazzino;
	
	public OMagazzino(Magazzino m){
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
	public IModelComponent getModel() {
		return this.magazzino;
	}
}