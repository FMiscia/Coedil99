package GUI.Avvisi;

import GUI.Abstract.AAvviso;

public class AvvisoCommessaFactory extends AvvisoFactory {
	
	private static AvvisoCommessaFactory instance = null;

	private AvvisoCommessaFactory() {
	};

	@Override
	public AAvviso makeAvviso() {
		return new AvvisoCommessa();
	}

	public static AvvisoCommessaFactory getInstance() {
		if (instance == null)
			instance = new AvvisoCommessaFactory();
		return instance;
	}

}
