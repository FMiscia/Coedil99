package GUIelaborazione2.RiquadriCommessa;

import java.awt.Dimension;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

@SuppressWarnings("serial")
public class RiquadroDatiClienteConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblCantiere;
	private JFormattedTextField txtCantiere;
	private JLabel lblCliente;
	private JFormattedTextField txtCliente;
	private JLabel lblCommessa;
	private JFormattedTextField txtCommessa;

	public RiquadroDatiClienteConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600,130));
		this.form = new JPanel();
		form.setBounds(0,30,600,90);
		this.add(form);
		form.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(230px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		lblCantiere = new JLabel("Cantiere");
		this.form.add(lblCantiere, "2, 2");
		
		txtCantiere = new JFormattedTextField();
		this.form.add(txtCantiere, "6, 2, fill, default");
		
		lblCliente = new JLabel("Cliente");
		this.form.add(lblCliente, "2, 4, left, center");
		
		txtCliente = new JFormattedTextField();
		this.form.add(txtCliente, "6, 4, fill, default");
		
		lblCommessa = new JLabel("Commessa");
		this.form.add(lblCommessa, "2, 6, left, center");
		
		txtCommessa = new JFormattedTextField();
		this.form.add(txtCommessa, "6, 6, fill, default");

		
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub

	}

}
