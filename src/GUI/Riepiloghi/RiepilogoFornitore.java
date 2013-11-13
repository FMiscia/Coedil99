package GUI.Riepiloghi;

import java.awt.Dimension;

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
		if(!this.importing)
			this.setPreferredSize(new Dimension(380,70));
		MCatalogoFornitore mcf = FornitoriCenter.getInstance().getFornitoreSelezionato();
		this.lblNome.setText(mcf.getPersistentModel().getName());
		this.setModify(false);
		this.setImporting(false);
		this.btnElimina.setVisible(false);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Inizializza la grafica
	 */
	private void initialize(){
		this.setModify(true);
		this.btnElimina.setVisible(true);
		//this.setImporting(true);
	}
	
}
