package GUI.Riepiloghi;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.Abstract.ARiepilogoRDA;
import GUI.Card.CardRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRDA;

/**
 * 
 * @author francesco
 * 
 *         Gestisce il pannello di riepilogo posto in alto per RDA in attesa
 *         conferma
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

		if (btnSposta.getActionListeners().length <= 1)
			btnSposta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MRDA temp = RDACenter.getInstance().getRDASelezionata();
					temp.getPersistentModel().setState(
							GestisciRDAHandler.CONGELATA);
					temp.getPersistentModel().setDate(new Date());
					((CardRDA) RDACenter.getInstance().getLista()
							.getPrimaCard()).setSaved(true);
					GestisciRDAHandler.getInstance().saveAndAddRDA(temp);
					JOptionPane.showMessageDialog(null,
							"RDA spostata in RDA congelate!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter
							.getInstance()
							.getClipPanel()
							.getButtons()
							.get(AClipPanel.RDAButtonState
									.get(GestisciRDAHandler.CONGELATA))
							.doClick();
				}
			});

		if (btnElimina.getActionListeners().length <= 1)
			btnElimina.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MRDA temp = RDACenter.getInstance().getRDASelezionata();
					GestisciRDAHandler.getInstance().deleteAndRemoveMRDA(temp);
					JOptionPane.showMessageDialog(null,
							"RDA eliminata con successo!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter
							.getInstance()
							.getClipPanel()
							.getButtons()
							.get(AClipPanel.RDAButtonState
									.get(GestisciRDAHandler.RIFIUTATA))
							.doClick();

				}
			});

		this.validate();
		this.repaint();

	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.addButton(this.btnSposta, 14);
		this.addButton(this.btnElimina, 16);
		this.setPreferredSize(new Dimension(ARiepilogoRDA.width, 200));
		this.validate();
		this.repaint();
	}

}
