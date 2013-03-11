package ElaboraDistinta.Operation;

import ElaboraDistinta.Model.DocumentoOttimizzazione;

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
		for (int i = 0; i < this.ddo.getItems().size(); ++i) {
			s = s + this.ddo.getItems().get(i).getOItem().toString() + "\n";
		}
		return s;

	}
	
}
