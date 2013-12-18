package GUI.Riepiloghi;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;
import coedil99.model.MRDA;


/**
 * 
 * @author francesco
 *
 * Gestisce il pannello di riepilogo posto in alto per RDA
 * confermate
 */
public class RiepilogoRDAConfermata extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public RiepilogoRDAConfermata(){
		super();
		this.initialize();
	}

	@Override
	/**
	 * Aggiorna il pannello di riepilogo
	 */
	public void refresh() {
		MRDA r = RDACenter.getInstance().getRDASelezionata(); 
		this.lblFornitoreSelezionato.setText(r.getPersistentModel().righeRDA.get(0).getDescription().getCatalogoFornitore().getName());
		float prezzo_totale = r.getPrezzoTotale();
		int quantita_totale = r.getQuantitaTotale();
		this.lblTotale.setText(String.valueOf(prezzo_totale));
		this.lblQuantita.setText(String.valueOf(quantita_totale));
		if (this.btnArrivata.getMouseListeners().length == 1) {
			this.btnArrivata.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					/*
					 * Funzionalità RDA confermata: caso d'uso invia RDA
					 */
				}

			});
		}
		this.validate();
		this.repaint();
		
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize(){
		this.addButton(this.btnArrivata, 14);
		this.setPreferredSize(new Dimension(ARiepilogoRDA.width,180));
		this.validate();
		this.repaint();
	}

}
