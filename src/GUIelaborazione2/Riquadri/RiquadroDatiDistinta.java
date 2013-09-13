package GUIelaborazione2.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GUIelaborazione2.PlicoDistinta;
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
	// private JButton toggle;
	private boolean aperto = true;
	private JButton btnElimina;
	private JLabel lblIcoBase;
	private JLabel lblIcoAltezza;
	private JLabel lblIcoLunghezza;
	private JLabel lblIcoNumero;
	private JLabel lblIcoTipoCapitello;
	private JLabel lblIcoNote;

	public RiquadroDatiDistinta(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.Container = new ArrayList<JTextField>();
		this.setPreferredSize(new Dimension(600, 300));
		this.addRiquadro();
	}

	public void addRiquadro() {
		form = new JPanel();
		form.setBounds(0, 30, 600, 270);
		this.add(form);
		form.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(155px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(140dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));

		/*
		 * Campo Base
		 */

		this.lbbase = new JLabel("Base");
		this.form.add(this.lbbase, "2, 2");
		this.tfbase = new JTextField("0.0");
		this.tfbase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = tfbase.getText();
				String pattern = "^[0-9]*\\.?[0-9]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoBase.setIcon(IcoErrore);
					lblIcoBase
							.setToolTipText("Il campo Base deve essere un numero reale!");
					tfbase.setBorder(new LineBorder(Color.red));
				} else if (!m.matches()) {
					lblIcoBase.setIcon(IcoErrore);
					lblIcoBase
							.setToolTipText("Il campo Base deve essere un numero reale!");
					tfbase.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoBase.setIcon(IcoOk);
					lblIcoBase.setToolTipText(null);
					tfbase.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(tfbase);
		this.form.add(this.tfbase, "6, 2, fill, fill");
		this.lblIcoBase = new JLabel("");
		this.lblIcoBase.setVisible(false);
		this.form.add(lblIcoBase, "8, 2, center, top");
		this.Label.add(lblIcoBase);

		/*
		 * Campo Altezza
		 */

		this.lbaltezza = new JLabel("Altezza");
		form.add(this.lbaltezza, "2, 4");
		this.tfaltezza = new JTextField("0.0");
		this.tfaltezza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = tfaltezza.getText();
				String pattern = "^[0-9]*\\.?[0-9]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoAltezza.setIcon(IcoErrore);
					lblIcoAltezza
							.setToolTipText("Il campo Altezza deve essere un numero reale!");
					tfaltezza.setBorder(new LineBorder(Color.red));
				} else if (!m.matches()) {
					lblIcoAltezza.setIcon(IcoErrore);
					lblIcoAltezza
							.setToolTipText("Il campo Altezza deve essere un numero reale!");
					tfaltezza.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoAltezza.setIcon(IcoOk);
					lblIcoAltezza.setToolTipText(null);
					tfaltezza.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(tfaltezza);
		form.add(this.tfaltezza, "6, 4, fill, fill");
		this.lblIcoAltezza = new JLabel("");
		this.lblIcoAltezza.setVisible(false);
		this.form.add(lblIcoAltezza, "8, 4, center, top");
		this.Label.add(lblIcoAltezza);

		/*
		 * Campo Lunghezza
		 */

		this.lblunghezza = new JLabel("Lunghezza");
		form.add(this.lblunghezza, "2, 6");
		this.tflunghezza = new JTextField("0.0");
		this.tflunghezza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = tflunghezza.getText();
				String pattern = "^[0-9]*\\.?[0-9]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoLunghezza.setIcon(IcoErrore);
					lblIcoLunghezza
							.setToolTipText("Il campo Lunghezza deve essere un numero reale!");
					tflunghezza.setBorder(new LineBorder(Color.red));
				} else if (!m.matches()) {
					lblIcoLunghezza.setIcon(IcoErrore);
					lblIcoLunghezza
							.setToolTipText("Il campo Lunghezza deve essere un numero reale!");
					tflunghezza.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoLunghezza.setIcon(IcoOk);
					lblIcoLunghezza.setToolTipText(null);
					tflunghezza.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(tflunghezza);
		form.add(this.tflunghezza, "6, 6, fill, fill");
		this.lblIcoLunghezza = new JLabel("");
		this.lblIcoLunghezza.setVisible(false);
		this.form.add(lblIcoLunghezza, "8, 6, center, top");
		this.Label.add(lblIcoLunghezza);

		/*
		 * Campo Numero
		 */

		this.lbnumero = new JLabel("Numero");
		form.add(this.lbnumero, "2, 8");
		this.tfnumero = new JTextField("0");
		this.tfnumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = tfnumero.getText();
				String pattern = "\\D+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("") || line.equals("0")) {
					lblIcoNumero.setIcon(IcoErrore);
					lblIcoNumero
							.setToolTipText("Il campo numero deve essere un numero intero maggiore di 0!");
					tfnumero.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoNumero.setIcon(IcoErrore);
					lblIcoNumero
							.setToolTipText("Il campo numero deve essere un numero intero maggiore di 0!");
					tfnumero.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoNumero.setIcon(IcoOk);
					lblIcoNumero.setToolTipText(null);
					tfnumero.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(tfnumero);
		form.add(this.tfnumero, "6, 8, fill, fill");
		this.lblIcoNumero = new JLabel("");
		this.lblIcoNumero.setVisible(false);
		this.form.add(lblIcoNumero, "8, 8, center, top");
		this.Label.add(lblIcoNumero);

		/*
		 * Campo Capitello
		 */

		this.lbcapitello = new JLabel("Capitello");
		form.add(this.lbcapitello, "2, 10");
		this.cbcapitello = new JComboBox<Object>();
		form.add(this.cbcapitello, "6, 10, fill, fill");
		this.cbcapitello.addItem(new String("Si"));
		this.cbcapitello.addItem(new String("No"));

		/*
		 * Campo Tipo Capitello
		 */
		
		this.lbtipocapitello = new JLabel("Tipo Capitello");
		form.add(this.lbtipocapitello, "2, 12");
		this.tftipocapitello = new JTextField("null");
		this.tftipocapitello.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = tftipocapitello.getText();
				String pattern = "[^a-zA-Z0-9אעשטיל'\\s]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoTipoCapitello.setIcon(IcoErrore);
					lblIcoTipoCapitello
							.setToolTipText("Il campo Tipo Capitello deve contenere solo lettere e/o numeri!");
					tftipocapitello.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoTipoCapitello.setIcon(IcoErrore);
					lblIcoTipoCapitello
							.setToolTipText("Il campo Tipo Capitello deve contenere solo lettere e/o numeri!");
					tftipocapitello.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoTipoCapitello.setIcon(IcoOk);
					lblIcoTipoCapitello.setToolTipText(null);
					tftipocapitello.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(tftipocapitello);
		form.add(this.tftipocapitello, "6, 12, fill, fill");
		this.lblIcoTipoCapitello = new JLabel("");
		this.lblIcoTipoCapitello.setVisible(false);
		this.form.add(lblIcoTipoCapitello, "8, 12, center, top");
		this.Label.add(lblIcoTipoCapitello);
		this.cbcapitello.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.print(cbcapitello.getSelectedItem().toString());
				if (cbcapitello.getSelectedItem().toString().equals("No")) {
					tftipocapitello.setEditable(false);
					tftipocapitello.setText(null);
				} else
					tftipocapitello.setEditable(true);
				RiquadroDatiDistinta.this.validate();
				RiquadroDatiDistinta.this.repaint();
			}
		});
		//this.validate();
		//this.repaint();

		/*
		 * Campo Note
		 */
		
		this.lbnote = new JLabel("Note");
		form.add(this.lbnote, "2, 14");
		this.tfnote = new JTextField("null");
		this.tfnote.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String line = tfnote.getText();
				String pattern = "[^a-zA-Z0-9אעשטיל',;:.\\s]";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
				if (line.equals("")) {
					lblIcoNote.setIcon(IcoErrore);
					lblIcoNote
							.setToolTipText("Il campo Note deve contenere solo lettere e/o numeri!");
					tfnote.setBorder(new LineBorder(Color.red));
				} else if (m.find()) {
					lblIcoNote.setIcon(IcoErrore);
					lblIcoNote
							.setToolTipText("Il campo Note deve contenere solo lettere e/o numeri!");
					tfnote.setBorder(new LineBorder(Color.red));
				} else {
					lblIcoNote.setIcon(IcoOk);
					lblIcoNote.setToolTipText(null);
					tfnote.setBorder(new LineBorder(Color.green));
				}
				controlloErrori();
			}
		});
		this.Container.add(tfnote);
		form.add(this.tfnote, "6, 14, fill, fill");
		this.lblIcoNote = new JLabel("");
		this.lblIcoNote.setVisible(false);
		this.form.add(lblIcoNote, "8, 14, center, top");
		this.Label.add(lblIcoNote);

		/*
		 * this.toggle = new JButton("Chiudi"); this.toggle.addMouseListener(new
		 * MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { if
		 * (RiquadroDatiDistinta.this.aperto) {
		 * RiquadroDatiDistinta.this.toggle.setText("Apri");
		 * RiquadroDatiDistinta.this.aperto = false;
		 * form.getParent().setSize(new Dimension(600, 30)); } else {
		 * RiquadroDatiDistinta.this.toggle.setText("Chiudi");
		 * RiquadroDatiDistinta.this.aperto = true; form.getParent().setSize(new
		 * Dimension(600, 310)); } RiquadroDatiDistinta.this.validate();
		 * RiquadroDatiDistinta.this.repaint(); } }); this.toggle.setSize(131,
		 * 20); this.toggle.setLocation(469, 0); add(this.toggle);
		 */

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(270, 0, 131, 20);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Distinta d = ProgrammaLavori.getInstance()
						.getCommessaSelezionata().getDistinta();
				RigaLavoro r = (RigaLavoro) RiquadroDatiDistinta.this.oggetto;
				d.eliminaRigaLavoro(r);
				RiquadroDatiDistinta.this.removeAll();
				// RiquadroDatiDistinta.this.validate();
				// RiquadroDatiDistinta.this.repaint();
				PlicoDistinta.getInstance().removeRiquadro(
						RiquadroDatiDistinta.this);
				PlicoDistinta.getInstance().posizionaAddButton();
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
	public void avoidEditing() {
		super.avoidEditing();
		this.btnElimina.setEnabled(false);
		for (MouseListener al : this.btnElimina.getMouseListeners()) {
			this.btnElimina.removeMouseListener(al);
		}
	}

	@Override
	public void enableEditing() {
		super.enableEditing();
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
