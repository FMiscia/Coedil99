package GUIelaborazione2.Riquadri;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import util.Validator;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager;
import elaboradistinta.model.Commessa;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.util.regex.*;

@SuppressWarnings("serial")
public class RiquadroDatiSviluppoConsegna extends Riquadro {

	private JPanel form;
	private JLabel lblResponsabile;
	private JTextField txtResponsabile;
	private JLabel lblEmissioneCommessa;
	private JXDatePicker dateEmissioneCommessa;
	private JLabel lblScadenzaCommessa;
	private JXDatePicker dateScadenzaCommessa;
	private JLabel lblDataFine;
	private JXDatePicker dateDataFine;
	private JLabel lblRitardo;
	private JTextField txtRitardo;
	private JLabel lblIcoResponsabile;
	private JLabel lblIcoRitardo;


	public RiquadroDatiSviluppoConsegna(String title) {
		super(title);
		this.setSize(new Dimension(600, 220));
		this.form = new JPanel();
		this.form.setBounds(0,30,600,190);
		this.add(form);
		this.form.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(155px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(140dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),}));

		/*
		 * Campo Responsabile
		 */
		
		this.lblResponsabile = new JLabel("Responsabile");
		this.form.add(this.lblResponsabile, "2, 2");

		this.txtResponsabile = new JTextField();
		this.txtResponsabile.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtResponsabile.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtResponsabile.getText();
	            String pattern = "[^a-zA-Zאעשטיל']";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoResponsabile.setIcon(IcoErrore);
	            	lblIcoResponsabile.setToolTipText("Il campo Responsabile deve contenere solo lettere!");
	            }
	            else{
	            	lblIcoResponsabile.setIcon(IcoOk);
	            	lblIcoResponsabile.setToolTipText("");
	            }
	        }
	    });
		this.Container.add(this.txtResponsabile);
		this.form.add(this.txtResponsabile, "6, 2, fill, fill");
		
		this.lblIcoResponsabile = new JLabel("");
		this.lblIcoResponsabile.setVisible(false);
		this.form.add(lblIcoResponsabile, "8, 2, center, top");
		this.Label.add(lblIcoResponsabile);

		/*
		 * Campo Emissione Commessa
		 */
		
		this.lblEmissioneCommessa = new JLabel("Emissione Commessa");
		this.form.add(this.lblEmissioneCommessa, "2, 4");

		this.dateEmissioneCommessa = new JXDatePicker();
		this.dateEmissioneCommessa.setFormats("yyyy-MM-dd");
		this.dateEmissioneCommessa.getEditor().setEditable(false);
		this.form.add(this.dateEmissioneCommessa, "6, 4, fill, fill");

		/*
		 * Campo Scadenza Commessa
		 */
		
		this.lblScadenzaCommessa = new JLabel("Scadenza Commessa");
		this.form.add(this.lblScadenzaCommessa, "2, 6");

		this.dateScadenzaCommessa = new JXDatePicker();
		this.dateScadenzaCommessa.setFormats("yyyy-MM-dd");
		this.dateScadenzaCommessa.getEditor().setEditable(false);
		this.form.add(dateScadenzaCommessa, "6, 6, fill, fill");

		/*
		 * Campo Data Fine
		 */
		this.lblDataFine = new JLabel("Data Fine Commessa");
		this.form.add(this.lblDataFine, "2, 8");

		this.dateDataFine = new JXDatePicker();
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.dateDataFine.getEditor().setEditable(false);
		this.form.add(this.dateDataFine, "6, 8, fill, fill");

		/*
		 * Campo Ritardo Produzione
		 */
		
		this.lblRitardo = new JLabel("Ritardo Produzione");
		this.form.add(this.lblRitardo, "2, 10");

		this.txtRitardo = new JTextField();
		this.txtRitardo.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtRitardo.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtRitardo.getText();
	            String pattern = "[\\D]";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoRitardo.setIcon(IcoErrore);
	            	lblIcoRitardo.setToolTipText("Il campo Ritardo Produzione deve contenere solo numeri!");
	            }
	            else{
	            	lblIcoRitardo.setIcon(IcoOk);
	            	lblIcoRitardo.setToolTipText("");
	            }
	        }
	    });
		this.Container.add(this.txtRitardo);
		this.form.add(this.txtRitardo, "6, 10, fill, fill");
		this.lblIcoRitardo = new JLabel("");
		this.lblIcoRitardo.setVisible(false);
		this.form.add(lblIcoRitardo, "8, 10, center, top");
		this.Label.add(lblIcoRitardo);
		
		this.makeEditable(false);
	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Commessa c = (Commessa)o;
		if(c.getResponsabile() != null)
			this.txtResponsabile.setText(c.getResponsabile());
		if(c.getEmissioneCommessa() != null)
			this.dateEmissioneCommessa.setDate(c.getEmissioneCommessa());
		if(c.getScadenzaCommessa() != null)
			this.dateScadenzaCommessa.setDate(c.getScadenzaCommessa());
		if(c.getFineCommessa() != null)
			this.dateDataFine.setDate(c.getFineCommessa());
		if(c.getRitardoProduzione() != null)
			this.txtRitardo.setText(c.getRitardoProduzione().toString());
	}

	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Commessa c = (Commessa)oggetto;
			c.setResponsabile(this.txtResponsabile.getText());
			c.setEmissioneCommessa(this.dateEmissioneCommessa.getDate());
			c.setScadenzaCommessa(this.dateScadenzaCommessa.getDate());
			c.setFineCommessa(this.dateDataFine.getDate());
			c.setRitardoProduzione(Integer.getInteger(this.txtRitardo.getText()));
			c.save();
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
			this.load(this.oggetto);
		}
	}

	@Override
	public void makeEditable(boolean editable) {
		// TODO Auto-generated method stub
		this.dateEmissioneCommessa.setEnabled(editable);
		this.dateScadenzaCommessa.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		super.makeEditable(editable);

	}
}