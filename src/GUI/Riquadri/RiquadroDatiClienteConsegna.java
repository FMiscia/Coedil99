package GUI.Riquadri;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI.Abstract.ARiquadro;
import coedil99.model.MCommessa;

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
	private JTextField txtCantiere;
	private JLabel lblCliente;
	private JTextField txtClienti;
	private JLabel lblCommessa;
	private JTextField txtCommessa;
	private JLabel lblIcoCantiere;
	private JLabel lblIcoCliente;
	private JLabel lblIcoCommessa;
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
		MCommessa c = (MCommessa) o;
		if (c.getPersistentModel().getOrdine().getCliente().getCantiere()
				.getNome() != null)
			this.txtCantiere.setText(c.getPersistentModel().getOrdine()
					.getCliente().getCantiere().getNome());
		if (c.getPersistentModel().getOrdine().getCliente().getName() != null)
			this.txtClienti.setText(c.getPersistentModel().getOrdine()
					.getCliente().getName());
		if (c.getPersistentModel().getOrdine().getCliente()
				.getNumeroCommessaCliente() != null)
			this.txtCommessa.setText(c.getPersistentModel().getOrdine()
					.getCliente().getNumeroCommessaCliente().toString());
	}

	/**
	 * Metodo che modifica i campi del model e lo salva sul db
	 * 
	 */
	@Override
	public void salva(boolean showmex) {
		if (this.oggetto != null) {
			MCommessa c = (MCommessa) this.oggetto;
			c.getPersistentModel().getOrdine().getCliente().getCantiere()
					.setNome(this.txtCantiere.getText());
			c.getPersistentModel().getOrdine().getCliente()
					.setName(this.txtClienti.getText());
			c.getPersistentModel().getOrdine().getCliente().setNumeroCommessaCliente(Integer.parseInt(this.txtCommessa.getText()));
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
		this.txtCantiere = new JTextField();
		this.txtCantiere.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantiere.setText("Seleziona un ordine!");
		this.txtCantiere.setEnabled(false);
		this.form.add(this.txtCantiere, "6, 4, fill, fill");
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

		this.txtClienti = new JTextField();
		this.txtClienti.setAlignmentX(SwingConstants.CENTER);
		this.txtClienti.setText("Seleziona un ordine!");
		this.txtClienti.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtClienti.setEnabled(false);
		this.Container.add(new JTextField(this.selected_cliente));
		this.form.add(this.txtClienti, "6, 2, fill, fill");
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
		this.txtCommessa = new JTextField("Seleziona un ordine!");
		this.txtCommessa.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCommessa.setEnabled(false);
		this.form.add(this.txtCommessa, "6, 6, fill, fill");
		this.lblIcoCommessa = new JLabel("");
		this.lblIcoCommessa.setVisible(false);
		this.form.add(lblIcoCommessa, "8, 6, center, top");
		this.Label.add(lblIcoCommessa);
	}

	/**
	 * Mette in focus nella combo box il cantiere
	 * 
	 * @param name
	 *            : cantiere desiderato
	 */
	public void setSelectedCantiere(String name) {
		this.txtCantiere.setText(name);
	}

	/**
	 * Mette in focus nella combo box il cliente
	 * 
	 * @param name
	 *            : cliente desiderato
	 */
	public void setSelectedCliente(String name) {
		this.txtClienti.setText(name);
	}

	public void setNumeroCommessaCliente(int n) {
		this.txtCommessa.setText(String.valueOf(n));
	}

	@Override
	public void makeEditable(boolean editable) {
		this.modifica.setVisible(false);
	}

}
