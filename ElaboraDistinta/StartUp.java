package ElaboraDistinta;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class StartUp {

	public GestisciCommessaHandler gch;
	public ElaboraDistintaHandler edh;
	
	Distinta dist = new Distinta();
	public Ordine o;
	public Commessa c1;
	public Commessa c2;
	public Catalogo cat;
	public Magazzino m;
	
	public StartUp(){
		Calendar inizio = Calendar.getInstance();
		Calendar fine = Calendar.getInstance();
		fine.add(Calendar.DAY_OF_MONTH, 1);
		
		
		o = new Ordine( null, "pippo", inizio , fine );
		
		c1 = new Commessa( o , null, "tetto" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Christian" , 0);
		c2 = new Commessa( o , null, "ponte" , Calendar.getInstance() , Calendar.getInstance() , "pomeriggio" , 
				"descrizione..." , "Pippo" , 0);
		o.addCommessa(c1);
		o.addCommessa(c2);
		
		
		this.dist.addRigaLavoro(new RigaLavoro(1,new Geometria(23,48,400),false,null,"niente da dichiarare",1));
		this.dist.addRigaLavoro(new RigaLavoro(2,new Geometria(3,35,300),true,"Dorico","niente da dichiarare",1));
		
		gch = GestisciCommessaHandler.getInstance();
		edh = ElaboraDistintaHandler.getInstance();
		
		
		
		gch.add(c1);
		gch.add(c2);
		edh.add(dist,c1.getId());
		edh.add(dist,c2.getId());

	}
	
}
