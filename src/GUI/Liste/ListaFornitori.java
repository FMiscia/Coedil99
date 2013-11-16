package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.FornitoriCenter;
import GUI.Abstract.ALista;
import GUI.Avvisi.AvvisoFornitore;
import GUI.Avvisi.AvvisoFornitoreFactory;
import GUI.Avvisi.AvvisoOrdine;
import GUI.Avvisi.AvvisoOrdineFactory;
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
		if(!GestisciFornitoreHandler.isInstanciated()){
			GestisciFornitoreHandler.getInstance().reloadFornitori();
		}
		ArrayList<MCatalogoFornitore> cataloghi = GestisciFornitoreHandler.getInstance().getArrayFornitori();
		int row = cataloghi.size();
		if (row == 0) {
			this.panel.add((AvvisoFornitore) AvvisoFornitoreFactory.getInstance().makeAvviso());
			this.panel.setPreferredSize(new Dimension(150, 70));
		} else {
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
		if(FornitoriCenter.getInstance().getFornitoreSelezionato() != null){
			this.selectFornitoreSelezionato(FornitoriCenter.getInstance().getFornitoreSelezionato());
		}
		}
		this.validate();
		this.repaint();
	}

	
	/**
	 * Fornisce l'id del primo Catalogo Fornitore
	 * 
	 * @return id:int
	 */
	public int getPrimoCatalogo() {
		if(this.getPrimaCard() != null)
			this.getPrimaCard().setBackground(new Color(30, 44, 255));
		return this.getPrimaCard().getCatalogoFornitoreId();

	}
	
	/**
	 * Metodo che seleziona il primo catalogo della lista
	 */
	public void setPrimoCatalogo(){
		if(this.getPrimaCard() != null)
			this.getPrimaCard().setBackground(new Color(30, 44, 255));
	}

	/**
	 * Controlla se il primo Catalogo Fornitore è salvato, per eventuali problemi all'uscita
	 * del pannello crea Catalogo Fornitore
	 * 
	 * @return saved:boolean
	 */
	public boolean isPrimoCatalogoSaved() {
		if(this.getPrimaCard() != null)
			return ((CardFornitore) this.getPrimaCard()).isSaved();
		else
			return false;

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
		if (panel.getComponentCount() != 0 && !panel.getComponent(0).getClass().getName().equals("GUI.Avvisi.AvvisoFornitore"))
			return (CardFornitore) panel.getComponent(0);
		return null;

	}

	/**
	 * Metodo che seleziona la card relativa al fornitore selezionato
	 */
	public void selectFornitoreSelezionato(MCatalogoFornitore mcf){
		if(this.panelHasFornitori()){
			Component[] c = panel.getComponents();
			for(int i=0; i<c.length; ++i)
				if(((CardFornitore) c[i]).getCatalogoFornitoreId() ==  mcf.getPersistentModel().getID())
					((CardFornitore) c[i]).selectCard();
		}
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
