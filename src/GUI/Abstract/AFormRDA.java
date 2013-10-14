package GUI.Abstract;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.CatalogoFornitore;
import coedil99.model.Geometria;
import coedil99.model.ProductDescription;
import coedil99.operation.OGeometria;
import GUI.JHorizontalSpinner;
import GUI.Riquadri.RiquadroDatiAziendali;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;

public abstract class AFormRDA extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> cbFornitore;
	private JComboBox<Object> cbEssenza;
	private JComboBox<Object> cbGeometria;
	private ArrayList<CatalogoFornitore> fornitori;
	private JLabel lblFornitore;
	private JLabel lblEssenza;
	private JLabel lblGeometria;
	private JLabel lblPrezzo;
	private JLabel lblQuantita;
	private JTextField textField;
	private JHorizontalSpinner spinner;
	private JLabel lblErrorePacchi;
	private ImageIcon IcoErrore = new ImageIcon(
			RiquadroDatiAziendali.class
					.getResource("/GUI/image/cancel.png"));
	
	public AFormRDA() {
		this.setPreferredSize(new Dimension(286, 240));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(179dlu;default)"),},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		cbFornitore = new JComboBox<Object>();
		add(cbFornitore, "2, 4");
		
		lblFornitore = new JLabel("Seleziona il catalogo del Fornitore");
		add(lblFornitore, "2, 2");
		
		cbEssenza = new JComboBox<Object>();
		cbEssenza.setEnabled(false);
		add(cbEssenza, "2, 8");
		
		lblEssenza = new JLabel("Seleziona l'essenza");
		add(lblEssenza, "2, 6");
		
		cbGeometria = new JComboBox<Object>();
		cbGeometria.setEnabled(false);
		add(cbGeometria, "2, 12");
		
		lblGeometria = new JLabel("Seleziona la geometria");
		add(lblGeometria, "2, 10");
		
		lblQuantita = new JLabel("Seleziona il numero di pacchi");
		add(lblQuantita, "2, 14");
		
		spinner = new JHorizontalSpinner();
		spinner.setEnabled(false);
		spinner.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					if(spinner.getValue().equals(0)){
						lblErrorePacchi.setVisible(true);
						spinner.setBorder(new LineBorder(Color.red));

					}
					else{
						lblErrorePacchi.setVisible(false);
						spinner.setBorder(null);
					}
					
				}
		    });
		spinner.setBorder(null);
		spinner.setPreferredSize(new Dimension(60, 20));
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		add(spinner, "2, 16, left, center");
		
		lblErrorePacchi = new JLabel("Seleziona un numero diverso da zero!");
		lblErrorePacchi.setHorizontalTextPosition(SwingConstants.LEFT);
		lblErrorePacchi.setIcon(IcoErrore);
		lblErrorePacchi.setToolTipText("Il numero di pacchi deve essere diverso da zero!");
		lblErrorePacchi.setVisible(false);
		add(lblErrorePacchi,"2, 16, right, center");
		
		lblPrezzo = new JLabel("Riepilogo spesa");
		add(lblPrezzo, "2, 18");
		
		textField = new JTextField();
		textField.setEditable(false);
		add(textField, "2, 20");
		textField.setColumns(10);
		
		this.load();
	}

	
	public void load(){
		this.setFornitori(GestisciFornitoreHandler.getInstance().getArrayFornitori());
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


	public ArrayList<CatalogoFornitore> getFornitori() {
		return fornitori;
	}


	public void setFornitori(ArrayList<CatalogoFornitore> fornitori) {
		this.fornitori = fornitori;
	}
	
	private void loadFornitori(){
		this.cbFornitore.removeAllItems();
		for(int i=0; i<this.fornitori.size(); ++i){
			this.cbFornitore.addItem(this.fornitori.get(i).getName());
			this.cbFornitore.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED) {
	                	AFormRDA.this.loadEssenze(GestisciFornitoreHandler.getInstance().getFornitoreByName(cbFornitore.getSelectedItem().toString()));
	                	AFormRDA.this.cbEssenza.setEnabled(true);
	                }
	            }
			});
		}
		this.cbFornitore.setSelectedItem(null);
	}
	
	private void loadEssenze(CatalogoFornitore fornitore){
		this.cbEssenza.removeAllItems();
		TreeSet<String> essenze = new TreeSet<String>();
		for(int i=0; i<fornitore.productDescription.size(); ++i){
			essenze.add(fornitore.productDescription.get(i).getEssenza());
		}
		for(int i=0; i<essenze.size(); ++i){
			this.cbEssenza.addItem(essenze.toArray()[i]);
			this.cbEssenza.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED) {
	                	AFormRDA.this.loadGeometria(cbFornitore.getSelectedItem().toString(),cbEssenza.getSelectedItem().toString());
	                	AFormRDA.this.cbGeometria.setEnabled(true);
	                }
	            }
			});
		}
		this.cbEssenza.setSelectedItem(null);
	}

	private void loadGeometria(String fornitore,String essenza){
		this.cbGeometria.removeAllItems();
		ArrayList<ProductDescription> pd = new ArrayList<ProductDescription>(GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore).productDescription.getCollection());
		for(int i=0; i<pd.size(); ++i){
			if(pd.get(i).getEssenza().equals(essenza)){
				Geometria g = pd.get(i).getGeometria();
				this.cbGeometria.addItem(new OGeometria(g).toString());
				this.cbGeometria.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						 if(e.getStateChange() == ItemEvent.SELECTED) {
			                	AFormRDA.this.spinner.setEnabled(true);
			                }
					}
				});
			}
		}
		this.cbGeometria.setSelectedItem(null);
	}
	
	public void reset(){
		this.cbFornitore.removeAllItems();
		this.cbEssenza.removeAllItems();
		this.cbEssenza.setEnabled(true);
		this.cbGeometria.removeAllItems();
		this.cbGeometria.setEnabled(true);
		this.spinner.setValue(1);
		this.spinner.setEnabled(false);
	}
	
	
	public Integer getQuantity(){
		return (Integer) spinner.getValue();
	}

}