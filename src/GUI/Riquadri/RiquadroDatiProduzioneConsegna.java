package GUI.Riquadri;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		if (this.dateDataInizio.getEditor().getFocusListeners().length == 0) {
			this.dateDataInizio.getEditor().addFocusListener(
					new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) {
							if (dateDataFine.getDate().before(
									dateDataInizio.getDate())) {
								lblIcoDataInizio.setIcon(ConfigGUI.getErrorIcon());
								lblIcoDataInizio
										.setToolTipText("La data di inizio deve precedere la data di fine!");
								lblIcoDataFine.setIcon(ConfigGUI.getErrorIcon());
								lblIcoDataFine
										.setToolTipText("La data di inizio deve precedere la data di fine!");
							} else {
								lblIcoDataFine.setIcon(ConfigGUI.getOkIcon());
								lblIcoDataFine.setToolTipText(null);
								lblIcoDataInizio.setIcon(ConfigGUI.getOkIcon());
								lblIcoDataInizio.setToolTipText(null);
							}
							controlloErrori();
						}

						@Override
						public void focusLost(FocusEvent e) {
							if (dateDataFine.getDate().before(
									dateDataInizio.getDate())) {
								lblIcoDataInizio.setIcon(ConfigGUI.getErrorIcon());
								lblIcoDataInizio
										.setToolTipText("La data di inizio deve precedere la data di fine!");
								lblIcoDataFine.setIcon(ConfigGUI.getErrorIcon());
								lblIcoDataFine
										.setToolTipText("La data di inizio deve precedere la data di fine!");
							} else {
								lblIcoDataFine.setIcon(ConfigGUI.getOkIcon());
								lblIcoDataFine.setToolTipText(null);
								lblIcoDataInizio.setIcon(ConfigGUI.getOkIcon());
								lblIcoDataInizio.setToolTipText(null);
							}
							controlloErrori();
						}
					});
		}
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
		if (this.dateDataFine.getEditor().getFocusListeners().length == 0) {
			this.dateDataFine.getEditor().addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
						lblIcoDataInizio.setIcon(ConfigGUI.getErrorIcon());
						lblIcoDataInizio
								.setToolTipText("La data di inizio deve precedere la data di fine!");
						lblIcoDataFine.setIcon(ConfigGUI.getErrorIcon());
						lblIcoDataFine
								.setToolTipText("La data di inizio deve precedere la data di fine!");
					} else {
						lblIcoDataFine.setIcon(ConfigGUI.getOkIcon());
						lblIcoDataFine.setToolTipText(null);
						lblIcoDataInizio.setIcon(ConfigGUI.getOkIcon());
						lblIcoDataInizio.setToolTipText(null);
					}
					controlloErrori();
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (dateDataFine.getDate().before(dateDataInizio.getDate())) {
						lblIcoDataInizio.setIcon(ConfigGUI.getErrorIcon());
						lblIcoDataInizio
								.setToolTipText("La data di inizio deve precedere la data di fine!");
						lblIcoDataFine.setIcon(ConfigGUI.getErrorIcon());
						lblIcoDataFine
								.setToolTipText("La data di inizio deve precedere la data di fine!");
					} else {
						lblIcoDataFine.setIcon(ConfigGUI.getOkIcon());
						lblIcoDataFine.setToolTipText(null);
						lblIcoDataInizio.setIcon(ConfigGUI.getOkIcon());
						lblIcoDataInizio.setToolTipText(null);
					}
					controlloErrori();
				}
			});
		}
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
		if (this.dateScadenza.getEditor().getFocusListeners().length == 0) {
			this.dateScadenza.getEditor().addFocusListener(
					new FocusListener() {

						@Override
						public void focusLost(FocusEvent e) {
							if (dateScadenza.getDate() == null) {
								lblIcoScadenza.setIcon(ConfigGUI.getErrorIcon());
								lblIcoScadenza
										.setToolTipText("La data di scadenza deve essere selezionata!");
							} else {
								lblIcoScadenza.setIcon(ConfigGUI.getOkIcon());
								lblIcoScadenza.setToolTipText(null);
							}
							controlloErrori();
						}

						@Override
						public void focusGained(FocusEvent e) {
							if (dateScadenza.getDate() == null) {
								lblIcoScadenza.setIcon(ConfigGUI.getErrorIcon());
								lblIcoScadenza
										.setToolTipText("La data di scadenza deve essere selezionata!");
							} else {
								lblIcoScadenza.setIcon(ConfigGUI.getOkIcon());
								lblIcoScadenza.setToolTipText(null);
							}
							controlloErrori();
						}
					});
		}
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
			this.dateDataFine.setDate(c.getPersistentModel().getFineProduzione());
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
			c.getPersistentModel().setFineProduzione(this.dateDataFine.getDate());
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
		lblTitolo.setBounds(0, 1, 170, 20);
		this.setSize(new Dimension(600, 150));
		this.form.setBounds(0, 30, 600, 120);
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
	}

}