package GUI.Abstract;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import GUI.Utilities.JHorizontalSpinner;

import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.MCatalogoFornitore;
import coedil99.model.MGeometria;
import coedil99.model.MProductDescription;
import coedil99.persistentmodel.CatalogoFornitore;
import coedil99.persistentmodel.Geometria;
import coedil99.persistentmodel.ProductDescription;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public abstract class AFormRDA extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JComboBox<Object> cbFornitore;
	protected JComboBox<Object> cbEssenza;
	protected JComboBox<Object> cbGeometria;
	private ArrayList<MCatalogoFornitore> fornitori;
	private JLabel lblFornitore;
	private JLabel lblEssenza;
	private JLabel lblGeometria;
	private JLabel lblPrezzo;
	private JLabel lblQuantita;
	protected JTextField tfSpesa;
	protected JHorizontalSpinner spinner;
	private JLabel lblValuta;

	/**
	 * Costruttore dello scheletro di una FormRDA
	 * 
	 */
	public AFormRDA() {
		this.initialize();
		this.load();
	}

	/**
	 * Metodo che carica i dati relativi ai cataloghi fornitori presenti nel
	 * sistema
	 * 
	 */
	public void load() {
		if(!GestisciFornitoreHandler.isInstanciated()){
			GestisciFornitoreHandler.getInstance().reloadFornitori();}
		this.setFornitori(GestisciFornitoreHandler.getInstance()
				.getArrayFornitori());
		this.cbEssenza.setEnabled(false);
		this.cbGeometria.setEnabled(false);
		this.loadFornitori();
		this.validate();
		this.repaint();
	}

	public JComboBox<Object> getCbFornitore() {
		return cbFornitore;
	}

	public JComboBox<Object> getCbGeometria() {
		return cbGeometria;
	}

	public JComboBox<Object> getCbEssenza() {
		return cbEssenza;
	}

	public ArrayList<MCatalogoFornitore> getFornitori() {
		return fornitori;
	}

	public void setFornitori(ArrayList<MCatalogoFornitore> fornitori) {
		this.fornitori = fornitori;
	}

	/**
	 * Metodo che carica nella combo box tutti i fornitori presenti nel sistema
	 * Quando un fornitore viene selezionato viene richiamato il metodo
	 * loadEssenze
	 * 
	 */
	protected void loadFornitori() {
		if (this.cbFornitore.getItemListeners().length != 0)
			this.cbFornitore.removeItemListener(this.cbFornitore
					.getItemListeners()[0]);
		this.cbFornitore.removeAllItems();
		this.cbFornitore.setEnabled(true);
		for (int i = 0; i < this.fornitori.size(); ++i) {
			this.cbFornitore.addItem(this.fornitori.get(i).getPersistentModel().getName());
		}
		this.cbFornitore.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					AFormRDA.this.resetEssenza();
					AFormRDA.this.resetGeometria();
					AFormRDA.this.disableSpinner();
					AFormRDA.this.loadEssenze(GestisciFornitoreHandler
							.getInstance().getFornitoreByName(
									cbFornitore.getSelectedItem().toString()));
					
				}
			}
		});
		this.cbFornitore.setSelectedItem(null);
	}

	/**
	 * Metodo che carica le essenze in base al fornitore selezionato Quando
	 * un'essenza viene selezionata viene richiamato il metodo loadGeometrie
	 * 
	 * @param fornitore
	 *            : Catalogo Fornitore selezionato
	 */
	protected void loadEssenze(final MCatalogoFornitore fornitore) {
		AFormRDA.this.cbEssenza.setEnabled(true);
		if (this.cbEssenza.getItemListeners().length != 0)
			this.cbEssenza
					.removeItemListener(this.cbEssenza.getItemListeners()[0]);
		this.cbEssenza.removeAllItems();
		TreeSet<String> essenze = new TreeSet<String>();
		for (int i = 0; i < fornitore.getPersistentModel().productDescription.size(); ++i) {
			essenze.add(fornitore.getPersistentModel().productDescription.get(i).getEssenza());
		}
		for (int i = 0; i < essenze.size(); ++i) {
			this.cbEssenza.addItem(essenze.toArray()[i]);
		}
		this.cbEssenza.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					AFormRDA.this.resetGeometria();
					AFormRDA.this.disableSpinner();
					AFormRDA.this.loadGeometria(fornitore, cbEssenza
							.getSelectedItem().toString());
				}
			}
		});
		this.cbEssenza.setSelectedItem(null);
	}

	/**
	 * Metodo che carica i dati relative alle geometrie in base al fornitore e
	 * all'essenza selezionati Quando una geometria viene selezionata viene
	 * attito lo spinner per la selezione della quantita e viene richiamato il
	 * metodo aggiornaSpese()
	 * 
	 * @param fornitore
	 *            : CatalogoFornitore selezionato
	 * @param essenza
	 *            : Essenza selezionata
	 * 
	 */
	protected void loadGeometria(MCatalogoFornitore fornitore, String essenza) {
		AFormRDA.this.cbGeometria.setEnabled(true);
		if (this.cbGeometria.getItemListeners().length != 0)
			this.cbGeometria.removeItemListener(this.cbGeometria
					.getItemListeners()[0]);
		this.cbGeometria.removeAllItems();
		@SuppressWarnings("unchecked")
		ArrayList<ProductDescription> pd = new ArrayList<ProductDescription>(
				fornitore.getPersistentModel().productDescription.getCollection());
		for (int i = 0; i < pd.size(); ++i) {
			if (pd.get(i).getEssenza().equals(essenza)) {
				this.cbGeometria.addItem(new MGeometria(pd.get(i).getGeometria().getID()).toString());
			}
		}
		this.cbGeometria.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					AFormRDA.this.spinner.setEnabled(true);
					AFormRDA.this.setQuantity(1);
				}
			}
		});
		this.cbGeometria.setSelectedItem(null);
	}

	/**
	 * Metodo astratto per il reset della form
	 * 
	 */
	public abstract void reset();

	/**
	 * Metodo che ritorna il valore dello spinner
	 * 
	 * @return valore dello spinner
	 */
	public Integer getQuantity() {
		return (Integer) ((DefaultEditor) spinner.getEditor()).getTextField()
				.getValue();
	}

	/**
	 * Metodo che aggiorna il prezzo della riga RDA
	 * 
	 */
	public void aggiornaSpesa() {
		if(this.spinner.isEnabled()){
			MProductDescription pd = GestisciFornitoreHandler.getInstance()
					.getMProductDescription(
							this.cbEssenza.getSelectedItem().toString(),
							this.cbGeometria.getSelectedItem().toString(),
							this.cbFornitore.getSelectedItem().toString());
			this.tfSpesa.setText(String.valueOf((Integer) this.spinner.getValue()
					* pd.getPersistentModel().getPrezzo()));
			this.tfSpesa.validate();
			this.tfSpesa.repaint();
		}
	}

	/**
	 * Set
	 * 
	 * @param i: quantità intera da settare
	 */
	public void setQuantity(int i) {
		this.spinner.setValue(i);
		this.aggiornaSpesa();
	}

	/**
	 * Get
	 * 
	 * @return jhorizzontal spinner
	 */
	public JHorizontalSpinner getSpinner() {
		return spinner;
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(317, 240));
		setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("54px"), ColumnSpec.decode("19px"),
						ColumnSpec.decode("center:220px"), }, new RowSpec[] {
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
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		cbFornitore = new JComboBox<Object>();
		add(cbFornitore, "2, 4, 3, 1");

		lblFornitore = new JLabel("Seleziona il catalogo del Fornitore");
		add(lblFornitore, "2, 2, 3, 1");

		cbEssenza = new JComboBox<Object>();
		cbEssenza.setEnabled(false);
		add(cbEssenza, "2, 8, 3, 1");

		lblEssenza = new JLabel("Seleziona l'essenza");
		add(lblEssenza, "2, 6, 3, 1");

		cbGeometria = new JComboBox<Object>();
		cbGeometria.setEnabled(false);
		add(cbGeometria, "2, 12, 3, 1");

		lblGeometria = new JLabel("Seleziona la geometria");
		add(lblGeometria, "2, 10, 3, 1");

		lblQuantita = new JLabel("Seleziona il numero di pacchi");
		add(lblQuantita, "2, 14, 3, 1");

		spinner = new JHorizontalSpinner();
		spinner.setPreferredSize(new Dimension(75, 20));
		spinner.setMinimumSize(new Dimension(60, 20));
		spinner.setBorder(null);
		spinner.setEnabled(false);

		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField()
				.addKeyListener(new KeyListener() {

					@Override
					public void keyPressed(KeyEvent e) {

					}

					@Override
					public void keyReleased(KeyEvent e) {
						Pattern p = Pattern.compile("[^0-9]+");
						String myString = ((DefaultEditor) spinner.getEditor())
								.getTextField().getText();
						Matcher m = p.matcher(myString);
						String clean = m.replaceAll("");
						((DefaultEditor) spinner.getEditor()).getTextField()
								.setText(clean);
						if (clean.equalsIgnoreCase("0"))
							((DefaultEditor) spinner.getEditor())
									.getTextField().setText("1");
					}

					@Override
					public void keyTyped(KeyEvent e) {
					}

				});
		if (this.spinner.getChangeListeners().length == 1)
			this.spinner.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					aggiornaSpesa();
				}
			});

		add(spinner, "2, 16, 2, 1, left, center");

		lblPrezzo = new JLabel("Riepilogo spesa");
		add(lblPrezzo, "2, 18, 3, 1");

		tfSpesa = new JTextField();
		tfSpesa.setHorizontalAlignment(SwingConstants.TRAILING);
		tfSpesa.setFont(new Font("Tahoma", Font.ITALIC, 12));
		tfSpesa.setBorder(null);
		tfSpesa.setEditable(false);
		add(tfSpesa, "2, 20, left, default");
		tfSpesa.setColumns(10);

		lblValuta = new JLabel("\u20AC");
		lblValuta.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblValuta.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblValuta, "3, 20, right, default");

	}
	
	/**
	 * Metodo che disabilita lo spinner resettando il valore a 1
	 */
	protected void disableSpinner(){
		this.spinner.setEnabled(false);
		this.spinner.setValue(1);
		this.tfSpesa.setText(null);
		this.spinner.validate();
		this.spinner.repaint();
		this.tfSpesa.validate();
		this.tfSpesa.repaint();
	}
	
	/**
	 * Metodo che resetta la combo box essenza
	 */
	protected void resetEssenza(){
		this.cbEssenza.setEnabled(false);
		this.cbEssenza.removeAllItems();
		this.cbEssenza.validate();
		this.cbEssenza.repaint();
	}
	
	/**
	 * Metodo che resetta la combo box geometria
	 */
	protected void resetGeometria(){
		this.cbGeometria.setEnabled(false);
		this.cbGeometria.removeAllItems();
		this.cbGeometria.validate();
		this.cbGeometria.repaint();
	}
	
	

}
