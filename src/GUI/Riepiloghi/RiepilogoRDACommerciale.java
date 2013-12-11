package GUI.Riepiloghi;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.CommercialeCenter;
import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoCommerciale;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRDA;

/**
 * 
 * @author francesco
 * 
 *         Gestisce il pannello di riepilogo posto in alto per RDA in attesa
 *         conferma viste dal Commerciale
 */
public class RiepilogoRDACommerciale extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public RiepilogoRDACommerciale() {
		super();
		this.initialize();
	}

	@Override
	/**
	 * Aggiorna il pannello di riepilogo
	 */
	public void refresh() {
		MRDA r = CommercialeCenter.getInstance().getRDASelezionata();
		this.lblFornitoreSelezionato.setText(r.getPersistentModel().righeRDA
				.get(0).getDescription().getCatalogoFornitore().getName());
		float prezzo_totale = 0;
		int quantita_totale = 0;
		for (int i = 0; i < r.getPersistentModel().righeRDA.size(); ++i) {
			prezzo_totale += (r.getPersistentModel().righeRDA.get(i)
					.getQuantity() * r.getPersistentModel().righeRDA.get(i)
					.getDescription().getPrezzo());
			quantita_totale += r.getPersistentModel().righeRDA.get(i)
					.getQuantity();
		}
		this.lblTotale.setText(String.valueOf(prezzo_totale));
		this.lblQuantita.setText(String.valueOf(quantita_totale));

		this.btnConferma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionSuRDA(GestisciRDAHandler.CONFERMATA);
			}
		});

		this.btnRifiuta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionSuRDA(GestisciRDAHandler.RIFIUTATA);
			}
		});
		
		this.validate();
		this.repaint();

	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.addButton(btnConferma, 14);
		this.addButton(btnRifiuta, 16);
		this.setPreferredSize(new Dimension(ARiepilogoRDA.width, 200));
		this.validate();
		this.repaint();
	}
	
	/**
	 * Metodo che conferma o rifiuta l'RDA
	 * @param stato String
	 */
	protected void actionSuRDA(String stato) {
		CommercialeCenter c = CommercialeCenter.getInstance();
		c.getRDASelezionata().setDescrizione(PlicoCommerciale.getInstance().getNotaRDA().getNotaTxt());
		c.getRDASelezionata().setState(stato);
		c.getRDASelezionata().save();
		if(stato.equals("CONFERMATA"))
			JOptionPane.showMessageDialog(null, "RDA confermata con successo!","Conferma", JOptionPane.PLAIN_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "RDA rifiutata con successo!","Conferma", JOptionPane.PLAIN_MESSAGE);
		c.getLista().loadComm(GestisciRDAHandler.ATTESA_CONFERMA);
		PlicoCommerciale plico_com = PlicoCommerciale.getInstance();
		if(c.getLista().panelHasRDA()){
			c.getLista().getPrimaCard().getRiquadro().deselectAll();
			c.setRDASelezionata(GestisciRDAHandler.getInstance().getMRDAById(c.getLista().getPrimaRDA()));
			c.loadListaRigheRDA();
			plico_com.refreshNotaRDA();
		}
	}

}
