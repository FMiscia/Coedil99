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
	
	Distinta dist = new Distinta();
	public Ordine o;
	public Commessa c1;
	public Commessa c2;
	public Catalogo cat;
	public Magazzino m;
	AOttimizzatoreStrategy optimizer;
	
	private StartUp(){
		
		o = new Ordine( null, "pippo",2013 );
		
		c1 = new Commessa( o , null, "tetto" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Christian");
		c2 = new Commessa( o , null, "parete" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Luca");
		
		this.dist.addRigaLavoro(new RigaLavoro(1,new Geometria(23,50,100),false,null,"niente da dichiarare",1));
		this.dist.addRigaLavoro(new RigaLavoro(2,new Geometria(23,50,400),true,"Dorico","niente da dichiarare",1));
		
		gch = GestisciCommessaHandler.getInstance();
		
		for ( int i = 0 ; i<50 ; i++ ){
			gch.add(c1);			
		}
		
		gch.add(c2);
		o.addCommessa(c1);
		o.addCommessa(c2);	
		gch.associaDistinta(dist, c1.getId());
		//gch.associaDistinta(dist, c2.getId());
		gch.getCommessaById(1).getDistinta().creaDDO();

		Iterator <Item> it = gch.getCommessaById(1).getDistinta().getDdo().getItems().iterator();
		while(it.hasNext()){
			System.out.println(it.next().getDescrizione());
		}
		System.out.println(c1.getCodiceInterno());
		System.out.println(c2.getCodiceInterno());

		
	}
	
	public static StartUp getInstance(){
		if (StartUp.instance == null){
			StartUp.instance = new StartUp();
		}
		return StartUp.instance;
	}
	
}
