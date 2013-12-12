package GUI.Riquadri;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

import GUI.ConfigGUI;
import GUI.Abstract.ARiquadro;
import coedil99.model.MCommessa;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Riquadro dati produzione consegna
 * 
 * @author Simone
 * 
 */
@SuppressWarnings("serial")
public class RiquadroDatiProduzioneConsegna extends ARiquadro {

	private JLabel lblDataInizio;
	private JLabel lblDataFine;
	private JLabel lblScadenza;
	private JXDatePicker dateDataInizio;
	private JLabel lblIcoDataInizio;
	private JXDatePicker dateDataFine;
	private JLabel lblIcoDataFine;
	private JXDatePicker dateScadenza;
	private JLabel lblIcoScadenza;

	public RiquadroDatiProduzioneConsegna(String title) {
		super(title);
		this.initialize();
		this.makeEditable(false);
	}

	/**
	 * Aggiunge il campo data inizio
	 */
	private void addDataInizio() {
		this.lblDataInizio = new JLabel("Data Inizio");
		this.form.add(this.lblDataInizio, "2, 2");

		this.dateDataInizio = new JXDatePicker();
		this.dateDataInizio.getEditor().setEditable(false);
		this.dateDataInizio.setFormats("yyyy-MM-dd");
		this.form.add(this.dateDataInizio, "6, 2, fill, fill");
		this.lblIcoDataInizio = new JLabel("");
		this.lblIcoDataInizio.setVisible(false);
		this.form.add(lblIcoDataInizio, "8, 2, center, top");
		this.Label.add(lblIcoDataInizio);
	}

	/**
	 * Aggiunge il campo data fine
	 */
	private void addDataFine() {
		this.lblDataFine = new JLabel("Data Fine");
		this.form.add(this.lblDataFine, "2, 4");

		this.dateDataFine = new JXDatePicker();
		this.dateDataFine.getEditor().setEditable(false);
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.form.add(this.dateDataFine, "6, 4, fill, fill");
		this.lblIcoDataFine = new JLabel("");
		this.lblIcoDataFine.setVisible(false);
		this.form.add(lblIcoDataFine, "8, 4, center, top");
		this.Label.add(lblIcoDataFine);
	}

	/**
	 * Aggiunge il campo data scadenza sviluppo
	 */
	private void addDataScadenzaProduzione() {
		this.lblScadenza = new JLabel("Scadenza Sviluppo");
		this.form.add(this.lblScadenza, "2, 6");

		this.dateScadenza = new JXDatePicker();
		this.dateScadenza.getEditor().setEditable(false);
		this.dateScadenza.setFormats("yyyy-MM-dd");
		this.form.add(this.dateScadenza, "6, 6, fill, fill");

		this.lblIcoScadenza = new JLabel("");
		this.lblIcoScadenza.setVisible(false);
		this.form.add(lblIcoScadenza, "8, 6, center, top");
		this.Label.add(lblIcoScadenza);
	}

	/**
	 * Carica il contenuto del riquadro
	 */
	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		MCommessa c = (MCommessa) o;
		if (c.getPersistentModel().getInizioProduzione() != null)
			this.dateDataInizio.setDate(c.getPersistentModel().getOrdine()
					.getDataInizio());
		else
			this.dateDataInizio.setDate(null);

		if (c.getPersistentModel().getFineProduzione() != null)
			this.dateDataFine.setDate(c.getPersistentModel()
					.getFineProduzione());
		else
			this.dateDataFine.setDate(null);

		if (c.getPersistentModel().getScadenzaProduzione() != null)
			this.dateScadenza.setDate(c.getPersistentModel()
					.getScadenzaProduzione());
		else
			this.dateScadenza.setDate(null);
	}

	/**
	 * Salva le modifiche sul db
	 */
	@Override
	public void salva(boolean showmex) {
		if (this.oggetto != null) {
			MCommessa c = (MCommessa) this.oggetto;
			this.dateScadenza.setFormats("yyyy-MM-dd");
			c.getPersistentModel().setInizioProduzione(
					this.dateDataInizio.getDate());
			c.getPersistentModel().setFineProduzione(
					this.dateDataFine.getDate());
			c.getPersistentModel().setScadenzaProduzione(
					this.dateScadenza.getDate());
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
		this.dateScadenza.setEnabled(editable);
		this.dateDataInizio.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		super.makeEditable(editable);

	}

	/**
	 * Imposta la grafica
	 */
	@Override
	protected void initialize() {
		this.setSize(new Dimension(600, 160));
		this.form.setBounds(0, 40, 600, 130);
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
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));
		this.addDataInizio();
		this.addDataFine();
		this.addDataScadenzaProduzione();
		this.checkDataInizio();
		this.checkDataFine();
		this.checkDataScadenza();
	}

	/**
	 * Metodo che aggiunge il controllo delle date per il campo data inizio
	 */
	private void checkDataInizio() {
		this.dateDataInizio.getEditor().addPropertyChangeListener(
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
	private void checkDataScadenza() {
		this.dateScadenza.getEditor().addPropertyChangeListener(
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
		if (dateScadenza.isEnabled() && dateDataFine.isEnabled()
				&& dateDataInizio.isEnabled()) {
			if (dateScadenza.getDate() != null
					&& dateDataFine.getDate() != null
					&& dateDataInizio.getDate() != null) {
				if (dateScadenza.getDate().before(dateDataFine.getDate())) {
					setErrore(lblIcoScadenza, false,
							"La data di scadenza non deve precedere la data fine");
				} else if (dateScadenza.getDate().before(
						dateDataInizio.getDate())) {
					setErrore(lblIcoScadenza, false,
							"La data di scadenza non deve precedere la data inizio");
				} else {
					setErrore(lblIcoScadenza, true, null);
				}
			} else if (dateScadenza.getDate() != null
					&& dateDataFine.getDate() != null
					&& dateDataInizio.getDate() == null) {
				if (dateScadenza.getDate().before(dateDataFine.getDate())) {
					setErrore(lblIcoScadenza, false,
							"La data di scadenza non deve precedere la data fine");
				} else {
					setErrore(lblIcoScadenza, true, null);
				}
			}
			if (dateDataInizio.getDate() != null
					&& dateDataFine.getDate() != null)
				if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
					setErrore(lblIcoDataInizio, false,
							"La data di inizio deve precedere la data di fine!");
					setErrore(lblIcoDataFine, false,
							"La data di inizio deve precedere la data di fine!");
				} else {
					setErrore(lblIcoDataInizio, true, null);
					setErrore(lblIcoDataFine, true, null);
				}
		} 
	}
	
}