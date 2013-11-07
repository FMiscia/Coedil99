package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<ARiquadro> isModifying() {
		// TODO Auto-generated method stub
		return null;
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
	
}
