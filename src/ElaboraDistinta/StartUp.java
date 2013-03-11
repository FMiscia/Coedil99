package ElaboraDistinta;

import java.util.Calendar;
import java.util.Iterator;

import ElaboraDistinta.Controller.GestisciCommessaHandler;
import ElaboraDistinta.Model.Catalogo;
import ElaboraDistinta.Model.Commessa;
import ElaboraDistinta.Model.Distinta;
import ElaboraDistinta.Model.Geometria;
import ElaboraDistinta.Model.Item;
import ElaboraDistinta.Model.Magazzino;
import ElaboraDistinta.Model.Ordine;
import ElaboraDistinta.Model.RigaLavoro;

public class StartUp {

	private static StartUp instance = null;
	
	public GestisciCommessaHandler gch;
	
	Distinta dist1 = new Distinta();
	Distinta dist2 = new Distinta();

	public Ordine o;
	public Ordine o2;
	public Commessa c1;
	public Commessa c2;
	public Commessa c3;
	public Catalogo cat;
	AOttimizzatoreStrategy optimizer;
	
	private StartUp(){
		
		o = new Ordine( null, "pippo",2013 );
		o2 = new Ordine( null, "pluto",2013 );
		
		c1 = new Commessa( o , null, "tetto" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Christian");
		c2 = new Commessa( o , null, "parete" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Luca");
		c3 = new Commessa( o2 , null, "cesso" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione ffeeerrr" , "tizio");
		
		this.dist1.addRigaLavoro(new RigaLavoro(1,new Geometria(23,50,100),false,null,"niente da dichiarare",1));
		this.dist1.addRigaLavoro(new RigaLavoro(2,new Geometria(23,50,400),true,"Dorico","niente da dichiarare",1));
		this.dist2.addRigaLavoro(new RigaLavoro(1,new Geometria(1,2,100),false,null,"sss",1));
		this.dist2.addRigaLavoro(new RigaLavoro(2,new Geometria(1,2,100),true,"Dorico","ddd",1));
		
		
		gch = GestisciCommessaHandler.getInstance();

		gch.add(c1);			
		gch.add(c2);
		gch.add(c3);
		o.addCommessa(c1);
		o.addCommessa(c2);	
		o2.addCommessa(c2);	
		gch.associaDistinta(dist1, c1.getId());
		gch.associaDistinta(dist2, c2.getId());
		
	}
	
	public static StartUp getInstance(){
		if (StartUp.instance == null){
			StartUp.instance = new StartUp();
		}
		return StartUp.instance;
	}
	
}
