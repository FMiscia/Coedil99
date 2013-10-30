package GUI.Riepiloghi;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import coedil99.persistentModel.RDA;
import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;


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
		this.panel.remove(this.btnSalva);
		this.panel.remove(this.btnElimina);
		this.panel.remove(this.btnInvia);
		this.setPreferredSize(new Dimension(ARiepilogoRDA.width,180));
		this.validate();
		this.repaint();
	}

}
