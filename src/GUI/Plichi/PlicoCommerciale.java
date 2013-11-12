package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import GUI.RDACenter;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Liste.ListaRigheRDA;
import GUI.Panels.PanelRDAComm;
import GUI.Panels.PanelRDACommFactory;

public class PlicoCommerciale extends APlico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PlicoCommerciale instance = null;
	private ListaRigheRDA listaRigheRDA;
	private PanelRDAComm panelrdacomm = null;

	
	/**
	 * Costruttore
	 */
	private PlicoCommerciale() {
		setLayout(new BorderLayout());
		addListaRigheRDA();
	}

	/**
	 * Aggiunge la lista delle righe RDA
	 */
	private void addListaRigheRDA() {
		// TODO Auto-generated method stub
		this.listaRigheRDA = new ListaRigheRDA();
		this.add(listaRigheRDA,BorderLayout.WEST);

	}
	


	/**
	 * Singleton
	 * @return instance:PlicoRDA
	 */
	public static PlicoCommerciale getInstance() {
		if (PlicoCommerciale.instance == null)
			PlicoCommerciale.instance = new PlicoCommerciale();
		return PlicoCommerciale.instance;
	}


	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
		
	}


	public ListaRigheRDA getListaRigheRDA() {
		return listaRigheRDA;
	}


	public void setListaRigheRDA(ListaRigheRDA listaRigheRDA) {
		this.listaRigheRDA = listaRigheRDA;
	}
	

	
	/**
	 * Aggiorna il plico
	 */
	@SuppressWarnings("unchecked")
	public void refresh(){
		this.listaRigheRDA.svuota();
		
		this.listaRigheRDA.loadNOUPDATE(new ArrayList<Object>(RDACenter.getInstance().getRDASelezionata().getPersistentModel().righeRDA.getCollection()) );
		this.validate();
		this.repaint();
	}


	/**
	 * Svuota la lista righe rda
	 */
	public void reset(){
		this.listaRigheRDA.svuota();
	}

	@Override
	public boolean isModifying() {
		// TODO Auto-generated method stub
		return false;
	}

	public void refreshFormRDA() {
		// TODO Auto-generated method stub
		if(this.panelrdacomm != null)
			this.remove(this.panelrdacomm);
		this.panelrdacomm = PanelRDACommFactory.getInstance().makePanelRDAComm();
		this.add(panelrdacomm, BorderLayout.CENTER);
		this.validate();
		this.repaint();	
	}


}
