package GUI.Riquadri;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

import GUI.ConfigGUI;
import GUI.Abstract.ARiquadro;
import coedil99.model.MCommessa;
import coedil99.model.MOrdine;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Riquadro dati aziendali
 * 
 * @author Simone
 * 
 */
@SuppressWarnings("serial")
public class RiquadroDatiAziendali extends ARiquadro {

	private JLabel lblOC;
	private JTextField txtOC;
	private JLabel lblAnno;
	private JTextField txtAnno;
	private JLabel lblOrdineContratto;
	private JTextField txtOrdineContratto;
	private JLabel lblCommessaCoedil;
	private JTextField txtCommessaCoedil;
	private JLabel lblOrdineGestionale;
	private JTextField txtOrdineGestionale;
	private JLabel lblDataInizio;
	private JLabel lblDataFine;
	private JLabel lblOrario;
	private JTextField txtOrario;
	private JLabel lblIcoOC;
	private JLabel lblIcoAnno;
	private JLabel lblIcoOrdineContratto;
	private JLabel lblIcoCommessaCoedil;
	private JLabel lblIcoOrdineGestionale;
	private JLabel lblIcoOrario;
	private JLabel lblIcoDataInizio;
	private JLabel lblIcoDataFine;
	private JXDatePicker dateDataFine;
	private JXDatePicker dateDataInizio;

	/**
	 * Costruttore
	 * 
	 * @param title
	 */
	public RiquadroDatiAziendali(String title) {
		super(title);
		this.initialize();
	}

