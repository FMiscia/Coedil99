package GUI.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import coedil99.model.Commessa;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


@SuppressWarnings("serial")
public class RiquadroDatiSviluppoConsegna extends Riquadro {

	private JPanel form;
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
		this.setSize(new Dimension(600, 220));
		this.form = new JPanel();
		this.form.setBounds(0, 30, 600, 190);
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

		/*
		 * Campo Responsabile
		 */

		this.lblResponsabile = new JLabel("Responsabile");
		this.form.add(this.lblResponsabile, "2, 2");

		this.txtResponsabile = new JTextField();
		this.txtResponsabile.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtResponsabile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtResponsabile.getText();
				String pattern = "[^a-zA-Z������']";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoResponsabile.setIcon(IcoErrore);
					lblIcoResponsabile
							.setToolTipText("Il campo Responsabile deve contenere solo lettere!");
					txtResponsabile.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoResponsabile.setIcon(IcoErrore);
					lblIcoResponsabile
							.setToolTipText("Il campo Responsabile deve contenere solo lettere!");
					txtResponsabile.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoResponsabile.setIcon(IcoOk);
					lblIcoResponsabile.setToolTipText("");
					txtResponsabile.setBorder(new LineBorder(Color.green));
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

		/*
		 * Campo Emissione Commessa
		 */

		this.lblEmissioneCommessa = new JLabel("Emissione Commessa");
		this.form.add(this.lblEmissioneCommessa, "2, 4");

