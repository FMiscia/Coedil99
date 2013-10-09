package GUI.Liste;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Abstract.ALista;
import GUI.Riquadri.RiquadroCodiceInterno;
import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Cliente;
import coedil99.model.RDA;

@SuppressWarnings("serial")
public class ListaCommesse extends ALista {
	
	
	public ListaCommesse(){
		super();
		this.load(new ArrayList<Object>(GestisciClienteHandler.getInstance().getClienti()));
		
	}
	
	@Override
	public void load(ArrayList<Object> t){
		int row = GestisciCommessaHandler.getInstance().getNumOfCommesse();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		for(int k=0; k<t.size(); ++k){
			Cliente temp = (Cliente)t.get(k);
			for(int j=0; j<temp.ordini.size(); ++j){
				for(int i=0; i<temp.ordini.get(j).commesse.size(); ++i){
					final RiquadroCodiceInterno r = new RiquadroCodiceInterno(this);
					r.load(temp, temp.ordini.get(j), temp.ordini.get(j).commesse.get(i));
					panel.add(r);
				}
			}
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

	@Override
	public void load(RDA rda) {
		// TODO Auto-generated method stub
		
	}
	

}