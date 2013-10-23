package GUI.Riepiloghi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import GUI.CoedilFrame;
import GUI.ProgrammaLavori;
import GUI.RDACenter;
import GUI.Abstract.ARiepilogoRDA;
import GUI.Card.CardRDA;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;


/**
 * 
 * @author francesco
 *
 * Gestisce il pannello di riepilogo posto in alto per RDA
 * congelate
 */
public class RiepilogoRDACongelata extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public RiepilogoRDACongelata(){
		super();
		this.initialize();
	}

	@Override
	/**
	 * Aggiorna il pannello preoccupandosi dei lstener dei bottoni di invia, elimina e salva RDA
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
		if (this.btnSalva.getMouseListeners().length == 1) {
			this.btnSalva.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("unchecked")
				@Override
				public void mouseClicked(MouseEvent e) {
					GestisciRDAHandler.getInstance().saveAndAddRDA(
							RDACenter.getInstance().getRDASelezionata());
					((CardRDA) RDACenter.getInstance().getLista().getPrimaCard()).setSaved(true);
					JOptionPane.showMessageDialog(null,
							"RDA salvata con successo!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter.getInstance().refreshCongelate();
				}

			});
		}
		if (this.btnElimina.getMouseListeners().length == 1) {
			this.btnElimina.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("unchecked")
				@Override
				public void mouseClicked(MouseEvent e) {
					Object[] options = { "Si", "No" };
					int n = JOptionPane.showOptionDialog(
							ProgrammaLavori.getInstance(),
							"Sicuro di voler eliminare la RDA?\n"
									+ "Nota: Questa operazione non è reversibile",
							"Conferma operazione",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[1]);
					if (n == JOptionPane.YES_OPTION) {
						GestisciRDAHandler.getInstance().deleteAndRemoveRDA(
								RDACenter.getInstance().getRDASelezionata());
						RDACenter.getInstance().refreshCongelate();
						PlicoRDA prda = PlicoRDA.getInstance();
						ListaRigheRDA lista_righe_rda = prda.getListaRigheRDA();
						lista_righe_rda.load(new ArrayList<Object>(RDACenter
								.getInstance().getRDASelezionata().righeRDA
								.getCollection()));
					}
				}
			});
		}
		if (this.btnInvia.getMouseListeners().length == 1) {
			this.btnInvia.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RDA temp = RDACenter.getInstance().getRDASelezionata();
					temp.setState(GestisciRDAHandler.ATTESA_CONFERMA);
					temp.setDate(new Date());
					((CardRDA) RDACenter.getInstance().getLista().getPrimaCard()).setSaved(true);
					GestisciRDAHandler.getInstance().saveAndAddRDA(temp);
					JOptionPane.showMessageDialog(null,
							"RDA inviata con successo!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter.getInstance().getClipPanel().getButtons().get(2).doClick();
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
		this.panel.remove(this.btnArrivata);
		this.validate();
		this.repaint();
	}

}
