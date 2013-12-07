package GUI.Abstract;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;

/**
 * 
 * @author francesco
 * 
 *         Gestisce i riquadri del programma lavoro contenuti nei vari plichi
 *         (distinta,commessa,ddo)
 */
@SuppressWarnings("serial")
public abstract class AFormDistinta extends JPanel {

	protected ArrayList<JTextField> Container;
	protected boolean aperto;
	protected Object oggetto;
	protected ArrayList<JLabel> Label;
	protected JLabel lblTitolo;
	protected JPanel form;

	public AFormDistinta() {
		super();
		this.initialize();
	}

	/**
	 * Rende gli elementi del riquadro editabili su richiesta
	 * 
	 * @param editable
	 *            :boolean
	 */
	public void makeEditable(boolean editable) {
		for (JTextField i : this.Container) {
			if (!editable) {
				i.setBackground(Color.getColor("textInactiveText"));
				i.setBorder(new LineBorder(Color.gray));
				aperto = true;
			} else {
				controlloErrori();
				aperto = false;

			}
			i.setEditable(editable);
		}
		for (JLabel j : this.Label) {
			if (!editable) {
				j.setVisible(false);
			} else {
				j.setVisible(true);
			}
		}
		this.validate();
		this.repaint();
	}


	/**
	 * Riabilita i listener dai bottoni dei riquadri
	 */
	public void enableEditing() {
					if (aperto) {
						aperto = false;
						AFormDistinta.this.makeEditable(true);
					} else {
						AFormDistinta.this.salva(true);
						aperto = true;
						AFormDistinta.this.makeEditable(false);
					}
		validate();
		repaint();
	}

	/**
	 * Carica un riquadro
	 * 
	 * @param o
	 *            :Object
	 */
	public abstract void load(Object o);

	/**
	 * Elimina i contenuti delle textField dei riquadri
	 */
	protected void resetRiquadro() {
		if (this.Container.size() != 0) {
			for (JTextField txt : Container)
				txt.setText("");
		}
	}

	/**
	 * Salva il riquadro
	 * 
	 * @param showmex
	 *            : se si vuole mostrare il messaggio di avvenuto salvataggio
	 */
	public abstract void salva(boolean showmex);

	/**
	 * Controllo degli errori di input
	 */
	public boolean controlloErrori() {
		boolean test = true;
		for (JLabel j : this.Label) {
			if (j.getIcon() != null
					&& j.getIcon().equals(ConfigGUI.getErrorIcon()))
				test = false;
		}
		if (test) 
			enableEditing();
		return test;
	}


	/**
	 * Cambia il colore del testo nei campi non abilitati mettendolo più scuro
	 */
	public void changeUnableColor(JTextField x) {
		x.setDisabledTextColor(Color.BLACK);
		x.validate();
		x.repaint();
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.form = new JPanel();
		this.aperto = true;
		this.oggetto = null;
		this.Container = new ArrayList<JTextField>();
		this.Label = new ArrayList<JLabel>();
		setLayout(null);
		setSize(600, 330);
		setPreferredSize(new Dimension(600, 280));
	}

	/**
	 * Controlla se almeno un campo del riquadro è vuoto
	 * 
	 * @return
	 */
	public boolean checkEmpty() {
		boolean test = true;
		for (JTextField temp : this.Container) {
			if (!temp.isEnabled());
			else if (temp.getText().length() <= 0) {
				test = false;
			}
		}
		return test;
	}

	public boolean modify() {
		return aperto;
	}

	public Object getOggetto() {
		return oggetto;
	}

	public void setOggetto(Object oggetto) {
		this.oggetto = oggetto;
	}

	public ArrayList<JLabel> getLabel() {
		return Label;
	}

	public void svuotaIconeLAbel() {
		for (JLabel temp : this.Label)
			temp.setIcon(null);

	}

}
