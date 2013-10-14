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
import java.awt.GridLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ListaRDA extends ALista {

	public ListaRDA() {
		super();
		this.setPreferredSize(new Dimension(260, 0));
		this.load(new ArrayList<Object>(GestisciRDAHandler.getInstance()
				.getArrayRDA()));
		this.deselectAll();
	}

	public void load() {
		ArrayList<Object> t = new ArrayList<Object>(GestisciRDAHandler
				.getInstance().getArrayRDA());
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

	@Override
	public void load(ArrayList<Object> t) {
		// TODO Auto-generated method stub
		int row = GestisciRDAHandler.getInstance().getNumOfRDA();
		this.panel.setPreferredSize(new Dimension(150, row * 70));
		for (int k = 0; k < t.size(); ++k) {
			final CardRDA r = (CardRDA) CardRDAFactory.getInstance().makeCard(
					this);
			r.load(GestisciRDAHandler.getInstance().getArrayRDA().get(k));
			panel.add(r);
		}
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.validate();
		this.repaint();
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
		this.panelTitle.removeAll();
		panelTitle.setSize(new Dimension(200, 90));
		panelTitle.setPreferredSize(new Dimension(200, 90));
		panel.add(panelTitle, 0);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelTitle.add(labeltitle);
		panelTitle.add(labelprezzo);
		JLabel prezzo = new JLabel("0.0");
		panelTitle.add(prezzo);
		this.btnSalva.setPreferredSize(new Dimension(120, 30));
		panelTitle.add(btnSalva);
		this.validate();
		this.repaint();
	}

}
