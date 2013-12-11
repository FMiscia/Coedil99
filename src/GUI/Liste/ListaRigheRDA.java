package GUI.Liste;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.CommercialeCenter;
import GUI.ConfigGUI;
import GUI.RDACenter;
import GUI.Abstract.ALista;
import GUI.Abstract.ARiepilogoRDA;
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
	protected ARiepilogoRDA riepilogoRDA;
	
	/**
	 * Costruttore
	 */
	public ListaRigheRDA() {
		super();
		this.setPreferredSize(new Dimension(330, 0));
		this.validate();
		this.repaint();
	}

	/**
	 * Carica le righe RDA
	 * 
	 * @param t
	 */
	public void load(ArrayList<Object> t) {
		
		this.updatePanelRDA();
		int row = t.size();
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
	 * Carica le righe RDA
	 * 
	 * @param t
	 */
	public void loadComm(ArrayList<Object> t) {
		this.updatePanelComm();
		int row = t.size();
		CardRigaRDA cardRigaRDA = null;
		for (int k = 0; k < row; k++) {
			cardRigaRDA = (CardRigaRDA) CardRigaRDAFactory.getInstance()
					.makeCard(this);
			cardRigaRDA.load( t.get(k) );
			cardRigaRDA.setCardWithNoOptions();
			this.panel.add(cardRigaRDA);
			this.panel.validate();
			this.panel.repaint();
			
		}
		if (cardRigaRDA != null)
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
			c.setBackground(ConfigGUI.getColoreDeselezionato());
			c.validate();
			c.repaint();
		}
	}

	/**
	 * Aggiorna la lista RDA e il riepilogo subito dopo una modifica
	 */
	public void updatePanelRDA() {
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
	 *
	 */
	public void updatePanelComm() {
		this.panel.removeAll();
		this.riepilogoRDA = (ARiepilogoRDA) RiepilogoRDAFactory.getInstance().makeRiepilogo();
		if (this.riepilogoRDA != null) {
			this.riepilogoRDA.refresh();
			this.panel.add(this.riepilogoRDA, 0);
			this.validate();
			this.repaint();
		}
	}
	
	
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

	public void loadNOUPDATE(ArrayList<Object> t) {
		this.updatePanelComm();
		int row = t.size();
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

}
