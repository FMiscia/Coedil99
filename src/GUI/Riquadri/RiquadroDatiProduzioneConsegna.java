package GUI.Riquadri;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;
import org.orm.PersistentException;

import GUI.Abstract.ARiquadro;
import coedil99.model.Ordine;

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

	private JPanel form;
	private JLabel lblDataInizio;
	private JLabel lblDataFine;
	private JLabel lblScadenzaSviluppo;
	private JXDatePicker dateDataInizio;
	private JLabel lblIcoDataInizio;
	private JXDatePicker dateDataFine;
	private JLabel lblIcoDataFine;
	private JXDatePicker dateScadenzaSviluppo;
	private JLabel lblIcoScadenzaSviluppo;

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
							if (dateDataFine.getDate().before(
									dateDataInizio.getDate())) {
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
	private void addDataScadenzaSviluppo() {
		this.lblScadenzaSviluppo = new JLabel("Scadenza Sviluppo");
		this.form.add(this.lblScadenzaSviluppo, "2, 6");

		this.dateScadenzaSviluppo = new JXDatePicker();
		this.dateScadenzaSviluppo.getEditor().setEditable(false);
		if (this.dateScadenzaSviluppo.getEditor().getFocusListeners().length == 0) {
			this.dateScadenzaSviluppo.getEditor().addFocusListener(
					new FocusListener() {

						@Override
						public void focusLost(FocusEvent e) {
							if (dateScadenzaSviluppo.getDate() == null) {
								lblIcoScadenzaSviluppo.setIcon(IcoErrore);
								lblIcoScadenzaSviluppo
										.setToolTipText("La data di scadenza deve essere selezionata!");
							} else {
								lblIcoScadenzaSviluppo.setIcon(IcoOk);
								lblIcoScadenzaSviluppo.setToolTipText(null);
							}
							controlloErrori();
						}

						@Override
						public void focusGained(FocusEvent e) {
							if (dateScadenzaSviluppo.getDate() == null) {
								lblIcoScadenzaSviluppo.setIcon(IcoErrore);
								lblIcoScadenzaSviluppo
										.setToolTipText("La data di scadenza deve essere selezionata!");
							} else {
								lblIcoScadenzaSviluppo.setIcon(IcoOk);
								lblIcoScadenzaSviluppo.setToolTipText(null);
							}
							controlloErrori();
						}
					});
		}
		this.dateScadenzaSviluppo.setFormats("yyyy-MM-dd");
		this.form.add(this.dateScadenzaSviluppo, "6, 6, fill, fill");

		this.lblIcoScadenzaSviluppo = new JLabel("");
		this.lblIcoScadenzaSviluppo.setVisible(false);
		this.form.add(lblIcoScadenzaSviluppo, "8, 6, center, top");
		this.Label.add(lblIcoScadenzaSviluppo);
	}

	/**
	 * Carica il contenuto del riquadro
	 */
	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Ordine ord = (Ordine) o;
		if (ord.getDataInizio() != null)
			this.dateDataInizio.setDate(ord.getDataInizio());
		else
			this.dateDataInizio.setDate(null);

		if (ord.getDataFine() != null)
			this.dateDataFine.setDate(ord.getDataFine());
		else
			this.dateDataFine.setDate(null);

		if (ord.getDataScadenza() != null)
			this.dateScadenzaSviluppo.setDate(ord.getDataScadenza());
		else
			this.dateScadenzaSviluppo.setDate(null);
	}

	/**
	 * Salva le modifiche sul db
	 */
	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Ordine ord = (Ordine) this.oggetto;
			ord.setDataInizio(this.dateDataInizio.getDate());
			ord.setDataFine(this.dateDataFine.getDate());
			ord.setDataScadenza(this.dateScadenzaSviluppo.getDate());
			try {
				ord.save();
			} catch (PersistentException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	/**
	 * Rende editabili i campi data
	 */
	@Override
	public void makeEditable(boolean editable) {
		this.dateDataInizio.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		this.dateScadenzaSviluppo.setEnabled(editable);
		super.makeEditable(editable);

	}

	/**
	 * Imposta la grafica
	 */
	@Override
	protected void initialize() {
		lblTitolo.setBounds(0, 1, 170, 20);
		this.setSize(new Dimension(600, 150));
		this.form = new JPanel();
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
		this.addDataScadenzaSviluppo();
	}

}