		this.dateEmissioneCommessa = new JXDatePicker();
		this.dateEmissioneCommessa.setFormats("yyyy-MM-dd");
		this.dateEmissioneCommessa.getEditor().setEditable(false);
		this.dateEmissioneCommessa.getEditor().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (dateDataFine.getDate().before(dateEmissioneCommessa.getDate())) {
					lblIcoEmissioneCommessa.setIcon(IcoErrore);
					lblIcoEmissioneCommessa
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");
				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoEmissioneCommessa.setIcon(IcoOk);
					lblIcoEmissioneCommessa.setToolTipText(null);
				}
				controlloErrori();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (dateDataFine.getDate().before(dateEmissioneCommessa.getDate())) {
					lblIcoEmissioneCommessa.setIcon(IcoErrore);
					lblIcoEmissioneCommessa
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");
				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoEmissioneCommessa.setIcon(IcoOk);
					lblIcoEmissioneCommessa.setToolTipText(null);
				}
				controlloErrori();
			}
		});
		this.form.add(this.dateEmissioneCommessa, "6, 4, fill, fill");
		this.lblIcoEmissioneCommessa = new JLabel("");
		this.lblIcoEmissioneCommessa.setVisible(false);
		this.form.add(lblIcoEmissioneCommessa, "8, 4, center, top");
		this.Label.add(lblIcoEmissioneCommessa);

		/*
		 * Campo Data Fine
		 */
		this.lblDataFine = new JLabel("Data Fine Commessa");
		this.form.add(this.lblDataFine, "2, 6");

		this.dateDataFine = new JXDatePicker();
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.dateDataFine.getEditor().setEditable(false);
		this.dateDataFine.getEditor().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (dateDataFine.getDate().before(dateEmissioneCommessa.getDate())) {
					lblIcoEmissioneCommessa.setIcon(IcoErrore);
					lblIcoEmissioneCommessa
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");
				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoEmissioneCommessa.setIcon(IcoOk);
					lblIcoEmissioneCommessa.setToolTipText(null);
				}
				controlloErrori();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (dateDataFine.getDate().before(dateEmissioneCommessa.getDate())) {
					lblIcoEmissioneCommessa.setIcon(IcoErrore);
					lblIcoEmissioneCommessa
							.setToolTipText("La data di inizio deve precedere la data di fine!");
					lblIcoDataFine.setIcon(IcoErrore);
					lblIcoDataFine
							.setToolTipText("La data di inizio deve precedere la data di fine!");
				} else {
					lblIcoDataFine.setIcon(IcoOk);
					lblIcoDataFine.setToolTipText(null);
					lblIcoEmissioneCommessa.setIcon(IcoOk);
					lblIcoEmissioneCommessa.setToolTipText(null);
				}
				controlloErrori();
			}
		});
		this.lblIcoDataFine = new JLabel("");
		this.lblIcoDataFine.setVisible(false);
		this.form.add(lblIcoDataFine, "8, 6, center, top");
		this.Label.add(lblIcoDataFine);
		this.form.add(this.dateDataFine, "6, 6, fill, fill");

		
		/*
		 * Campo Scadenza Commessa
		 */

		this.lblScadenzaCommessa = new JLabel("Scadenza Commessa");
		this.form.add(this.lblScadenzaCommessa, "2, 8");

		this.dateScadenzaCommessa = new JXDatePicker();
		this.dateScadenzaCommessa.setFormats("yyyy-MM-dd");
		this.dateScadenzaCommessa.getEditor().setEditable(false);
		this.dateScadenzaCommessa.getEditor().addFocusListener(
				new FocusListener() {

					@Override
					public void focusLost(FocusEvent e) {
						if (dateScadenzaCommessa.getDate() == null) {
							lblIcoScadenzaCommessa.setIcon(IcoErrore);
							lblIcoScadenzaCommessa
									.setToolTipText("La data di scadenza deve essere selezionata!");
							dateScadenzaCommessa.setBorder(new LineBorder(
									Color.red));
						} else {
							lblIcoScadenzaCommessa.setIcon(IcoOk);
							lblIcoScadenzaCommessa.setToolTipText(null);
						}
						controlloErrori();
					}

					@Override
					public void focusGained(FocusEvent e) {
						if (dateScadenzaCommessa.getDate() == null) {
							lblIcoScadenzaCommessa.setIcon(IcoErrore);
							lblIcoScadenzaCommessa
									.setToolTipText("La data di scadenza deve essere selezionata!");
							dateScadenzaCommessa.setBorder(new LineBorder(
									Color.red));
						} else {
							lblIcoScadenzaCommessa.setIcon(IcoOk);
							lblIcoScadenzaCommessa.setToolTipText(null);
						}
						controlloErrori();
					}
				});
		this.form.add(dateScadenzaCommessa, "6, 8, fill, fill");
		this.lblIcoScadenzaCommessa = new JLabel("");
		this.lblIcoScadenzaCommessa.setVisible(false);
		this.form.add(lblIcoScadenzaCommessa, "8, 8, center, top");
		this.Label.add(lblIcoScadenzaCommessa);

		
		/*
		 * Campo Ritardo Produzione
		 */

		this.lblRitardo = new JLabel("Ritardo Produzione");
		this.form.add(this.lblRitardo, "2, 10");

		this.txtRitardo = new JTextField();
		this.txtRitardo.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtRitardo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtRitardo.getText();
				String pattern = "[\\D]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoRitardo.setIcon(IcoErrore);
					lblIcoRitardo
							.setToolTipText("Il campo Ritardo Produzione deve contenere solo numeri!");
					txtRitardo.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoRitardo.setIcon(IcoErrore);
					lblIcoRitardo
							.setToolTipText("Il campo Ritardo Produzione deve contenere solo numeri!");
					txtRitardo.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoRitardo.setIcon(IcoOk);
					lblIcoRitardo.setToolTipText("");
					txtRitardo.setBorder(new LineBorder(Color.green));
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

		this.makeEditable(false);
	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Commessa c = (Commessa) o;
		if (c.getResponsabile() != null)
			this.txtResponsabile.setText(c.getResponsabile());
		if (c.getEmissioneCommessa() != null)
			this.dateEmissioneCommessa.setDate(c.getEmissioneCommessa());
		if (c.getScadenzaCommessa() != null)
			this.dateScadenzaCommessa.setDate(c.getScadenzaCommessa());
		if (c.getFineCommessa() != null)
			this.dateDataFine.setDate(c.getFineCommessa());
		if (c.getRitardoProduzione() != null)
			this.txtRitardo.setText(c.getRitardoProduzione().toString());
	}

	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Commessa c = (Commessa) oggetto;
			c.setResponsabile(this.txtResponsabile.getText());
			c.setEmissioneCommessa(this.dateEmissioneCommessa.getDate());
			c.setScadenzaCommessa(this.dateScadenzaCommessa.getDate());
			c.setFineCommessa(this.dateDataFine.getDate());
			c.setRitardoProduzione(Integer.getInteger(this.txtRitardo.getText()));
			c.save();
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	@Override
	public void makeEditable(boolean editable) {
		// TODO Auto-generated method stub
		this.dateEmissioneCommessa.setEnabled(editable);
		this.dateScadenzaCommessa.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		super.makeEditable(editable);

	}

}