package GUIelaborazione2.RiquadriCommessa;

import java.awt.Dimension;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class RiquadroDatiConsegna extends Riquadro {

	private JPanel form;
	
	public RiquadroDatiConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 100));
		form = new JPanel();
		form.setBounds(0,30,600,60);
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblDataPrimaConsegna = new JLabel("Data Prima Consegna");
		form.add(lblDataPrimaConsegna, "2, 2");
		
		JFormattedTextField txtDataPrimaConsegna = new JFormattedTextField();
		form.add(txtDataPrimaConsegna, "6, 2, fill, default");
		
		JLabel lblRitardoConsegna = new JLabel("Ritardo Consegna");
		form.add(lblRitardoConsegna, "2, 4");
		
		JFormattedTextField txtRirardoConsegna = new JFormattedTextField();
		form.add(txtRirardoConsegna, "6, 4, fill, default");
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub

	}

}
