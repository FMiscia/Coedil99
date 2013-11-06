package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.RDACenter;
import GUI.Abstract.ALista;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.Riepiloghi.RiepilogoRDAFactory;
import coedil99.controller.GestisciRDAHandler;

/**
 * 
 * @author francesco
 * 
 *         Gestisce la lista delle righe di unaRDA selezionata
 */
public class ListaRigheRDA extends ALista {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public ListaRigheRDA() {
		super();
		this.setPreferredSize(new Dimension(300, 0));
		this.validate();
		this.repaint();
	}

	/**
	 * Carica le righe RDA
	 * 
	 * @param t
	 */
	public void load(ArrayList<Object> t) {
		this.updatePanel();
		int row = t.size();
		// this.getViewport().setPreferredSize(new Dimension(300, row * 70));
		CardRigaRDA riquadroRigaRDA = null;
		for (int k = 0; k < row; k++) {
			riquadroRigaRDA = (CardRigaRDA) CardRigaRDAFactory.getInstance()
					.makeCard(this);
			riquadroRigaRDA.load( t.get(k) );
			this.panel.add(riquadroRigaRDA);
			this.panel.validate();
			this.panel.repaint();
		}
		if (riquadroRigaRDA != null)
			this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),
					this.riepilogoRDA.getHeight() + row
							* (this.panel.getComponent(1).getHeight() + 10)));
		this.validate();
		this.repaint();
	}

	/**
	 * Rimuove un riquadro contenente una riga RDA
	 * 
	 * @param r
	 */
	public void removeRiquadro(CardRigaRDA r) {
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

	public JPanel getPanel() {
		return this.panel;
	}

	@Override
	/**
	 * Toglie il focus a tutte le righe RDA
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
	 * Aggiorna la lista e il riepilogo subito dopo una modifica
	 */
	public void updatePanel() {
		this.panel.removeAll();
		String stato = RDACenter.getInstance().getRDASelezionata()
				.getPersistentModel().getState();
		this.riepilogoRDA = RiepilogoRDAFactory.getInstance().makeRiepilogo(
				(stato!=null)?stato:GestisciRDAHandler.CONGELATA);
		if (this.riepilogoRDA != null) {
			this.riepilogoRDA.refresh();
			this.panel.add(this.riepilogoRDA, 0);
			this.validate();
			this.repaint();
		}
	}

	/**
	 * Aggiorna il riepilogo
	 */
	public void updateRiepilogo() {
		if (this.riepilogoRDA != null)
			this.riepilogoRDA.refresh();
	}

	@Override
	public void load(String s) {
	}

	@Override
	public void load() {
	}

	/**
	 * Ritorna il numero di righe RDA
	 * 
	 * @return count:int
	 */
	public int getNumRigheRDA() {
		return this.panel.getComponentCount() - 1;
	}

	/**
	 * Metodo che ricalcola l'altezza della lista
	 */
	public void updateAltezza() {
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),
				this.riepilogoRDA.getHeight() + this.getNumRigheRDA()
						* (this.panel.getComponent(1).getHeight() + 10)));
		this.validate();
		this.repaint();
	}

}
