package coedil99.operation;

import org.orm.PersistentException;

import coedil99.model.RigaLavoro;

public class ORigaLavoro {

	private RigaLavoro rigalavoro = null;
	
	private boolean isSaved = false;

	public ORigaLavoro(RigaLavoro r) {
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
}
