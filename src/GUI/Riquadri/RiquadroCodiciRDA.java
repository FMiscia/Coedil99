package GUI.Riquadri;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Abstract.ARiquadroCodici;

import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Cliente;

@SuppressWarnings("serial")
public class RiquadroCodiciRDA extends ARiquadroCodici {
	
	
	public RiquadroCodiciRDA(){
		super();
	
	}
	
	@Override
	public void load(ArrayList<Object> t){

		
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