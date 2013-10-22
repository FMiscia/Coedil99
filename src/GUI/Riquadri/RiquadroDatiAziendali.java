package GUI.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.orm.PersistentException;

import GUI.Abstract.ARiquadro;
import coedil99.model.Commessa;
import coedil99.model.Ordine;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class RiquadroDatiAziendali extends ARiquadro {

	private JPanel form;
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
	private JLabel lblDescrizione;
	private JTextField txtDescrizione;
	private JLabel lblIcoOC;
	private JLabel lblIcoAnno;
	private JLabel lblIcoOrdineContratto;
	private JLabel lblIcoCommessaCoedil;
	private JLabel lblIcoOrdineGestionale;
	private JLabel lblIcoOrario;
	private JLabel lblIcoDescrizione;
	private JLabel lblIcoDataInizio;
	private JLabel lblIcoDataFine;
	private JXDatePicker dateDataFine;
	private JXDatePicker dateDataInizio;

	/**
	 * Costruttore
	 * @param title
	 */
	public RiquadroDatiAziendali(String title) {
		super(title);
		this.initialize();
	}

	/**
	 * Aggiunge descrizione
	 */
	private void addDescrizione() {
		// TODO Auto-generated method stub
		this.lblDescrizione = new JLabel("Descrizione");
		this.form.add(this.lblDescrizione, "2, 18");
		this.txtDescrizione = new JTextField();
		this.txtDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtDescrizione.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtDescrizione.getText();
				String pattern = "[^a-zA-Z������'\\s]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoDescrizione.setIcon(IcoErrore);
					lblIcoDescrizione
							.setToolTipText("Il campo Descrizione deve contenere solo lettere!");
					txtDescrizione.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoDescrizione.setIcon(IcoErrore);
					lblIcoDescrizione
							.setToolTipText("Il campo Descrizione deve contenere solo lettere!");
					txtDescrizione.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoDescrizione.setIcon(IcoOk);
					lblIcoDescrizione.setToolTipText("");
					txtDescrizione.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(this.txtDescrizione);
		this.form.add(this.txtDescrizione, "6, 18, fill, fill");

		this.lblIcoDescrizione = new JLabel("");
		this.lblIcoDescrizione.setVisible(false);
		this.form.add(lblIcoDescrizione, "8, 18, center, top");
		this.Label.add(lblIcoDescrizione);

	}

	/**
	 * Aggiunge orario
	 */
	private void addOrario() {
		// TODO Auto-generated method stub
		this.lblOrario = new JLabel("Orario");
		this.form.add(this.lblOrario, "2, 16");
		this.txtOrario = new JTextField();
		this.txtOrario.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtOrario.getText();
				String pattern = "[^a-zA-Z������]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoOrario.setIcon(IcoErrore);
					lblIcoOrario
							.setToolTipText("Il campo Orario deve contenere solo lettere!");
					txtOrario.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoOrario.setIcon(IcoErrore);
					lblIcoOrario
							.setToolTipText("Il campo Orario deve contenere solo lettere!");
					txtOrario.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoOrario.setIcon(IcoOk);
					lblIcoOrario.setToolTipText("");
					txtOrario.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
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
		// TODO Auto-generated method stub

		this.lblDataFine = new JLabel("Data Fine");
		this.form.add(this.lblDataFine, "2, 14");
		this.dateDataFine = new JXDatePicker();
		dateDataFine.getEditor().setEditable(false);
		dateDataFine.getEditor().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
					lblIcoDataInizio.setIcon(IcoErrore);
					lblIcoDataInizio
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");

				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoDataInizio.setIcon(IcoOk);
					lblIcoDataInizio.setToolTipText(null);
				}
				controlloErrori();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
					lblIcoDataInizio.setIcon(IcoErrore);
					lblIcoDataInizio
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");

				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoDataInizio.setIcon(IcoOk);
					lblIcoDataInizio.setToolTipText(null);
				}
				controlloErrori();
			}
		});
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.form.add(dateDataFine, "6, 14, fill, fill");

		this.lblIcoDataFine = new JLabel("");
		this.lblIcoDataFine.setVisible(false);
		this.form.add(lblIcoDataFine, "8, 14, center, top");
		this.Label.add(lblIcoDataFine);
	}

	/**
	 * Aggiunge data inizio
	 */
	private void addDataInizio() {
		// TODO Auto-generated method stub

		this.lblDataInizio = new JLabel("Data Inizio");
		this.form.add(this.lblDataInizio, "2, 12");
		this.dateDataInizio = new JXDatePicker();
		dateDataInizio.getEditor().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
					lblIcoDataInizio.setIcon(IcoErrore);
					lblIcoDataInizio
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");

				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoDataInizio.setIcon(IcoOk);
					lblIcoDataInizio.setToolTipText(null);
				}
				controlloErrori();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
					lblIcoDataInizio.setIcon(IcoErrore);
					lblIcoDataInizio
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");

				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoDataInizio.setIcon(IcoOk);
					lblIcoDataInizio.setToolTipText(null);
				}
				controlloErrori();
			}
		});
		dateDataInizio.getEditor().setEditable(false);
		this.dateDataInizio.setFormats("yyyy-MM-dd");
		this.form.add(dateDataInizio, "6, 12, fill, fill");
		this.lblIcoDataInizio = new JLabel("");
		this.lblIcoDataInizio.setVisible(false);
		this.form.add(lblIcoDataInizio, "8, 12, center, top");
		this.Label.add(lblIcoDataInizio);
	}

	/**
	 * Aggiunge ordine gestionale
	 */
	private void addOrdineGestionale() {
		// TODO Auto-generated method stub

		this.lblOrdineGestionale = new JLabel("Ordine Gestionale");
		this.form.add(this.lblOrdineGestionale, "2, 10");
		this.txtOrdineGestionale = new JTextField();
		this.txtOrdineGestionale.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrdineGestionale.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtOrdineGestionale.getText();
				String pattern = "\\D+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoOrdineGestionale.setIcon(IcoErrore);
					lblIcoOrdineGestionale
							.setToolTipText("Il campo Ordine Gestionale deve contenere solo numeri!");
					txtOrdineGestionale.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoOrdineGestionale.setIcon(IcoErrore);
					lblIcoOrdineGestionale
							.setToolTipText("Il campo Ordine Gestionale deve contenere solo numeri!");
					txtOrdineGestionale.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoOrdineGestionale.setIcon(IcoOk);
					lblIcoOrdineGestionale.setToolTipText(null);
					txtOrdineGestionale.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(this.txtOrdineGestionale);
		this.form.add(this.txtOrdineGestionale, "6, 10, fill, fill");
		this.lblIcoOrdineGestionale = new JLabel("");
		this.lblIcoOrdineGestionale.setVisible(false);
		this.form.add(lblIcoOrdineGestionale, "8, 10, center, top");
		this.Label.add(lblIcoOrdineGestionale);
	}

	/**
	 * Aggiunge commessa 
	 */
	private void addCommessaCoedil() {
		// TODO Auto-generated method stub

		this.lblCommessaCoedil = new JLabel("Commessa Coedil");
		this.form.add(this.lblCommessaCoedil, "2, 8");
		this.txtCommessaCoedil = new JTextField();
		this.txtCommessaCoedil.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCommessaCoedil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtCommessaCoedil.getText();
				String pattern = "\\D+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoCommessaCoedil.setIcon(IcoErrore);
					lblIcoCommessaCoedil
							.setToolTipText("Il campo Commessa Coedil deve contenere solo numeri!");
					txtCommessaCoedil.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoCommessaCoedil.setIcon(IcoErrore);
					lblIcoCommessaCoedil
							.setToolTipText("Il campo Commessa Coedil deve contenere solo numeri!");
					txtCommessaCoedil.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoCommessaCoedil.setIcon(IcoOk);
					lblIcoCommessaCoedil.setToolTipText(null);
					txtCommessaCoedil.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(this.txtCommessaCoedil);
		this.form.add(this.txtCommessaCoedil, "6, 8, fill, fill");
		this.lblIcoCommessaCoedil = new JLabel("");
		this.lblIcoCommessaCoedil.setVisible(false);
		this.form.add(lblIcoCommessaCoedil, "8, 8, center, top");
		this.Label.add(lblIcoCommessaCoedil);
	}

	/**
	 * Aggiunge ordine contratto
	 */
	private void addOrdineContratto() {
		// TODO Auto-generated method stub

		this.lblOrdineContratto = new JLabel("Ordine/Contratto");
		this.form.add(this.lblOrdineContratto, "2, 6");
		this.txtOrdineContratto = new JTextField();
		this.txtOrdineContratto.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrdineContratto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtOrdineContratto.getText();
				String pattern = "\\D+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoOrdineContratto.setIcon(IcoErrore);
					lblIcoOrdineContratto
							.setToolTipText("Il campo Ordine/Contratto deve contenere solo numeri!");
					txtOrdineContratto.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoOrdineContratto.setIcon(IcoErrore);
					lblIcoOrdineContratto
							.setToolTipText("Il campo Ordine/Contratto deve contenere solo numeri!");
					txtOrdineContratto.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoOrdineContratto.setIcon(IcoOk);
					lblIcoOrdineContratto.setToolTipText(null);
					txtOrdineContratto.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});

		this.Container.add(this.txtOrdineContratto);
		this.form.add(this.txtOrdineContratto, "6, 6, fill, fill");

		this.lblIcoOrdineContratto = new JLabel("");
		this.lblIcoOrdineContratto.setVisible(false);
		this.form.add(lblIcoOrdineContratto, "8, 6, center, top");
		this.Label.add(lblIcoOrdineContratto);
	}

	/**
	 * Aggiunge anno
	 */
	private void addAnno() {
		// TODO Auto-generated method stub
		this.lblAnno = new JLabel("Anno");
		this.form.add(this.lblAnno, "2, 4");
		this.txtAnno = new JTextField();
		this.txtAnno.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtAnno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtAnno.getText();
				String pattern = "\\D+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoAnno.setIcon(RiquadroDatiAziendali.this.IcoErrore);
					lblAnno.setToolTipText("Il campo Anno deve contenere solo numeri!");
					txtAnno.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoAnno.setIcon(RiquadroDatiAziendali.this.IcoErrore);
					lblAnno.setToolTipText("Il campo Anno deve contenere solo numeri!");
					txtAnno.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoAnno.setIcon(RiquadroDatiAziendali.this.IcoOk);
					lblIcoOC.setToolTipText(null);
					txtAnno.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});

		this.Container.add(this.txtAnno);
		this.form.add(this.txtAnno, "6, 4, fill, fill");

		this.lblIcoAnno = new JLabel("");
		this.lblIcoAnno.setVisible(false);
		this.form.add(lblIcoAnno, "8, 4, center, top");
		this.Label.add(lblIcoAnno);
	}

	/**
	 * Aggiunge OC
	 */
	private void addOC() {
		// TODO Auto-generated method stub

		this.lblOC = new JLabel("O/C");
		this.form.add(this.lblOC, "2, 2, left, default");
		this.txtOC = new JTextField();
		this.txtOC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtOC.getText();
				String pattern = "\\W+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoOC.setIcon(IcoErrore);
					lblIcoOC.setToolTipText("Il campo O/C deve contenere solo lettere e/o numeri!");
					txtOC.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoOC.setIcon(IcoErrore);
					lblIcoOC.setToolTipText("Il campo O/C deve contenere solo lettere e/o numeri!");
					txtOC.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoOC.setIcon(IcoOk);
					lblIcoOC.setToolTipText(null);
					txtOC.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
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
	private void initialize() {
		// TODO Auto-generated method stub
		this.setSize(new Dimension(630, 370));
		this.form = new JPanel();
		this.form.setBounds(0, 30, 600, 340);
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
		this.addDescrizione();
		this.makeEditable(false);
	}

	@Override
	/**
	 * carica i dati della commessa
	 */
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Commessa c = (Commessa) this.oggetto;
		if (c != null)
			this.txtCommessaCoedil.setText(Integer.toString(c.getID()));
		Ordine ord = c.getOrdine();
		if (ord != null)
			this.txtOrdineContratto.setText(Integer.toString(ord.getID()));
		if (ord.getOC() != null)
			this.txtOC.setText(ord.getOC());
		if (ord.getAnno() != null)
			this.txtAnno.setText(ord.getAnno().toString());
		if (ord.getOrdineGestionale() != null)
			this.txtOrdineGestionale.setText(ord.getOrdineGestionale());
		if (ord.getDataInizio() != null)
			this.dateDataInizio.setDate(ord.getDataInizio());
		else
			this.dateDataInizio.setDate(null);
		if (ord.getDataFine() != null)
			this.dateDataFine.setDate(ord.getDataFine());
		else
			this.dateDataFine.setDate(null);
		if (c.getOrario() != null)
			this.txtOrario.setText(c.getOrario());
		if (c.getDescrizione() != null)
			this.txtDescrizione.setText(c.getDescrizione());
	}

	/**
	 * Metodo che modifica i campi deglli oggetti interessati e li salva sul db
	 */
	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Commessa c = (Commessa) this.oggetto;
			Ordine ord = c.getOrdine();
			ord.setOC(this.txtOC.getText());
			ord.setAnno(Integer.valueOf(this.txtAnno.getText()));
			ord.setOrdineGestionale(this.txtOrdineGestionale.getText());
			ord.setDataInizio(this.dateDataInizio.getDate());
			ord.setDataFine(this.dateDataFine.getDate());
			try {
				ord.save();
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.setOrario(this.txtOrario.getText());
			c.setDescrizione(this.txtDescrizione.getText());
			try {
				c.save();
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	@Override
	/**
	 * rende editabili i campi data 
	 */
	public void makeEditable(boolean editable) {
		// TODO Auto-generated method stub
		this.dateDataInizio.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		super.makeEditable(editable);

	}

}