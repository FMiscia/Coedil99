package GUI.Liste;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import coedil99.controller.GestisciRDAHandler;

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
		this.load(new ArrayList<Object>(GestisciRDAHandler.getInstance().getArrayRDA()));
		this.validate();
		this.repaint();
	}

	@Override
	public void load(ArrayList<Object> t) {
		// TODO Auto-generated method stub
		int selectedRDA = 1;
		int row = GestisciRDAHandler.getInstance().getRDAById(selectedRDA).righeRDA.size();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		RiquadroRigaRDA riquadroRigaRDA;
		for(int k=0; k<t.size(); ++k){
			System.out.println(k);
			riquadroRigaRDA = new RiquadroRigaRDA(this);
			riquadroRigaRDA.load(GestisciRDAHandler.getInstance().getRDAById(selectedRDA).righeRDA.get(k));
			this.panel.add(riquadroRigaRDA);
		}
		this.setPreferredSize(new Dimension(260,panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
	}

	public void removeRiquadro(RiquadroRigaRDA r){
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

}
