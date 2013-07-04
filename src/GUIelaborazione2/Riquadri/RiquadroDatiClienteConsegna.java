package GUIelaborazione2.Riquadri;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Cliente;

@SuppressWarnings("serial")
public class RiquadroDatiClienteConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblCantiere;
	private JTextField txtCantiere;
	private JLabel lblCliente;
	private JTextField txtCliente;
	private JLabel lblCommessa;
	private JTextField txtCommessa;

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
		
		txtCantiere = new JTextField();
		this.Container.add(txtCantiere);
		this.form.add(txtCantiere, "6, 2, fill, default");
		
		lblCliente = new JLabel("Cliente");
		this.form.add(lblCliente, "2, 4, left, center");
		
		txtCliente = new JTextField();
		this.Container.add(txtCliente);
		this.form.add(txtCliente, "6, 4, fill, default");
		
		lblCommessa = new JLabel("Commessa");
		this.form.add(lblCommessa, "2, 6, left, center");
		
		txtCommessa = new JTextField();
		this.Container.add(txtCommessa);
		this.form.add(txtCommessa, "6, 6, fill, default");

		
	}

	@Override
	public void load(Object o) {
		Cliente c = (Cliente) o;
		if(c.getCantiere().getNome() != null)
			txtCantiere.setText(c.getCantiere().getNome());
		if(c.getName() != null)
			txtCliente.setText(c.getName());
		if(c.getNumeroCommessaCliente() != null)
			txtCommessa.setText(c.getNumeroCommessaCliente().toString());
		validate();
		repaint();

	}
	

}
