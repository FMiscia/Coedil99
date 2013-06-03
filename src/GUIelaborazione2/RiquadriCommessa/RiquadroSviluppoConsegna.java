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
public class RiquadroSviluppoConsegna extends Riquadro {
	
	private JPanel form;
	private JLabel lblResponsabile;
	private JFormattedTextField txtResponsabile;
	private JLabel lblEmissioneCommessa;
	private JFormattedTextField txtEmissioneCommessa;
	private JLabel lblScadenzaCommessa;
	private JFormattedTextField txtScadenzaCommessa;
	private JLabel lblDataFine;
	private JFormattedTextField txtDataFine;
	private JLabel lblRitardo;
	private JFormattedTextField txtRitardo;
	
	public RiquadroSviluppoConsegna(String title) {
		super(title);
		setPreferredSize(new Dimension(600, 180));
		this.setSize(new Dimension(600, 180));
		form = new JPanel();
		form.setBounds(0,30,600,140);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblResponsabile = new JLabel("Responsabile");
		form.add(lblResponsabile, "2, 2");
		
		txtResponsabile = new JFormattedTextField();
		form.add(txtResponsabile, "6, 2, fill, default");
		
		lblEmissioneCommessa = new JLabel("Emissione Commessa");
		form.add(lblEmissioneCommessa, "2, 4");
		
		txtEmissioneCommessa = new JFormattedTextField();
		form.add(txtEmissioneCommessa, "6, 4, fill, default");
		
		lblScadenzaCommessa = new JLabel("Scadenza Commessa");
		form.add(lblScadenzaCommessa, "2, 6");
		
		txtScadenzaCommessa = new JFormattedTextField();
		form.add(txtScadenzaCommessa, "6, 6, fill, default");
		
		lblDataFine = new JLabel("Data Fine");
		form.add(lblDataFine, "2, 8");
		
		txtDataFine = new JFormattedTextField();
		form.add(txtDataFine, "6, 8, fill, default");
		
		lblRitardo = new JLabel("Ritardo");
		form.add(lblRitardo, "2, 10");
		
		txtRitardo = new JFormattedTextField();
		form.add(txtRitardo, "6, 10, fill, default");
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub

	}
}
