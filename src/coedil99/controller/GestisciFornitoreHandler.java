package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;

import coedil99.model.CatalogoFornitore;
import coedil99.model.CatalogoFornitoreFactory;
import coedil99.model.ProductDescription;
import coedil99.model.RDAFactory;
import coedil99.operation.OGeometria;

public class GestisciFornitoreHandler {

	private ArrayList<CatalogoFornitore> arrayFornitori = null;
	private static GestisciFornitoreHandler instance;
	
	/**
	 * Costruttore
	 */
	private GestisciFornitoreHandler() {
		
		try {
			this.arrayFornitori = new ArrayList<CatalogoFornitore>(Arrays.asList(CatalogoFornitoreFactory.listCatalogoFornitoreByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static GestisciFornitoreHandler getInstance() {
		if (GestisciFornitoreHandler.instance == null) {
			GestisciFornitoreHandler.instance = new GestisciFornitoreHandler();
		}

		return GestisciFornitoreHandler.instance;
	}

	public ArrayList<CatalogoFornitore> getArrayFornitori() {
		return arrayFornitori;
	}
	
	public CatalogoFornitore getFornitoreByName(String nome){
		try {
			return CatalogoFornitoreFactory.loadCatalogoFornitoreByQuery(" Name = " + "'" + nome + "'", null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ProductDescription getProductDescription(String essenza, String geometria, String fornitore) {
		// TODO Auto-generated method stub
		CatalogoFornitore cf = GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore);
		List l = cf.productDescription.getCollection();
		ProductDescription pd = null;
		for ( int i=0 ; i<l.size() ; i++  ){
			pd = (ProductDescription) l.get(i);
			if( pd.getEssenza().toString().equalsIgnoreCase(essenza)  && new OGeometria(pd.getGeometria()).toString().equalsIgnoreCase(geometria)){
				return pd;
			}
		}
		return null;
	}
	
	
}
