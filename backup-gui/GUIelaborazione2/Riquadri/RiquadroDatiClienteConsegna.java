package GUIelaborazione2.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import coedil99.model.Cliente;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


@SuppressWarnings("serial")
public class RiquadroDatiClienteConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblCantiere;
	private JTextField txtCantiere;
	private JLabel lblCliente;
	private JTextField txtCliente;
	private JLabel lblCommessa;
	private JTextField txtCommessa;
	private JLabel lblIcoCantiere;
	private JLabel lblIcoCliente;
	private JLabel lblIcoCommessa;

	public RiquadroDatiClienteConsegna(String title) {
		super(title);
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

		/*
		 * Campo Cantiere
		 */

		this.lblCantiere = new JLabel("Cantiere");
		this.form.add(this.lblCantiere, "2, 2");

		this.txtCantiere = new JTextField();
		this.txtCantiere.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantiere.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtCantiere.getText();
				String pattern = "[^\\w������\\s]+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoCantiere.setIcon(IcoErrore);
					lblIcoCantiere
							.setToolTipText("Il campo Cantiere deve contenere solo lettere e/o numeri!");
					txtCantiere.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoCantiere.setIcon(IcoErrore);
					lblIcoCantiere
							.setToolTipText("Il campo Cantiere deve contenere solo lettere e/o numeri!");
					txtCantiere.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoCantiere.setIcon(IcoOk);
					lblIcoCantiere.setToolTipText("");
					txtCantiere.setBorder(new LineBorder(Color.green));
				}
				RiquadroDatiClienteConsegna.this.controlloErrori();
			}
		});
		this.Container.add(this.txtCantiere);
		this.form.add(this.txtCantiere, "6, 2, fill, fill");
		this.lblIcoCantiere = new JLabel("");
		this.lblIcoCantiere.setVisible(false);
		this.form.add(lblIcoCantiere, "8, 2, center, top");
		this.Label.add(lblIcoCantiere);

		/*
		 * Campo Cliente
		 */

		this.lblCliente = new JLabel("Cliente");
		this.form.add(this.lblCliente, "2, 4, left, center");

		this.txtCliente = new JTextField();
		this.txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtCliente.getText();
				String pattern = "[^\\w������\\s]+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoCliente.setIcon(IcoErrore);
					lblIcoCliente
							.setToolTipText("Il campo Cliente deve contenere solo lettere e/o numeri!");
					txtCliente.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoCliente.setIcon(IcoErrore);
					lblIcoCliente
							.setToolTipText("Il campo Cliente deve contenere solo lettere e/o numeri!");
					txtCliente.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoCliente.setIcon(IcoOk);
					lblIcoCliente.setToolTipText("");
					txtCliente.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(this.txtCliente);
		this.form.add(this.txtCliente, "6, 4, fill, fill");
		this.lblIcoCliente = new JLabel("");
		this.lblIcoCliente.setVisible(false);
		this.form.add(lblIcoCliente, "8, 4, center, top");
		this.Label.add(lblIcoCliente);

		/*
		 * Campo Commessa
		 */

		this.lblCommessa = new JLabel("Commessa");
		this.form.add(lblCommessa, "2, 6, left, center");

		this.txtCommessa = new JTextField();
		this.txtCommessa.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCommessa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = txtCommessa.getText();
				String pattern = "[\\D]+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoCommessa.setIcon(IcoErrore);
					lblIcoCommessa
							.setToolTipText("Il campo Commessa deve contenere solo numeri!");
					txtCommessa.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoCommessa.setIcon(IcoErrore);
					lblIcoCommessa
							.setToolTipText("Il campo Commessa deve contenere solo numeri!");
					txtCommessa.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoCommessa.setIcon(IcoOk);
					lblIcoCommessa.setToolTipText("");
					txtCommessa.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(this.txtCommessa);
		this.form.add(this.txtCommessa, "6, 6, fill, fill");
		this.lblIcoCommessa = new JLabel("");
		this.lblIcoCommessa.setVisible(false);
		this.form.add(lblIcoCommessa, "8, 6, center, top");
		this.Label.add(lblIcoCommessa);

		this.makeEditable(false);

	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Cliente c = (Cliente) o;
		if (c.getCantiere().getNome() != null)
			this.txtCantiere.setText(c.getCantiere().getNome());
		if (c.getName() != null)
			this.txtCliente.setText(c.getName());
		if (c.getNumeroCommessaCliente() != null)
			this.txtCommessa.setText(c.getNumeroCommessaCliente().toString());
	}

	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Cliente c = (Cliente) this.oggetto;
			c.getCantiere().setNome(this.txtCantiere.getText());
			c.setName(this.txtCliente.getText());
			c.save();
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}


}