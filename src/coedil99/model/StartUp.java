package coedil99.model;

import org.orm.PersistentException;

import coedil99.controller.GestisciCommessaHandler;
import coedil99.operation.OCommessa;
import coedil99.operation.ODistinta;
import coedil99.operation.OOrdine;


//import elaboradistinta.model.Catalogo;

public class StartUp {

	private static StartUp instance = null;
	
	public GestisciCommessaHandler gch;
	
	ODistinta dist1; 
	ODistinta dist2; 

	//public OOrdine o;
	public OOrdine o2;
	public OCommessa c1;
	public OCommessa c2;
	public OCommessa c3;
	//public Catalogo cat;
	AOttimizzatoreStrategy optimizer;
	
	private StartUp() throws PersistentException {
	/*
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
		try{
		
		ListaRintracciabilita ldr = ListaRintracciabilitaFactory.createListaRintracciabilita();
		ldr.save();
		
		Commessa commessa = CommessaFactory.createCommessa();
		commessa.setLdr(ldr);
		commessa.setCodiceInterno("2013-01-02");
		commessa.save();
		
		Commessa c1 = CommessaFactory.createCommessa();
		c1.setLdr(ldr);
		c1.setCodiceInterno("2013-01-01");
		c1.save();
	
		elaboradistinta.model.Ordine o = elaboradistinta.model.OrdineFactory.createOrdine();
		o.commesse.add(commessa);
		o.commesse.add(c1);
		o.setAnno(2013);
		o.save();
		
		elaboradistinta.model.Cliente c = elaboradistinta.model.ClienteFactory.createCliente();
		c.setName("GianFranco");
		c.setNumeroCommessaCliente(1);
		c.ordini.add(o);
		c.save();
		
		for(int r=0; r<3; ++r){
			Geometria g = GeometriaFactory.createGeometria();
			g.setBase(23f);
			g.setAltezza(50f);
			g.setLunghezza(1000f);
			g.save();
		
			History h = HistoryFactory.createHistory();
			h.save();
		
			Item i = ItemFactory.createItem();
			i.setDescrizione("Listarelli");
			i.setGeometria(g);
			i.setHistory(h);
			i.save();}
		//DocumentoOttimizzazione o = DocumentoOttimizzazioneFactory.createDocumentoOttimizzazione();
		//o.items.add(ItemFactory.getItemByORMID(1));
		//o.save();
		t.commit();
	}
	catch (Exception e) {
		t.rollback();
	}
		*/
		//d.save();

		

		
		


		
	}
	
	public static StartUp getInstance(){
		if (StartUp.instance == null){
			try {
				StartUp.instance = new StartUp();
				Coedil99ingdelsoftwarePersistentManager.instance().disposePersistentManager();
			}
			catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		return StartUp.instance;
	}
	
}
