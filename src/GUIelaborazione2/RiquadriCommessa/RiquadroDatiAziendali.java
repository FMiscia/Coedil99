package GUIelaborazione2.RiquadriCommessa;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel lblPartizione;
	private JTextField txtPartizione;
	private boolean aperto;
	private JButton toggle;
	
	public RiquadroDatiAziendali(String title) {
		super(title);
		aperto = true;
		this.setSize(new Dimension(600,310));
		form = new JPanel();
		form.setBounds(0,30,600,270);
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
		
		lblOC = new JLabel("O/C");
		form.add(lblOC, "2, 2");
		
		txtOC = new JTextField();
		form.add(txtOC, "6, 2, fill, default");

		
		lblAnno = new JLabel("Anno");
		form.add(lblAnno, "2, 4");
		
		txtAnno = new JTextField();
		form.add(txtAnno, "6, 4, fill, default");

		
		lblOrdineContratto = new JLabel("Ordine/Contratto");
		form.add(lblOrdineContratto, "2, 6");
		
		txtOrdineContratto = new JTextField();
		form.add(txtOrdineContratto, "6, 6, fill, default");

		
		lblCommessaCoedil = new JLabel("Commessa Coedil");
		form.add(lblCommessaCoedil, "2, 8");
		
		txtCommessaCoedil = new JTextField();
		form.add(txtCommessaCoedil, "6, 8, fill, default");

		
		lblOrdineGestionale = new JLabel("Ordine Gestionale");
		form.add(lblOrdineGestionale, "2, 10");
		
		txtOrdineGestionale = new JTextField();
		form.add(txtOrdineGestionale, "6, 10, fill, default");

		
		lblDataInizio = new JLabel("Data Inizio");
		form.add(lblDataInizio, "2, 12");
		
		txtDataInizio = new JTextField();
		form.add(txtDataInizio, "6, 12, fill, default");

		
		lblDataFine = new JLabel("Data Fine");
		form.add(lblDataFine, "2, 14");
		
		txtDataFine = new JTextField();
		form.add(txtDataFine, "6, 14, fill, default");

		
		lblOrario = new JLabel("Orario");
		form.add(lblOrario, "2, 16");
		
		txtOrario = new JTextField();
		form.add(txtOrario, "6, 16, fill, default");
		
		
		lblDescrizione = new JLabel("Descrizione");
		form.add(lblDescrizione, "2, 18");
		
		txtDescrizione = new JTextField();
		form.add(txtDescrizione, "6, 18, fill, default");
		
		
		lblPartizione = new JLabel("Partizione");
		form.add(lblPartizione, "2, 20");
		
		txtPartizione = new JTextField();
		form.add(txtPartizione, "6, 20, fill, default");
	
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
					form.getParent().setSize(new Dimension(600,310));
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
		// TODO Auto-generated method stub

	}

}
