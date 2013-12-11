package GUI.Abstract;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;
import javax.swing.ImageIcon;

/**
 * 
 * @author francesco
 * 
 *         Gestisce i riquadri del programma lavoro contenuti nei vari plichi
 *         (distinta,commessa,ddo)
 */
@SuppressWarnings("serial")
public abstract class ARiquadro extends JPanel {

	protected ArrayList<JTextField> Container;
	protected JButton modifica;
	protected boolean aperto;
	protected Object oggetto;
	protected ArrayList<JLabel> Label;
	protected JLabel lblTitolo;
	protected JPanel form;

	public ARiquadro(String title) {
		super();
		this.initialize(title);
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
				//ARiquadro.this.modifica.setText("modifica");
				modifica.setIcon(ConfigGUI.getEditIcon());
				aperto = true;
			} else {
				//ARiquadro.this.modifica.setText("salva");
				modifica.setIcon(ConfigGUI.getSaveIcon());
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
	 * Elimina i listener dai bottoni dei riquadri
	 */
	public void avoidEditing(boolean otherButtonstoo) {
		this.modifica.setEnabled(false);
		if(modifica.getMouseListeners().length != 1)
			ARiquadro.this.modifica.removeMouseListener(modifica.getMouseListeners()[1]);
		this.validate();
		this.repaint();
	}

	/**
	 * Riabilita i listener dai bottoni dei riquadri
	 */
	public void enableEditing() {
		this.modifica.setEnabled(true);
		if (this.modifica.getMouseListeners().length == 1)
			this.modifica.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (aperto) {
						//ARiquadro.this.modifica.setText("salva");
						modifica.setIcon(ConfigGUI.getSaveIcon());
						aperto = false;
						ARiquadro.this.makeEditable(true);
					} else {
						ARiquadro.this.salva(true);
						//ARiquadro.this.modifica.setText("modifica");
						modifica.setIcon(ConfigGUI.getEditIcon());
						aperto = true;
						ARiquadro.this.makeEditable(false);
					}
				}
			});
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
		if (test) {
			enableEditing();
		} else {
			avoidEditing(false);
		}
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
	private void initialize(String title) {
		this.form = new JPanel();
		this.aperto = true;
		this.oggetto = null;
		this.Container = new ArrayList<JTextField>();
		this.Label = new ArrayList<JLabel>();
		setLayout(null);
		setSize(600, 330);
		setPreferredSize(new Dimension(600, 280));
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 3));
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(ConfigGUI.getColoreBordoCard());
		separator.setBounds(0, 31, 600, 2);
		add(separator);

		lblTitolo = new JLabel(title);
		lblTitolo.setPreferredSize(new Dimension(60, 32));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		lblTitolo.setBounds(0, 1, 143, 31);
		add(lblTitolo);

		this.modifica = new JButton();
		modifica.setOpaque(false);
		modifica.setFocusPainted(false);
		modifica.setBorderPainted(false);
		this.modifica.setContentAreaFilled(false);
		modifica.setPreferredSize(new Dimension(32, 32));
		modifica.setIcon(ConfigGUI.getEditIcon());
		this.modifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aperto) {
					//ARiquadro.this.modifica.setText("salva");
					modifica.setIcon(ConfigGUI.getSaveIcon());
					aperto = false;
					ARiquadro.this.makeEditable(true);
				} else {
					ARiquadro.this.salva(true);
					//ARiquadro.this.modifica.setText("modifica");
					modifica.setIcon(ConfigGUI.getEditIcon());
					aperto = true;
					ARiquadro.this.makeEditable(false);
				}
				validate();
				repaint();
			}
		});
		this.modifica.setSize(32, 32);
		this.modifica.setLocation(500, 0);
		add(this.modifica);
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

	protected abstract void initialize();

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

	/**
	 * Elimina dal riquadro il bottone di modifica
	 */
	public void deleteButtons() {
		this.remove(this.modifica);
		this.validate();
		this.repaint();
	}

}
