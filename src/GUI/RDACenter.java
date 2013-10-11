package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;

import GUI.ClipPanels.ClipPanelRDA;
import GUI.Liste.ListaRDA;
import GUI.Plichi.PlicoRDA;

public class RDACenter extends JPanel {
	
	private static RDACenter instance = null;
	private RDA rdaSelezionata = null;

	
	private ListaRDA lista;
	private ClipPanelRDA clipPanel = new ClipPanelRDA();	
	
	public RDACenter(){
		this.setLayout(new BorderLayout());
		this.add(clipPanel, BorderLayout.NORTH);
		this.lista = new ListaRDA();
		this.add(this.lista, BorderLayout.WEST);
		this.add(PlicoRDA.getInstance(), BorderLayout.CENTER);
		this.setRDASelezionata(GestisciRDAHandler.getInstance().getRDAById(this.lista.getPrimaRDA()));
		PlicoRDA.getInstance().getListaRigheRDA().load(new ArrayList<Object>(this.getRDASelezionata().righeRDA.getCollection()) );
	}
	
	//Singleton
	public static RDACenter getInstance(){
		if(RDACenter.instance == null)
			RDACenter.instance = new RDACenter();
		return RDACenter.instance;
	}
	
	public RDA getRDASelezionata() {
		return rdaSelezionata;
	}

	public void setRDASelezionata(RDA rdaSelezionata) {
		this.rdaSelezionata = rdaSelezionata;
	}

	
}
