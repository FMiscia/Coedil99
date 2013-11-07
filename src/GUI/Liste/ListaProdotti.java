package GUI.Liste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.FornitoriCenter;
import GUI.Abstract.ALista;
import GUI.Card.CardProdotto;
import GUI.Card.CardProdottoFactory;
import GUI.Riepiloghi.RiepilogoFornitore;
import GUI.Riepiloghi.RiepilogoFornitoreFactory;
import coedil99.model.MProductDescription;

public class ListaProdotti extends ALista {

	private JPanel intestazione;
	protected RiepilogoFornitore riepilogoFornitore;

	/**
	 * Costruttore
	 */
	public ListaProdotti() {
		super();
		this.setPreferredSize(new Dimension(550, 0));
		this.initialize();
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
					row * this.panel.getComponent(1).getHeight()));
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
		return FornitoriCenter.getInstance().getFornitoreSelezionato()
				.getPersistentModel().productDescription.size();
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

	@Override
	/**
	 * Aggiorna la lista subito dopo una modifica
	 */
	public void updatePanel() {
		this.panel.removeAll();
		this.riepilogoFornitore = (RiepilogoFornitore) RiepilogoFornitoreFactory
				.getInstance().makeRiepilogo();
		if (this.riepilogoFornitore != null) {
			this.riepilogoFornitore.refresh();
			this.panel.add(this.riepilogoFornitore, 0);
			//this.panel.add(intestazione,1);
			this.validate();
			this.repaint();
		}
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
		this.intestazione = new JPanel();
		FlowLayout flowLayout = (FlowLayout) intestazione.getLayout();
		flowLayout.setVgap(0);
		intestazione.setPreferredSize(new Dimension(530, 30));
		
		JLabel lblEssenza = new JLabel("Essenza");
		lblEssenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblEssenza.setPreferredSize(new Dimension(80, 30));
		intestazione.add(lblEssenza);
		
		JLabel lblLunghezza = new JLabel("Lunghezza");
		lblLunghezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunghezza.setPreferredSize(new Dimension(80, 30));
		intestazione.add(lblLunghezza);
		
		JLabel lblAltezza = new JLabel("Altezza");
		lblAltezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltezza.setPreferredSize(new Dimension(60, 30));
		intestazione.add(lblAltezza);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setPreferredSize(new Dimension(60, 30));
		lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		intestazione.add(lblBase);
		
		JLabel lblPezziPerPacco = new JLabel("Pezzi per Pacco");
		lblPezziPerPacco.setPreferredSize(new Dimension(100, 30));
		lblPezziPerPacco.setHorizontalAlignment(SwingConstants.CENTER);
		intestazione.add(lblPezziPerPacco);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setPreferredSize(new Dimension(50, 30));
		lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		intestazione.add(lblPrezzo);
	}

}
