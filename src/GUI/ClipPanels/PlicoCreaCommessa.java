package GUI.ClipPanels;

import GUI.Plichi.PlicoCommessa;

public class PlicoCreaCommessa {
	private static PlicoCreaCommessa instance = null;
	
	/**
	 * Singleton
	 * 
	 * @return instance:PlicoCommessa
	 */
	public static PlicoCreaCommessa getInstance() {
		if (PlicoCreaCommessa.instance == null)
			PlicoCreaCommessa.instance = new PlicoCreaCommessa();
		return PlicoCreaCommessa.instance;
	}

	public void resetAll() {
		// TODO Auto-generated method stub
		
	}
}
