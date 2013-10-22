package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import GUI.RDACenter;
import GUI.Abstract.AFormRDA;
import GUI.Abstract.APlico;
import GUI.Liste.ListaRigheRDA;


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
	 * Aggiorna il plico
	 */
	@SuppressWarnings("unchecked")
	public void refresh(){
		this.resetFormRDA();
		this.listaRigheRDA.svuota();
		this.listaRigheRDA.load(new ArrayList<Object>(RDACenter.getInstance().getRDASelezionata().righeRDA.getCollection()) );
		this.validate();
		this.repaint();
	}

	/**
	 * Svuola la lista righe se non ci sono righe
	 */
	public void controllaListaRighe(){
		ListaRigheRDA lrrda = this.getListaRigheRDA();
		if(lrrda.getNumRigheRDA() == 0){
			this.formRDA.reset();
			this.listaRigheRDA.svuota();
			this.validate();
			this.repaint();
		}
	}
}
