package GUI.Riepiloghi;

import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;
import coedil99.model.RDA;

public class RiepilogoRDAAttesaConferma extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RiepilogoRDAAttesaConferma() {
		super();
	}

	@Override
	public void refresh() {
		RDA r = RDACenter.getInstance().getRDASelezionata();
		this.lblFornitoreSelezionato.setText(r.righeRDA.get(0).getDescription()
				.getCatalogoFornitore().getName());
		float prezzo_totale = 0;
		int quantita_totale = 0;
		for (int i = 0; i < r.righeRDA.size(); ++i) {
			prezzo_totale += (r.righeRDA.get(i).getQuantity() * r.righeRDA
					.get(i).getDescription().getPrezzo());
			quantita_totale += r.righeRDA.get(i).getQuantity();
		}
		this.lblTotale.setText(String.valueOf(prezzo_totale));
		this.lblQuantita.setText(String.valueOf(quantita_totale));
		this.btnSalva.removeAll();
		this.btnSalva.setEnabled(false);
		this.btnElimina.removeAll();
		this.btnElimina.setEnabled(false);
		this.btnInvia.removeAll();
		this.btnInvia.setEnabled(false);
		this.validate();
		this.repaint();

	}

}
