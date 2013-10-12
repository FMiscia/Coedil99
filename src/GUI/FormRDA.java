package GUI;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.CatalogoFornitore;
import coedil99.model.CatalogoFornitoreFactory;
import coedil99.model.Geometria;
import coedil99.model.ProductDescription;
import coedil99.model.ProductDescriptionFactory;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;

import org.orm.PersistentException;

public class FormRDA extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> cbFornitore;
	private JComboBox<Object> cbEssenza;
	private JComboBox<Object> cbGeometria;
	private ArrayList<CatalogoFornitore> fornitori;
	private JLabel lblFornitore;
	private JLabel lblEssenza;
	private JLabel lblGeometria;
	
	public FormRDA() {
		this.setPreferredSize(new Dimension(351, 200));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(225dlu;default)"),},
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
		
		this.load();
	}

	
	public void load(){
		this.setFornitori(GestisciFornitoreHandler.getInstance().getArrayFornitori());
		this.loadFornitori();
		this.validate();
		this.repaint();
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
					System.out.println("change");
	                if(e.getStateChange() == ItemEvent.SELECTED) {
		                FormRDA.this.loadEssenze(GestisciFornitoreHandler.getInstance().getFornitoreByName(cbFornitore.getSelectedItem().toString()));
		                FormRDA.this.cbEssenza.setEnabled(true);
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
					System.out.println("change essenza");
	                if(e.getStateChange() == ItemEvent.SELECTED) {
		                FormRDA.this.loadGeometria(cbFornitore.getSelectedItem().toString(),cbEssenza.getSelectedItem().toString());
		                FormRDA.this.cbGeometria.setEnabled(true);
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
				this.cbGeometria.addItem(g.getBase()+" x "+g.getLunghezza()+" x "+g.getAltezza());
			}
		}
	}
	
	

}
