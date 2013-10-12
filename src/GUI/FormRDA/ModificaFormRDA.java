package GUI.FormRDA;

import GUI.Abstract.AFormRDA;
import coedil99.model.RigaRDA;
import coedil99.operation.OGeometria;

public class ModificaFormRDA extends AFormRDA {

	public ModificaFormRDA() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	public void modificaRDA(RigaRDA rigaRDA){
		String fornitoreRDA = rigaRDA.getDescription().getCatalogoFornitore().getName();
		String essenzaRDA = rigaRDA.getDescription().getEssenza();
		String geometriaRDA = new OGeometria(rigaRDA.getDescription().getGeometria()).toString();
		this.load();
		for(int i=0; i<this.getCbFornitore().getItemCount(); ++i){
			if(this.getCbFornitore().getItemAt(i).equals(fornitoreRDA))
				this.getCbFornitore().setSelectedIndex(i);
		}
		
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
		
	}

}
