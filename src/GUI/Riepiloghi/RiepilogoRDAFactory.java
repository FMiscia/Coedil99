package GUI.Riepiloghi;

import java.util.HashMap;

import coedil99.controller.GestisciRDAHandler;

import GUI.Abstract.ARiepilogoRDA;

/**
 * 
 * @author francesco
 *
 * Factory dei riepiloghi
 */
public class RiepilogoRDAFactory {

	private static RiepilogoRDAFactory instance = null;
	
	private RiepilogoRDAFactory(){};
	
	/**
	 * Uso un Hash Map statico perchè non posso
	 * prevedere in anticipo che oggetto dovrò istanziare. Allora
	 * in runtime mi faccio fornire una stringa nel makeRiepilogo
	 * che rappresenta il tipo RDA
	 */
	protected static HashMap<String, ARiepilogoRDA> className;
	{
		className = new HashMap<String, ARiepilogoRDA>();
		className.put(GestisciRDAHandler.CONGELATA, new RiepilogoRDACongelata());
		className.put(GestisciRDAHandler.ATTESA_CONFERMA,  new RiepilogoRDAAttesaConferma());
		className.put(GestisciRDAHandler.CONFERMATA,  new RiepilogoRDAConfermata());
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
