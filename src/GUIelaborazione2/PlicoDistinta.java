package GUIelaborazione2;

public class PlicoDistinta extends Plico{

	
	private static PlicoDistinta instance = null;
	private RigaDistinta rd = new RigaDistinta();
	
	public PlicoDistinta(){
		this.add(rd);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	public static PlicoDistinta getInstance(){
		if(PlicoDistinta.instance == null)
			PlicoDistinta.instance = new PlicoDistinta();
		return PlicoDistinta.instance;
	}

}
