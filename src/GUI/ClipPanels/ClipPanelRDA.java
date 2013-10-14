package GUI.ClipPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;
import coedil99.model.RDAFactory;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.ProgrammaLavori;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import GUI.FormRDA.CreaFormRDA;
import GUI.FormRDA.CreaFormRDAFactory;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;

public class ClipPanelRDA extends AClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean clickFromNuovaRDA() {
		if (ClipPanelRDA.this.isButtonFocused((JButton) ClipPanelRDA.this
				.getComponent(3))) {
			Object[] options = { "Si", "No" };
			int n = JOptionPane.showOptionDialog(null,
					"Sicuro di voler abbandonare la creazione RDA?\n"
							+ "Nota: Le modifiche non salvate andranno perse",
					"Conferma operazione", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if (n == JOptionPane.YES_OPTION) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public ClipPanelRDA() {
		super();
		this.addButton("Menu", "Torna al menu principale",
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JButton b = (JButton) arg0.getSource();
						if (!ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;
						}
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = new PanelStart(cf);
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);

					}
				});

		this.addButton("RDA Congelate", "Visualizza le RDA Congelate",
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						JButton b = (JButton) arg0.getSource();
						if (!ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;
						}
						ClipPanelRDA.this.focusOut();
						b.setBackground(new Color(180, 180, 180));
						RDACenter rdac = RDACenter.getInstance();
						ListaRDA listarda = (ListaRDA) ListaRDAFactory
								.getInstance().makeLista();
						rdac.setLista(listarda);
						rdac.setRDASelezionata(GestisciRDAHandler.getInstance()
								.getRDAById(rdac.getLista().getPrimaRDA()));
						PlicoRDA prda = PlicoRDA.getInstance();
						ListaRigheRDA lista_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						lista_rda.getPanel().removeAll();
						lista_rda.load(new ArrayList<Object>(rdac
								.getRDASelezionata().righeRDA.getCollection()));
						lista_rda.validate();
						lista_rda.repaint();

					}
				});

		this.addButton("RDA Attesa", "Visualizza le RDA in attesa conferma",
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						JButton b = (JButton) arg0.getSource();
						if (!ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;
						}
						ClipPanelRDA.this.focusOut();
						b.setBackground(new Color(180, 180, 180));
						PlicoRDA prda = PlicoRDA.getInstance();
						prda.getListaRigheRDA().svuota();
						RDACenter rdac = RDACenter.getInstance();
						rdac.getLista().svuota();
						BorderLayout layout = (BorderLayout) prda.getLayout();
						if (layout.getLayoutComponent(BorderLayout.CENTER) != null)
							prda.remove(layout
									.getLayoutComponent(BorderLayout.CENTER));
						prda.validate();
						prda.repaint();
					}
				});

		this.addButton("Nuova RDA", "Crea una nuova RDA", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipPanelRDA.this.focusOut();
				JButton b = (JButton) arg0.getSource();
				b.setBackground(new Color(180, 180, 180));
				PlicoRDA prda = PlicoRDA.getInstance();
				prda.getListaRigheRDA().svuota();
				CreaFormRDA form = (CreaFormRDA) CreaFormRDAFactory
						.getInstance().makeFormRDA();
				prda.addFormRDA(form);
			}
		});

		this.fill();
		this.resetInitialState();
	}

	public void focusToRDACongelate(){
		this.focusOut();
		JButton b = (JButton) ClipPanelRDA.this.getComponent(1);
		b.setBackground(new Color(180,180,180));
	}
}
