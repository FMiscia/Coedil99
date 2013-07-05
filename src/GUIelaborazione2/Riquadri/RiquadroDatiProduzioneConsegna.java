package GUIelaborazione2.Riquadri;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;

@SuppressWarnings("serial")
public class RiquadroDatiProduzioneConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblDataInizio;
	private JTextField txtDataInizio;
	private JLabel lblDataFine;
	private JTextField txtDataFine;
	private JLabel lblScadenzaSviluppo;
	private JTextField txtScadenzaSviluppo;
	
	public RiquadroDatiProduzioneConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 130));
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
		
		this.lblDataInizio = new JLabel("Data Inizio");
		this.form.add(this.lblDataInizio, "2, 2");
		
		this.txtDataInizio = new JTextField();
		this.Container.add(this.txtDataInizio);
		this.form.add(this.txtDataInizio, "6, 2, fill, default");
		
		this.lblDataFine = new JLabel("Data Fine");
		this.form.add(this.lblDataFine, "2, 4");
		
		this.txtDataFine = new JTextField();
		this.Container.add(this.txtDataFine);
		this.form.add(this.txtDataFine, "6, 4, fill, default");
		
		this.lblScadenzaSviluppo = new JLabel("Scadenza Sviluppo");
		this.form.add(this.lblScadenzaSviluppo, "2, 6");
		
		this.txtScadenzaSviluppo = new JTextField();
		this.Container.add(this.txtScadenzaSviluppo);
		this.form.add(this.txtScadenzaSviluppo, "6, 6, fill, default");
	}

	@Override
	public void load(Object o) {
		this.resetRiquadro();
		Ordine ord = (Ordine) o;
		if(ord.getDataInizio() != null)
			this.txtDataInizio.setText(ord.getDataInizio().toString());
		if(ord.getDataFine() != null)
			this.txtDataFine.setText(ord.getDataFine().toString());
		if(ord.getDataScadenza() != null)
			this.txtScadenzaSviluppo.setText(ord.getDataScadenza().toString());
	}
}
