package GUIelaborazione2.Riquadri;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Cliente;
import elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager;

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
		this.form.setBounds(0,30,600,90);
		this.add(form);
		this.form.setLayout(new FormLayout(new ColumnSpec[] {
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
		
		
		this.lblCantiere = new JLabel("Cantiere");
		this.form.add(this.lblCantiere, "2, 2");
		
		this.txtCantiere = new JTextField();
		this.Container.add(this.txtCantiere);
		this.form.add(this.txtCantiere, "6, 2, fill, default");
		
		this.lblCliente = new JLabel("Cliente");
		this.form.add(this.lblCliente, "2, 4, left, center");
		
		this.txtCliente = new JTextField();
		this.Container.add(this.txtCliente);
		this.form.add(this.txtCliente, "6, 4, fill, default");
		
		this.lblCommessa = new JLabel("Commessa");
		this.form.add(lblCommessa, "2, 6, left, center");
		
		txtCommessa = new JTextField();
		this.Container.add(this.txtCommessa);
		this.form.add(this.txtCommessa, "6, 6, fill, default");
		this.makeEditable(false);
		
	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Cliente c = (Cliente) o;
		if(c.getCantiere().getNome() != null)
			this.txtCantiere.setText(c.getCantiere().getNome());
		if(c.getName() != null)
			this.txtCliente.setText(c.getName());
		if(c.getNumeroCommessaCliente() != null)
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
