package GUI.Riepiloghi;

import GUI.Abstract.ARiepilogoRDA;

public class RiepilogoRDAFactory {

	private static RiepilogoRDAFactory instance = null;
	
	private RiepilogoRDAFactory(){};
	
	
	public ARiepilogoRDA makeRiepilogo(String tipo) {
		switch(tipo){
			case "CONGELATA":
				return new RiepilogoRDACongelata();
			case "ATTESA_CONFERMA":
				return new RiepilogoRDAAttesaConferma();
		}
		// TODO Auto-generated method stub
		return null;
		
	}
	
	public static RiepilogoRDAFactory getInstance(){
		if(instance == null)
			instance = new RiepilogoRDAFactory();
		return instance;
	}


}
