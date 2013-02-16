package ElaboraDistinta;

import java.util.Calendar;
import java.util.Iterator;

public class StartUp {

	private static StartUp instance = null;
	
	public GestisciCommessaHandler gch;
	
	Distinta dist = new Distinta();
	public Ordine o;
	public Commessa c1;
	public Commessa c2;
	public Catalogo cat;
	public Magazzino m;
	IOttimizzatoreStrategy optimizer;
	
	public StartUp(){
		Calendar inizio = Calendar.getInstance();
		Calendar fine = Calendar.getInstance();
		fine.add(Calendar.DAY_OF_MONTH, 1);
		
		o = new Ordine( null, "pippo", inizio , fine );
		
		c1 = new Commessa( o , null, "tetto" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Christian" , 0);
		c2 = new Commessa( o , null, "parete" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Luca" , 0);
		
		this.dist.addRigaLavoro(new RigaLavoro(1,new Geometria(23,50,100),false,null,"niente da dichiarare",1));
		this.dist.addRigaLavoro(new RigaLavoro(2,new Geometria(23,50,400),true,"Dorico","niente da dichiarare",1));
		this.dist.addRigaLavoro(new RigaLavoro(2,new Geometria(23,50,100),true,"Dorico","niente da dichiarare",1));
		
		gch = GestisciCommessaHandler.getInstance();
		
		
		gch.add(c1);
		gch.add(c2);
		gch.associaDistinta(dist, c1.getId());
		gch.associaDistinta(dist, c2.getId());
		gch.getCommessaById(1).getDistinta().creaDDO();

		Iterator <Item> it = gch.getCommessaById(1).getDistinta().ddo.items.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getDescrizione());
		}

		
	}
	
	public static StartUp getInstance(){
		if (StartUp.instance == null){
			StartUp.instance = new StartUp();
		}
		return StartUp.instance;
	}
	
}
