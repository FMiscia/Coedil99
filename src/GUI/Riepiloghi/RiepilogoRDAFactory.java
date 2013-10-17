package GUI.Riepiloghi;

import java.util.HashMap;

import coedil99.controller.GestisciRDAHandler;

import GUI.Abstract.ARiepilogoRDA;

public class RiepilogoRDAFactory {

	private static RiepilogoRDAFactory instance = null;
	
	private RiepilogoRDAFactory(){};
	
	protected static HashMap<String, ARiepilogoRDA> className;
	{
		className = new HashMap<String, ARiepilogoRDA>();
		className.put(GestisciRDAHandler.CONGELATA, new RiepilogoRDACongelata());
		className.put(GestisciRDAHandler.ATTESA_CONFERMA,  new RiepilogoRDAAttesaConferma());
	}
	

	
	public ARiepilogoRDA makeRiepilogo(String tipo) {
		
		return className.get(tipo);
		
	}
	
	public static RiepilogoRDAFactory getInstance(){
		if(instance == null)
			instance = new RiepilogoRDAFactory();
		return instance;
	}
	


}
