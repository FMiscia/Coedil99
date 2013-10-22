package GUI.FormRDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.orm.PersistentException;

import GUI.ProgrammaLavori;
import GUI.Abstract.AFormRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.ProductDescription;
import coedil99.model.RigaRDA;
import coedil99.operation.OGeometria;


/**
 * 
 * @author francesco
 * Gestisce la form per la modifica di una RDA
 */
public class ModificaFormRDA extends AFormRDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btSalvaModifica;
	private RigaRDA rigaRDA = null;

	/**
	 * Costruttore
	 */
	public ModificaFormRDA() {
		super();
		this.initialize();
	}
	
	/**
	 * Carica la riga RDA selezionata sulla form per la modifica
	 * @param rigaRDA
	 */
	public void modificaRDA(RigaRDA rigaRDA){
		this.setRigaRDA(rigaRDA);
		String fornitoreRDA = rigaRDA.getDescription().getCatalogoFornitore().getName();
		String essenzaRDA = rigaRDA.getDescription().getEssenza();
		String geometriaRDA = new OGeometria(rigaRDA.getDescription().getGeometria()).toString();
		this.load();
		for(int i=0; i<this.getCbFornitore().getItemCount(); ++i){
			if(this.getCbFornitore().getItemAt(i).equals(fornitoreRDA))
				this.getCbFornitore().setSelectedIndex(i);
		}
		this.getCbFornitore().setEnabled(false);
		for(int i=0; i<this.getCbEssenza().getItemCount(); ++i){
			if(this.getCbEssenza().getItemAt(i).equals(essenzaRDA))
				this.getCbEssenza().setSelectedIndex(i);
		}
		this.getCbEssenza().setEnabled(true);
		for(int i=0; i<this.getCbGeometria().getItemCount(); ++i){
			if(this.getCbGeometria().getItemAt(i).equals(geometriaRDA))
				this.getCbGeometria().setSelectedIndex(i);
		}
		this.getCbGeometria().setEnabled(true);
		this.setQuantity(rigaRDA.getQuantity());
	}


	public RigaRDA getRigaRDA() {
		return rigaRDA;
	}


	public void setRigaRDA(RigaRDA rigaRDA) {
		this.rigaRDA = rigaRDA;
	}


	@Override
	/**
	 * rimuove tutti i componenti dalla form
	 */
	public void reset() {
		this.cbFornitore.removeAllItems();
		this.cbEssenza.removeAllItems();
		this.cbEssenza.setEnabled(true);
		this.cbGeometria.removeAllItems();
		this.cbGeometria.setEnabled(false);
		this.spinner.setValue(1);
		this.spinner.setEnabled(false);
		this.tfSpesa.setText(null);
		
	}
	
	/**
	 * Imposta la grafica e i bottoni (e relativi listeners)
	 */
	private void initialize(){
		btSalvaModifica = new JButton("Salva Modifica");
		btSalvaModifica.addMouseListener(new MouseAdapter() {
							
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Si", "No" };
				int n = JOptionPane.showOptionDialog(
						ProgrammaLavori.getInstance(),
						"Sicuro di voler salvare le modifiche della RDA?\n",
						"Conferma operazione",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null,
						options, options[1]);
				if (n == JOptionPane.YES_OPTION) {
					String fornitore = ModificaFormRDA.this.getCbFornitore().getSelectedItem().toString();
					String essenza = ModificaFormRDA.this.getCbEssenza().getSelectedItem().toString();
					String geometria = ModificaFormRDA.this.getCbGeometria().getSelectedItem().toString();
					ProductDescription pd = GestisciFornitoreHandler.getInstance().getProductDescription(essenza, geometria, fornitore);
					ModificaFormRDA.this.getRigaRDA().setQuantity(ModificaFormRDA.this.getQuantity());
					ModificaFormRDA.this.getRigaRDA().setDescription(pd);
					try {
						ModificaFormRDA.this.getRigaRDA().save();
					} catch (PersistentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PlicoRDA.getInstance().refresh();
				}
				
			}
		});
		add(btSalvaModifica, "2, 22, 3, 1");
	}



}
