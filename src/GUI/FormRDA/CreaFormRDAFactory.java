package GUI.FormRDA;

import GUI.Abstract.AFormRDA;

/**
 * 
 * @author francesco
 * implementazione factory abstract factory
 */
public class CreaFormRDAFactory extends FormRDAFactory {

	private static CreaFormRDAFactory instance = null;
	
	private CreaFormRDAFactory(){};
	
	@Override
	public AFormRDA makeFormRDA() {
		// TODO Auto-generated method stub
		return new CreaFormRDA();
	}
	
	public static CreaFormRDAFactory getInstance(){
		if(instance == null)
			instance = new CreaFormRDAFactory();
		return instance;
	}

}
