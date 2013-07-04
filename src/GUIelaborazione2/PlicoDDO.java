package GUIelaborazione2;
import java.awt.Dimension;

import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Commessa;
import GUIelaborazione2.Riquadri.RiquadroOttimizzazione;



@SuppressWarnings("serial")
public class PlicoDDO extends Plico{

	private RiquadroOttimizzazione ro;
	private static PlicoDDO instance = null;
	
	
	
	private PlicoDDO(){
		setBorder(null);
		setLayout(null);
		

		ro = new RiquadroOttimizzazione("Ottimizzazione");

		ro.setBounds(40, 20,ro.getWidth(),ro.getHeight());
		setPreferredSize(new Dimension(745,1000));
		setSize(745,950);
		add(ro);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}


	
	
	public static PlicoDDO getInstance(){
		if(PlicoDDO.instance == null)
			PlicoDDO.instance = new PlicoDDO();
		return PlicoDDO.instance;
	}

	public void load(int id) {
		// TODO Auto-generated method stub
		Commessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
		ro.load(c.getDistinta().getDdo());
	}
}