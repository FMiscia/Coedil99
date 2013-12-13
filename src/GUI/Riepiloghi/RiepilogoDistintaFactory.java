package GUI.Riepiloghi;

import GUI.Abstract.ARiepilogo;

/**
 * 
 * @author francesco
 *
 * Factory dei riepiloghi
 */
public class RiepilogoDistintaFactory extends RiepilogoFactory{

	private static RiepilogoDistintaFactory instance = null;
	
	private RiepilogoDistintaFactory(){};

	/**
	 * Singleton
	 * @return instance
	 */
	public static RiepilogoDistintaFactory getInstance(){
		if(instance == null)
			instance = new RiepilogoDistintaFactory();
		return instance;
	}

	@Override
	public ARiepilogo makeRiepilogo() {
		return new RiepilogoDistinta();
	}

	@Override
	public ARiepilogo makeRiepilogo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
