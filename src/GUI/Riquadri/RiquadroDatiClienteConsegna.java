package GUI.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.Abstract.ARiquadro;
import coedil99.controller.GestisciCantiereHandler;
import coedil99.controller.GestisciClienteHandler;
import coedil99.model.MCantiere;
import coedil99.model.MCliente;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Riquadro dati cliente consegna
 * 
 * @author Simone
 * 
 */
@SuppressWarnings("serial")
public class RiquadroDatiClienteConsegna extends ARiquadro {

	private JLabel lblCantiere;
	private JComboBox<Object> cbCantiere;
	private JLabel lblCliente;
	private JComboBox<Object> cbClienti;
	private JLabel lblCommessa;
	private JTextField txtCommessa;
	private JLabel lblIcoCantiere;
	private JLabel lblIcoCliente;
	private JLabel lblIcoCommessa;
	private String selected_cantiere;
	private String selected_cliente;

	public RiquadroDatiClienteConsegna(String title) {
		super(title);
		this.initialize();
	}

	/**
	 * Metodo che carica il contenuto del riquadro
	 */
	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		MCliente c = (MCliente) o;
		if (c.getPersistentModel().getCantiere().getNome() != null)
			this.cbCantiere.setSelectedItem(c.getPersistentModel()
					.getCantiere().getNome());
		if (c.getPersistentModel().getName() != null)
			this.cbClienti.setSelectedItem(c.getPersistentModel().getName());
		if (c.getPersistentModel().getNumeroCommessaCliente() != null)
			this.txtCommessa.setText(c.getPersistentModel()
					.getNumeroCommessaCliente().toString());
	}

	/**
	 * Metodo che modifica i campi del model e lo salva sul db 
	 * 
	 * CORREGGERE
	 * 
	 */
	@Override
	public void salva() {
		if (this.oggetto != null) {
			MCliente c = (MCliente) this.oggetto;
			c.getPersistentModel().getCantiere()
					.setNome(this.cbCantiere.getSelectedItem().toString());
			c.getPersistentModel().setName(
					this.cbClienti.getSelectedItem().toString());
			c.save();
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	/**
	 * Imposta la grafica
	 */
	@Override
	protected void initialize() {
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
		this.addCliente();
		this.addCantiere();
		this.addCommessa();
		this.makeEditable(false);
	}

	/**
	 * Aggiunge il campo cantiere
	 * 
	 */
	private void addCantiere() {
		this.lblCantiere = new JLabel("Cantiere");
		this.form.add(this.lblCantiere, "2, 4");
		this.cbCantiere = new JComboBox<Object>();
		this.cbCantiere.setAlignmentX(SwingConstants.CENTER);
		if (this.cbCantiere.getItemListeners().length != 0)
			this.cbCantiere.removeItemListener(this.cbCantiere
					.getItemListeners()[0]);
		this.cbCantiere.removeAllItems();
		this.cbCantiere.setEnabled(true);
		ArrayList<MCantiere> cantieri = GestisciCantiereHandler.getInstance()
				.getCantieri();
		for (int i = 0; i < cantieri.size(); ++i) {
			this.cbCantiere.addItem(cantieri.get(i).getPersistentModel()
					.getNome());
		}
		this.cbCantiere.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					RiquadroDatiClienteConsegna.this.selected_cantiere = RiquadroDatiClienteConsegna.this.cbCantiere
							.getSelectedItem().toString();

				}
			}
		});
		this.cbCantiere.setSelectedItem(null);
		this.cbCantiere.setEnabled(false);
		this.Container.add(new JTextField((this.selected_cantiere == null) ? ""
				: this.selected_cantiere));
		this.form.add(this.cbCantiere, "6, 4, fill, fill");
		this.lblIcoCantiere = new JLabel("");
		this.lblIcoCantiere.setVisible(false);
		this.form.add(lblIcoCantiere, "8, 4, center, top");
		this.Label.add(lblIcoCantiere);
	}

	/**
	 * Aggiunge il campo Cliente
	 */
	private void addCliente() {
		this.lblCliente = new JLabel("Cliente");
		this.form.add(this.lblCliente, "2, 2, left, center");

		this.cbClienti = new JComboBox<Object>();
		this.cbClienti.setAlignmentX(SwingConstants.CENTER);
		if (this.cbClienti.getItemListeners().length != 0)
			this.cbClienti.removeItemListener(this.cbClienti
					.getItemListeners()[0]);
		this.cbClienti.removeAllItems();
		this.cbClienti.setEnabled(true);
		ArrayList<MCliente> cantieri = GestisciClienteHandler.getInstance()
				.getClienti();
		for (int i = 0; i < cantieri.size(); ++i) {
			this.cbClienti.addItem(cantieri.get(i).getPersistentModel()
					.getName());
		}
		this.cbClienti.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					RiquadroDatiClienteConsegna.this.selected_cliente = RiquadroDatiClienteConsegna.this.cbClienti
							.getSelectedItem().toString();
					RiquadroDatiClienteConsegna.this.cbCantiere
							.setSelectedItem(GestisciClienteHandler
									.getInstance()
									.getClienteByName(selected_cliente)
									.getPersistentModel().getCantiere()
									.getNome());
					RiquadroDatiClienteConsegna.this.cbCantiere.setEnabled(false);
					RiquadroDatiClienteConsegna.this.txtCommessa.setText(String
							.valueOf(GestisciClienteHandler.getInstance()
									.getClienteByName(selected_cliente)
									.getPersistentModel()
									.getNumeroCommessaCliente()));
					RiquadroDatiClienteConsegna.this.validate();
					RiquadroDatiClienteConsegna.this.repaint();
				}
			}
		});
		this.cbClienti.setSelectedItem(null);
		this.cbClienti.setEnabled(false);
		this.Container.add(new JTextField(this.selected_cliente));
		this.form.add(this.cbClienti, "6, 2, fill, fill");
		this.lblIcoCliente = new JLabel("");
		this.lblIcoCliente.setVisible(false);
		this.form.add(lblIcoCliente, "8, 2, center, top");
		this.Label.add(lblIcoCliente);
	}

	/**
	 * Aggiunge il campo commessa
	 */
	private void addCommessa() {
		this.lblCommessa = new JLabel("Commessa");
		this.form.add(lblCommessa, "2, 6, left, center");

		this.txtCommessa = new JTextField();
		this.txtCommessa.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCommessa.setEditable(false);
		if (this.txtCommessa.getKeyListeners().length == 0)
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
	}

	public void setSelectedCantiere(String name) {
		this.cbCantiere.setSelectedItem(name);
	}

	public void setSelectedCliente(String name) {
		this.cbClienti.setSelectedItem(name);
	}

	@Override
	public void makeEditable(boolean editable) {
		//this.cbCantiere.setEnabled(editable);
		this.cbClienti.setEnabled(editable);

	}

}
