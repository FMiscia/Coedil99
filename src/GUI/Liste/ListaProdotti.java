package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.FornitoriCenter;
import GUI.Abstract.ALista;
import GUI.Card.CardProdotto;
import GUI.Card.CardProdottoFactory;
import GUI.Riepiloghi.RiepilogoFornitore;
import GUI.Riepiloghi.RiepilogoFornitoreFactory;
import coedil99.model.MProductDescription;

public class ListaProdotti extends ALista {

	protected RiepilogoFornitore riepilogoFornitore;

	/**
	 * Costruttore
	 */
	public ListaProdotti() {
		super();
		this.initialize();
		this.setPreferredSize(new Dimension(500, 0));
		this.validate();
		this.repaint();
	}

	/**
	 * Carica i Product Description
	 * 
	 * @param prodotti
	 */
	public void load(ArrayList<MProductDescription> prodotti) {
		this.updatePanel();
		int row = prodotti.size();
		CardProdotto cardProdotto = null;
		for (int k = 0; k < row; k++) {
			cardProdotto = (CardProdotto) CardProdottoFactory.getInstance()
					.makeCard(this);
			cardProdotto.load(prodotti.get(k));
			cardProdotto.setSfondoCard(k);
			this.panel.add(cardProdotto);
			this.panel.validate();
			this.panel.repaint();
		}
		if (cardProdotto != null)
			this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),
					row * (this.panel.getComponent(1).getHeight() + 10)));
		this.validate();
		this.repaint();
	}

	/**
	 * Rimuove un riquadro contenente un Product Description
	 * 
	 * @param r
	 */
	public void removeRiquadro(CardProdotto r) {
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public int getNumProdotti() {
		return this.panel.getComponentCount() -1;
	}

	@Override
	/**
	 * Toglie il focus a tutti i Product Description
	 */
	public void deselectAll() {
		for (Component c : this.panel.getComponents()) {
			c.setBackground(new Color(209, 209, 209));
			c.validate();
			c.repaint();
		}
	}

	/**
	 * Aggiorna la lista subito dopo una modifica
	 */
	public void updatePanel() {
		this.panel.removeAll();
		if (this.riepilogoFornitore != null) {
			this.riepilogoFornitore.refresh();
		}
		else{
			this.riepilogoFornitore = (RiepilogoFornitore) RiepilogoFornitoreFactory
					.getInstance().makeRiepilogo();
		}
		this.panel.add(this.riepilogoFornitore, 0);
		this.validate();
		this.repaint();
	}

	@Override
	public void load(String s) {
	}

	@Override
	public void load() {
	}

	/**
	 * Metodo che ricalcola l'altezza della lista
	 */
	public void updateAltezza() {
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),
				this.riepilogoFornitore.getHeight() + this.getNumProdotti()
						* (this.panel.getComponent(1).getHeight() + 10)));
		this.validate();
		this.repaint();
	}
	
	/**
	 * Inizializza la grafica
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(550, 0));
		this.riepilogoFornitore = (RiepilogoFornitore) RiepilogoFornitoreFactory
				.getInstance().makeRiepilogo();
		this.panel.add(this.riepilogoFornitore, 0);
	}
	
	/**
	 * Metodo che ritorna true o false se la lista è vuota o piena
	 * @return boolean
	 */
	public boolean isEmpty(){
		return this.getNumProdotti() == 0;
	}
	
	/**
	 * Metodo che ritorna un booleano sullo stato di importing del catalogo
	 * @return boolean
	 */
	public boolean isImporting(){
		return this.riepilogoFornitore.isImporting();
	}
	
	/**
	 * Metodo che annulla import di un nuovo catalogo fornitore
	 */
	public void abortImporting(){
		this.riepilogoFornitore.aborting();
	}
	
}
