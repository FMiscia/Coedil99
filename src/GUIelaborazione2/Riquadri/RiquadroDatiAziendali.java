package GUIelaborazione2.Riquadri;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
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
public class RiquadroDatiAziendali extends Riquadro {

	private JPanel form;
	private JLabel lblOC;
	private JTextField txtOC;
	private JLabel lblAnno;
	private JTextField txtAnno;
	private JLabel lblOrdineContratto;
	private JTextField txtOrdineContratto;
	private JLabel lblCommessaCoedil;
	private JTextField txtCommessaCoedil;
	private JLabel lblOrdineGestionale;
	private JTextField txtOrdineGestionale;
	private JLabel lblDataInizio;
	private JTextField txtDataInizio;
	private JLabel lblDataFine;
	private JTextField txtDataFine;
	private JLabel lblOrario;
	private JTextField txtOrario;
	private JLabel lblDescrizione;
	private JTextField txtDescrizione;
	private boolean aperto;
	private JButton toggle;
	
	
	
	public RiquadroDatiAziendali(String title) {
		super(title);
		this.aperto = true;
		this.setSize(new Dimension(600, 290));
		this.form = new JPanel();
		this.form.setBounds(0,30,600,250);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblOC = new JLabel("O/C");
		this.form.add(this.lblOC, "2, 2");
		
		this.txtOC = new JTextField();
		this.Container.add(this.txtOC);
		this.form.add(this.txtOC, "6, 2, fill, default");

		
		this.lblAnno = new JLabel("Anno");
		this.form.add(this.lblAnno, "2, 4");
		
		this.txtAnno = new JTextField();
		this.Container.add(this.txtAnno);
		this.form.add(this.txtAnno, "6, 4, fill, default");

		
		this.lblOrdineContratto = new JLabel("Ordine/Contratto");
		this.form.add(this.lblOrdineContratto, "2, 6");
		
		this.txtOrdineContratto = new JTextField();
		this.Container.add(this.txtOrdineContratto);
		this.form.add(this.txtOrdineContratto, "6, 6, fill, default");
		
		
		this.lblCommessaCoedil = new JLabel("Commessa Coedil");
		this.form.add(this.lblCommessaCoedil, "2, 8");
		
		this.txtCommessaCoedil = new JTextField();
		this.Container.add(this.txtCommessaCoedil);
		this.form.add(this.txtCommessaCoedil, "6, 8, fill, default");

		
		this.lblOrdineGestionale = new JLabel("Ordine Gestionale");
		this.form.add(this.lblOrdineGestionale, "2, 10");
		
		this.txtOrdineGestionale = new JTextField();
		this.Container.add(this.txtOrdineGestionale);
		this.form.add(this.txtOrdineGestionale, "6, 10, fill, default");

		
		this.lblDataInizio = new JLabel("Data Inizio");
		this.form.add(this.lblDataInizio, "2, 12");
		
		this.txtDataInizio = new JTextField();
		this.Container.add(this.txtDataInizio);
		this.form.add(this.txtDataInizio, "6, 12, fill, default");

		
		this.lblDataFine = new JLabel("Data Fine");
		this.form.add(this.lblDataFine, "2, 14");
		
		this.txtDataFine = new JTextField();
		this.Container.add(this.txtDataFine);
		this.form.add(this.txtDataFine, "6, 14, fill, default");

		
		this.lblOrario = new JLabel("Orario");
		this.form.add(this.lblOrario, "2, 16");
		
		this.txtOrario = new JTextField();
		this.Container.add(this.txtOrario);
		this.form.add(this.txtOrario, "6, 16, fill, default");
		
		
		this.lblDescrizione = new JLabel("Descrizione");
		this.form.add(this.lblDescrizione, "2, 18");
		
		this.txtDescrizione = new JTextField();
		this.Container.add(this.txtDescrizione);
		this.form.add(this.txtDescrizione, "6, 18, fill, default");
	
		toggle = new JButton("Chiudi");
		toggle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(aperto){
					toggle.setText("Apri");
					aperto = false;
					form.getParent().setSize(new Dimension(600,30));
				}
				else{
					toggle.setText("Chiudi");
					aperto = true;
					form.getParent().setSize(new Dimension(600,290));
				}
				validate();
				repaint();
			}
		});
		toggle.setSize(131, 20);
		toggle.setLocation(469, 0);
		add(toggle);
	}

	@Override
	public void load(Object o) {
		Commessa c = (Commessa) o;
		if(c != null)
			this.txtCommessaCoedil.setText(Integer.toString(c.getID()));
		Ordine ord = c.getOrdine();
		if(ord != null)
			this.txtOrdineContratto.setText(Integer.toString(ord.getID()));
		if(ord.getOC() != null)
			this.txtOC.setText(ord.getOC());
		if(ord.getAnno() != null)
			this.txtAnno.setText(ord.getAnno().toString());
		if(ord.getOrdineGestionale() != null)
			this.txtOrdineGestionale.setText(ord.getOrdineGestionale());
		if(ord.getDataInizio() != null)
			this.txtDataInizio.setText(ord.getDataInizio().toString());
		if(ord.getDataFine() != null)
			this.txtDataFine.setText(ord.getDataFine().toString());
		if(c.getOrario() != null)
			this.txtOrario.setText(c.getOrario());
		if(c.getDescrizione() != null)
			this.txtDescrizione.setText(c.getDescrizione());
		
	}

}
