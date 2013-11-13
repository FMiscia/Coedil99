package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Abstract.ALista;
import GUI.Card.CardFornitore;
import GUI.Card.CardFornitoreFactory;
import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.MCatalogoFornitore;

@SuppressWarnings("serial")
public class ListaFornitori extends ALista {

	/**
	 * Costruttore
	 */
	public ListaFornitori() {
		super();
		this.initialize();
		this.load();
	}

	@Override
	public void load(String s) {
	}

	@Override
	/**
	 * Carica la lista
	 */
	public void load() {
		this.panel.removeAll();
		if(GestisciFornitoreHandler.isInstanciated()){
			GestisciFornitoreHandler.getInstance().reloadFornitori();
		}
		ArrayList<MCatalogoFornitore> cataloghi = GestisciFornitoreHandler.getInstance().getArrayFornitori();
		int row = cataloghi.size();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		for(int k=0; k<row; ++k){
			CardFornitore r = (CardFornitore) CardFornitoreFactory.getInstance().makeCard(
					this);
			r.load(cataloghi.get(k));
			this.panel.add(r);
			this.panel.validate();
			this.panel.repaint();
		}
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), row * (this.panel.getComponent(0).getHeight() + 6)));
		this.validate();
		this.repaint();
	}

	
	/**
	 * Fornisce l'id del primo Catalogo Fornitore
	 * 
	 * @return id:int
	 */
	public int getPrimoCatalogo() {
		this.getPrimaCard().setBackground(new Color(30, 44, 255));
		return this.getPrimaCard().getCatalogoFornitoreId();

	}
	
	/**
	 * Metodo che seleziona il primo catalogo della lista
	 */
	public void setPrimoCatalogo(){
		this.getPrimaCard().setBackground(new Color(30, 44, 255));
	}

	/**
	 * Controlla se il primo Catalogo Fornitore è salvato, per eventuali problemi all'uscita
	 * del pannello crea Catalogo Fornitore
	 * 
	 * @return saved:boolean
	 */
	public boolean isPrimoCatalogoSaved() {
		return ((CardFornitore) this.getPrimaCard()).isSaved();

	}

	/**
	 * Aggiunge la CardFornitore al pannello
	 * 
	 * @param c:CardFornitore
	 */
	public void addCard(CardFornitore c) {
		panel.add(c, 0);
		this.validate();
		this.repaint();
	}

	/**
	 * Fornisce la prima Card della lista
	 * 
	 * @return component:Component
	 */
	public CardFornitore getPrimaCard() {
		return (CardFornitore) panel.getComponent(0);

	}

	/**
	 * Fornisce true se il pannello ha almeno un Catalogo Fornitore false altrimenti
	 * 
	 * @return bool:boolean
	 */
	public boolean panelHasFornitori() {
		if (panel.getComponentCount() == 0)
			return false;
		return true;
	}

	
	/**
	 * Inizializza la grafica
	 */
	private void initialize(){
		this.setPreferredSize(new Dimension(230, 0));
	}
	
}
