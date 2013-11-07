package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.IPersistentModel;
import coedil99.persistentmodel.RDA;
import coedil99.persistentmodel.RDAFactory;


public class MRDA extends coedil99.model.Subject implements IModel{
	
	private RDA rda;

	/**
	 * Costruttore senza parametro
	 * 
	 */
	public MRDA() {
		this.rda = RDAFactory.createRDA();
		this.Attach(MMagazzino.getInstance());
	}

	/**
	 * Costruttore
	 * @param ID
	 * 
	 */
	public MRDA(int ID) {
		try {
			this.rda = RDAFactory
					.getRDAByORMID(ID);
			this.Attach(MMagazzino.getInstance());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

		
	public void setState(String value) {
		this.getPersistentModel().setState(value);
		this.Notify();
	}

	
	@Override
	public void setPersistentModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		this.rda = (RDA) m;
	}
	
	public RDA getPersistentModel(){
		return this.rda;
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			this.rda.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		try {
			this.rda.deleteAndDissociate();
			this.rda=null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Attach(Observer obj) {
		// TODO Auto-generated method stub
		this.observers.add(obj);
	}

	@Override
	public void Detach(Observer obj) {
		// TODO Auto-generated method stub
		this.observers.remove(obj);
		
	}

	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		for(Observer temp : this.observers){
			temp.Update();
		}
		/*
		 * Risolvere problema GestisciRDAHandler observer
		 */
		//GestisciRDAHandler.getInstance().Update();
	}
	
	public void setDescrizione(String s){
		this.rda.setDescrizione(s);
	}


}