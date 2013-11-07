package GUI.Riepiloghi;

import GUI.Abstract.ARiepilogo;

/**
 * Factory per i riepiloghi dei cataloghi fornitore
 * 
 * @author Simone
 *
 */
public class RiepilogoFornitoreFactory extends RiepilogoFactory {

private static RiepilogoFornitoreFactory instance = null;
	
	private RiepilogoFornitoreFactory(){};
	
	/**
	 * Singleton
	 * @return instance
	 */
	public static RiepilogoFornitoreFactory getInstance(){
		if(instance == null)
			instance = new RiepilogoFornitoreFactory();
		return instance;
	}

	@Override
	public ARiepilogo makeRiepilogo() {
		return new RiepilogoFornitore();
	}


	@Override
	public ARiepilogo makeRiepilogo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
