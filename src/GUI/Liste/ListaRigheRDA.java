package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.RDACenter;
import GUI.Abstract.ALista;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;
import coedil99.model.RigaRDA;

public class ListaRigheRDA extends ALista {

	public ListaRigheRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.validate();
		this.repaint();
	}

	@Override
	public void load(ArrayList<Object> t) {
		//Aggiorna titolo e prezzo delle righe rda
		this.updateTitlePanel();
		this.setPreferredSize(new Dimension(290, 0));
		int row = t.size();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		CardRigaRDA riquadroRigaRDA;
		for(int k=0; k<row; ++k){
			riquadroRigaRDA = (CardRigaRDA) CardRigaRDAFactory.getInstance().makeCard(this);
			final RigaRDA riga = (RigaRDA) t.get(k);
			riquadroRigaRDA.load(riga);
			this.panel.add(riquadroRigaRDA);
			this.panel.validate();
			this.panel.repaint();
		}
		this.setPreferredSize(new Dimension(290,panel.getHeight()));
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
	

	@Override
	public void deselectAll(){
		for(Component c:this.panel.getComponents()){
			c.setBackground(new Color(209,209,209));
			c.validate();
			c.repaint();
		}
	}
	
		


}
