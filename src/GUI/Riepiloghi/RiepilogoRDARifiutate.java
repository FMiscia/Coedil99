package GUI.Riepiloghi;

import java.awt.Dimension;

import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;
import coedil99.model.MRDA;

/**
 * 
 * @author francesco
 *
 * Gestisce il pannello di riepilogo posto in alto per RDA
 * in attesa conferma
 */
public class RiepilogoRDARifiutate extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public RiepilogoRDARifiutate() {
		super();
		this.initialize();
	}

	@Override
	/**
	 * Aggiorna il pannello di riepilogo
	 */
	public void refresh() {
		MRDA r = RDACenter.getInstance().getRDASelezionata();
		this.lblFornitoreSelezionato.setText(r.getPersistentModel().righeRDA.get(0).getDescription()
				.getCatalogoFornitore().getName());
		float prezzo_totale = 0;
		int quantita_totale = 0;
		for (int i = 0; i < r.getPersistentModel().righeRDA.size(); ++i) {
			prezzo_totale += (r.getPersistentModel().righeRDA.get(i).getQuantity() * r.getPersistentModel().righeRDA
					.get(i).getDescription().getPrezzo());
			quantita_totale += r.getPersistentModel().righeRDA.get(i).getQuantity();
		}
		this.lblTotale.setText(String.valueOf(prezzo_totale));
		this.lblQuantita.setText(String.valueOf(quantita_totale));
		
		
		this.validate();
		this.repaint();

	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize(){
//		this.panel.remove(this.btnSalva);
//		this.panel.remove(this.btnElimina);
//		this.panel.remove(this.btnInvia);
		this.validate();
		this.repaint();
	}

}
