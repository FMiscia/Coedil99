package ElaboraDistinta.Model;

import java.util.ArrayList;
import java.util.ListIterator;

public class RigheLavoro {

	ArrayList<RigaLavoro> righe;

	public RigheLavoro() {
		this.righe = new ArrayList<RigaLavoro>();
	}
	
	public ArrayList<RigaLavoro> getRigheLavoro(){
		return this.righe;
	}

}