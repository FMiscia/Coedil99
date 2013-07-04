package GUIelaborazione2.Riquadri;

import java.awt.Color;
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
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.transaction.SystemException;

public class RiquadroDatiDistinta extends Riquadro {
	
	private JPanel form;
	private JLabel lbbase;
	private JTextField tfbase;
	private JLabel lbaltezza;
	private JTextField tfaltezza;
	private JLabel lblunghezza;
	private JTextField tflunghezza;
	private JLabel lbnumero;
	private JTextField tfnumero;
	private JLabel lbcapitello;
	private JComboBox<Object> cbcapitello;
	private JLabel lbtipocapitello;
	private JTextField tftipocapitello;
	private JLabel lbnote;
	private JTextField tfnote;
	private JButton toggle;
	private boolean aperto = true;
	private ArrayList<JTextField> Container;

	public RiquadroDatiDistinta(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.Container = new ArrayList<JTextField>();
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lbbase = new JLabel("Base");
		form.add(this.lbbase, "2, 2");		
		this.tfbase = new JTextField();
		this.Container.add(tfbase);
		form.add(this.tfbase, "6, 2, fill, default");
		
		this.lbaltezza = new JLabel("Altezza");
		form.add(this.lbaltezza, "2, 4");		
		this.tfaltezza = new JTextField();
		this.Container.add(tfaltezza);
		form.add(this.tfaltezza, "6, 4, fill, default");
		
		this.lblunghezza = new JLabel("Lunghezza");
		form.add(this.lblunghezza, "2, 6");		
		this.tflunghezza = new JTextField();
		this.Container.add(tflunghezza);
		form.add(this.tflunghezza, "6, 6, fill, default");
		
		this.lbnumero = new JLabel("Numero");
		form.add(this.lbnumero, "2, 8");	
		this.tfnumero = new JTextField();
		this.Container.add(tfnumero);
		form.add(this.tfnumero, "6, 8, fill, default");
		
		this.lbcapitello = new JLabel("Capitello");
		form.add(this.lbcapitello, "2, 10");	
		this.cbcapitello = new JComboBox<Object>();
		form.add(this.cbcapitello, "6, 10, fill, default");
		this.cbcapitello.addItem(new String("Si"));
		this.cbcapitello.addItem(new String("No"));

		this.lbtipocapitello = new JLabel("Tipo Capitello");
		form.add(this.lbtipocapitello, "2, 12");	
		this.tftipocapitello = new JTextField();
		this.Container.add(tftipocapitello);
		form.add(this.tftipocapitello, "6, 12, fill, default");
//		if(this.cbcapitello.getItemAt(0).equals("No"))
//			this.tftipocapitello.enableInputMethods(false);
	
		this.lbnote = new JLabel("Note");
		form.add(this.lbnote,"2, 14");
		this.tfnote = new JTextField();
		this.Container.add(tfnote);
		form.add(this.tfnote, "6, 14, fill, default");
		
		this.toggle = new JButton("Chiudi");
		this.toggle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(RiquadroDatiDistinta.this.aperto){
					RiquadroDatiDistinta.this.toggle.setText("Apri");
					RiquadroDatiDistinta.this.aperto = false;
					form.getParent().setSize(new Dimension(600,30));
				}
				else{
					RiquadroDatiDistinta.this.toggle.setText("Chiudi");
					RiquadroDatiDistinta.this.aperto = true;
					form.getParent().setSize(new Dimension(600,310));
				}
				RiquadroDatiDistinta.this.validate();
				RiquadroDatiDistinta.this.repaint();
			}
		});
		this.toggle.setSize(131, 20);
		this.toggle.setLocation(469, 0);
		add(this.toggle);

	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeEditable(boolean editable) {
		// TODO Auto-generated method stub
		this.cbcapitello.setEditable(editable);
		super.makeEditable(editable);
		
	}

}
