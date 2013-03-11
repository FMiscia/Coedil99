package ElaboraDistinta.Model;

import java.util.ArrayList;

import ElaboraDistinta.StandardOttimizzatoreStrategy;
import ElaboraDistinta.Controller.OttimizzatoreHandler;
import ElaboraDistinta.Operation.ODocumentoOttimizzazione;
import ElaboraDistinta.Operation.ORigheLavoro;

public class Distinta {

	private static int count;
	private int id;
	private RigheLavoro lavori = new RigheLavoro();
	private DocumentoOttimizzazione ddo = null;

	public Distinta(){
		/*startup*/
		this.count++;
		this.id = count;
	}
	
	public int getId() {
		return id;
	}
	
	public RigheLavoro getLavori(){
		return this.lavori;
	}

	public ArrayList<RigaLavoro> getRigheLavoro(){
		return this.lavori.getRigheLavoro();
	}

	public DocumentoOttimizzazione getDdo() {	
		return (this.ddo==null?null:ddo);
	}

	public void setDdo(DocumentoOttimizzazione ddo) {
		this.ddo = ddo;
	}
	
	public ORigheLavoro getORigheLavoro(){
		return new ORigheLavoro(this.lavori);
	}
	
	public ODocumentoOttimizzazione getOddo(){
		return new ODocumentoOttimizzazione(this.ddo);
	}


}