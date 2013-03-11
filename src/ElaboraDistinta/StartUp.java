package ElaboraDistinta;

import java.util.Calendar;


import ElaboraDistinta.Controller.GestisciCommessaHandler;
import ElaboraDistinta.Model.Catalogo;
import ElaboraDistinta.Model.Commessa;
import ElaboraDistinta.Model.Distinta;
import ElaboraDistinta.Model.Geometria;
import ElaboraDistinta.Model.Ordine;
import ElaboraDistinta.Model.RigaLavoro;
import ElaboraDistinta.Operation.OCommessa;
import ElaboraDistinta.Operation.ODistinta;
import ElaboraDistinta.Operation.OOrdine;

public class StartUp {

	private static StartUp instance = null;
	
	public GestisciCommessaHandler gch;
	
	ODistinta dist1 = new ODistinta(new Distinta());
	ODistinta dist2 = new ODistinta(new Distinta());

	public OOrdine o;
	public OOrdine o2;
	public OCommessa c1;
	public OCommessa c2;
	public OCommessa c3;
	public Catalogo cat;
	AOttimizzatoreStrategy optimizer;
	
	private StartUp(){
		
		o = new OOrdine(new Ordine( null, "pippo",2013 ));
		o2 = new OOrdine(new Ordine( null, "pluto",2013 ));
		
		c1 = new OCommessa(new Commessa( o.getOrdine() , null, "tetto" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Christian"));
		c2 = new OCommessa(new Commessa( o.getOrdine() , null, "parete" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Luca"));
		c3 = new OCommessa(new Commessa( o2.getOrdine() , null, "cesso" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione ffeeerrr" , "tizio"));
		
		this.dist1.addRigaLavoro(new RigaLavoro(1,new Geometria(23,50,100),false,null,"niente da dichiarare",1));
		this.dist1.addRigaLavoro(new RigaLavoro(2,new Geometria(23,50,400),true,"Dorico","niente da dichiarare",1));
		this.dist2.addRigaLavoro(new RigaLavoro(1,new Geometria(1,2,100),false,null,"sss",1));
		this.dist2.addRigaLavoro(new RigaLavoro(2,new Geometria(1,2,100),true,"Dorico","ddd",1));
		
		
		gch = GestisciCommessaHandler.getInstance();

		gch.add(c1.getCommessa());			
		gch.add(c2.getCommessa());
		gch.add(c3.getCommessa());
		o.addCommessa(c1.getCommessa());
		o.addCommessa(c2.getCommessa());	
		o2.addCommessa(c2.getCommessa());	
		gch.associaDistinta(dist1.getDistinta(), c1.getCommessa().getId());
		gch.associaDistinta(dist2.getDistinta(), c2.getCommessa().getId());
		
	}
	
	public static StartUp getInstance(){
		if (StartUp.instance == null){
			StartUp.instance = new StartUp();
		}
		return StartUp.instance;
	}
	
}
