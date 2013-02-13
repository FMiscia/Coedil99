package ElaboraDistinta;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GestisciCommessaHandler {

	private int id;
	ElaboraDistintaHandler cdistinta;
	List<Commessa> commesse;
	ListIterator<Commessa> it;
	private static GestisciCommessaHandler instance;
	
	private GestisciCommessaHandler(){
		this.commesse = new ArrayList<Commessa>();
		this.it = this.commesse.listIterator();
	}
	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void associaDistinta(Distinta distinta, int idCommessa) {
		while(this.it.hasNext()){
			if(this.it.next().getId() == idCommessa)
				this.it.previous().distinta =distinta;
		}
	}

	/**
	 * 
	 * @param idCommessa
	 * @return 
	 */
	public void eliminaDistinta(int idCommessa) {
		while(this.it.hasNext()){
			if(this.it.next().getId() == idCommessa)
				this.it.previous().distinta = null;
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return Commessa
	 */
	public Commessa getCommessaById(int id){
		
		while(this.it.hasNext()){
			if(this.it.next().getId()==id)
				return this.it.previous();
		}
		
		return null;
	}
	
	
	public int getId() {
		return id;
	}
	
	public static GestisciCommessaHandler getInstance(){
		if(GestisciCommessaHandler.instance == null){
			GestisciCommessaHandler.instance = new GestisciCommessaHandler();
		}
		
		return GestisciCommessaHandler.instance;
	}


}