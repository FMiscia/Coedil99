package GUI.Avvisi;

import GUI.Abstract.AAvviso;

public class AvvisoRDAFactory extends AvvisoFactory {

	private static AvvisoRDAFactory instance = null;

	private AvvisoRDAFactory() {
	};

	public static AvvisoRDAFactory getInstance() {
		if (instance == null)
			instance = new AvvisoRDAFactory();
		return instance;
	}
	
	@Override
	public AAvviso makeAvviso() {
		return new AvvisoRDA();
	}

}
