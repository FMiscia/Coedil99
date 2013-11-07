package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;

/**
 * Gestisce il pannello dei fornitori
 * 
 * @author Simone
 *
 */
@SuppressWarnings("serial")
public class PlicoFornitore extends APlico {

	private static PlicoFornitore instance = null;
	
	/**
	 * Costruttore
	 */
	private PlicoFornitore(){
		this.setLayout(new BorderLayout());
	}
	
	/**
	 * Singleton
	 * @return instance:PlicoRDA
	 */
	public static PlicoFornitore getInstance() {
		if (PlicoFornitore.instance == null)
			PlicoFornitore.instance = new PlicoFornitore();
		return PlicoFornitore.instance;
	}
	
	
	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isModifying() {
		// TODO Auto-generated method stub
		return false;
	}

}
