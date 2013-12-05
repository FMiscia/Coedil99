package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import GUI.Abstract.APlico;
import GUI.Liste.ListaProdotti;
import GUI.Liste.ListaProdottiFactory;
import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.MProductDescription;

/**
 * Gestisce il pannello dei fornitori
 * 
 * @author Simone
 *
 */
@SuppressWarnings("serial")
public class PlicoFornitore extends APlico {

	private static PlicoFornitore instance = null;
	private ListaProdotti listaProdotti;
	
	/**
	 * Costruttore
	 */
	private PlicoFornitore(){
		this.setLayout(new BorderLayout());
		this.addListaProdotti();
	}
	


	/**
	 * Singleton
	 * @return instance:PlicoRDA
	 */
	public static PlicoFornitore getInstance() {
		if (PlicoFornitore.instance == null)
			PlicoFornitore.instance = new PlicoFornitore();
		return PlicoFornitore.instance;
	}
	
	
	@Override
	public void load() {
	}

	@Override
	public void load(int id) {
	}

	@Override
	public boolean isModifying() {
		return false;
	}
	
	/**
	 * Metodo che aggiunge la lista dei prodotti nel plico fornitore
	 */
	public void addListaProdotti(){
		if(this.listaProdotti != null){
			this.remove(listaProdotti);
		}
		this.listaProdotti = (ListaProdotti) ListaProdottiFactory.getInstance().makeLista();
		this.add(listaProdotti,BorderLayout.WEST);
	}
	
	/**
	 * Metodo che carica il contenuto della lista dei prodotti a partire dal nome del catalogo fornitore
	 * 
	 * @param catalogo: String
	 */
	public void loadListaProdotti(String catalogo){
		this.listaProdotti.svuota();
		ArrayList<MProductDescription> prodotti = GestisciFornitoreHandler.getInstance().getMProductDescriptions(catalogo);
		this.listaProdotti.load(prodotti);
	}
	
	/**
	 * Metodo che prepara la grafica per l'inserimento di un nuovo catalogo fornitore
	 */
	public void newCatalogo(){
		this.addListaProdotti();
		this.validate();
		this.repaint();
	}
	
	/**
	 * Getter
	 * @return ListaProdottti
	 */
	public ListaProdotti getListaProdotti(){
		return this.listaProdotti;
	}
	
	/**
	 * Metodo che ritorna un booleano sullo stato di importing del catalogo
	 * @return boolean
	 */
	public boolean isImporting(){
		return this.listaProdotti.isImporting();
	}
	
	/**
	 * Metodo che annulla import di un nuovo catalogo fornitore
	 */
	public void abortImporting(){
		this.listaProdotti.abortImporting();
	}
}
