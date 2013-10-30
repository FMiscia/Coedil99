package coedil99.operation;

import coedil99.model.DocumentoOttimizzazione;
import coedil99.model.IModelComponent;

public class ODocumentoOttimizzazione implements IOperation{

private DocumentoOttimizzazione ddo;
	
	public ODocumentoOttimizzazione(DocumentoOttimizzazione d){
		this.ddo = d;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.ddo.items.size(); ++i) {
			OItem oitem = new OItem(this.ddo.items.get(i));
			s = s + oitem.toString() + "\n";
		}
		return s;

	}
	
	public String stampaDDO(){
		String s = "";
		for(int i=0; i<this.ddo.items.size(); ++i){
			OItem oi = new OItem(this.ddo.items.get(i));
			s = s + oi.toString();
		}
		return s;
	}

	@Override
	public IModelComponent getModel() {
		return this.ddo;
	}

	@Override
	public void setModel(IModelComponent m) {
		// TODO Auto-generated method stub
		
	}

}