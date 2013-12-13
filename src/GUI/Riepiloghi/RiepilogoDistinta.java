package GUI.Riepiloghi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import GUI.ProgrammaLavoriCenter;
import GUI.Abstract.AClipPanel;
import GUI.Abstract.ARiepilogoDistinta;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoDistinta;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.controller.OttimizzatoreHandler;
import coedil99.model.MDistinta;

/**
 * Gestisce il riepilogo dei dati relativi al catalogo fornitore
 * 
 * @author Simone
 * 
 */
@SuppressWarnings("serial")
public class RiepilogoDistinta extends ARiepilogoDistinta {

	/**
	 * Costruttore
	 */
	public RiepilogoDistinta() {
		super();
		this.initialize();
	}

	@Override
	/**
	 * Metodo che si occupa di aggiornare i dati relativi alla distinta
	 */
	public void refresh() {
		if (ProgrammaLavoriCenter.getInstance().getCommessaSelezionata() != null) {
			final MDistinta d = new MDistinta(ProgrammaLavoriCenter.getInstance()
					.getCommessaSelezionata().getPersistentModel()
					.getDistinta().getID());
			this.cbOttimizzatore.removeAllItems();
			for (int i = 0; i < OttimizzatoreHandler.ottimizzatori.keySet()
					.size(); ++i)
				this.cbOttimizzatore.addItem(OttimizzatoreHandler.ottimizzatori
						.keySet().toArray()[i]);
			if (this.btnSalva.getMouseListeners().length == 1) {
				this.btnSalva.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MDistinta d = new MDistinta(ProgrammaLavoriCenter
								.getInstance().getCommessaSelezionata()
								.getPersistentModel().getDistinta().getID());
						GestisciCommessaHandler.getInstance().saveDistinta(d);
						JOptionPane.showMessageDialog(null,
								"Distinta salvata con successo!\n",
								"Conferma operazione",
								JOptionPane.INFORMATION_MESSAGE);
						ProgrammaLavoriCenter.getInstance().getClipPanel()
								.getButtons().get(2).doClick();
					}

				});
			}

			if (this.btnAdd.getMouseListeners().length == 1) {
				this.btnAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						PlicoDistinta.getInstance().addRiquadroRigaLavoro(null);
					}

				});
			}

			if (d.getPersistentModel().lavori.isEmpty())
				this.btnOttimizza.setEnabled(false);
			else {
				this.btnOttimizza.setEnabled(true);
				if (this.btnOttimizza.getMouseListeners().length == 1) {
					this.btnOttimizza.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							ottimizzaDistinta(d);
						}

					});

				}
			}

			this.validate();
			this.repaint();
		}
	}

	/**
	 * Metodo che inizializza la grafica
	 */
	private void initialize() {
		this.addButton(this.btnSalva, 14);
		this.addButton(this.btnAdd, 16);
		this.addButton(this.btnOttimizza, 18);
	}

	/**
	 * Metodo che permette di ottimizzare la distinta se quest'ultima non è già
	 * stata ottimizzata
	 * 
	 * @param d
	 *            {@link MDistinta}
	 */
	private void ottimizzaDistinta(final MDistinta d) {
		if (d.hasDdo()) {
			this.btnOttimizza.setEnabled(false);
			this.cbOttimizzatore.setEnabled(false);
		} else {
			this.btnOttimizza.setEnabled(true);
			this.cbOttimizzatore.setEnabled(true);
			this.btnOttimizza.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ProgrammaLavoriCenter pl = ProgrammaLavoriCenter.getInstance();
					Object[] options = { "Si", "No" };
					int n = JOptionPane
							.showOptionDialog(
									pl,
									"Il DDO non esiste.\nVuoi elaborare un'ottimizzazione "
											+ cbOttimizzatore.getSelectedItem()
											+ "?\n"
											+ "Nota: questa operazione non è reversibile",
									"Conferma operazione",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null,
									options, options[1]);
					if (n == JOptionPane.YES_OPTION) {
						GestisciCommessaHandler.getInstance().OttimizzaDistinta((String) cbOttimizzatore.getSelectedItem(),d);
						pl.checkDDO();
						pl.getClipPanel().getButtons().get(AClipPanel.PLButtonState.get("DDO")).doClick();
					}
				}
			});
		}

	}

	@Override
	public void setEdit(boolean edit) {
		this.btnOttimizza.setVisible(edit);
		this.btnAdd.setVisible(edit);
		this.btnSalva.setVisible(edit);
		this.addOttimizzata();
		this.cbOttimizzatore.setEnabled(edit);
	}

}
