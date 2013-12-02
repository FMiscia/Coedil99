package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.ConfigGUI;
import GUI.Abstract.ALista;
import GUI.Avvisi.AvvisoOrdine;
import GUI.Avvisi.AvvisoOrdineFactory;
import GUI.Card.CardCodiceInterno;
import GUI.Card.CardCodiceInternoFactory;
import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MCliente;
import coedil99.model.MCommessa;

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
	public ListaCommesse() {
		super();
		this.load();
	}

	@Override
	public void load(String n) {
	}

	/**
	 * Toglie il focus a tutte le card Commessa
	 */
	public void deselectAll() {
		// TODO Auto-generated method stub
		for (Component c : panel.getComponents()) {
			c.setBackground(ConfigGUI.getColoreDeselezionato());
			c.validate();
			c.repaint();
		}

	}

	/**
	 * Fornisce l'id della prima commessa della lista
	 * 
	 * @return id:int
	 */
	public int getPrimaCommessa() {
		if (panel.getComponentCount() != 0 && !panel.getComponent(0).getClass().getName().equals("GUI.Avvisi.AvvisoOrdine")){
			((CardCodiceInterno) this.panel.getComponent(0))
			.setBackground(ConfigGUI.getColoreSelezionato());
			return ((CardCodiceInterno) this.panel.getComponent(0)).getCommessaId();
		}
			
		return 0;
	}

	/**
	 * Aggiorna il pannello contenente la lista se necessario (caso d'uso
	 * gestisci commessa)
	 */
	public void updatePanel() {
		this.panel.removeAll();
        this.load();
        this.panel.validate();
        this.panel.repaint();
	}
	
	/**
	 * Metodo che seleziona la card relativa alla commessa selezionata
	 */
	public void selectCommessaSelezionata(MCommessa mcf){
		if(this.panel.getComponentCount()!=0){
			Component[] c = panel.getComponents();
			for(int i=0; i<c.length; ++i)
				if(((CardCodiceInterno) c[i]).getCommessaId() ==  mcf.getPersistentModel().getID())
					((CardCodiceInterno) c[i]).selectCard();
		}
	}

	@Override
	/**
	 * Carica la lista
	 */
	public void load() {
		ArrayList<Object> t = new ArrayList<Object>(GestisciClienteHandler
				.getInstance().getClienti());
		int row = GestisciCommessaHandler.getInstance().getNumOfCommesse();
		if (row == 0) {
			this.panel.add((AvvisoOrdine) AvvisoOrdineFactory.getInstance().makeAvviso());
			this.panel.setPreferredSize(new Dimension(150, 70));
		} else {
			this.panel.setPreferredSize(new Dimension(150, row * 70));
			for (int k = 0; k < t.size(); ++k) {
				MCliente temp = (MCliente) t.get(k);
				for (int j = 0; j < temp.getPersistentModel().ordini.size(); ++j) {
					for (int i = 0; i < temp.getPersistentModel().ordini.get(j).commesse
							.size(); ++i) {
						final CardCodiceInterno r = (CardCodiceInterno) CardCodiceInternoFactory
								.getInstance().makeCard(this);
						ArrayList<Object> commessaIdentifier = new ArrayList<Object>();
						// cliente
						commessaIdentifier.add(0, temp);
						// ordine
						commessaIdentifier.add(1,
								temp.getPersistentModel().ordini.get(j));
						// commessa
						commessaIdentifier
								.add(2,
										temp.getPersistentModel().ordini.get(j).commesse
												.get(i));
						r.load(commessaIdentifier);
						panel.add(r);
					}
				}
			}
		}
			this.setPreferredSize(new Dimension(154, panel.getHeight()));
			this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
	}

}
