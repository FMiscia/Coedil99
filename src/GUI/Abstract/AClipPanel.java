package GUI.Abstract;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import GUI.CoedilFrame;
import GUI.ConfigGUI;
import GUI.LoginPanel;
import GUI.PanelStart;
import coedil99.controller.GestisciDipendenteHandler;
import coedil99.controller.GestisciRDAHandler;

/**
 * Classe astratta per la realizzazione del menu contestuale
 * 
 * @author Simone
 * 
 */

public abstract class AClipPanel extends JPanel {

	/**
	 * Hash Map che associa i possibili stati di una rda con il pulsante
	 * relativo nel menu
	 */
	public static HashMap<String, Integer> RDAButtonState;
	{
		RDAButtonState = new HashMap<String, Integer>();
		RDAButtonState.put(GestisciRDAHandler.CONFERMATA, 4);
		RDAButtonState.put(GestisciRDAHandler.ATTESA_CONFERMA, 2);
		RDAButtonState.put(GestisciRDAHandler.CONGELATA, 1);
		RDAButtonState.put(GestisciRDAHandler.CONGELATA, 1);
		RDAButtonState.put("NUOVA", 5);
		RDAButtonState.put(GestisciRDAHandler.RIFIUTATA, 3);
	}

	public static HashMap<String, Integer> PLButtonState;
	{
		PLButtonState = new HashMap<String, Integer>();
		PLButtonState.put("COMMESSA", 1);
		PLButtonState.put("DISTINTA", 2);
		PLButtonState.put("DDO", 3);
		PLButtonState.put("NUOVA", 4);
	}

	private static final long serialVersionUID = 1L;

	private ArrayList<JToggleButton> buttons = new ArrayList<JToggleButton>();

	/**
	 * Costruttore: imposta i parametri standard dei clip panel
	 */
	public AClipPanel() {
		this.initialize();

	}

	/**
	 * Metodo che aggiunge un nuovo bottone al clipPanel
	 * 
	 * @param label
	 *            : Stringa che dovrà contenere il bottone
	 * @param ToolTip
	 *            : Testo per il tooltip del bottone
	 * @param click
	 *            : ActionListener del bottone
	 */
	public void addButton(String label, String ToolTip, ActionListener click) {
		JToggleButton temp = new JToggleButton();
		temp.setLayout(new BorderLayout());
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.addActionListener(click);
		temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		temp.setFocusPainted(false);
		temp.setSelected(false);
		JLabel nome = new JLabel(label);
		temp.add(nome, BorderLayout.WEST);
		this.buttons.add(temp);
		this.add(temp);
		this.validate();
		this.repaint();
	}

	/**
	 * Metodo che aggiunge una label contenente le notifiche
	 * 
	 * @param value
	 *            : Stringa contenente il numero della notifica
	 * @param RDAState
	 *            : Stringa contenente lo stato dell'RDA, serve per selezionare
	 *            il bottone specifico
	 */
	protected void AddNotificaLabel(String value, String RDAState) {
		JLabel notifica = new JLabel(value);
		notifica.setHorizontalAlignment(SwingConstants.RIGHT);
		if (this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState))
				.getComponentCount() != 1)
			this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState))
					.remove(1);
		this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState))
				.add(notifica, BorderLayout.EAST);
	}

	/**
	 * Metodo per la creazione del bottone
	 * 
	 * @param label
	 *            : Stringa che dovr� contenere il bottone
	 * @param ToolTip
	 *            : Testo per il tooltip del bottone
	 * @return bottone creato
	 */
	public JToggleButton createButton(String label, String ToolTip) {
		JToggleButton temp = new JToggleButton(label);
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return temp;

	}

	/**
	 * Metodo che aggiunge delle label per mantenere fissa la dimensione dei
	 * bottoni sul clip panel
	 * 
	 */
	public void addLabel() {
		JLabel temp = new JLabel();
		this.add(temp);
		this.validate();
		this.repaint();
	}

	/**
	 * Metodo che aggiunge i bottoni di help e chiusura mantenendoli di
	 * dimensione fissa usando addLabel()
	 * 
	 */
	public void fill() {
		for (int n = ConfigGUI.getInstance().getNumBottoniClipPanel()
				- this.getComponentCount(); n > 0; n--) {
			if (n <= ConfigGUI.getInstance().getNumBottoniClipPanel() && n != 2 && n != 1)
				this.addLabel();
			if (n == 3)
				this.addButton("Help", "Help", null);
			if (n == 2)
				this.addButton("Logout", "Logout", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						GestisciDipendenteHandler.getInstance().logOut();
						PanelStart.getInstance().getClipPanel()
								.changeButtonLogState();
						CoedilFrame.getInstance().montaPanel(
								LoginPanel.getInstance());
					}

				});

			if (n == 1)
				this.addButton("Exit", "Close Coedil99", new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
		}
	}

	/**
	 * Metodo che cambia colore ai bottoni quando non sono selezionati, reset al
	 * loro colore di dafault
	 * 
	 */
	public void focusOut() {
		for (JToggleButton b : this.buttons) {
			b.setSelected(false);
			b.setEnabled(true);
		}
	}

	/**
	 * Metodo che controlla se un bottone è selezionato
	 * 
	 * @param b
	 *            : Bottone
	 * @return booleano
	 */
	public Boolean isButtonFocused(JToggleButton b) {
		return b.isSelected();
	}

	/**
	 * Metodo che deseleziona tutti i bottoni e seleziona il primo nel clipPanel
	 * 
	 */
	public void resetInitialState() {
		this.focusOut();
		this.getButtons().get(1).setSelected(true);
	}

	/**
	 * Get per bottoni
	 * 
	 * @return l'array bottoni
	 */
	public ArrayList<JToggleButton> getButtons() {
		return buttons;
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setLayout(new GridLayout(1, 0));
		this.setPreferredSize(new Dimension(210, 40));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}

}
