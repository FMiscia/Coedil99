package GUI.Riepiloghi;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

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

public class RiepilogoRDACongelata extends ARiepilogoRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RiepilogoRDACongelata(){
		super();
		this.panel.remove(this.btnArrivata);
		this.validate();
		this.repaint();
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
		if (this.btnSalva.getMouseListeners().length == 1) {
			this.btnSalva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GestisciRDAHandler.getInstance().saveAndAddRDA(
							RDACenter.getInstance().getRDASelezionata());
					((CardRDA) RDACenter.getInstance().getLista().getPrimaCard()).setSaved(true);
					JOptionPane.showMessageDialog(null,
							"RDA salvata con successo!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter rdac = RDACenter.getInstance();
					ListaRDA listarda = (ListaRDA) ListaRDAFactory
							.getInstance().makeLista(GestisciRDAHandler.CONGELATA);
					rdac.setLista(listarda);

					rdac.setRDASelezionata(GestisciRDAHandler.getInstance()
							.getRDAById(
									RDACenter.getInstance().getLista()
											.getPrimaRDA()));

					PlicoRDA prda = PlicoRDA.getInstance();
					ListaRigheRDA lista_rda = prda.getListaRigheRDA();
					prda.resetFormRDA();
					lista_rda.getPanel().removeAll();
					lista_rda.load(new ArrayList<Object>(rdac
							.getRDASelezionata().righeRDA.getCollection()));

					rdac.getClipPanel().focusToRDACongelate();
					lista_rda.validate();
					lista_rda.repaint();
				}

			});
		}
		if (this.btnElimina.getMouseListeners().length == 1) {
			this.btnElimina.addMouseListener(new MouseAdapter() {
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
						ListaRDA listarda = (ListaRDA) ListaRDAFactory
								.getInstance().makeLista(GestisciRDAHandler.CONGELATA);
						RDACenter.getInstance().setLista(listarda);
						PlicoRDA prda = PlicoRDA.getInstance();
						ListaRigheRDA lista_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						listarda.getPanel().removeAll();
						listarda.load(RDACenter.getInstance().getRDASelezionata().getState());
						RDACenter.getInstance().setRDASelezionata(
								GestisciRDAHandler.getInstance().getRDAById(
										listarda.getPrimaRDA()));
						lista_rda.getPanel().removeAll();
						lista_rda.load(new ArrayList<Object>(RDACenter
								.getInstance().getRDASelezionata().righeRDA
								.getCollection()));
						lista_rda.validate();
						lista_rda.repaint();
						listarda.validate();
						listarda.repaint();
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

}
