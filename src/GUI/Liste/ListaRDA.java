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
	 * @param tipo:String
	 */
	public ListaRDA(String tipo) {
		super();
		this.setPreferredSize(new Dimension(300, 0));
		this.load(tipo);
		this.deselectAll();
	}

	@Override
	/**
	 * Carica la lista RDA a seconda del tipo Richiesto
	 * @param tipo:String
	 */
	public void load(String tipo) {
		this.panel.removeAll();
		ArrayList<Object> t = null;
		t = new ArrayList<Object>(GestisciRDAHandler.getInstance()
				.getArrayRDA(tipo));
		// int row = GestisciRDAHandler.getInstance().getNumOfRDA();
		this.getViewport().setPreferredSize(new Dimension(150, t.size() * 70));
		for (int k = 0; k < t.size(); ++k) {
			final CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(this);
			r.load(GestisciRDAHandler.getInstance().getArrayRDA(tipo).get(k));

			panel.add(r);

		}
		// this.setPreferredSize(new Dimension(260, panel.getHeight()));
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
	 * Controlla se la prima RDA è salvata, per eventuali
	 * problemi all'uscita del pannello crea RDA
	 * 
	 * @return saved:boolean
	 */
	public boolean isPrimaRDASaved() {
		return ((CardRDA) this.getPrimaCard()).isSaved();

	}

	/**
	 * Aggiunge la CardRDA al pannello
	 * @param c:CardRDA
	 */
	public void addCard(CardRDA c) {
		panel.add(c, 0);
		this.validate();
		this.repaint();
	}

	/**
	 * Fornisce la prima Card della lista
	 * @return component:Component
	 */
	public CardRDA getPrimaCard() {
		return (CardRDA) panel.getComponent(0);

	}
	
	/**
	 * Fornisce true se il pannello ha almeno una RDA, false altrimenti
	 * @return bool:boolean
	 */
	public boolean panelHasRDA(){
		if(panel.getComponentCount()==0)
			return false;
		return true;
	}

	@Override
	/**
	 * Aggiorna la lista RDA se necessario
	 */
	public void updatePanel() {
	}

	@Override
	/**
	 * Carica la lista senza alcun tipo (not yet implemented)
	 */
	public void load() {
		// TODO Auto-generated method stub

	}

}
