package GUI.Riquadri;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import coedil99.controller.GestisciCommessaHandler;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.Cliente;
import coedil99.model.RDA;

import GUI.Abstract.ARiquadroCodici;

@SuppressWarnings("serial")
public class RiquadroCodiciRDA extends ARiquadroCodici {
	
	
	public RiquadroCodiciRDA(){
		super();
		this.load(new ArrayList<Object>(GestisciRDAHandler.getInstance().getArrayRDA()));
	
	}
	
	@Override
	public void load(ArrayList<Object> t){

		int row = GestisciRDAHandler.getInstance().getNumOfRDA();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		for(int k=0; k<t.size(); ++k){
//			final RiquadroRDA r = new RiquadroRDA(this);
//			r.load(GestisciRDAHandler.getInstance().getArrayRDA().get(k));
//			panel.add(r);
		}
		this.setPreferredSize(new Dimension(154,panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
	}

	public void deselectAll() {
		// TODO Auto-generated method stub
		for(Component c:panel.getComponents()){
			c.setBackground(new Color(30,144,255));
			c.validate();
			c.repaint();
		}
			
		
	}
	
	public int getPrimaCommessa(){
		((RiquadroCodiceInterno) this.panel.getComponent(0)).setBackground(new Color(30,44,255));
		
		return ((RiquadroCodiceInterno) this.panel.getComponent(0)).getCommessaId();	
		
	}
	

}