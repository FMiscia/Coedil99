package GUI.Liste;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Abstract.ALista;
import GUI.Card.CardCodiceInterno;
import GUI.Card.CardCodiceInternoFactory;
import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MCliente;
import coedil99.persistentmodel.Cliente;

@SuppressWarnings("serial")
/**
 * 
 * @author francesco
 * Gestisce la lista delle commesse sul lato dello schermo
 */
public class ListaCommesse extends ALista {
	
	/**
	 * Costruttore
	 */
	public ListaCommesse(){
		super();
		this.load();
	}
	
	@Override
	public void load(String n){
	}

	/**
	 * Toglie il focus a tutte le card Commessa
	 */
	public void deselectAll() {
		// TODO Auto-generated method stub
		for(Component c:panel.getComponents()){
			c.setBackground(new Color(30,144,255));
			c.validate();
			c.repaint();
		}
			
		
	}
	
	/**
	 * Fornisce l'id della prima commessa della lista
	 * 
	 * @return id:int
	 */
	public int getPrimaCommessa(){
		((CardCodiceInterno) this.panel.getComponent(0)).setBackground(new Color(30,44,255));
		
		return ((CardCodiceInterno) this.panel.getComponent(0)).getCommessaId();	
		
	}

	
	@Override
	/**
	 * Aggiorna il pannello contenente la lista se necessario (caso d'uso gestisci commessa)
	 */
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Carica la lista
	 */
	public void load() {
		// TODO Auto-generated method stub
		ArrayList<Object> t = new ArrayList<Object>(GestisciClienteHandler.getInstance().getClienti());
		int row = GestisciCommessaHandler.getInstance().getNumOfCommesse();
		this.panel.setPreferredSize(new Dimension(150,row*70));
		for(int k=0; k<t.size(); ++k){
			MCliente temp = (MCliente)t.get(k);
			for(int j=0; j<temp.getPersistentModel().ordini.size(); ++j){
				for(int i=0; i<temp.getPersistentModel().ordini.get(j).commesse.size(); ++i){
					final CardCodiceInterno r = (CardCodiceInterno) CardCodiceInternoFactory.getInstance().makeCard(this);
					ArrayList<Object> commessaIdentifier = new ArrayList<Object>();
					//cliente
					commessaIdentifier.add(0, temp);
					//ordine
					commessaIdentifier.add(1, temp.getPersistentModel().ordini.get(j));
					//commessa
					commessaIdentifier.add(2, temp.getPersistentModel().ordini.get(j).commesse.get(i));
					r.load(commessaIdentifier);
					panel.add(r);
				}
			}
		}
		this.setPreferredSize(new Dimension(154,panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
	}




}