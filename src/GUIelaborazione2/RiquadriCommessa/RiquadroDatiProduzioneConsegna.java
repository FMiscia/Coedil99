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
public class RiquadroDatiProduzioneConsegna extends Riquadro {

	private JPanel form;
	
	public RiquadroDatiProduzioneConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 130));
		form = new JPanel();
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
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		form.add(lblDataInizio, "2, 2");
		
		JFormattedTextField txtDataInizio = new JFormattedTextField();
		form.add(txtDataInizio, "6, 2, fill, default");
		
		JLabel lblDataFine = new JLabel("Data Fine");
		form.add(lblDataFine, "2, 4");
		
		JFormattedTextField txtDataFine = new JFormattedTextField();
		form.add(txtDataFine, "6, 4, fill, default");
		
		JLabel lblScadenzaSviluppo = new JLabel("Scadenza Sviluppo");
		form.add(lblScadenzaSviluppo, "2, 6");
		
		JFormattedTextField txtScadenzaSviluppo = new JFormattedTextField();
		form.add(txtScadenzaSviluppo, "6, 6, fill, default");
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub

	}
}
