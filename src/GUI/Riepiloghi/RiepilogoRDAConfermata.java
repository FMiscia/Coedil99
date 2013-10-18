package GUI.Riepiloghi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;
import GUI.ProgrammaLavori;
import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;
import GUI.Card.CardRDA;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;

public class RiepilogoRDAConfermata extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RiepilogoRDAConfermata(){
		super();
	}

	@Override
	public void refresh() {
		RDA r = RDACenter.getInstance().getRDASelezionata(); 
		this.lblFornitoreSelezionato.setText(r.righeRDA.get(0).getDescription().getCatalogoFornitore().getName());
		float prezzo_totale = 0;
		int quantita_totale = 0;
		for (int i = 0; i < r.righeRDA.size(); ++i) {
			prezzo_totale += (r.righeRDA.get(i).getQuantity() * r.righeRDA
					.get(i).getDescription().getPrezzo());
			quantita_totale += r.righeRDA.get(i).getQuantity();
		}
		this.lblTotale.setText(String.valueOf(prezzo_totale));
		this.lblQuantita.setText(String.valueOf(quantita_totale));
		this.btnElimina.setVisible(false);
		this.btnInvia.setVisible(false);
		this.btnSalva.setVisible(false);
		this.validate();
		this.repaint();
		
	}

}
