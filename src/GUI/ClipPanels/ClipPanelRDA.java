package GUI.ClipPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.orm.PersistentException;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.FormRDA.CreaFormRDA;
import GUI.FormRDA.CreaFormRDAFactory;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;

public class ClipPanelRDA extends AClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
						if (!RDACenter.getInstance().getLista()
								.isPrimaRDASaved()
								&& !ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;

						}
						ClipPanelRDA.this.focusOut();
						b.setBackground(new Color(180, 180, 180));
						RDACenter rdac = RDACenter.getInstance();
						rdac.getLista().svuota();
						rdac.getLista().load(GestisciRDAHandler.CONGELATA);
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
						if (!RDACenter.getInstance().getLista()
								.isPrimaRDASaved()
								&& !ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;

						}
						ClipPanelRDA.this.focusOut();
						b.setBackground(new Color(180, 180, 180));

						PlicoRDA prda = PlicoRDA.getInstance();
						prda.getListaRigheRDA().svuota();

						RDACenter rdac = RDACenter.getInstance();
						rdac.getLista().svuota();
						rdac.getLista()
								.load(GestisciRDAHandler.ATTESA_CONFERMA);
						rdac.setRDASelezionata(GestisciRDAHandler.getInstance()
								.getRDAById(rdac.getLista().getPrimaRDA()));

						BorderLayout layout = (BorderLayout) prda.getLayout();
						if (layout.getLayoutComponent(BorderLayout.CENTER) != null)
							prda.remove(layout
									.getLayoutComponent(BorderLayout.CENTER));
						ListaRigheRDA lista_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						lista_rda.getPanel().removeAll();
						lista_rda.load(new ArrayList<Object>(rdac
								.getRDASelezionata().righeRDA.getCollection()));
						lista_rda.getPanel().validate();
						lista_rda.getPanel().repaint();
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

	public void focusToRDACongelate() {
		this.focusOut();
		JButton b = (JButton) ClipPanelRDA.this.getComponent(1);
		b.setBackground(new Color(180, 180, 180));
	}

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

	public boolean isSelectedCongelate() {
		JButton b = (JButton) ClipPanelRDA.this.getComponent(1);
		return this.isButtonFocused(b);
	}

	public boolean isSelectedAttesa() {
		JButton b = (JButton) ClipPanelRDA.this.getComponent(2);
		return this.isButtonFocused(b);
	}
}
