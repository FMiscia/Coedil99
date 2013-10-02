package GUI.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

import coedil99.model.Commessa;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class RiquadroDatiConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblDataPrimaConsegna;
	private JLabel lblRitardoConsegna;
	private JFormattedTextField txtRirardoConsegna;
	private JXDatePicker dateDataPrimaConsegna;
	private JLabel lblIcoDataPrimaConsegna;
	private JLabel lblIcoRirardoConsegna;

	public RiquadroDatiConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 120));
		this.form = new JPanel();
		this.form.setBounds(0, 30, 600, 80);
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
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));

		/*
		 * Campo Data Prima Consegna
		 */

		this.lblDataPrimaConsegna = new JLabel("Data Prima Consegna");
		this.form.add(this.lblDataPrimaConsegna, "2, 2");

		this.dateDataPrimaConsegna = new JXDatePicker();
		this.dateDataPrimaConsegna.getEditor().setEditable(false);
		this.dateDataPrimaConsegna.getEditor().addFocusListener(
				new FocusListener() {

					@Override
					public void focusLost(FocusEvent e) {
						if (dateDataPrimaConsegna.getDate() == null) {
							lblIcoDataPrimaConsegna.setIcon(IcoErrore);
							lblIcoDataPrimaConsegna
									.setToolTipText("La data di scadenza deve essere selezionata!");
						} else {
							lblIcoDataPrimaConsegna.setIcon(IcoOk);
							lblIcoDataPrimaConsegna.setToolTipText(null);
						}
						controlloErrori();
					}

					@Override
					public void focusGained(FocusEvent e) {
						if (dateDataPrimaConsegna.getDate() == null) {
							lblIcoDataPrimaConsegna.setIcon(IcoErrore);
							lblIcoDataPrimaConsegna
									.setToolTipText("La data di scadenza deve essere selezionata!");
						} else {
							lblIcoDataPrimaConsegna.setIcon(IcoOk);
							lblIcoDataPrimaConsegna.setToolTipText(null);
						}
						controlloErrori();
					}
				});
		this.dateDataPrimaConsegna.setFormats("yyyy-MM-dd");
		this.form.add(this.dateDataPrimaConsegna, "6, 2, fill, fill");

		this.lblIcoDataPrimaConsegna = new JLabel("");
		this.lblIcoDataPrimaConsegna.setVisible(false);
		this.form.add(lblIcoDataPrimaConsegna, "8, 2, center, top");
		this.Label.add(lblIcoDataPrimaConsegna);

		/*
		 * Campo Ritardo Consegna
		 */
		this.lblRitardoConsegna = new JLabel("Ritardo Consegna");
		this.form.add(this.lblRitardoConsegna, "2, 4");

		this.txtRirardoConsegna = new JFormattedTextField();
		this.txtRirardoConsegna.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtRirardoConsegna.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtRirardoConsegna.getText();
				String pattern = "[\\D]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoRirardoConsegna.setIcon(IcoErrore);
					lblIcoRirardoConsegna
							.setToolTipText("Il campo Ritardo deve contenere solo numeri!");
					txtRirardoConsegna.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoRirardoConsegna.setIcon(IcoErrore);
					lblIcoRirardoConsegna
							.setToolTipText("Il campo Ritardo deve contenere solo numeri!");
					txtRirardoConsegna.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoRirardoConsegna.setIcon(IcoOk);
					lblIcoRirardoConsegna.setToolTipText("");
					txtRirardoConsegna.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(this.txtRirardoConsegna);
		this.form.add(this.txtRirardoConsegna, "6, 4, fill, fill");
		this.lblIcoRirardoConsegna = new JLabel("");
		this.lblIcoRirardoConsegna.setVisible(false);
		this.form.add(lblIcoRirardoConsegna, "8, 4, center, top");
		this.Label.add(lblIcoRirardoConsegna);
		this.makeEditable(false);
	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Commessa c = (Commessa) o;
		if (c.getPrimaConsegna() != null)
			this.dateDataPrimaConsegna.setDate(c.getPrimaConsegna());
		else
			this.dateDataPrimaConsegna.setDate(null);
		if (c.getRitardoConsegna() != null)
			this.txtRirardoConsegna.setText(c.getRitardoConsegna().toString());

	}

	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Commessa c = (Commessa) this.oggetto;
			c.setPrimaConsegna(this.dateDataPrimaConsegna.getDate());
			c.setRitardoConsegna(Integer.valueOf(this.txtRirardoConsegna
					.getText()));
			c.save();
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	@Override
	public void makeEditable(boolean editable) {
		this.dateDataPrimaConsegna.setEnabled(editable);
		super.makeEditable(editable);

	}


}