package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import GUI.RDACenter;
import GUI.Abstract.AFormRDA;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Liste.ListaRigheRDA;
import GUI.Panels.NotaRDA;
import coedil99.controller.GestisciRDAHandler;



/**
 * 
 * @author francesco
 *
 * Gestisce il pannello della RDA
 */

public class PlicoRDA extends APlico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PlicoRDA instance = null;
	private ListaRigheRDA listaRigheRDA;
	private AFormRDA formRDA = null;
	private NotaRDA notaRDA = null;

	/**
	 * Costruttore
	 */
	private PlicoRDA() {
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
	 * Aggiunge il form di creazione o modifica RDA
	 * @param formRDA: AFormRDA
	 */
	public void addFormRDA(AFormRDA formRDA){
		if(this.formRDA != null)
			this.remove(this.formRDA);
		this.formRDA = formRDA;
		this.add(formRDA, BorderLayout.CENTER);
		this.validate();
		this.repaint();	
		
	}


	public void addNotaRDA(NotaRDA n){
		if(this.notaRDA != null)
			this.remove(this.notaRDA);
		this.notaRDA = n;
		this.add(notaRDA, BorderLayout.CENTER);
		this.validate();
		this.repaint();	
	}
	
	public void refreshNotaChange(){
		if(this.notaRDA != null)
			this.notaRDA.setNotaTxt();
		this.validate();
		this.repaint();
	}
	
	
	/**
	 * Singleton
	 * @return instance:PlicoRDA
	 */
	public static PlicoRDA getInstance() {
		if (PlicoRDA.instance == null)
			PlicoRDA.instance = new PlicoRDA();
		return PlicoRDA.instance;
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
	 * Rimuove gli elementi dalla form RDA
	 */
	public void resetFormRDA(){
		if(this.formRDA != null)
			this.remove(this.formRDA);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Rimuove gli elementi dalla nota RDA
	 */
	public void resetNotaRDA(){
		if(this.notaRDA != null)
			this.remove(this.notaRDA);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Aggiorna il plico
	 */
	@SuppressWarnings("unchecked")
	public void refresh(){
		this.resetFormRDA();
		this.listaRigheRDA.svuota();
		this.listaRigheRDA.load(new ArrayList<Object>(RDACenter.getInstance().getRDASelezionata().getPersistentModel().righeRDA.getCollection()) );
		this.validate();
		this.repaint();
	}

	/**
	 * Svuola la lista righe se non ci sono righe altrimenti fa un refresh dell'altezza della lista righe rda
	 */
	public void controllaListaRighe(){
		ListaRigheRDA lrrda = this.getListaRigheRDA();
		if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.CONGELATA) && lrrda.getNumRigheRDA() == 0){
			GestisciRDAHandler.getInstance().deleteAndRemoveMRDA(RDACenter.getInstance().getRDASelezionata());
			PlicoRDA prda = PlicoRDA.getInstance();
			ListaRigheRDA lista_righe_rda = prda.getListaRigheRDA();
				RDACenter.getInstance().refreshCongelate();
				lista_righe_rda.load(new ArrayList<Object>(RDACenter
						.getInstance().getRDASelezionata().getPersistentModel().righeRDA
						.getCollection()));
			this.validate();
			this.repaint();
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected("NUOVA") && lrrda.getNumRigheRDA() == 0){
			RDACenter.getInstance().getClipPanel().getButtons().get(4).doClick();
			this.validate();
			this.repaint();
		}
		else{
			this.listaRigheRDA.updateRiepilogo();
			this.listaRigheRDA.updateAltezza();
		}
	}
	
	/**
	 * Svuota la lista righe rda e resetta la form
	 */
	public void reset(){
		this.listaRigheRDA.svuota();
		this.resetFormRDA();
		this.resetNotaRDA();
	}

	@Override
	public boolean isModifying() {
		return false;
	}

}
