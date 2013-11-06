package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Abstract.ALista;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import coedil99.controller.GestisciRDAHandler;

@SuppressWarnings("serial")
/**
 * 
 * @author francesco
 * 
 * Gestisce la lista delle RDA
 */
public class ListaRDA extends ALista {

	/**
	 * Costruttore
	 * 
	 * @param tipo
	 *            :String
	 */
	public ListaRDA(String tipo) {
		super();
		this.initialize();
		this.load(tipo);
	}

	@Override
	/**
	 * Carica la lista RDA a seconda del tipo Richiesto
	 * @param tipo:String
	 */
	public void load(String tipo) {
		this.panel.removeAll();
		ArrayList<Object> t = null;
		t = new ArrayList<Object>(GestisciRDAHandler.getInstance().getArrayMRDA(
				tipo));
		// this.getViewport().setPreferredSize(new Dimension(300, t.size() *
		// 70));
		for (int k = 0; k < t.size(); ++k) {
			CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(this);
			r.load(GestisciRDAHandler.getInstance().getArrayMRDA(tipo).get(k));
			this.panel.add(r);
			this.panel.validate();
			this.panel.repaint();

		}
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), t
				.size() * (this.panel.getComponent(0).getHeight() + 6)));
		this.validate();
		this.repaint();

	}

	/**
	 * Fornisce l'id della prima RDA
	 * 
	 * @return id:int
	 */
	public int getPrimaRDA() {
		this.getPrimaCard().setBackground(new Color(30, 44, 255));
		return this.getPrimaCard().getRDAId();

	}

	/**
	 * Controlla se la prima RDA è salvata, per eventuali problemi all'uscita
	 * del pannello crea RDA
	 * 
	 * @return saved:boolean
	 */
	public boolean isPrimaRDASaved() {
		return ((CardRDA) this.getPrimaCard()).isSaved();

	}

	/**
	 * Aggiunge la CardRDA al pannello
	 * 
	 * @param c
	 *            :CardRDA
	 */
	public void addCard(CardRDA c) {
		panel.add(c, 0);
		this.validate();
		this.repaint();
	}

	/**
	 * Fornisce la prima Card della lista
	 * 
	 * @return component:Component
	 */
	public CardRDA getPrimaCard() {
		return (CardRDA) panel.getComponent(0);

	}

	/**
	 * Fornisce true se il pannello ha almeno una RDA, false altrimenti
	 * 
	 * @return bool:boolean
	 */
	public boolean panelHasRDA() {
		if (panel.getComponentCount() == 0)
			return false;
		return true;
	}

	@Override
	/**
	 * Aggiorna la lista RDA se necessario
	 */
	public void updatePanelRDA() {
	}

	@Override
	/**
	 * Carica la lista senza alcun tipo (not yet implemented)
	 */
	public void load() {

	}
	
	/**
	 * Inizializza la grafica
	 */
	private void initialize(){
		this.setPreferredSize(new Dimension(300, 0));
		//this.getViewport().setPreferredSize(new Dimension(300,0));
		this.deselectAll();
	}

}
