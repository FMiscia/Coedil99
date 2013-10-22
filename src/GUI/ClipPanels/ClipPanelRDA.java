package GUI.ClipPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.FormRDA.CreaFormRDA;
import GUI.FormRDA.CreaFormRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;

/**
 * 
 * @author francesco
 * 
 * Implementazione di ACLipPanel per il menù in alto dell'RDA Center
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

	/**
	 * Imposta il focus sul bottone delle RDA congelate
	 */
	public void focusToRDACongelate() {
		this.focusOut();
		JButton b = (JButton) ClipPanelRDA.this.getComponent(1);
		b.setBackground(new Color(180, 180, 180));
	}

	/**
	 * Fornisce true o false a seconda se, nel caso ci trovassimo su Crea RDA, stiamo 
	 * andando in focus su altri bottoni (RDA Congelate,Confermate, Menù)
	 * 
	 * @return bool:boolean
	 */
	private boolean clickFromNuovaRDA() {
		if (ClipPanelRDA.this.isButtonFocused((JButton) ClipPanelRDA.this
				.getButtons().get(4))) {
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
	 * Fornisce true se siamo in focus sul bottone delle RDA Congelate
	 * @return bool:boolean
	 */
	public boolean isSelectedCongelate() {
		JButton b = (JButton) ClipPanelRDA.this.getButtons().get(1);
		return this.isButtonFocused(b);
	}

	/**
	 * Fornisce true se siamo in focus sul bottone delle RDA Attesa Conferma
	 * @return bool:boolean
	 */
	public boolean isSelectedAttesa() {
		JButton b = (JButton) ClipPanelRDA.this.getButtons().get(2);
		return this.isButtonFocused(b);
	}

	/**
	 * Aggiorna le notifiche: Il metodo viene chiamato dal controllore delle RDA quando 
	 * nasce un notify() per il pattern Observer
	 */
	public void updateNotifiche() {
		String AttesaSize = String.valueOf(GestisciRDAHandler.getInstance()
				.getArrayRDA(GestisciRDAHandler.ATTESA_CONFERMA).size());
		String ConfermateSize = String.valueOf(GestisciRDAHandler.getInstance()
				.getArrayRDA(GestisciRDAHandler.CONFERMATA).size());
		this.AddNotificaLabel(AttesaSize, GestisciRDAHandler.ATTESA_CONFERMA);
		this.AddNotificaLabel(ConfermateSize, GestisciRDAHandler.CONFERMATA);
		this.validate();
		this.repaint();

	}

	/**
	 * Fornisce true se siamo in focus sul bottone delle RDA Confermate
	 * @return bool:boolean
	 */
	public boolean isSelectedConfermate() {
		JButton b = (JButton) ClipPanelRDA.this.getButtons().get(3);
		return this.isButtonFocused(b);
	}

	/**
	 * Fornisce true se siamo in focus sul bottone di Nuova RDA
	 * @return bool:boolean
	 */
	public boolean isSelectedNuova() {
		JButton b = (JButton) ClipPanelRDA.this.getButtons().get(4);
		return this.isButtonFocused(b);

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
						PanelStart pl = new PanelStart();
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});

		this.addButton("RDA Congelate", "Visualizza le RDA Congelate",
				new ActionListener() {
					@SuppressWarnings("unchecked")
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
						ListaRigheRDA lista_righe_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						lista_righe_rda.getPanel().removeAll();
						lista_righe_rda.load(new ArrayList<Object>(rdac
								.getRDASelezionata().righeRDA.getCollection()));
						lista_righe_rda.validate();
						lista_righe_rda.repaint();

					}
				});

		this.addButton("RDA Attesa", "Visualizza le RDA in attesa conferma",
				new ActionListener() {
					@SuppressWarnings("unchecked")
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
						ListaRigheRDA lista_righe_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						lista_righe_rda.getPanel().removeAll();
						lista_righe_rda.load(new ArrayList<Object>(rdac
								.getRDASelezionata().righeRDA.getCollection()));
						lista_righe_rda.getPanel().validate();
						lista_righe_rda.getPanel().repaint();
					}
				});

		this.addButton("RDA Confermate",
				"Visualizza le RDA confermate dall'ufficio tecnico",
				new ActionListener() {
					@SuppressWarnings("unchecked")
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
						rdac.getLista().load(GestisciRDAHandler.CONFERMATA);
						rdac.setRDASelezionata(GestisciRDAHandler.getInstance()
								.getRDAById(rdac.getLista().getPrimaRDA()));

						BorderLayout layout = (BorderLayout) prda.getLayout();
						if (layout.getLayoutComponent(BorderLayout.CENTER) != null)
							prda.remove(layout
									.getLayoutComponent(BorderLayout.CENTER));
						ListaRigheRDA lista_righe_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						lista_righe_rda.getPanel().removeAll();
						lista_righe_rda.load(new ArrayList<Object>(rdac
								.getRDASelezionata().righeRDA.getCollection()));
						lista_righe_rda.getPanel().validate();
						lista_righe_rda.getPanel().repaint();
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
}
