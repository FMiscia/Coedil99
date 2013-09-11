package GUIelaborazione2.Riquadri;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdesktop.swingx.JXDatePicker;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.*;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
	private JLabel lblIcoOC;
	private JLabel lblIcoAnno;
	private JLabel lblIcoOrdineContratto;
	private JLabel lblIcoCommessaCoedil;
	private JLabel lblIcoOrdineGestionale;
	private JLabel lblIcoOrario;
	private JLabel lblIcoDescrizione;
	private JLabel lblIcoDataInizio;
	private JLabel lblIcoDataFine;
	private JXDatePicker dateDataFine;
	private JXDatePicker dateDataInizio;
	

	
	
	
	
	
	public RiquadroDatiAziendali(String title) {
		super(title);
		
		//this.setPreferredSize(new Dimension(600, 370));
		this.setSize(new Dimension(630, 370));
		this.form = new JPanel();
		this.form.setBounds(0,30,600,340);
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
		 *	Campo O/C 	
		 */
	
		this.lblOC = new JLabel("O/C");
		this.form.add(this.lblOC, "2, 2, left, default");
		this.txtOC = new JTextField();
		txtOC.setHorizontalAlignment(SwingConstants.CENTER);
		//Controllo Input
		this.txtOC.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtOC.getText();
	            String pattern = "\\W+";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoOC.setIcon(IcoErrore);
	            	lblIcoOC.setToolTipText("Il campo O/C deve contenere solo lettere e/o numeri!");
	            }
	            else{
	            	lblIcoOC.setIcon(IcoOk);
	            	lblIcoOC.setToolTipText("");
	            }
	        }
	    });
		this.Container.add(this.txtOC);
		this.form.add(this.txtOC, "6, 2, fill, fill");
		this.lblIcoOC = new JLabel("");
		this.lblIcoOC.setVisible(false);
		this.form.add(lblIcoOC, "8, 2, center, top");
		this.Label.add(lblIcoOC);
		
		
		/*
		 *	Campo Anno	
		 */
				
		this.lblAnno = new JLabel("Anno");
		this.form.add(this.lblAnno, "2, 4");
		this.txtAnno = new JTextField();
		this.txtAnno.setHorizontalAlignment(SwingConstants.CENTER);
		//Controllo Input
		this.txtAnno.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtAnno.getText();
	            String pattern = "\\D+";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoAnno.setIcon(RiquadroDatiAziendali.this.IcoErrore);
	            	lblAnno.setToolTipText("Il campo Anno deve contenere solo numeri!");
	            }
	            else{
	            	lblIcoAnno.setIcon(RiquadroDatiAziendali.this.IcoOk);
	            	lblIcoOC.setToolTipText("");
	            }
	        }
	    });
		
		this.Container.add(this.txtAnno);
		this.form.add(this.txtAnno, "6, 4, fill, fill");
		
		this.lblIcoAnno = new JLabel("");
		this.lblIcoAnno.setVisible(false);
		this.form.add(lblIcoAnno, "8, 4, center, top");
		this.Label.add(lblIcoAnno);

		
		/*
		 *	Campo Ordine/Contratto	
		 */
		
		
		this.lblOrdineContratto = new JLabel("Ordine/Contratto");
		this.form.add(this.lblOrdineContratto, "2, 6");
		
		this.txtOrdineContratto = new JTextField();
		this.txtOrdineContratto.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrdineContratto.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtOrdineContratto.getText();
	            String pattern = "\\D+";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoOrdineContratto.setIcon(IcoErrore);
	            	lblIcoOrdineContratto.setToolTipText("Il campo Ordine/Contratto deve contenere solo numeri!");
	            }
	            else{
	            	lblIcoOrdineContratto.setIcon(IcoOk);
	            	lblIcoOrdineContratto.setToolTipText("");
	            }
	        }
	    });
		
		this.Container.add(this.txtOrdineContratto);
		this.form.add(this.txtOrdineContratto, "6, 6, fill, fill");
		
		this.lblIcoOrdineContratto = new JLabel("");
		this.lblIcoOrdineContratto.setVisible(false);
		this.form.add(lblIcoOrdineContratto, "8, 6, center, top");
		this.Label.add(lblIcoOrdineContratto);
		
		
		/*
		 * Campo Commessa Coedil
		 */
		
		
		this.lblCommessaCoedil = new JLabel("Commessa Coedil");
		this.form.add(this.lblCommessaCoedil, "2, 8");
		
		this.txtCommessaCoedil = new JTextField();
		this.txtCommessaCoedil.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCommessaCoedil.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtCommessaCoedil.getText();
	            String pattern = "\\D+";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoCommessaCoedil.setIcon(IcoErrore);
	            	lblIcoCommessaCoedil.setToolTipText("Il campo Commessa Coedil deve contenere solo numeri!");
	            }
	            else{
	            	lblIcoCommessaCoedil.setIcon(IcoOk);
	            	lblIcoCommessaCoedil.setToolTipText("");
	            }
	        }
	    });
		this.Container.add(this.txtCommessaCoedil);
		this.form.add(this.txtCommessaCoedil, "6, 8, fill, fill");

		this.lblIcoCommessaCoedil = new JLabel("");
		this.lblIcoCommessaCoedil.setVisible(false);
		this.form.add(lblIcoCommessaCoedil, "8, 8, center, top");
		this.Label.add(lblIcoCommessaCoedil);
		
		
		/*
		 * Campo Ordine Gestionale
		 */
		
		
		this.lblOrdineGestionale = new JLabel("Ordine Gestionale");
		this.form.add(this.lblOrdineGestionale, "2, 10");
		
		this.txtOrdineGestionale = new JTextField();
		this.txtOrdineGestionale.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrdineGestionale.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtOrdineGestionale.getText();
	            String pattern = "\\D+";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoOrdineGestionale.setIcon(IcoErrore);
	            	lblIcoOrdineGestionale.setToolTipText("Il campo Ordine Gestionale deve contenere solo numeri!");
	            }
	            else{
	            	lblIcoOrdineGestionale.setIcon(IcoOk);
	            	lblIcoOrdineGestionale.setToolTipText("");
	            }
	        }
	    });
		this.Container.add(this.txtOrdineGestionale);
		this.form.add(this.txtOrdineGestionale, "6, 10, fill, fill");
		
		this.lblIcoOrdineGestionale = new JLabel("");
		this.lblIcoOrdineGestionale.setVisible(false);
		this.form.add(lblIcoOrdineGestionale, "8, 10, center, top");
		this.Label.add(lblIcoOrdineGestionale);
		
		
		/*
		 * Campo Data Inizio
		 */
		
		
		this.lblDataInizio = new JLabel("Data Inizio");
		this.form.add(this.lblDataInizio, "2, 12");
		
		this.dateDataInizio = new JXDatePicker();
		dateDataInizio.getEditor().setEditable(false);
		this.dateDataInizio.setFormats("yyyy-MM-dd");
		this.form.add(dateDataInizio, "6, 12, fill, fill");
		/*dateDataInizio.getEditor().addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String line = dateDataInizio.getDate().toString();
	            String pattern = "\\w";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoDataInizio.setIcon(IcoErrore);
	            	lblIcoDataInizio.setToolTipText("Il campo Ordine Gestionale deve contenere solo numeri!");
	            	//lblIcoOC.setVisible(true);
	            }
	            else{
	            	lblIcoDataInizio.setIcon(IcoOk);
	            	lblIcoDataInizio.setToolTipText("");
	            	//lblIcoOC.setVisible(true);
	            }
	        }
			
		});*/

		
		this.lblIcoDataInizio = new JLabel("");
		this.lblIcoDataInizio.setVisible(false);
		this.form.add(lblIcoDataInizio, "8, 12, center, top");
		this.Label.add(lblIcoDataInizio);
		
		/*
		 * Campo Data Fine
		 */
		
		this.lblDataFine = new JLabel("Data Fine");
		this.form.add(this.lblDataFine, "2, 14");
		
		this.dateDataFine = new JXDatePicker();
		dateDataFine.getEditor().setEditable(false);
		this.dateDataFine.setFormats("yyyy-MM-dd");
		this.form.add(dateDataFine, "6, 14, fill, fill");
		

		this.lblIcoDataFine = new JLabel("");
		this.lblIcoDataFine.setVisible(false);
		this.form.add(lblIcoDataFine, "8, 14, center, top");
		this.Label.add(lblIcoDataFine);
		
		/*
		 * Campo Orario
		 */
		
		this.lblOrario = new JLabel("Orario");
		this.form.add(this.lblOrario, "2, 16");
		
		this.txtOrario = new JTextField();
		this.txtOrario.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtOrario.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtOrario.getText();
	            String pattern = "[^a-zA-Zאעשטיל]";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoOrario.setIcon(IcoErrore);
	            	lblIcoOrario.setToolTipText("Il campo Orario deve contenere solo lettere!");
	            }
	            else{
	            	lblIcoOrario.setIcon(IcoOk);
	            	lblIcoOrario.setToolTipText("");
	            }
	        }
	    });
		
		this.Container.add(this.txtOrario);
		this.form.add(this.txtOrario, "6, 16, fill, fill");
		
		this.lblIcoOrario = new JLabel("");
		this.lblIcoOrario.setVisible(false);
		this.form.add(lblIcoOrario, "8, 16, center, top");
		this.Label.add(lblIcoOrario);
		
		/*
		 * Campo Descrizione
		 */
		
		
		this.lblDescrizione = new JLabel("Descrizione");
		this.form.add(this.lblDescrizione, "2, 18");
		
		this.txtDescrizione = new JTextField();
		this.txtDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtDescrizione.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	String line = txtDescrizione.getText();
	            String pattern = "[^a-zA-Zאעשטיל'\\s]";
	            Pattern r = Pattern.compile(pattern);
	            Matcher m = r.matcher(line);
	            if (m.find( )) {
	            	lblIcoDescrizione.setIcon(IcoErrore);
	            	lblIcoDescrizione.setToolTipText("Il campo Descrizione deve contenere solo lettere!");
	            	//lblIcoOC.setVisible(true);
	            }
	            else{
	            	lblIcoDescrizione.setIcon(IcoOk);
	            	lblIcoDescrizione.setToolTipText("");
	            	//lblIcoOC.setVisible(true);
	            }
	        }
	    });
		this.Container.add(this.txtDescrizione);
		this.form.add(this.txtDescrizione, "6, 18, fill, fill");
		
		this.lblIcoDescrizione = new JLabel("");
		this.lblIcoDescrizione.setVisible(false);
		this.form.add(lblIcoDescrizione, "8, 18, center, top");
		this.Label.add(lblIcoDescrizione);
		
		
		this.makeEditable(false);
	}

	@Override
	public void load(Object o) {
		this.oggetto = o;
		this.resetRiquadro();
		Commessa c = (Commessa) this.oggetto;
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
			this.dateDataInizio.setDate(ord.getDataInizio());
		else
			this.dateDataInizio.setDate(null);
		if(ord.getDataFine() != null)
			this.dateDataFine.setDate(ord.getDataFine());
		else
			this.dateDataFine.setDate(null);
		if(c.getOrario() != null)
			this.txtOrario.setText(c.getOrario());
		if(c.getDescrizione() != null)
			this.txtDescrizione.setText(c.getDescrizione());
	}

	/**
	 * Metodo che modifica i campi deglli oggetti interessati e li salva sul db
	 */
	@Override
	protected void salva() {
		if (this.oggetto != null) {
			Commessa c = (Commessa) this.oggetto;
			Ordine ord = c.getOrdine();
			ord.setOC(this.txtOC.getText());
			ord.setAnno(Integer.valueOf(this.txtAnno.getText()));
			ord.setOrdineGestionale(this.txtOrdineGestionale.getText());
			ord.setDataInizio(this.dateDataInizio.getDate());
			ord.setDataFine(this.dateDataFine.getDate());
			ord.save();
			c.setOrario(this.txtOrario.getText());
			c.setDescrizione(this.txtDescrizione.getText());
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
		this.dateDataInizio.setEnabled(editable);
		this.dateDataFine.setEnabled(editable);
		super.makeEditable(editable);

	}
	
}
