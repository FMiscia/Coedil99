package GUI.Panels;


public class NotaRDAFactory {
	
	private static NotaRDAFactory instance = null;
	
	private NotaRDAFactory(){};
	

	public NotaRDA makeNotaRDA() {
		return new NotaRDA();
	}
	
	public static NotaRDAFactory getInstance(){
		if(instance == null)
			instance = new NotaRDAFactory();
		return instance;
	}



}


