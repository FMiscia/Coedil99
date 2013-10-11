package GUI.Liste;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.Abstract.ALista;
import GUI.Card.CardRigaRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;
import coedil99.model.RigaRDA;

public class ListaRigheRDA extends ALista {

	public ListaRigheRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPreferredSize(new Dimension(320,0));
		this.validate();
		this.repaint();
	}

	@Override
	public void load(ArrayList<Object> t) {
		// TODO Auto-generated method stub
		int row = t.size();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		CardRigaRDA riquadroRigaRDA;
		for(int k=0; k<row; ++k){
			riquadroRigaRDA = new CardRigaRDA(this);
			riquadroRigaRDA.load(t.get(k));
			this.panel.add(riquadroRigaRDA);
			this.panel.validate();
			this.panel.repaint();
		}
		this.setPreferredSize(new Dimension(471,panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		this.validate();
		this.repaint();
	}

	public void removeRiquadro(CardRigaRDA r){
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

	
	public JPanel getPanel(){
		return this.panel;
	}

}