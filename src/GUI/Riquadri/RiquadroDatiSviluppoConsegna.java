package GUI.Riquadri;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
/**
 * Riquadro dati sviluppo consegna
 * 
 * @author Simone
 *
 */
public class RiquadroDatiSviluppoConsegna extends ARiquadro {

	private JLabel lblResponsabile;
	private JTextField txtResponsabile;
	private JLabel lblEmissioneCommessa;
	private JXDatePicker dateEmissioneCommessa;
	private JLabel lblScadenzaCommessa;
	private JXDatePicker dateScadenzaCommessa;
	private JLabel lblDataFine;
	private JXDatePicker dateDataFine;
	private JLabel lblRitardo;
	private JTextField txtRitardo;
	private JLabel lblIcoResponsabile;
	private JLabel lblIcoRitardo;
	private JLabel lblIcoScadenzaCommessa;
	private JLabel lblIcoEmissioneCommessa;
	private JLabel lblIcoDataFine;

	public RiquadroDatiSviluppoConsegna(String title) {
		super(title);
		this.initialize();
		this.makeEditable(false);
	}

	/**
	 * Carica il contenuto del riquadro
	 */
	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		MCommessa c = (MCommessa) o;
		if (c.getPersistentModel().getResponsabile() != null)
			this.txtResponsabile.setText(c.getPersistentModel()
					.getResponsabile());
		if (c.getPersistentModel().getEmissioneCommessa() != null)
			this.dateEmissioneCommessa.setDate(c.getPersistentModel()
					.getEmissioneCommessa());
		if (c.getPersistentModel().getScadenzaCommessa() != null)
			this.dateScadenzaCommessa.setDate(c.getPersistentModel()
					.getScadenzaCommessa());
		if (c.getPersistentModel().getFineCommessa() != null)
			this.dateDataFine.setDate(c.getPersistentModel().getFineCommessa());
		if (c.getPersistentModel().getRitardoProduzione() != null)
			this.txtRitardo.setText(c.getPersistentModel()
					.getRitardoProduzione().toString());
	}

	/**
	 * Salva le modifiche sul db
	 */
	@Override
	public void salva(boolean showmex) {
		if (this.oggetto != null) {
			MCommessa c = (MCommessa) oggetto;
			c.getPersistentModel().setResponsabile(
					this.txtResponsabile.getText());
			c.getPersistentModel().setEmissioneCommessa(
					this.dateEmissioneCommessa.getDate());
			c.getPersistentModel().setScadenzaCommessa(
					this.dateScadenzaCommessa.getDate());
			c.getPersistentModel().setFineCommessa(this.dateDataFine.getDate());
			c.getPersistentModel().setRitardoProduzione(
					Integer.parseInt(this.txtRitardo.getText()));
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
	 * Rende editabili i campi data
	 */
	@Override
	public void makeEditable(boolean editable) {
		this.dateEmissioneCommessa.setEnabled(editable);
		this.dateScadenzaCommessa.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		super.makeEditable(editable);

	}

	/**
	 * Imposta la grafica
	 */
	@Override
	protected void initialize() {
		this.setSize(new Dimension(600, 230));
		this.form.setBounds(0, 40, 600, 200);
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
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));
		this.addResponsabile();
		this.addEmissioneCommessa();
		this.addDataFineCommessa();
		this.addScadenzaCommessa();
		this.addRitardo();
		this.checkEmissioneCommessa();
		this.checkDataFine();
		this.checkScadenzaCommessa();
	}

	/**
	 * Aggiunge il campo responsabile
	 */
	private void addResponsabile() {
		this.lblResponsabile = new JLabel("Responsabile");
		this.form.add(this.lblResponsabile, "2, 2");

		this.txtResponsabile = new JTextField();
		this.txtResponsabile.setHorizontalAlignment(SwingConstants.CENTER);
		if (this.txtResponsabile.getKeyListeners().length == 0)
			this.txtResponsabile.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String line = txtResponsabile.getText();
					String pattern = "[^a-zA-Z\'\\è\\é\\ò\\à\\ù\\s]";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(line);
					if (line.equals("")) {
						setErrore(lblIcoResponsabile, false,
								"Il campo Responsabile deve contenere solo lettere!");
						txtResponsabile.setBorder(new LineBorder(ConfigGUI
								.getColoreBordoErrore()));
					} else if (m.find()) {
						setErrore(lblIcoResponsabile, false,
								"Il campo Responsabile deve contenere solo lettere!");
						txtResponsabile.setBorder(new LineBorder(ConfigGUI
								.getColoreBordoErrore()));
					} else {
						setErrore(lblIcoResponsabile, true, null);
						txtResponsabile.setBorder(new LineBorder(ConfigGUI
								.getColoreBordoOk()));
					}
					controlloErrori();
				}
			});
		this.Container.add(this.txtResponsabile);
		this.form.add(this.txtResponsabile, "6, 2, fill, fill");

		this.lblIcoResponsabile = new JLabel("");
		this.lblIcoResponsabile.setVisible(false);
		this.form.add(lblIcoResponsabile, "8, 2, center, top");
		this.Label.add(lblIcoResponsabile);
	}

	/**
	 * Aggiunge il campo emissione commessa
	 */
	private void addEmissioneCommessa() {
		this.lblEmissioneCommessa = new JLabel("Emissione Commessa");
		this.form.add(this.lblEmissioneCommessa, "2, 4");

		this.dateEmissioneCommessa = new JXDatePicker();
		this.dateEmissioneCommessa.setFormats("yyyy-MM-dd");
		this.dateEmissioneCommessa.getEditor().setEditable(false);
		this.form.add(this.dateEmissioneCommessa, "6, 4, fill, fill");
		this.lblIcoEmissioneCommessa = new JLabel("");
		this.lblIcoEmissioneCommessa.setVisible(false);
		this.form.add(lblIcoEmissioneCommessa, "8, 4, center, top");
		this.Label.add(lblIcoEmissioneCommessa);
	}

	/**
	 * Aggiunge il campo data fine commessa
	 */
	private void addDataFineCommessa() {
		this.lblDataFine = new JLabel("Data Fine Commessa");
		this.form.add(this.lblDataFine, "2, 6");

		this.dateDataFine = new JXDatePicker();
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.dateDataFine.getEditor().setEditable(false);
		this.lblIcoDataFine = new JLabel("");
		this.lblIcoDataFine.setVisible(false);
		this.form.add(lblIcoDataFine, "8, 6, center, top");
		this.Label.add(lblIcoDataFine);
		this.form.add(this.dateDataFine, "6, 6, fill, fill");
	}

	/**
	 * Aggiunge il campo scadenza commessa
	 */
	private void addScadenzaCommessa() {
		this.lblScadenzaCommessa = new JLabel("Scadenza Commessa");
		this.form.add(this.lblScadenzaCommessa, "2, 8");

		this.dateScadenzaCommessa = new JXDatePicker();
		this.dateScadenzaCommessa.setFormats("yyyy-MM-dd");
		this.dateScadenzaCommessa.getEditor().setEditable(false);
		this.form.add(dateScadenzaCommessa, "6, 8, fill, fill");
		this.lblIcoScadenzaCommessa = new JLabel("");
		this.lblIcoScadenzaCommessa.setVisible(false);
		this.form.add(lblIcoScadenzaCommessa, "8, 8, center, top");
		this.Label.add(lblIcoScadenzaCommessa);
	}

	/**
	 * Aggiunge il campo ritardo
	 */
	private void addRitardo() {
		this.lblRitardo = new JLabel("Ritardo Produzione");
		this.form.add(this.lblRitardo, "2, 10");

		this.txtRitardo = new JTextField();
		this.txtRitardo.setHorizontalAlignment(SwingConstants.CENTER);
		if (this.txtRitardo.getKeyListeners().length == 0)
			this.txtRitardo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String line = txtRitardo.getText();
					String pattern = "[\\D]";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(line);
					if (line.equals("")) {
						setErrore(lblIcoRitardo, false,
								"Il campo Ritardo Produzione deve contenere solo numeri!");
						txtRitardo.setBorder(new LineBorder(ConfigGUI
								.getColoreBordoErrore()));
					} else if (m.find()) {
						setErrore(lblIcoRitardo, false,
								"Il campo Ritardo Produzione deve contenere solo numeri!");
						txtRitardo.setBorder(new LineBorder(ConfigGUI
								.getColoreBordoErrore()));
					} else {
						setErrore(lblIcoRitardo, true, null);
						txtRitardo.setBorder(new LineBorder(ConfigGUI
								.getColoreBordoOk()));
					}
					controlloErrori();
				}
			});
		this.Container.add(this.txtRitardo);
		this.form.add(this.txtRitardo, "6, 10, fill, fill");
		this.lblIcoRitardo = new JLabel("");
		this.lblIcoRitardo.setVisible(false);
		this.form.add(lblIcoRitardo, "8, 10, center, top");
		this.Label.add(lblIcoRitardo);
	}

	/**
	 * Set della data di emissione commessa
	 */
	public void setDataEmissioneCommmessa(Date d) {
		this.dateEmissioneCommessa.setDate(d);
		this.validate();
		this.repaint();
	}

	/**
	 * Metodo che aggiunge il controllo delle date per il campo data inizio
	 */
	private void checkEmissioneCommessa() {
		this.dateEmissioneCommessa.getEditor().addPropertyChangeListener(
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName().equals("value")) {
							checkDate();
						}

					}
				});
	}

	/**
	 * Metodo che aggiunge il controllo delle date per il campo data fine
	 */
	private void checkDataFine() {
		this.dateDataFine.getEditor().addPropertyChangeListener(
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName().equals("value")) {
							checkDate();
						}

					}
				});

	}

	/**
	 * Metodo che aggiunge il controllo del campo data scadenza
	 */
	private void checkScadenzaCommessa() {
		this.dateScadenzaCommessa.getEditor().addPropertyChangeListener(
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName().equals("value")) {
							checkDate();
						}
					}
				});
	}

	/**
	 * Metodo che controlla lo stato dei campi data inizio, fine e scadenza
	 */
	private void checkDate() {
		if (dateScadenzaCommessa.isEnabled()
				&& dateEmissioneCommessa.isEnabled()
				&& dateDataFine.isEnabled()) {
			if (dateScadenzaCommessa.getDate() != null
					&& dateDataFine.getDate() != null
					&& dateEmissioneCommessa.getDate() != null) {
				if (dateScadenzaCommessa.getDate().before(
						dateDataFine.getDate())) {
					setErrore(lblIcoScadenzaCommessa, false,
							"La data di scadenza non deve precedere la data fine");
				} else if (dateScadenzaCommessa.getDate().before(
						dateEmissioneCommessa.getDate())) {
					setErrore(lblIcoScadenzaCommessa, false,
							"La data di scadenza non deve precedere la data inizio");
				} else {
					setErrore(lblIcoScadenzaCommessa, true, null);
				}
			} else if (dateScadenzaCommessa.getDate() != null
					&& dateDataFine.getDate() != null
					&& dateEmissioneCommessa.getDate() == null) {
				if (dateScadenzaCommessa.getDate().before(
						dateDataFine.getDate())) {
					setErrore(lblIcoScadenzaCommessa, false,
							"La data di scadenza non deve precedere la data fine");
				} else {
					setErrore(lblIcoScadenzaCommessa, true, null);
				}
			}
			if (dateEmissioneCommessa.getDate() != null
					&& dateDataFine.getDate() != null)
				if (dateDataFine.getDate().before(
						dateEmissioneCommessa.getDate())) {
					setErrore(lblIcoEmissioneCommessa, false,
							"La data di inizio deve precedere la data di fine!");
					setErrore(lblIcoDataFine, false,
							"La data di inizio deve precedere la data di fine!");
				} else {
					setErrore(lblIcoEmissioneCommessa, true, null);
					setErrore(lblIcoDataFine, true, null);
				}
		}
	}

}