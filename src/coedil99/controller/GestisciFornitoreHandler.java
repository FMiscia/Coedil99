package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;

import coedil99.model.CatalogoFornitore;
import coedil99.model.CatalogoFornitoreBuilder;
import coedil99.model.CatalogoFornitoreFactory;
import coedil99.model.ProductDescription;
import coedil99.model.RDAFactory;
import coedil99.operation.OGeometria;

public class GestisciFornitoreHandler {

	private ArrayList<CatalogoFornitore> arrayFornitori = null;
	private CatalogoFornitoreBuilder builder;
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
	
	/**
	 * Singleton
	 * @return instance:GestisciFornitoreHandler
	 */
	public static GestisciFornitoreHandler getInstance() {
		if (GestisciFornitoreHandler.instance == null) {
			GestisciFornitoreHandler.instance = new GestisciFornitoreHandler();
		}

		return GestisciFornitoreHandler.instance;
	}

	/**
	 * Fornisce i fornitori dell'azienda
	 * @return arrayFornitori:ArrayList<CatalogoFornitore>
	 */
	public ArrayList<CatalogoFornitore> getArrayFornitori() {
		return arrayFornitori;
	}
	
	/**
	 * Fornisce un catalogo da un nome
	 * @param nome:String
	 * @return catalogo:CatalogoFornitore
	 */
	public CatalogoFornitore getFornitoreByName(String nome){
		try {
			return CatalogoFornitoreFactory.loadCatalogoFornitoreByQuery(" Name = " + "'" + nome + "'", null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Fornisce la descrizione di un prodotto
	 * 
	 * @param essenza:String
	 * @param geometria:Geometria
	 * @param fornitore:String
	 * @return pd:ProductDescription
	 */
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
	
	public void setBuilder(CatalogoFornitoreBuilder builder){
		this.builder = builder;
	}
	
	public CatalogoFornitore getCatalogo(){
		return this.builder.getCatalogo();
	}
	
	public void ConstructCataologo(){
		this.builder.createNewCatalogo();
		this.builder.Parse(null);
	}
	
	
}
