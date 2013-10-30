package coedil99.model;

import coedil99.persistentModel.DocumentoOttimizzazione;
import coedil99.persistentModel.IPersistentModel;

public class MDocumentoOttimizzazione implements IModel{

private DocumentoOttimizzazione ddo;
	
	public MDocumentoOttimizzazione(DocumentoOttimizzazione d){
		this.ddo = d;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.ddo.items.size(); ++i) {
			MItem oitem = new MItem(this.ddo.items.get(i));
			s = s + oitem.toString() + "\n";
		}
		return s;

	}
	
	public String stampaDDO(){
		String s = "";
		for(int i=0; i<this.ddo.items.size(); ++i){
			MItem oi = new MItem(this.ddo.items.get(i));
			s = s + oi.toString();
		}
		return s;
	}

	@Override
	public IPersistentModel getModel() {
		return this.ddo;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}

}