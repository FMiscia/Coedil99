package Panels;

public class PanelRDACommFactory {

	private static PanelRDACommFactory instance = null;
	
	private PanelRDACommFactory(){};
	
	public PanelRDAComm makePanelRDAComm() {
		// TODO Auto-generated method stub
		return new PanelRDAComm();
	}
	
	public static PanelRDACommFactory getInstance(){
		if(instance == null)
			instance = new PanelRDACommFactory();
		return instance;
	
	}
}