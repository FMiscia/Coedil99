package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

import GUI.ProgrammaLavoriCenter;
import GUI.Abstract.APlico;
import GUI.Form.FormDistinta;
import GUI.Liste.ListaRigheLavoro;
import GUI.Liste.ListaRigheLavoroFactory;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MDistinta;
import coedil99.model.MRigaLavoro;

/**
 * 
 * @author francesco
 *
 * Gestisce il pannello della distinta
 */
public class PlicoDistinta extends APlico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PlicoDistinta instance = null;
	private FormDistinta riquadroRigaLavoro;
	private ArrayList<FormDistinta> riquadri = new ArrayList<FormDistinta>();
	private ListaRigheLavoro listaRigheLavoro;

	/**
	 * Costruttore
	 */
	private PlicoDistinta() {
		this.initialize();
	}

	@Override
	public void load() {
	}

	/**
	 * Singleton
	 * @return instance:PlicoDistinta
	 */
	public static PlicoDistinta getInstance() {
		if (PlicoDistinta.instance == null)
			PlicoDistinta.instance = new PlicoDistinta();
		return PlicoDistinta.instance;
	}

	@Override
	/**
	 * Carica il riquadro della distinta
	 * @param id:commessaId
	 */
	public void load(int id) {
		//int bounds = (CoedilFrame.getInstance().getBounds().width/6);
		this.listaRigheLavoro.updatePanel();
		MDistinta d = new MDistinta(GestisciCommessaHandler.getInstance()
				.getCommessaById(id).getPersistentModel().getDistinta().getID());
		this.listaRigheLavoro.load(new ArrayList<Object>(d.getPersistentModel().lavori.getCollection()));
		if(d.hasDdo())
			this.setEdit(false);
		this.listaRigheLavoro.updateAltezza();
		this.validate();
		this.repaint();
	}

	/**
	 * Metodo che rimuove, se presente, il riquadro delle righe lavoro
	 */
	public void removeRiquadro(){
		if(this.riquadroRigaLavoro != null)
			this.remove(this.riquadroRigaLavoro);
	}
	
	public void addRiquadroinLista(FormDistinta r){
		this.riquadri.add(r);
	}
	
	public ArrayList<FormDistinta> getRiquadri() {
		return riquadri;
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize(){
		this.setLayout(new BorderLayout());
		this.addListaRigheLavoro();
	}

	public boolean isModifying() {
		boolean result = false;
		for(FormDistinta temp: this.riquadri){
			for (JLabel j : temp.getLabel()) {
				if (j.isVisible())
					result = true;
				temp.svuotaIconeLAbel();
			}
		}
		return result;
	}
	
	/**
	 * Metodo che aggiunge la lista righe lavoro
	 */
	private void addListaRigheLavoro(){
		this.listaRigheLavoro = (ListaRigheLavoro) ListaRigheLavoroFactory.getInstance().makeLista();
		this.add(listaRigheLavoro,BorderLayout.WEST);
	}
	
	/**
	 * Metodo che aggiunge il riquadro contenente le informazioni circa la riga lavoro nel plico
	 * @param r MRigaLavoro
	 */
	public void addRiquadroRigaLavoro(MRigaLavoro r){
		if(this.riquadroRigaLavoro != null)
			this.remove(this.riquadroRigaLavoro);
		this.riquadroRigaLavoro = new FormDistinta();
		this.riquadroRigaLavoro.load(r);
		this.add(this.riquadroRigaLavoro,BorderLayout.EAST);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Metodo che refresha il contenuto del plico, rimuovendo la form della distinta se è visibile
	 */
	public void refresh(){
		this.removeRiquadro();
		this.load(ProgrammaLavoriCenter.getInstance().getCommessaSelezionata().getPersistentModel().getID());
	}
	
	/**
	 * Metodo che disabilita i pulsanti per modificare/eliminare delle card
	 * @param b
	 */
	public void setEdit(boolean b) {
		this.listaRigheLavoro.setEdit(b);
		this.validate();
		this.repaint();
	}

}
