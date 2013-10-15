package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import coedil99.controller.GestisciRDAHandler;
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
		this.load();
		this.deselectAll();
		ArrayList<Object> a=null;
		try {
			a = new ArrayList<Object>(GestisciRDAHandler.getInstance().getArrayRDA(GestisciRDAHandler.CONGELATA));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int k = 0; k < a.size(); ++k) {
			System.out.println(a.toArray()[k]);
		}

	}
	
	@Override
	public void load() {
		ArrayList<Object> t=null;
		try {
			t = new ArrayList<Object>(GestisciRDAHandler
					.getInstance().getArrayRDA(GestisciRDAHandler.CONGELATA));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row = GestisciRDAHandler.getInstance().getNumOfRDA();
		this.panel.setPreferredSize(new Dimension(150, row * 70));
		for (int k = 0; k < t.size(); ++k) {
			final CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(
					this);
			r.load(GestisciRDAHandler.getInstance().getArrayRDA().get(k));
			panel.add(r);

		}
		this.setPreferredSize(new Dimension(260, panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.validate();
		this.repaint();

	}

	public void deselectAll() {
		// TODO Auto-generated method stub
		for (Component c : panel.getComponents()) {
			c.setBackground(new Color(30, 144, 255));
			c.validate();
			c.repaint();
		}

	}

	public int getPrimaRDA() {
		((CardRDA) this.panel.getComponent(0)).setBackground(new Color(30, 44,
				255));
		return ((CardRDA) this.panel.getComponent(0)).getRDAId();

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

}
