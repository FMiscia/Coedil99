package GUIelaborazione2;


import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;

import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Cliente;

@SuppressWarnings("serial")
public class RiquadroCodici extends JScrollPane {
	
	private JPanel panel;
	
	public RiquadroCodici(){
		panel = new JPanel(null);
		this.setViewportView(panel);
		panel.setLayout(new WrapLayout());
		this.load(GestisciClienteHandler.getInstance().getClienti());
		
	}
	
	public void load(ArrayList<Cliente> cliente){
		int row = GestisciCommessaHandler.getInstance().getNumOfCommesse();
		panel.setPreferredSize(new Dimension(150,row*70));
		for(int k=0; k<cliente.size(); ++k){
			for(int j=0; j<cliente.get(k).ordini.size(); ++j){
				for(int i=0; i<cliente.get(k).ordini.get(j).commesse.size(); ++i){
					final RiquadroCodiceInterno r = new RiquadroCodiceInterno(this);
					r.load(cliente.get(k), cliente.get(k).ordini.get(j), cliente.get(k).ordini.get(j).commesse.get(i));
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
	

}