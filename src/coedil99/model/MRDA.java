package coedil99.model;

import org.orm.PersistentException;

import coedil99.controller.GestisciRDAHandler;
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
		//this.Attach(GestisciRDAHandler.getInstance());
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
			this.Notify();
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
			this.Notify();
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
		for(Observer temp : this.observers){
			temp.Update();
		}
	}
	
	public void setDescrizione(String s){
		this.rda.setDescrizione(s);
	}

	public String getDescrizione() {
		// TODO Auto-generated method stub
		return this.rda.getDescrizione();
	}

	public float getPrezzoTotale() {
		float prezzo_totale = 0;
		for (int i = 0; i < this.getPersistentModel().righeRDA.size(); ++i) {
			prezzo_totale += (this.getPersistentModel().righeRDA.get(i).getQuantity() 
					* this.getPersistentModel().righeRDA
					.get(i).getDescription().getPrezzo());
		}
		return prezzo_totale;
	}

	public int getQuantitaTotale() {
		int quantita_totale = 0;
		for (int i = 0; i < this.getPersistentModel().righeRDA.size(); ++i) {
			quantita_totale += this.getPersistentModel().righeRDA.get(i).getQuantity();
		}
		return quantita_totale;
	}


}