package GUI.Abstract;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;
import GUI.Form.FormDistinta;
import GUI.Plichi.PlicoDistinta;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

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
	protected JButton salva;
	protected boolean aperto;
	protected Object oggetto;
	protected ArrayList<JLabel> Label;
	protected JLabel lblTitolo;
	protected JPanel form;
	protected JLabel lbbase;
	protected JTextField tfbase;
	protected JLabel lbaltezza;
	protected JTextField tfaltezza;
	protected JLabel lblunghezza;
	protected JTextField tflunghezza;
	protected JLabel lbnumero;
	protected JTextField tfnumero;
	protected JLabel lbcapitello;
	protected JComboBox<Object> cbcapitello;
	protected JLabel lbtipocapitello;
	protected JTextField tftipocapitello;
	protected JLabel lbnote;
	protected JTextField tfnote;
	protected JLabel lblIcoBase;
	protected JLabel lblIcoAltezza;
	protected JLabel lblIcoLunghezza;
	protected JLabel lblIcoNumero;
	protected JLabel lblIcoTipoCapitello;
	protected JLabel lblIcoNote;

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
				i.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoStandard()));
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
	 * Elimina i listener dai bottoni dei riquadri
	 */
	public void setEditing(boolean edit) {
		if (edit) {
			this.salva.setEnabled(true);
		} else {
			this.salva.setEnabled(false);
		}
		this.validate();
		this.repaint();
	}

	/**
	 * Riabilita i listener dai bottoni dei riquadri
	 */
	public void enableEditing() {
		this.salva.setEnabled(true);
		if (this.salva.getMouseListeners().length == 1)
			this.salva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (aperto) {
						aperto = false;
						AFormDistinta.this.makeEditable(true);
					} else {
						AFormDistinta.this.salva(true);
						aperto = true;
						AFormDistinta.this.makeEditable(false);
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
	 * Metodo che resetta gli errori nella form
	 */
	protected void resetErroriForm(){
		if (this.Container.size() != 0) {
			for (JTextField txt : Container)
				txt.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoStandard()));
		}
		for (JLabel j : this.Label) {
			j.setVisible(false);
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
					&& j.getIcon().equals(ConfigGUI.getInstance().getErrorIcon()))
				test = false;
		}
		setEditing(test);
		return test;
	}

	/**
	 * Cambia il colore del testo nei campi non abilitati mettendolo più scuro
	 */
	public void changeUnableColor(JTextField x) {
		x.setDisabledTextColor(ConfigGUI.getInstance().getColoreBordoCard());
		x.validate();
		x.repaint();
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.Container = new ArrayList<JTextField>();
		this.aperto = true;
		this.oggetto = null;
		this.Label = new ArrayList<JLabel>();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(screenSize.width/2, 300));
		this.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(155px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(140dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));
		this.addBase();
		this.addAltezza();
		this.addLunghezza();
		this.addCapitello();
		this.addTipoCapitello();
		this.addNote();
		this.addNumero();
		this.validate();
		this.repaint();

		this.salva = new JButton("Salva");
		this.salva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aperto) {
					aperto = false;
					AFormDistinta.this.makeEditable(true);
				} else {
					AFormDistinta.this.salva(true);
					aperto = true;
					AFormDistinta.this.makeEditable(false);
					PlicoDistinta.getInstance().refresh();
				}
				validate();
				repaint();
			}
		});
		this.add(this.salva, "6, 16");
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

	/**
	 * Elimina dal riquadro il bottone di modifica
	 */
	public void deleteButtons() {
		this.remove(this.salva);
		this.validate();
		this.repaint();
	}

	/**
	 * Aggiunge il campo base
	 */
	private void addBase() {
		this.lbbase = new JLabel("Base");
		this.add(this.lbbase, "2, 2");
		this.tfbase = new JTextField();
		if (this.tfbase.getKeyListeners().length == 0)
			this.tfbase.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkBase();
				}
			});
		this.Container.add(tfbase);
		this.add(this.tfbase, "6, 2, fill, fill");
		this.lblIcoBase = new JLabel("");
		this.lblIcoBase.setVisible(false);
		this.add(lblIcoBase, "8, 2, center, top");
		this.Label.add(lblIcoBase);
	}

	/**
	 * Aggiunge il campo altezza
	 */
	private void addAltezza() {
		this.lbaltezza = new JLabel("Altezza");
		add(this.lbaltezza, "2, 4");
		this.tfaltezza = new JTextField();
		if (this.tfaltezza.getKeyListeners().length == 0)
			this.tfaltezza.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkAltezza();
				}
			});
		this.Container.add(tfaltezza);
		add(this.tfaltezza, "6, 4, fill, fill");
		this.lblIcoAltezza = new JLabel("");
		this.lblIcoAltezza.setVisible(false);
		this.add(lblIcoAltezza, "8, 4, center, top");
		this.Label.add(lblIcoAltezza);
	}

	/**
	 * Aggiunge il campo lunghezza
	 */
	private void addLunghezza() {
		this.lblunghezza = new JLabel("Lunghezza");
		add(this.lblunghezza, "2, 6");
		this.tflunghezza = new JTextField();
		if (this.tflunghezza.getKeyListeners().length == 0)
			this.tflunghezza.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkLunghezza();
				}
			});
		this.Container.add(tflunghezza);
		add(this.tflunghezza, "6, 6, fill, fill");
		this.lblIcoLunghezza = new JLabel("");
		this.lblIcoLunghezza.setVisible(false);
		this.add(lblIcoLunghezza, "8, 6, center, top");
		this.Label.add(lblIcoLunghezza);
	}

	/**
	 * Aggiunge il campo numero
	 */
	private void addNumero() {
		this.lbnumero = new JLabel("Numero");
		add(this.lbnumero, "2, 8");
		this.tfnumero = new JTextField();
		if (this.tfnumero.getKeyListeners().length == 0)
			this.tfnumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkNumero();
				}
			});
		this.Container.add(tfnumero);
		add(this.tfnumero, "6, 8, fill, fill");
		this.lblIcoNumero = new JLabel("");
		this.lblIcoNumero.setVisible(false);
		this.add(lblIcoNumero, "8, 8, center, top");
		this.Label.add(lblIcoNumero);
	}

	/**
	 * Aggiunge il campo capitello
	 */
	private void addCapitello() {
		this.lbcapitello = new JLabel("Capitello");
		add(this.lbcapitello, "2, 10");
		this.cbcapitello = new JComboBox<Object>();
		add(this.cbcapitello, "6, 10, fill, fill");
		this.cbcapitello.addItem(new String("Si"));
		this.cbcapitello.addItem(new String("No"));
		this.cbcapitello.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbcapitello.getSelectedItem().toString().equals("No")) {
					tftipocapitello.setEnabled(false);
					tftipocapitello.setText(null);
					lblIcoTipoCapitello.setVisible(false);
					lblIcoTipoCapitello.setToolTipText(null);
					tftipocapitello.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoStandard()));
					setEditing(checkEmpty());
				} else {
					tftipocapitello.setEnabled(true);
					checkTipoCapitello();
				}
				AFormDistinta.this.validate();
				AFormDistinta.this.repaint();
			}
		});
	}

	/**
	 * Aggiunge il campo tipo capitello
	 */
	private void addTipoCapitello() {
		this.lbtipocapitello = new JLabel("Tipo Capitello");
		add(this.lbtipocapitello, "2, 12");
		this.tftipocapitello = new JTextField();
		if (this.tftipocapitello.getKeyListeners().length == 0)
			this.tftipocapitello.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkTipoCapitello();
				}
			});
		this.Container.add(tftipocapitello);
		add(this.tftipocapitello, "6, 12, fill, fill");
		this.lblIcoTipoCapitello = new JLabel("");
		this.lblIcoTipoCapitello.setVisible(false);
		this.add(lblIcoTipoCapitello, "8, 12, center, top");
		this.Label.add(lblIcoTipoCapitello);
	}

	/**
	 * Aggiunge il campo note
	 */
	private void addNote() {
		this.lbnote = new JLabel("Note");
		add(this.lbnote, "2, 14");
		this.tfnote = new JTextField();
		if (this.tfnote.getKeyListeners().length == 0)
			this.tfnote.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkNote();
				}
			});
		this.Container.add(tfnote);
		add(this.tfnote, "6, 14, fill, fill");
		this.lblIcoNote = new JLabel("");
		this.lblIcoNote.setVisible(false);
		this.add(lblIcoNote, "8, 14, center, top");
		this.Label.add(lblIcoNote);
	}

	/**
	 * Metodo che controlla lo stato del campo Base
	 */
	private void checkBase() {
		String line = tfbase.getText();
		String pattern = "^[0-9]*\\.?[0-9]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoBase.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoBase
					.setToolTipText("Il campo Base deve essere un numero reale!");
			tfbase.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else if (!m.matches()) {
			lblIcoBase.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoBase
					.setToolTipText("Il campo Base deve essere un numero reale!");
			tfbase.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else {
			lblIcoBase.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoBase.setToolTipText(null);
			tfbase.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		lblIcoBase.setVisible(true);
		if (!checkEmpty())
			setEditing(false);
		else {
			setEditing(true);
			controlloErrori();
		}
	}

	/**
	 * Metodo che controlla lo stato del campo altezza
	 */
	private void checkAltezza() {
		String line = tfaltezza.getText();
		String pattern = "^[0-9]*\\.?[0-9]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoAltezza.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoAltezza
					.setToolTipText("Il campo Altezza deve essere un numero reale!");
			tfaltezza
					.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else if (!m.matches()) {
			lblIcoAltezza.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoAltezza
					.setToolTipText("Il campo Altezza deve essere un numero reale!");
			tfaltezza
					.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else {
			lblIcoAltezza.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoAltezza.setToolTipText(null);
			tfaltezza.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		lblIcoAltezza.setVisible(true);
		if (!checkEmpty())
			setEditing(false);
		else {
			setEditing(true);
			controlloErrori();
		}
	}

	/**
	 * Metodo che controlla lo stato del campo Lunghezza
	 */
	private void checkLunghezza() {
		String line = tflunghezza.getText();
		String pattern = "^[0-9]*\\.?[0-9]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoLunghezza.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoLunghezza
					.setToolTipText("Il campo Lunghezza deve essere un numero reale!");
			tflunghezza.setBorder(new LineBorder(ConfigGUI.getInstance()
					.getColoreBordoErrore()));
		} else if (!m.matches()) {
			lblIcoLunghezza.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoLunghezza
					.setToolTipText("Il campo Lunghezza deve essere un numero reale!");
			tflunghezza.setBorder(new LineBorder(ConfigGUI.getInstance()
					.getColoreBordoErrore()));
		} else {
			lblIcoLunghezza.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoLunghezza.setToolTipText(null);
			tflunghezza.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		lblIcoLunghezza.setVisible(true);
		if (!checkEmpty())
			setEditing(false);
		else {
			setEditing(true);
			controlloErrori();
		}
	}

	/**
	 * Metodo che controlla lo stato del campo Numero
	 */
	private void checkNumero() {
		String line = tfnumero.getText();
		String pattern = "\\D+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("") || line.equals("0")) {
			lblIcoNumero.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoNumero
					.setToolTipText("Il campo numero deve essere un numero intero maggiore di 0!");
			tfnumero.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else if (m.find()) {
			lblIcoNumero.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoNumero
					.setToolTipText("Il campo numero deve essere un numero intero maggiore di 0!");
			tfnumero.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else {
			lblIcoNumero.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoNumero.setToolTipText(null);
			tfnumero.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		lblIcoNumero.setVisible(true);
		if (!checkEmpty())
			setEditing(false);
		else {
			setEditing(true);
			controlloErrori();
		}
	}

	/**
	 * Metodo che controlla lo stato del campo Tipo Capitello
	 */
	private void checkTipoCapitello() {
		if (!tftipocapitello.isEnabled())
			return;
		String line = tftipocapitello.getText();
		String pattern = "[^a-zA-Z0-9\'\\s]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoTipoCapitello.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoTipoCapitello
					.setToolTipText("Il campo Tipo Capitello deve contenere solo lettere e/o numeri!");
			tftipocapitello.setBorder(new LineBorder(ConfigGUI.getInstance()
					.getColoreBordoErrore()));
		} else if (m.find()) {
			lblIcoTipoCapitello.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoTipoCapitello
					.setToolTipText("Il campo Tipo Capitello deve contenere solo lettere e/o numeri!");
			tftipocapitello.setBorder(new LineBorder(ConfigGUI.getInstance()
					.getColoreBordoErrore()));
		} else {
			lblIcoTipoCapitello.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoTipoCapitello.setToolTipText(null);
			tftipocapitello.setBorder(new LineBorder(ConfigGUI.getInstance()
					.getColoreBordoOk()));
		}
		lblIcoTipoCapitello.setVisible(true);
		if (!checkEmpty())
			setEditing(false);
		else {
			setEditing(true);
			controlloErrori();
		}
	}

	/**
	 * Metodo che controlla lo stato del campo Note
	 */
	private void checkNote() {
		String line = tfnote.getText();
		String pattern = "[^a-zA-Z0-9\',;:.\\s]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoNote.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoNote
					.setToolTipText("Il campo Note deve contenere solo lettere e/o numeri!");
			tfnote.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else if (m.find()) {
			lblIcoNote.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoNote
					.setToolTipText("Il campo Note deve contenere solo lettere e/o numeri!");
			tfnote.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else {
			lblIcoNote.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoNote.setToolTipText(null);
			tfnote.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		lblIcoNote.setVisible(true);
		if (!checkEmpty())
			setEditing(false);
		else {
			setEditing(true);
			controlloErrori();
		}
	}

}
