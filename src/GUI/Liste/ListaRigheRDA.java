package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;

import GUI.RDACenter;
import GUI.Abstract.ALista;
import GUI.Riquadri.RiquadroCodiceRDA;
import GUI.Riquadri.RiquadroDatiDistinta;
import GUI.Riquadri.RiquadroRigaRDA;

public class ListaRigheRDA extends ALista {

	public ListaRigheRDA() {
		// TODO Auto-generated constructor stub
		super();
		panel.setBackground(Color.ORANGE);
		this.setPreferredSize(new Dimension(471,0));
		//this.load(new ArrayList<Object>(GestisciRDAHandler.getInstance().getArrayRDA()));
		this.validate();
		this.repaint();
	}

	@Override
	public void load(RDA rda) {
		// TODO Auto-generated method stub
		int row = rda.righeRDA.size();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		RiquadroRigaRDA riquadroRigaRDA;
		for(int k=0; k<row; ++k){
			//System.out.println(k);
			riquadroRigaRDA = new RiquadroRigaRDA(this);
			riquadroRigaRDA.load(rda.righeRDA.get(k));
			this.panel.add(riquadroRigaRDA);
			System.out.print(panel.getComponent(0));
			this.panel.validate();
			this.panel.repaint();
		}
		this.setPreferredSize(new Dimension(260,panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		this.validate();
		this.repaint();
	}

	public void removeRiquadro(RiquadroRigaRDA r){
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

	@Override
	public void load(ArrayList<Object> t) {
		// TODO Auto-generated method stub
		
	}

}
