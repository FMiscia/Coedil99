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

@SuppressWarnings("serial")
public class RiquadroDatiSviluppoConsegna extends Riquadro {
	
	private JPanel form;
	private JLabel lblResponsabile;
	private JTextField txtResponsabile;
	private JLabel lblEmissioneCommessa;
	private JTextField txtEmissioneCommessa;
	private JLabel lblScadenzaCommessa;
	private JTextField txtScadenzaCommessa;
	private JLabel lblDataFine;
	private JTextField txtDataFine;
	private JLabel lblRitardo;
	private JTextField txtRitardo;
	
	public RiquadroDatiSviluppoConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 180));
		this.form = new JPanel();
		this.form.setBounds(0,30,600,140);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblResponsabile = new JLabel("Responsabile");
		this.form.add(this.lblResponsabile, "2, 2");
		
		this.txtResponsabile = new JTextField();
		this.Container.add(this.txtResponsabile);
		this.form.add(this.txtResponsabile, "6, 2, fill, default");
		
		this.lblEmissioneCommessa = new JLabel("Emissione Commessa");
		this.form.add(this.lblEmissioneCommessa, "2, 4");
		
		this.txtEmissioneCommessa = new JTextField();
		this.Container.add(this.txtEmissioneCommessa);
		this.form.add(this.txtEmissioneCommessa, "6, 4, fill, default");
		
		this.lblScadenzaCommessa = new JLabel("Scadenza Commessa");
		this.form.add(this.lblScadenzaCommessa, "2, 6");
		
		this.txtScadenzaCommessa = new JTextField();
		this.Container.add(this.txtScadenzaCommessa);
		form.add(txtScadenzaCommessa, "6, 6, fill, default");
		
		this.lblDataFine = new JLabel("Data Fine Commessa");
		this.form.add(this.lblDataFine, "2, 8");
		
		this.txtDataFine = new JTextField();
		this.Container.add(this.txtDataFine);
		this.form.add(this.txtDataFine, "6, 8, fill, default");
		
		this.lblRitardo = new JLabel("Ritardo Produzione");
		this.form.add(this.lblRitardo, "2, 10");
		
		this.txtRitardo = new JTextField();
		this.Container.add(this.txtRitardo);
		this.form.add(this.txtRitardo, "6, 10, fill, default");
	}

	@Override
	public void load(Object o) {
		this.resetRiquadro();
		Commessa c = (Commessa)o;
		if(c.getResponsabile() != null)
			this.txtResponsabile.setText(c.getResponsabile());
		if(c.getEmissioneCommessa() != null)
			this.txtEmissioneCommessa.setText(c.getEmissioneCommessa().toString());
		if(c.getScadenzaCommessa() != null)
			this.txtScadenzaCommessa.setText(c.getScadenzaCommessa().toString());
		if(c.getFineCommessa() != null)
			this.txtDataFine.setText(c.getFineCommessa().toString());
		if(c.getRitardoProduzione() != null)
			this.txtRitardo.setText(c.getRitardoProduzione().toString());
	}

	@Override
	protected void resetRiquadro() {
		if(this.Container.size() != 0){
			for(JTextField txt: Container)
				txt.setText("");
		}
		
	}
}
