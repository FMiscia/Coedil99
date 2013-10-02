package GUI.Riquadri;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import coedil99.model.Item;
import coedil99.operation.OItem;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


@SuppressWarnings("serial")
public class RiquadroOttimizzazione extends Riquadro {

	private JPanel form;
	private JLabel lblQual;
	private JTextField txtQual;
	private JLabel lblLarg;
	private JTextField txtLarg;
	private JLabel lblAltezza;
	private JTextField txtAltezza;
	private JLabel lblCommessaLung;
	private JTextField txtCommessaLung;
	private JLabel lblQuantita;
	private JTextField txtOrdineQuantita;
	private JLabel lblVolume;
	private JTextField txtVolume;

	
	
	public RiquadroOttimizzazione(String title) {
		super(title);
		remove(this.modifica);
		this.validate();
		this.repaint();
		this.setSize(new Dimension(600,310));
		form = new JPanel();
		form.setBounds(0,35,600,270);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC}));
		
		lblQual = new JLabel("Qual");
		form.add(lblQual, "2, 2");
		
		txtQual = new JTextField();
		form.add(txtQual, "6, 2, fill, default");
		this.Container.add(txtQual);
		
		lblLarg = new JLabel("Larghezza");
		form.add(lblLarg, "2, 4");
		
		txtLarg = new JTextField();
		form.add(txtLarg, "6, 4, fill, default");
		this.Container.add(txtLarg);
		
		lblAltezza = new JLabel("Altezza");
		form.add(lblAltezza, "2, 6");
		
		txtAltezza = new JTextField();
		form.add(txtAltezza, "6, 6, fill, default");
		this.Container.add(txtAltezza);

		
		lblCommessaLung = new JLabel("Lunghezza");
		form.add(lblCommessaLung, "2, 8");
		
		txtCommessaLung = new JTextField();
		form.add(txtCommessaLung, "6, 8, fill, default");
		this.Container.add(txtCommessaLung);

		
		lblQuantita = new JLabel("Quantità");
		form.add(lblQuantita, "2, 10");
		
		txtOrdineQuantita = new JTextField();
		form.add(txtOrdineQuantita, "6, 10, fill, default");
		this.Container.add(txtOrdineQuantita);

		
		lblVolume = new JLabel("Volume");
		form.add(lblVolume, "2, 12");
		
		txtVolume = new JTextField();
		form.add(txtVolume, "6, 12, fill, default");
		this.Container.add(txtVolume);
		this.makeEditable(false);

	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		Item i = (Item) o;
		OItem oi = i.getOItem();
		this.txtLarg.setText(oi.getBase()+" cm");
		this.txtAltezza.setText(oi.getAltezza()+" cm");
		this.txtCommessaLung.setText(oi.getLunghezza()/100 +" m");
		this.txtQual.setText("prova");
		this.txtOrdineQuantita.setText("prova");
		this.txtVolume.setText(oi.getBase()*oi.getAltezza()*oi.getLunghezza()/1000000+" m^3");
		this.validate();
		this.repaint();
	}

	@Override
	protected void resetRiquadro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void salva() {
		// TODO Auto-generated method stub
		
	}



}