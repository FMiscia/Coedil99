package GUIelaborazione2.Riquadri;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUIelaborazione2.ProgrammaLavori;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Distinta;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.GeometriaFactory;
import elaboradistinta.model.RigaLavoro;
import elaboradistinta.model.RigaLavoroFactory;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RiquadroDatiDistinta extends Riquadro {

	private static final Dimension dimension = new Dimension(600, 275);
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
	private JButton btnElimina;

	public RiquadroDatiDistinta(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.Container = new ArrayList<JTextField>();
		this.setSize(new Dimension(600, 375));
		this.addRiquadro();
	}

	public void addRiquadro() {
		form = new JPanel();
		form.setBounds(0, 30, 600, 198);
		this.add(form);
		form.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(230px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		this.lbbase = new JLabel("Base");
		form.add(this.lbbase, "2, 2");
		this.tfbase = new JTextField("0.0");
		this.Container.add(tfbase);
		form.add(this.tfbase, "6, 2, fill, default");

		this.lbaltezza = new JLabel("Altezza");
		form.add(this.lbaltezza, "2, 4");
		this.tfaltezza = new JTextField("0.0");
		this.Container.add(tfaltezza);
		form.add(this.tfaltezza, "6, 4, fill, default");

		this.lblunghezza = new JLabel("Lunghezza");
		form.add(this.lblunghezza, "2, 6");
		this.tflunghezza = new JTextField("0.0");
		this.Container.add(tflunghezza);
		form.add(this.tflunghezza, "6, 6, fill, default");

		this.lbnumero = new JLabel("Numero");
		form.add(this.lbnumero, "2, 8");
		this.tfnumero = new JTextField("0");
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
		this.tftipocapitello = new JTextField("null");
		this.Container.add(tftipocapitello);
		form.add(this.tftipocapitello, "6, 12, fill, default");
		this.cbcapitello.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(cbcapitello.getSelectedItem().toString());
				if (cbcapitello.getSelectedItem().toString().equals("No"))
						tftipocapitello.setEditable(false);
				else
					tftipocapitello.setEditable(true);
				
				RiquadroDatiDistinta.this.validate();
				RiquadroDatiDistinta.this.repaint();
			}
		});
		this.validate();
		this.repaint();

		this.lbnote = new JLabel("Note");
		form.add(this.lbnote, "2, 14");
		this.tfnote = new JTextField("null");
		this.Container.add(tfnote);
		form.add(this.tfnote, "6, 14, fill, default");

		this.toggle = new JButton("Chiudi");
		this.toggle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (RiquadroDatiDistinta.this.aperto) {
					RiquadroDatiDistinta.this.toggle.setText("Apri");
					RiquadroDatiDistinta.this.aperto = false;
					form.getParent().setSize(new Dimension(600, 30));
				} else {
					RiquadroDatiDistinta.this.toggle.setText("Chiudi");
					RiquadroDatiDistinta.this.aperto = true;
					form.getParent().setSize(new Dimension(600, 310));
				}
				RiquadroDatiDistinta.this.validate();
				RiquadroDatiDistinta.this.repaint();
			}
		});
		this.toggle.setSize(131, 20);
		this.toggle.setLocation(469, 0);
		add(this.toggle);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(270, 0, 131, 20);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Distinta d = ProgrammaLavori.getInstance().getCommessaSelezionata()
						.getDistinta();
				RigaLavoro r = (RigaLavoro) RiquadroDatiDistinta.this.oggetto;
				d.eliminaRigaLavoro(r);
			}
		});
		add(btnElimina);

	}

	@Override
	public void load(Object o) {
		RigaLavoro d = (RigaLavoro) o;
		if (d != null) {
			this.tflunghezza.setText(String.valueOf(d.getGeometria()
					.getLunghezza()));
			this.tfaltezza.setText(String
					.valueOf(d.getGeometria().getAltezza()));
			this.tfbase.setText(String.valueOf(d.getGeometria().getBase()));
			this.tfnumero.setText(String.valueOf(d.getNumero()));
			this.cbcapitello.setSelectedIndex((d.getCapitello()) ? 0 : 1);
			this.tftipocapitello.setText(d.getProfiloCapitello());
			this.tfnote.setText(d.getNote());
			this.makeEditable(false);
			this.oggetto = d;
		}
	}

	@Override
	public void makeEditable(boolean editable) {
		// TODO Auto-generated method stub
		this.cbcapitello.setEnabled(editable);
		super.makeEditable(editable);

	}

	@Override
	protected void resetRiquadro() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void avoidEditing(){
		super.avoidEditing();
		this.btnElimina.setEnabled(false);
		for (MouseListener al : this.btnElimina.getMouseListeners()) {
			this.btnElimina.removeMouseListener(al);
		}
		this.validate();
		this.repaint();
	}

	@Override
	public void enableEditing(){
		super.enableEditing();
		this.btnElimina.setEnabled(true);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Distinta d = ProgrammaLavori.getInstance().getCommessaSelezionata()
						.getDistinta();
				RigaLavoro r = (RigaLavoro) RiquadroDatiDistinta.this.oggetto;
				d.eliminaRigaLavoro(r);
			}
		});
		this.validate();
		this.repaint();
	}
	
	@Override
	protected void salva() {
		RigaLavoro r = RigaLavoroFactory.createRigaLavoro();
		if (this.oggetto != null) {
			r = (RigaLavoro) this.oggetto;
		} else {
			Distinta d = ProgrammaLavori.getInstance().getCommessaSelezionata()
					.getDistinta();
			d.getLavori().add(r);
		}
		Geometria g = GeometriaFactory.createGeometria();
		g.setBase(Float.parseFloat(this.tfbase.getText()));
		g.setAltezza(Float.parseFloat(this.tfaltezza.getText()));
		g.setLunghezza(Float.parseFloat(this.tflunghezza.getText()));
		r.setGeometria(g);
		r.setCapitello(this.cbcapitello.getSelectedIndex() == 0 ? true : false);
		r.setProfiloCapitello(this.tftipocapitello.getText());
		r.setNumero(Integer.parseInt(this.tfnumero.getText()));
		r.setNote(this.tfnote.getText());
		r.save();
		this.oggetto = r;
		JOptionPane.showMessageDialog(null,
				"Salvataggio avvenuto correttamente", "Messaggio di Sistema",
				JOptionPane.INFORMATION_MESSAGE);
		this.load(this.oggetto);

	}

	public static Dimension getFormDimension() {
		return RiquadroDatiDistinta.dimension;
	}
}
