package GUI.Form;

import GUI.Abstract.AFormDistinta;
import GUI.Abstract.AFormRDA;

/**
 * 
 * @author francesco
 * implementazione factory abstract factory
 */
public class FormDistintaFactory {

	private static FormDistintaFactory instance = null;
	
	private FormDistintaFactory(){};
	
	public AFormDistinta makeFormDistinta() {
		return new FormDistinta();
	}
	
	public static FormDistintaFactory getInstance(){
		if(instance == null)
			instance = new FormDistintaFactory();
		return instance;
	}

}
