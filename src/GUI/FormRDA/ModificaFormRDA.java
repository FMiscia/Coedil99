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
import coedil99.model.MGeometria;
import coedil99.model.MProductDescription;
import coedil99.model.MRigaRDA;
import coedil99.persistentModel.ProductDescription;
import coedil99.persistentModel.RigaRDA;


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
	private MRigaRDA rigaRDA = null;

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
	public void modificaRDA(MRigaRDA rigaRDA){
		this.setRigaRDA(rigaRDA);
		String fornitoreRDA = rigaRDA.getPersistentModel().getDescription().getCatalogoFornitore().getName();
		String essenzaRDA = rigaRDA.getPersistentModel().getDescription().getEssenza();
		String geometriaRDA = new MGeometria(rigaRDA.getPersistentModel().getDescription().getGeometria().getID()).toString();
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
		this.setQuantity(rigaRDA.getPersistentModel().getQuantity());
	}


	public MRigaRDA getRigaRDA() {
		return rigaRDA;
	}


	public void setRigaRDA(MRigaRDA rigaRDA) {
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
					MProductDescription pd = GestisciFornitoreHandler.getInstance().getMProductDescription(essenza, geometria, fornitore);
					ModificaFormRDA.this.getRigaRDA().getPersistentModel().setQuantity(ModificaFormRDA.this.getQuantity());
					ModificaFormRDA.this.getRigaRDA().getPersistentModel().setDescription(pd.getPersistentModel());
					ModificaFormRDA.this.getRigaRDA().save();

					PlicoRDA.getInstance().refresh();
				}
				
			}
		});
		add(btSalvaModifica, "2, 22, 3, 1");
	}



}
