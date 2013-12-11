package GUI.Liste;

import java.awt.Dimension;
import java.util.ArrayList;

import GUI.ConfigGUI;
import GUI.Abstract.ALista;
import GUI.Avvisi.AvvisoRDA;
import GUI.Avvisi.AvvisoRDAFactory;
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

	public ListaRDA(String tipo, String contesto) {
		super();
		this.initialize();
		this.loadComm(tipo);
	}

	public void loadComm(String tipo) {
		this.panel.removeAll();
		ArrayList<Object> t = null;
		t = new ArrayList<Object>(GestisciRDAHandler.getInstance()
				.getArrayMRDA(tipo));
		if (t.size() != 0) {
			for (int k = 0; k < t.size(); ++k) {
				CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(
						this);
				r.loadComm(GestisciRDAHandler.getInstance().getArrayMRDA(tipo)
						.get(k));
				this.panel.add(r);
				this.panel
						.setPreferredSize(new Dimension(this.panel.getWidth(),
								t.size()
										* (this.panel.getComponent(0)
												.getHeight() + 6)));
				this.panel.validate();
				this.panel.repaint();
			}
		} else {
			this.panel.add((AvvisoRDA) AvvisoRDAFactory.getInstance().makeAvviso());
			this.panel.setPreferredSize(new Dimension(150, 70));
		}

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
				this.panel
						.setPreferredSize(new Dimension(this.panel.getWidth(),
								t.size()
										* (this.panel.getComponent(0)
												.getHeight() + 6)));
			}
		} else {
			this.panel.add((AvvisoRDA) AvvisoRDAFactory.getInstance().makeAvviso());
			this.panel.setPreferredSize(new Dimension(150, 70));
		}
		this.validate();
		this.repaint();
	}

	/**
	 * Fornisce l'id della prima RDA
	 * 
	 * @return id:int
	 */
	public int getPrimaRDA() {
		if (this.getPrimaCard() != null) {
			this.getPrimaCard().setBackground(ConfigGUI.getColoreSelezionato());
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
		if (panel.getComponentCount() != 0 && !panel.getComponent(0).getClass().getName().equals("GUI.Avvisi.AvvisoRDA"))
			return (CardRDA) panel.getComponent(0);
		return null;

	}

	/**
	 * Fornisce true se il pannello ha almeno una RDA, false altrimenti
	 * 
	 * @return bool:boolean
	 */
	public boolean panelHasRDA() {
		return panel.getComponentCount() != 0 && !panel.getComponent(0).getClass().getName().equals("GUI.Avvisi.AvvisoRDA") ;
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
		this.deselectAll();
	}

}