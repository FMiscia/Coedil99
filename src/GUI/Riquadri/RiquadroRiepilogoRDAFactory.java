package GUI.Riquadri;

import GUI.Abstract.ARiepilogoRDA;

public class RiquadroRiepilogoRDAFactory {

	private static RiquadroRiepilogoRDAFactory instance = null;
	
	private RiquadroRiepilogoRDAFactory(){};
	
	
	public ARiepilogoRDA makeRiepilogo() {
		// TODO Auto-generated method stub
		return new RiquadroRiepilogoRDA();
	}
	
	public static RiquadroRiepilogoRDAFactory getInstance(){
		if(instance == null)
			instance = new RiquadroRiepilogoRDAFactory();
		return instance;
	}


}
