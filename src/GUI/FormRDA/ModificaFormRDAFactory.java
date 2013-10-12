package GUI.FormRDA;

import GUI.Abstract.AFormRDA;

public class ModificaFormRDAFactory extends FormRDAFactory {

	private static ModificaFormRDAFactory instance = null;
	
	private ModificaFormRDAFactory(){};
	
	@Override
	public AFormRDA makeFormRDA() {
		// TODO Auto-generated method stub
		return new ModificaFormRDA();
	}
	
	public static ModificaFormRDAFactory getInstance(){
		if(instance == null)
			instance = new ModificaFormRDAFactory();
		return instance;
	}

}
