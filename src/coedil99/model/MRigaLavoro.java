package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.RigaLavoro;

public class MRigaLavoro implements IModel{

	private RigaLavoro rigalavoro = null;
	
	private boolean isSaved = false;

	public MRigaLavoro(RigaLavoro r) {
		this.rigalavoro = r;
	}
	
	public void save(){
		try {
			this.rigalavoro.save();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.isSaved=true;
	}
	
	public boolean isSaved(){
		return this.isSaved;
	}

	@Override
	public IPersistentModel getModel() {
		return this.rigalavoro;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}
}
