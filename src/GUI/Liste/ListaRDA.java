package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import coedil99.controller.GestisciRDAHandler;
import GUI.RDACenter;
import GUI.Abstract.ALista;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.orm.PersistentException;

import java.awt.GridLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ListaRDA extends ALista {

	public ListaRDA() {
		super();
		this.setPreferredSize(new Dimension(260, 0));
		this.load(GestisciRDAHandler.CONGELATA);
		this.deselectAll();
	}

	@Override
	public void load(String tipo) {
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
			final CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(
					this);
			r.load(t.get(k));
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

	@Override
	public void updatePanel() {
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

}
