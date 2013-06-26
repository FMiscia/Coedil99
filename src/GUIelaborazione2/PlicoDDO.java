package GUIelaborazione2;
import java.awt.Dimension;
import GUIelaborazione2.Riquadri.RiquadroOttimizzazione;



@SuppressWarnings("serial")
public class PlicoDDO extends Plico{

	private RiquadroOttimizzazione rdcc;
	private static PlicoDDO instance = null;
	
	
	
	public PlicoDDO(){
		setBorder(null);
		setLayout(null);
		

		rdcc = new RiquadroOttimizzazione("Ottimizzazione");

		rdcc.setBounds(40, 20,rdcc.getWidth(),rdcc.getHeight());
		setPreferredSize(new Dimension(745,1000));
		setSize(745,950);
		add(rdcc);
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static PlicoDDO getInstance(){
		if(PlicoDDO.instance == null)
			PlicoDDO.instance = new PlicoDDO();
		return PlicoDDO.instance;
	}
}