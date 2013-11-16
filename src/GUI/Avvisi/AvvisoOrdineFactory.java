package GUI.Avvisi;

import GUI.Abstract.AAvviso;

public class AvvisoOrdineFactory extends AvvisoFactory {
	
	private static AvvisoOrdineFactory instance = null;

	private AvvisoOrdineFactory() {
	};

	@Override
	public AAvviso makeAvviso() {
		return new AvvisoOrdine();
	}

	public static AvvisoOrdineFactory getInstance() {
		if (instance == null)
			instance = new AvvisoOrdineFactory();
		return instance;
	}

}
