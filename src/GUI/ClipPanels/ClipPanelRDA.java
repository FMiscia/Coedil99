package GUI.ClipPanels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import coedil99.model.RDA;
import coedil99.model.RDAFactory;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import GUI.FormRDA.CreaFormRDA;
import GUI.FormRDA.CreaFormRDAFactory;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Plichi.PlicoRDA;

public class ClipPanelRDA extends AClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ClipPanelRDA(){
		super();
		
		this.addButton("Menu", "Torna al menu principale", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoedilFrame cf = CoedilFrame.getInstance();
				PanelStart pl = new PanelStart(cf);
				pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
				CoedilFrame.getInstance().montaPanel(pl);
			}
		});
		
		this.addButton("Lista RDA", "Visualizza tutte le RDA", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RDACenter rdac = RDACenter.getInstance();
			}
		});
		
		this.addButton("Nuova RDA", "Crea una nuova RDA", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RDACenter rdac = RDACenter.getInstance();
				RDA rda = RDAFactory.createRDA();
				CardRDA rdaCard = (CardRDA) CardRDAFactory.getInstance().makeCard(rdac.getLista());
				rdaCard.load(rda);
				rdac.getLista().addCard(rdaCard);
				rdac.setRDASelezionata(rda);
				rdac.getLista().deselectAll();
				rdac.getLista().getPrimaRDA();
				PlicoRDA prda = PlicoRDA.getInstance();
				prda.getListaRigheRDA().svuota();
				CreaFormRDA form = (CreaFormRDA) CreaFormRDAFactory.getInstance().makeFormRDA();
				prda.add(form,BorderLayout.CENTER);
				prda.validate();
				prda.repaint();	
			}
		});
		this.fill();
	}
	
	

}
