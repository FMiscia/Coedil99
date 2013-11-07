package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import GUI.ClipPanels.ClipPanelFornitori;
import GUI.ClipPanels.ClipPanelFornitoriFactory;
import GUI.Liste.ListaFornitori;
import GUI.Plichi.PlicoFornitore;
import coedil99.model.MCatalogoFornitore;
import javax.swing.JSplitPane;

public class FornitoriCenter extends JPanel{
	
	private static FornitoriCenter instance = null;
	private ListaFornitori lista = null;
	private MCatalogoFornitore fornitoreSelezionato = null;
	private ClipPanelFornitori clipPanel = (ClipPanelFornitori) ClipPanelFornitoriFactory
			.getInstance().makeClipPanel();
	
	/**
	 * Costruttore
	 */
	public FornitoriCenter() {
		this.initialize();
	}

	/**
	 * Inizializza le componenti grafiche
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(clipPanel, BorderLayout.NORTH);
		this.add(PlicoFornitore.getInstance(), BorderLayout.CENTER);
	}

	/**
	 * Metodo che fa caricare la lista dei prodotti in base al catalogo fornitore selezionato
	 */
	public void loadListaProdotti(){
		PlicoFornitore.getInstance().loadListaProdotti(this.getFornitoreSelezionato().getPersistentModel().getName());
	}

	/**
	 * Singleton
	 * 
	 * @return FornitoriCenter
	 */
	public static FornitoriCenter getInstance() {
		if (FornitoriCenter.instance == null)
			FornitoriCenter.instance = new FornitoriCenter();
		return FornitoriCenter.instance;
	}
	
	/**
	 * Getter fornitoreSelezionato
	 * @return
	 */
	public MCatalogoFornitore getFornitoreSelezionato() {
		return fornitoreSelezionato;
	}

	/**
	 * Setter fornitoreSelezionato
	 * @param fornitoreSelezionato
	 */
	public void setFornitoreSelezionato(MCatalogoFornitore fornitoreSelezionato) {
		this.fornitoreSelezionato = fornitoreSelezionato;
	}
	
	/**
	 * Setter lista dei fornitori
	 * @param r: la listaFornitori da impostare
	 */
	public void setLista(ListaFornitori f) {
		if(this.lista != null){
			this.remove(this.lista);}
		this.validate();
		this.repaint();
		this.lista = f;
		this.add(this.lista, BorderLayout.WEST);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Aggiorna lo stato della lista dei fornitori
	 */
	public void refreshFornitori(){
		this.lista.svuota();
		this.lista.load();
		this.lista.deselectAll();
	}

	/**
	 * 
	 * @return true se FornitoriCenter è instanziato, false altrimenti
	 */
	public static boolean isInstanciated() {
		return instance == null;
	}

	/**
	 * Getter 
	 * @return clipPanel
	 */
	public ClipPanelFornitori getClipPanel() {
		return clipPanel;
	}

	/**
	 * Setter
	 * @param clipPanel
	 */
	public void setClipPanel(ClipPanelFornitori clipPanel) {
		this.clipPanel = clipPanel;
	}
	
	/**
	 * Metodo che setta come catalogo fornitore il primo elemento della lista
	 */
	public void setPrimoCatalogoFornitore(){
		this.setFornitoreSelezionato(new MCatalogoFornitore(this.lista.getPrimoCatalogo()));
	}
	
	/**
	 * Metodo che seleziona il primo catalogo fornitore
	 */
	public void selectPrimoCatalogo(){
		this.lista.setPrimoCatalogo();
		this.setPrimoCatalogoFornitore();
		this.loadListaProdotti();
	}
	
	/**
	 * Metodo che prepara la schermata per l'inserimento di un nuovo catalogo fornitore
	 */
	public void newCatalogo(){
		this.lista.svuota();
		PlicoFornitore.getInstance().newCatalogo();
		
		
		
	}
	
}