	/**
	 * Aggiunge orario
	 */
	private void addOrario() {
		this.lblOrario = new JLabel("Orario");
		this.form.add(this.lblOrario, "2, 16");
		this.txtOrario = new JTextField();
		this.txtOrario.setHorizontalAlignment(SwingConstants.CENTER);
		if (this.txtOrario.getKeyListeners().length == 0)
			this.txtOrario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkOrario();
				}
			});
		this.Container.add(this.txtOrario);
		this.form.add(this.txtOrario, "6, 16, fill, fill");
		this.lblIcoOrario = new JLabel("");
		this.lblIcoOrario.setVisible(false);
		this.form.add(lblIcoOrario, "8, 16, center, top");
		this.Label.add(lblIcoOrario);
	}

	/**
	 * Aggiunge data fine
	 */
	private void addDataFine() {
		this.lblDataFine = new JLabel("Data Fine");
		this.form.add(this.lblDataFine, "2, 14");
		this.dateDataFine = new JXDatePicker();
		this.dateDataFine.getEditor().setEditable(false);
		if (this.dateDataFine.getEditor().getFocusListeners().length == 0) {
			this.dateDataFine.getEditor().addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
						lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getErrorIcon());
						lblIcoDataInizio
								.setToolTipText("La data di inizio deve precedere la data di fine!");
						lblIcoDataFine.setIcon(ConfigGUI.getInstance().getErrorIcon());
						lblIcoDataFine
								.setToolTipText("La data di inizio deve precedere la data di fine!");

					} else {
						lblIcoDataFine.setIcon(ConfigGUI.getInstance().getOkIcon());
						lblIcoDataFine.setToolTipText(null);
						lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getOkIcon());
						lblIcoDataInizio.setToolTipText(null);
					}
					controlloErrori();
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
						lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getErrorIcon());
						lblIcoDataInizio
								.setToolTipText("La data di inizio deve precedere la data di fine!");
						lblIcoDataFine.setIcon(ConfigGUI.getInstance().getErrorIcon());
						lblIcoDataFine
								.setToolTipText("La data di inizio deve precedere la data di fine!");

					} else {
						lblIcoDataFine.setIcon(ConfigGUI.getInstance().getOkIcon());
						lblIcoDataFine.setToolTipText(null);
						lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getOkIcon());
						lblIcoDataInizio.setToolTipText(null);
					}
					controlloErrori();
				}
			});
		}
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.dateDataFine.setEnabled(false);
		this.form.add(dateDataFine, "6, 14, fill, fill");
		this.lblIcoDataFine = new JLabel("");
		this.lblIcoDataFine.setVisible(false);
		this.form.add(lblIcoDataFine, "8, 14, center, top");
		//this.Label.add(lblIcoDataFine);
	}

	/**
	 * Aggiunge data inizio
	 */
	private void addDataInizio() {
		this.lblDataInizio = new JLabel("Data Inizio");
		this.form.add(this.lblDataInizio, "2, 12");
		this.dateDataInizio = new JXDatePicker();
		if (this.dateDataInizio.getEditor().getFocusListeners().length == 0) {
			this.dateDataInizio.getEditor().addFocusListener(
					new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) {
							if (dateDataFine.getDate().before(
									dateDataInizio.getDate())) {
								lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getErrorIcon());
								lblIcoDataInizio
										.setToolTipText("La data di inizio deve precedere la data di fine!");
								lblIcoDataFine.setIcon(ConfigGUI.getInstance().getErrorIcon());
								lblIcoDataFine
										.setToolTipText("La data di inizio deve precedere la data di fine!");

							} else {
								lblIcoDataFine.setIcon(ConfigGUI.getInstance().getOkIcon());
								lblIcoDataFine.setToolTipText(null);
								lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getOkIcon());
								lblIcoDataInizio.setToolTipText(null);
							}
							controlloErrori();
						}

						@Override
						public void focusLost(FocusEvent e) {
							if (dateDataFine.getDate().before(
									dateDataInizio.getDate())) {
								lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getErrorIcon());
								lblIcoDataInizio
										.setToolTipText("La data di inizio deve precedere la data di fine!");
								lblIcoDataFine.setIcon(ConfigGUI.getInstance().getErrorIcon());
								lblIcoDataFine
										.setToolTipText("La data di inizio deve precedere la data di fine!");

							} else {
								lblIcoDataFine.setIcon(ConfigGUI.getInstance().getOkIcon());
								lblIcoDataFine.setToolTipText(null);
								lblIcoDataInizio.setIcon(ConfigGUI.getInstance().getOkIcon());
								lblIcoDataInizio.setToolTipText(null);
							}
							controlloErrori();
						}
					});
		}
		dateDataInizio.getEditor().setEditable(false);
		this.dateDataInizio.setEnabled(false);
		this.dateDataInizio.setFormats("yyyy-MM-dd");
		this.form.add(dateDataInizio, "6, 12, fill, fill");
		this.lblIcoDataInizio = new JLabel("");
		this.lblIcoDataInizio.setVisible(false);
		this.form.add(lblIcoDataInizio, "8, 12, center, top");
		//this.Label.add(lblIcoDataInizio);
	}

	/**
	 * Aggiunge ordine gestionale
	 */
	private void addOrdineGestionale() {
		this.lblOrdineGestionale = new JLabel("Ordine Gestionale");
		this.form.add(this.lblOrdineGestionale, "2, 10");
		this.txtOrdineGestionale = new JTextField();
		this.txtOrdineGestionale.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrdineGestionale.setEnabled(false);
		this.form.add(this.txtOrdineGestionale, "6, 10, fill, fill");
		this.lblIcoOrdineGestionale = new JLabel("");
		this.lblIcoOrdineGestionale.setVisible(false);
		this.form.add(lblIcoOrdineGestionale, "8, 10, center, top");
		//this.Label.add(lblIcoOrdineGestionale);
	}

	/**
	 * Aggiunge commessa
	 */
	private void addCommessaCoedil() {
		this.lblCommessaCoedil = new JLabel("Commessa Coedil");
		this.form.add(this.lblCommessaCoedil, "2, 8");
		this.txtCommessaCoedil = new JTextField();
		this.txtCommessaCoedil.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCommessaCoedil.setEnabled(false);
		this.form.add(this.txtCommessaCoedil, "6, 8, fill, fill");
		this.lblIcoCommessaCoedil = new JLabel("");
		this.lblIcoCommessaCoedil.setVisible(false);
		this.form.add(lblIcoCommessaCoedil, "8, 8, center, top");
		//this.Label.add(lblIcoCommessaCoedil);
	}

	/**
	 * Aggiunge ordine contratto
	 */
	private void addOrdineContratto() {
		this.lblOrdineContratto = new JLabel("Ordine/Contratto");
		this.form.add(this.lblOrdineContratto, "2, 6");
		this.txtOrdineContratto = new JTextField();
		this.txtOrdineContratto.setHorizontalAlignment(SwingConstants.CENTER);

		this.txtOrdineContratto.setEnabled(false);
		this.form.add(this.txtOrdineContratto, "6, 6, fill, fill");

		this.lblIcoOrdineContratto = new JLabel("");
		this.lblIcoOrdineContratto.setVisible(false);
		this.form.add(lblIcoOrdineContratto, "8, 6, center, top");
		//this.Label.add(lblIcoOrdineContratto);
	}

	/**
	 * Aggiunge anno
	 */
	private void addAnno() {
		this.lblAnno = new JLabel("Anno");
		this.form.add(this.lblAnno, "2, 4");
		this.txtAnno = new JTextField();
		this.txtAnno.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtAnno.setEnabled(false);
		this.form.add(this.txtAnno, "6, 4, fill, fill");

		this.lblIcoAnno = new JLabel("");
		this.lblIcoAnno.setVisible(false);
		this.form.add(lblIcoAnno, "8, 4, center, top");
		//this.Label.add(lblIcoAnno);
	}

	/**
	 * Aggiunge OC
	 */
	private void addOC() {
		this.lblOC = new JLabel("O/C");
		this.form.add(this.lblOC, "2, 2, left, default");
		this.txtOC = new JTextField();
		if (this.txtOC.getKeyListeners().length == 0)
			this.txtOC.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkOC();
				}
			});
		this.txtOC.setHorizontalAlignment(SwingConstants.CENTER);
		this.Container.add(this.txtOC);
		this.form.add(this.txtOC, "6, 2, fill, fill");
		this.lblIcoOC = new JLabel("");
		this.lblIcoOC.setVisible(false);
		this.form.add(lblIcoOC, "8, 2, center, top");
		this.Label.add(lblIcoOC);
	}

	/**
	 * Inizializza gli elementi grafici
	 */
	@Override
	protected void initialize() {
		this.setSize(new Dimension(600, 370));
		this.form.setBounds(0, 40, 500, 340);
		this.add(form);
		this.form.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));
		this.addOC();
		this.addAnno();
		this.addOrdineContratto();
		this.addCommessaCoedil();
		this.addOrdineGestionale();
		this.addDataInizio();
		this.addDataFine();
		this.addOrario();
		this.makeEditable(false);
	}

	@Override
	/**
	 * Carica i dati della commessa
	 */
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		MCommessa c = (MCommessa) this.oggetto;
		if (c != null)
			this.txtCommessaCoedil.setText(Integer.toString(c
					.getPersistentModel().getID()));
		MOrdine ord = new MOrdine(c.getPersistentModel().getOrdine().getID());
		if (ord != null)
			this.txtOrdineContratto.setText(Integer.toString(ord
					.getPersistentModel().getID()));
		if (ord.getPersistentModel().getOC() != null)
			this.txtOC.setText(ord.getPersistentModel().getOC());
		if (ord.getPersistentModel().getAnno() != null)
			this.txtAnno.setText(ord.getPersistentModel().getAnno().toString());
		if (ord.getPersistentModel().getOrdineGestionale() != null)
			this.txtOrdineGestionale.setText(ord.getPersistentModel()
					.getOrdineGestionale());
		if (ord.getPersistentModel().getDataInizio() != null)
			this.dateDataInizio.setDate(ord.getPersistentModel()
					.getDataInizio());
		else
			this.dateDataInizio.setDate(null);
		if (ord.getPersistentModel().getDataFine() != null)
			this.dateDataFine.setDate(ord.getPersistentModel().getDataFine());
		else
			this.dateDataFine.setDate(null);
		if (c.getPersistentModel().getOrario() != null)
			this.txtOrario.setText(c.getPersistentModel().getOrario());
	}

	/**
	 * Metodo che modifica i campi degli oggetti interessati e li salva sul db
	 */
	@Override
	public void salva(boolean showmex) {
		if (this.oggetto != null) {
			MCommessa c = (MCommessa) this.oggetto;
			MOrdine ord = new MOrdine(c.getPersistentModel().getOrdine()
					.getID());
			ord.getPersistentModel().setOC(this.txtOC.getText());
			ord.getPersistentModel().setDataInizio(
					this.dateDataInizio.getDate());
			ord.getPersistentModel().setDataFine(this.dateDataFine.getDate());
			ord.save();
			c.getPersistentModel().setOrario(this.txtOrario.getText());
			c.save();
			if (showmex)
				JOptionPane
						.showMessageDialog(null,
								"Salvataggio avvenuto correttamente",
								"Messaggio di Sistema",
								JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	/**
	 * Mostra un messaggio utile nella fase di creazione che comunica che il
	 * numero commessa Coedil verrà inserito automaticamente dal sistema una
	 * volta che la Commessa verrà salvata
	 */
	public void showNumeroCommessaCoedilMessage() {
		this.txtCommessaCoedil.setText("Automatico dopo il salvataggio");
		this.validate();
		this.repaint();
	}

	
	/**
	 * Set della data di inizio commessa nel data picker del Riquadro dati
	 * aziendali
	 * 
	 * @param t
	 *            :data
	 */
	public void setDataInizio(Date t) {
		this.dateDataInizio.setDate(t);
		this.validate();
		this.repaint();
	}

	/**
	 * Set della data di fine commessa nel data picker del Riquadro dati
	 * aziendali
	 * 
	 * @param t
	 *            :data
	 */
	public void setDataFine(Date t) {
		this.dateDataFine.setDate(t);
		this.validate();
		this.repaint();
	}

	/**
	 * Mostra un messaggio informativo sulla label ad indicare che il campo
	 * verrà automaticamente riempito dopo il salvataggio
	 */
	public void showOrdineGestionaleMessage() {
		this.txtOrdineGestionale.setText("Automatico dopo il salvataggio");
		this.validate();
		this.repaint();
	}

	/**
	 * Set del numero d'ordine
	 * 
	 * @param n
	 *            :valore
	 */
	public void setOrdineContratto(int n) {
		this.txtOrdineContratto.setText(String.valueOf(n));
		this.validate();
		this.repaint();
	}

	/**
	 * Set dell'anno dell'ordine
	 * 
	 * @param year
	 */
	public void setAnno(int year) {
		this.txtAnno.setText(String.valueOf(year));
		this.validate();
		this.repaint();
	}
	
	/**
	 * Metodo che effettua il controllo sul campo Orario
	 */
	private void checkOrario(){
		String line = txtOrario.getText();
		String pattern = "[^a-zA-Z0-9\'\\s]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoOrario.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoOrario
					.setToolTipText("Il campo Orario deve contenere solo lettere e/o numeri!");
			txtOrario.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else if (m.find()) {
			lblIcoOrario.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoOrario
					.setToolTipText("Il campo Orario deve contenere solo lettere e/o numeri!");
			txtOrario.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else {
			lblIcoOrario.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoOrario.setToolTipText("");
			txtOrario.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		controlloErrori();
	}
	
	/**
	 * Metodo che controlla lo stato del campo O/C
	 */
	private void checkOC(){
		String line = txtOC.getText();
		String pattern = "\\W+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblIcoOC.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoOC.setToolTipText("Il campo O/C deve contenere solo lettere e/o numeri!");
			txtOC.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else if (m.find()) {
			lblIcoOC.setIcon(ConfigGUI.getInstance().getErrorIcon());
			lblIcoOC.setToolTipText("Il campo O/C deve contenere solo lettere e/o numeri!");
			txtOC.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
		} else {
			lblIcoOC.setIcon(ConfigGUI.getInstance().getOkIcon());
			lblIcoOC.setToolTipText(null);
			txtOC.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
		}
		controlloErrori();
	}
		

	@Override
	/**
	 * Rende editabili i campi data 
	 */
	public void makeEditable(boolean editable) {

		super.makeEditable(editable);

	}
	
	@Override
	public boolean controlloErrori(){
		boolean test = super.controlloErrori() && super.checkEmpty();
		return test;
	}
	
	public void checkErrori(){
		checkOrario();
		checkOC();
	}

}