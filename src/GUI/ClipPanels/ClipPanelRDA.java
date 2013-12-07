package GUI.ClipPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JToggleButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.Form.CreaFormRDA;
import GUI.Form.CreaFormRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Panels.NotaRDA;
import GUI.Panels.NotaRDAFactory;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;

/**
 * 
 * @author francesco
 * 
 *         Implementazione di ACLipPanel per il menù in alto dell'RDA Center
 */
public class ClipPanelRDA extends AClipPanel {

	/**
         * 
         */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public ClipPanelRDA() {
		super();
		this.initialize();

	}

//	/**
//	 * Imposta il focus sul bottone delle RDA congelate
//	 */
//	public void focusToRDACongelate() {
//		this.focusOut();
//		JToggleButton b = (JToggleButton) ClipPanelRDA.this
//				.getComponent(AClipPanel.RDAButtonState
//						.get(GestisciRDAHandler.CONGELATA));
//		b.setBackground(new Color(180, 180, 180));
//	}

	/**
	 * Fornisce true o false a seconda se, nel caso ci trovassimo su Crea RDA,
	 * stiamo andando in focus su altri bottoni (RDA Congelate,Confermate, Menù)
	 * 
	 * @return bool:boolean
	 */
	private boolean clickFromNuovaRDA() {
		if (ClipPanelRDA.this.isButtonFocused((JToggleButton) ClipPanelRDA.this
				.getButtons().get(AClipPanel.RDAButtonState.get("NUOVA")))) {
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

	/**
	 * Aggiorna le notifiche: Il metodo viene chiamato dal controllore delle RDA
	 * quando nasce un notify() per il pattern Observer
	 */
	public void updateNotifiche() {
		String AttesaSize = String.valueOf(GestisciRDAHandler.getInstance()
				.getArrayMRDA(GestisciRDAHandler.ATTESA_CONFERMA).size());
		String ConfermateSize = String.valueOf(GestisciRDAHandler.getInstance()
				.getArrayMRDA(GestisciRDAHandler.CONFERMATA).size());
		String RifiutateSize = String.valueOf(GestisciRDAHandler.getInstance()
				.getArrayMRDA(GestisciRDAHandler.RIFIUTATA).size());
		this.AddNotificaLabel(AttesaSize, GestisciRDAHandler.ATTESA_CONFERMA);
		this.AddNotificaLabel(ConfermateSize, GestisciRDAHandler.CONFERMATA);
		this.AddNotificaLabel(RifiutateSize, GestisciRDAHandler.RIFIUTATA);
		this.validate();
		this.repaint();

	}

	/**
	 * Imposta la grafica e i bottoni
	 */
	private void initialize() {
		this.addButton("Menu", "Torna al menu principale",
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;
						}
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = PanelStart.getInstance();
						pl.resetInitialState();
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});

		this.addButton("RDA Congelate", "Visualizza le RDA Congelate",
				new ActionListener() {
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0) {
						JToggleButton b = (JToggleButton) arg0.getSource();
						if (!RDACenter.getInstance().getLista()
								.isPrimaRDASaved()
								&& !ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;

						}
						ClipPanelRDA.this.focusOut();
						b.setSelected(true);
						RDACenter rdac = RDACenter.getInstance();
						rdac.refreshCongelate();
					}
				});

