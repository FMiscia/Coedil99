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

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class FormRDA extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> cbFornitore;
	private JComboBox<Object> cbEssenza;
	private JComboBox<Object> cbGeometria;
	private ArrayList<CatalogoFornitore> fornitori;
	
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		cbFornitore = new JComboBox<Object>();
		cbFornitore.addItem("Seleziona il catalogo del Fornitore...");
		add(cbFornitore, "2, 2");
		
		cbEssenza = new JComboBox<Object>();
		cbEssenza.setEnabled(false);
		cbEssenza.addItem("Seleziona l'essenza...");
		add(cbEssenza, "2, 4");
		
		cbGeometria = new JComboBox<Object>();
		cbGeometria.setEnabled(false);
		cbGeometria.addItem("Seleziona la geometria...");
		add(cbGeometria, "2, 6");
		
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
	}
	
	private void loadEssenze(CatalogoFornitore fornitore){
		TreeSet<String> essenze = new TreeSet<String>();
		for(int i=0; i<fornitore.productDescription.size(); ++i){
			essenze.add(fornitore.productDescription.get(i).getEssenza());
		}
		for(int i=0; i<essenze.size(); ++i){
			this.cbEssenza.addItem(essenze.toArray()[i]);
		}
			
	}

	private void loadGeometrie(){
		
	}

}
