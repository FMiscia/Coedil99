package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.Abstract.ALista;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.Riquadri.RiquadroRiepilogoRDA;
import GUI.Riquadri.RiquadroRiepilogoRDAFactory;
import coedil99.model.RigaRDA;

public class ListaRigheRDA extends ALista {

	public ListaRigheRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPreferredSize(new Dimension(290, 0));
		this.validate();
		this.repaint();
	}


	public void load(ArrayList<Object> t) {
		this.updatePanel();
		int row = t.size();
		this.getViewport().setPreferredSize(new Dimension(180, row * 70));
		CardRigaRDA riquadroRigaRDA;
		for (int k = 0; k < row; ++k) {
			riquadroRigaRDA = (CardRigaRDA) CardRigaRDAFactory.getInstance()
					.makeCard(this);
			final RigaRDA riga = (RigaRDA) t.get(k);
			riquadroRigaRDA.load(riga);
			this.panel.add(riquadroRigaRDA);
			this.panel.validate();
			this.panel.repaint();
		}
		this.validate();
		this.repaint();
	}

	public void removeRiquadro(CardRigaRDA r) {
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

	public JPanel getPanel() {
		return this.panel;
	}

	@Override
	public void deselectAll() {
		for (Component c : this.panel.getComponents()) {
			c.setBackground(new Color(209, 209, 209));
			c.validate();
			c.repaint();
		}
	}

	

	@Override
	public void updatePanel() {
		this.riepilogoRDA = (RiquadroRiepilogoRDA) RiquadroRiepilogoRDAFactory.getInstance().makeRiepilogo();
		this.riepilogoRDA.refresh();
		this.panel.add(this.riepilogoRDA,0);
		this.validate();
		this.repaint();
	}




	@Override
	public void load(String s) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
