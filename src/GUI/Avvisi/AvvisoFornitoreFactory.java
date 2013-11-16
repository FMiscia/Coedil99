package GUI.Avvisi;

import GUI.Abstract.AAvviso;

public class AvvisoFornitoreFactory extends AvvisoFactory {

	private static AvvisoFornitoreFactory instance = null;

	private AvvisoFornitoreFactory() {
	};


	public static AvvisoFornitoreFactory getInstance() {
		if (instance == null)
			instance = new AvvisoFornitoreFactory();
		return instance;
	}
	
	@Override
	public AAvviso makeAvviso() {
		return new AvvisoFornitore();
	}
	
	

}
