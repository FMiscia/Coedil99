package elaboradistinta.operation;

import elaboradistinta.model.DocumentoOttimizzazione;

public class ODocumentoOttimizzazione {
	
	private DocumentoOttimizzazione ddo;
	
	public ODocumentoOttimizzazione(DocumentoOttimizzazione d){
		this.ddo = d;
	}

	public DocumentoOttimizzazione getDdo() {
		return ddo;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.ddo.items.size(); ++i) {
			s = s + this.ddo.items.get(i).getOItem().toString() + "\n";
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
	
}
