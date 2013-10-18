package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.orm.PersistentException;

import GUI.Abstract.ALista;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import coedil99.controller.GestisciRDAHandler;

@SuppressWarnings("serial")
public class ListaRDA extends ALista {

	public ListaRDA(String tipo) {
		super();
		this.setPreferredSize(new Dimension(260, 0));
		this.load(tipo);
		this.deselectAll();
	}

	@Override
	public void load(String tipo) {
		this.panel.removeAll();
		ArrayList<Object> t = null;
		try {
			t = new ArrayList<Object>(GestisciRDAHandler.getInstance()
					.getArrayRDA(tipo));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// int row = GestisciRDAHandler.getInstance().getNumOfRDA();
		this.getViewport().setPreferredSize(new Dimension(150, t.size() * 70));
		for (int k = 0; k < t.size(); ++k) {
			final CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(this);
			try {
				r.load(GestisciRDAHandler.getInstance().getArrayRDA(tipo).get(k));
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			panel.add(r);

		}
		// this.setPreferredSize(new Dimension(260, panel.getHeight()));
		this.validate();
		this.repaint();

	}

	public int getPrimaRDA() {
		this.getPrimaCard().setBackground(new Color(30, 44, 255));
		return this.getPrimaCard().getRDAId();

	}

	public boolean isPrimaRDASaved() {
		return ((CardRDA) this.getPrimaCard()).isSaved();

	}

	public void addCard(CardRDA c) {
		panel.add(c, 0);
		this.validate();
		this.repaint();
	}

	public CardRDA getPrimaCard() {
		return (CardRDA) panel.getComponent(0);

	}
	
	public boolean panelHasRDA(){
		if(panel.getComponentCount()==0)
			return false;
		return true;
	}

	@Override
	public void updatePanel() {
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

}
