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
		this.validate();
		this.repaint();
	}
	
	/**
	 * Inizializza la grafica
	 */
	private void initialize(){
		this.btn.validate();
		this.btn.repaint();
	}

}
