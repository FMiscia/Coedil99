package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.CommercialeCenter;
import GUI.RDACenter;
import GUI.Abstract.APlico;
import GUI.Liste.ListaRigheRDA;
import GUI.Panels.NotaRDA;
import GUI.Panels.NotaRDAFactory;

public class PlicoCommerciale extends APlico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PlicoCommerciale instance = null;
	private ListaRigheRDA listaRigheRDA;
	private NotaRDA notaRDA = null;

	/**
	 * Costruttore
	 */
	private PlicoCommerciale() {
		setLayout(new BorderLayout());
		addListaRigheRDA();
		addNotaRDA();
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
	 * Aggiunge il pannello per la descrizione dell'RDA
	 */
	private void addNotaRDA(){
		this.notaRDA = NotaRDAFactory.getInstance().makeNotaRDA();
		this.notaRDA.setEnable(true);
		this.add(notaRDA, BorderLayout.CENTER);
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

	/**
	 * Metodo che aggiorna lo stato della nota RDA
	 */
	public void refreshNotaRDA() {
		if(CommercialeCenter.getInstance().getLista().panelHasRDA() == false){
			this.remove(this.notaRDA);
			this.notaRDA = null;
			this.validate();
			this.repaint();
			return;
		}
		if(this.notaRDA != null)
			this.remove(this.notaRDA);
		this.notaRDA = NotaRDAFactory.getInstance().makeNotaRDA();
		this.notaRDA.setEnable(true);
		this.add(notaRDA, BorderLayout.CENTER);
		this.validate();
		this.repaint();	
	}
	
	public NotaRDA getNotaRDA() {
		return notaRDA;
	}

	public void setNotaRDA(NotaRDA notaRDA) {
		this.notaRDA = notaRDA;
	}


}
