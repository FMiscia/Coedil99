package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.Abstract.ALista;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import GUI.Utilities.WrapLayout;
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

	public ListaRDA(String tipo, String contesto) {
		super();
		this.initialize();
		this.loadComm(tipo);
	}

	public void loadComm(String tipo) {
		// TODO Auto-generated method stub
		this.panel.removeAll();
		ArrayList<Object> t = null;
		t = new ArrayList<Object>(GestisciRDAHandler.getInstance()
				.getArrayMRDA(tipo));
		for (int k = 0; k < t.size(); ++k) {
			CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(this);
			r.loadComm(GestisciRDAHandler.getInstance().getArrayMRDA(tipo)
					.get(k));
			this.panel.add(r);
			this.panel.validate();
			this.panel.repaint();

		}
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), t
				.size() * (this.panel.getComponent(0).getHeight() + 6)));
		this.validate();
		this.repaint();
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
				.getArrayMRDA(tipo));
		if (t.size() != 0) {
			for (int k = 0; k < t.size(); ++k) {
				CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(
						this);
				r.load(GestisciRDAHandler.getInstance().getArrayMRDA(tipo)
						.get(k));
				this.panel.add(r);
				this.panel.validate();
				this.panel.repaint();

			}
			// if (tipo != GestisciRDAHandler.RIFIUTATA)
			this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), t
					.size() * (this.panel.getComponent(0).getHeight() + 6)));
			this.validate();
			this.repaint();
		}
	}

	/**
	 * Fornisce l'id della prima RDA
	 * 
	 * @return id:int
	 */
	public int getPrimaRDA() {
		if (this.getPrimaCard() != null) {
			this.getPrimaCard().setBackground(new Color(30, 44, 255));
			return this.getPrimaCard().getRDAId();
		}
		return 0;

	}

	/**
	 * Controlla se la prima RDA è salvata, per eventuali problemi all'uscita
	 * del pannello crea RDA
	 * 
	 * @return saved:boolean
	 */
	public boolean isPrimaRDASaved() {
		if (((CardRDA) this.getPrimaCard()) != null)
			return ((CardRDA) this.getPrimaCard()).isSaved();
		return false;
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
		if (panel.getComponentCount() != 0)
			return (CardRDA) panel.getComponent(0);
		return null;

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
	 * Carica la lista senza alcun tipo (not yet implemented)
	 */
	public void load() {

	}

	/**
	 * Inizializza la grafica
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(300, 0));
		// this.getViewport().setPreferredSize(new Dimension(300,0));
		this.deselectAll();
	}

}
