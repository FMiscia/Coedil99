package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import org.orm.PersistentException;

import GUI.Abstract.ALista;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import coedil99.controller.GestisciRDAHandler;

public class ListaRDAAttesa extends ALista {

	public ListaRDAAttesa() {
		// TODO Auto-generated constructor stub
		super();
		this.setPreferredSize(new Dimension(260, 0));
		this.load();
		this.deselectAll();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		ArrayList<Object> t=null;
		try {
			t = new ArrayList<Object>(GestisciRDAHandler
					.getInstance().getArrayRDA(GestisciRDAHandler.ATTESA_CONFERMA));
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

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub

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


}
