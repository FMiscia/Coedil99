package GUI.Riepiloghi;

import GUI.FornitoriCenter;
import GUI.Abstract.ARiepilogoFornitore;
import coedil99.model.MCatalogoFornitore;

/**
 * Gestisce il riepilogo dei dati relativi al catalogo fornitore
 * @author Simone
 *
 */
public class RiepilogoFornitore extends ARiepilogoFornitore {

	/**
	 * Costruttore
	 */
	public RiepilogoFornitore(){
		super();
		this.initialize();
	}
	
	/**
	 * Aggiorna il contenuto del riepilogo fornitore
	 */
	@Override
	public void refresh() {
		MCatalogoFornitore mcf = FornitoriCenter.getInstance().getFornitoreSelezionato();
		this.lblNome.setText(mcf.getPersistentModel().getName());
		this.setModify(false);
		this.importing = false;
		this.btnElimina.setVisible(false);
	}
	
	/**
	 * Inizializza la grafica
	 */
	private void initialize(){
		this.setModify(true);
		this.btnElimina.setVisible(true);
	}
	
	/**
	 * Metodo che setta la visione di alcuni bottoni se si sta creando un nuovo catalogo oppure no
	 * @param nuovo: booleano
	 */
	private void newRiepilogo(boolean nuovo){
		this.btnElimina.setVisible(nuovo);
		this.importing = true;
	}
}
