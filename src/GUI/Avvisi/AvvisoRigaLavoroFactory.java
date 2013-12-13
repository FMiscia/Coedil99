package GUI.Avvisi;

import GUI.Abstract.AAvviso;

public class AvvisoRigaLavoroFactory extends AvvisoFactory {
	
	private static AvvisoRigaLavoroFactory instance = null;

	private AvvisoRigaLavoroFactory() {
	};

	@Override
	public AAvviso makeAvviso() {
		return new AvvisoRigaLavoro();
	}

	public static AvvisoRigaLavoroFactory getInstance() {
		if (instance == null)
			instance = new AvvisoRigaLavoroFactory();
		return instance;
	}

}
