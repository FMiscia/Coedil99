package GUIelaborazione2.Riquadri;

import java.awt.Dimension;
import java.sql.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;

@SuppressWarnings("serial")
public class RiquadroDatiConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblDataPrimaConsegna;
	private JFormattedTextField txtDataPrimaConsegna;
	private JLabel lblRitardoConsegna;
	private JFormattedTextField txtRirardoConsegna;
	
	public RiquadroDatiConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 100));
		this.form = new JPanel();
		this.form.setBounds(0,30,600,60);
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblDataPrimaConsegna = new JLabel("Data Prima Consegna");
		this.form.add(this.lblDataPrimaConsegna, "2, 2");
		
		this.txtDataPrimaConsegna = new JFormattedTextField();
		this.Container.add(this.txtDataPrimaConsegna);
		this.form.add(this.txtDataPrimaConsegna, "6, 2, fill, default");
		
		this.lblRitardoConsegna = new JLabel("Ritardo Consegna");
		this.form.add(this.lblRitardoConsegna, "2, 4");
		
		this.txtRirardoConsegna = new JFormattedTextField();
		this.Container.add(this.txtRirardoConsegna);
		this.form.add(this.txtRirardoConsegna, "6, 4, fill, default");
		this.makeEditable(false);
	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Commessa c = (Commessa) o;
		if(c.getPrimaConsegna() != null)
			this.txtDataPrimaConsegna.setText(c.getPrimaConsegna().toString());
		if(c.getRitardoConsegna() != null)
			this.txtRirardoConsegna.setText(c.getRitardoConsegna().toString());

	}

	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Commessa c = (Commessa) this.oggetto;
			c.setPrimaConsegna(Date.valueOf(this.txtDataPrimaConsegna.getText()));
			c.setRitardoConsegna(Integer.valueOf(this.txtRirardoConsegna
					.getText()));
			c.save();
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}
}
