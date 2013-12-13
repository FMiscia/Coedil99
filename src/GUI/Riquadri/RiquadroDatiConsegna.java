package GUI.Riquadri;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

import GUI.ConfigGUI;
import GUI.Abstract.ARiquadro;
import coedil99.model.MCommessa;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Riquadro dati consegna
 * 
 * @author Simone
 * 
 */
@SuppressWarnings("serial")
public class RiquadroDatiConsegna extends ARiquadro {

	private JLabel lblDataPrimaConsegna;
	private JLabel lblRitardoConsegna;
	private JTextField txtRirardoConsegna;
	private JXDatePicker dateDataPrimaConsegna;
	private JLabel lblIcoDataPrimaConsegna;
	private JLabel lblIcoRirardoConsegna;

	public RiquadroDatiConsegna(String title) {
		super(title);
		this.initialize();
		this.makeEditable(false);
	}

	/**
	 * Carica i dati relativi alla consegna
	 * 
	 * @param o
	 */
	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		MCommessa c = (MCommessa) o;
		if (c.getPersistentModel().getPrimaConsegna() != null)
			this.dateDataPrimaConsegna.setDate(c.getPersistentModel()
					.getPrimaConsegna());
		else
			this.dateDataPrimaConsegna.setDate(null);
		if (c.getPersistentModel().getRitardoConsegna() != null)
			this.txtRirardoConsegna.setText(c.getPersistentModel()
					.getRitardoConsegna().toString());

	}

	/**
	 * Modifica i campi del model e lo salva sul db
	 */
	@Override
	public void salva(boolean showmex) {
		if (this.oggetto != null) {
			MCommessa c = (MCommessa) this.oggetto;
			c.getPersistentModel().setPrimaConsegna(
					this.dateDataPrimaConsegna.getDate());
			c.getPersistentModel().setRitardoConsegna(
					Integer.valueOf(this.txtRirardoConsegna.getText()));
			c.save();
			if (showmex)
				JOptionPane
						.showMessageDialog(null,
								"Salvataggio avvenuto correttamente",
								"Messaggio di Sistema",
								JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	/**
	 * Rende editabili il campo data
	 * 
	 * @param editable
	 *            booleano
	 */
	@Override
	public void makeEditable(boolean editable) {
		this.dateDataPrimaConsegna.setEnabled(editable);
		super.makeEditable(editable);

	}

	/**
	 * Imposta la grafica
	 */
	@Override
	protected void initialize() {
		this.setSize(new Dimension(600, 130));
		this.form.setBounds(0, 40, 600, 90);
		this.add(form);
		this.form.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(155px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(140dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));
		this.addDataPrimaConsegna();
		this.addRitardoConsegna();
	}

	/**
	 * Aggiunge il campo Data Prima Consegna
	 */
	private void addDataPrimaConsegna() {
		this.lblDataPrimaConsegna = new JLabel("Data Prima Consegna");
		this.form.add(this.lblDataPrimaConsegna, "2, 2");

		this.dateDataPrimaConsegna = new JXDatePicker();
		this.dateDataPrimaConsegna.getEditor().setEditable(false);
		if (this.dateDataPrimaConsegna.getFocusListeners().length <= 3) {
			this.dateDataPrimaConsegna.getEditor().addFocusListener(
					new FocusListener() {

						@Override
						public void focusLost(FocusEvent e) {
							chechDate();
						}

						@Override
						public void focusGained(FocusEvent e) {
							chechDate();
						}
					});
		}
		this.dateDataPrimaConsegna.setFormats("yyyy-MM-dd");
		this.form.add(this.dateDataPrimaConsegna, "6, 2, fill, fill");

		this.lblIcoDataPrimaConsegna = new JLabel("");
		this.lblIcoDataPrimaConsegna.setVisible(false);
		this.form.add(lblIcoDataPrimaConsegna, "8, 2, center, top");
		this.Label.add(lblIcoDataPrimaConsegna);
	}

	/**
	 * Aggiunge il campo Ritardo Consegna
	 */
	private void addRitardoConsegna() {
		this.lblRitardoConsegna = new JLabel("Ritardo Consegna");
		this.form.add(this.lblRitardoConsegna, "2, 4");

		this.txtRirardoConsegna = new JTextField();
		this.txtRirardoConsegna.setHorizontalAlignment(SwingConstants.CENTER);
		if (this.txtRirardoConsegna.getKeyListeners().length == 0)
			this.txtRirardoConsegna.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String line = txtRirardoConsegna.getText();
					String pattern = "[\\D]";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(line);
					if (line.equals("")) {
						setErrore(lblIcoRirardoConsegna,false,"Il campo Ritardo deve contenere solo numeri!");
						txtRirardoConsegna.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
					} else if (m.find()) {
						setErrore(lblIcoRirardoConsegna,false,"Il campo Ritardo deve contenere solo numeri!");
						txtRirardoConsegna.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoErrore()));
					} else {
						setErrore(lblIcoRirardoConsegna,true,null);
						txtRirardoConsegna
								.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoOk()));
					}
					controlloErrori();
				}
			});
		this.Container.add(this.txtRirardoConsegna);
		this.form.add(this.txtRirardoConsegna, "6, 4, fill, fill");
		this.lblIcoRirardoConsegna = new JLabel("");
		this.lblIcoRirardoConsegna.setVisible(false);
		this.form.add(lblIcoRirardoConsegna, "8, 4, center, top");
		this.Label.add(lblIcoRirardoConsegna);
	}
	
	/**
	 * Metodo che controlla lo stato del campo data prima consegna
	 */
	public void chechDate(){
		if (dateDataPrimaConsegna.getDate() == null) {
			setErrore(lblIcoDataPrimaConsegna,false,"La data di scadenza deve essere selezionata!");
		} else {
			setErrore(lblIcoDataPrimaConsegna,true,null);
		}
		controlloErrori();
	}

}