		this.addButton("RDA Attesa", "Visualizza le RDA in attesa conferma",
				new ActionListener() {
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0) {

						JToggleButton b = (JToggleButton) arg0.getSource();
						if (!RDACenter.getInstance().getLista()
								.isPrimaRDASaved()
								&& !ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;

						}
						ClipPanelRDA.this.focusOut();
						//b.setBackground(new Color(180, 180, 180));
						b.setSelected(true);
						PlicoRDA prda = PlicoRDA.getInstance();
						prda.getListaRigheRDA().svuota();
						prda.resetFormRDA();
						RDACenter rdac = RDACenter.getInstance();
						rdac.getLista().svuota();
						rdac.getLista()
								.load(GestisciRDAHandler.ATTESA_CONFERMA);
						if (rdac.getLista().getPrimaCard() != null) {
							rdac.setRDASelezionata(GestisciRDAHandler
									.getInstance().getMRDAById(
											rdac.getLista().getPrimaRDA()));

							BorderLayout layout = (BorderLayout) prda
									.getLayout();
							if (layout.getLayoutComponent(BorderLayout.CENTER) != null)
								prda.remove(layout
										.getLayoutComponent(BorderLayout.CENTER));
							ListaRigheRDA lista_righe_rda = prda
									.getListaRigheRDA();
							
							lista_righe_rda.getPanel().removeAll();
							lista_righe_rda.load(new ArrayList<Object>(
									rdac.getRDASelezionata()
											.getPersistentModel().righeRDA
											.getCollection()));
							lista_righe_rda.getPanel().validate();
							lista_righe_rda.getPanel().repaint();
						}
					}
				});

		this.addButton("RDA Rifiutate",
				"Visualizza le RDA confermate dall'ufficio commerciale",
				new ActionListener() {
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0) {
						JToggleButton b = (JToggleButton) arg0.getSource();
						if (!RDACenter.getInstance().getLista()
								.isPrimaRDASaved()
								&& !ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;

						}
						ClipPanelRDA.this.focusOut();
						//b.setBackground(new Color(180, 180, 180));
						b.setSelected(true);
						PlicoRDA prda = PlicoRDA.getInstance();
						prda.getListaRigheRDA().svuota();
						prda.resetFormRDA();
						RDACenter rdac = RDACenter.getInstance();
						rdac.getLista().svuota();
						rdac.getLista().load(GestisciRDAHandler.RIFIUTATA);
						if (rdac.getLista().getPrimaCard() != null) {
							rdac.setRDASelezionata(GestisciRDAHandler
									.getInstance().getMRDAById(
											rdac.getLista().getPrimaRDA()));

							BorderLayout layout = (BorderLayout) prda
									.getLayout();
							if (layout.getLayoutComponent(BorderLayout.CENTER) != null)
								prda.remove(layout
										.getLayoutComponent(BorderLayout.CENTER));
							ListaRigheRDA lista_righe_rda = prda
									.getListaRigheRDA();
							lista_righe_rda.getPanel().removeAll();
							lista_righe_rda.load(new ArrayList<Object>(
									rdac.getRDASelezionata()
											.getPersistentModel().righeRDA
											.getCollection()));
							lista_righe_rda.getPanel().validate();
							lista_righe_rda.getPanel().repaint();
							NotaRDA nota = (NotaRDA) NotaRDAFactory
									.getInstance().makeNotaRDA();
							prda.addNotaRDA(nota);
						}
					}
				});
		this.addButton("RDA Confermate",
				"Visualizza le RDA confermate dall'ufficio commerciale",
				new ActionListener() {
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0) {

						JToggleButton b = (JToggleButton) arg0.getSource();
						if (!RDACenter.getInstance().getLista()
								.isPrimaRDASaved()
								&& !ClipPanelRDA.this.clickFromNuovaRDA()) {
							return;

						}
						ClipPanelRDA.this.focusOut();
						//b.setBackground(new Color(180, 180, 180));
						b.setSelected(true);
						PlicoRDA prda = PlicoRDA.getInstance();
						prda.getListaRigheRDA().svuota();
						prda.resetFormRDA();
						RDACenter rdac = RDACenter.getInstance();
						rdac.getLista().svuota();
						rdac.getLista().load(GestisciRDAHandler.CONFERMATA);
						if (rdac.getLista().getPrimaCard() != null) {
							rdac.setRDASelezionata(GestisciRDAHandler
									.getInstance().getMRDAById(
											rdac.getLista().getPrimaRDA()));

							BorderLayout layout = (BorderLayout) prda
									.getLayout();
							if (layout.getLayoutComponent(BorderLayout.CENTER) != null)
								prda.remove(layout
										.getLayoutComponent(BorderLayout.CENTER));
							ListaRigheRDA lista_righe_rda = prda
									.getListaRigheRDA();
							lista_righe_rda.getPanel().removeAll();
							lista_righe_rda.load(new ArrayList<Object>(
									rdac.getRDASelezionata()
											.getPersistentModel().righeRDA
											.getCollection()));
							lista_righe_rda.getPanel().validate();
							lista_righe_rda.getPanel().repaint();
							NotaRDA nota = (NotaRDA) NotaRDAFactory
									.getInstance().makeNotaRDA();
							nota.removeButtons();
							prda.addNotaRDA(nota);
						}
					}
				});
		this.addButton("Nuova RDA", "Crea una nuova RDA", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipPanelRDA.this.focusOut();
				JToggleButton b = (JToggleButton) arg0.getSource();
				//b.setBackground(new Color(180, 180, 180));
				b.setSelected(true);
				PlicoRDA prda = PlicoRDA.getInstance();
				prda.reset();
				CreaFormRDA form = (CreaFormRDA) CreaFormRDAFactory
						.getInstance().makeFormRDA();
				prda.addFormRDA(form);
				prda.resetNotaRDA();
			}
		});

		this.fill();
		this.resetInitialState();
	}

	/**
	 * Fornisce true se siamo in focus sul bottone delle RDA passato come
	 * parametro
	 * 
	 * @param s
	 *            identifica il button da controllate
	 * @return bool:boolean
	 */
	public boolean isSelected(String s) {
		JToggleButton b = (JToggleButton) ClipPanelRDA.this.getButtons().get(
				AClipPanel.RDAButtonState.get(s));
		return this.isButtonFocused(b);
	}

}