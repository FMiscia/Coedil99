package coedil99.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;

import coedil99.model.MGeometria;
import coedil99.persistentModel.CatalogoFornitore;
import coedil99.persistentModel.CatalogoFornitoreBuilder;
import coedil99.persistentModel.CatalogoFornitoreFactory;
import coedil99.persistentModel.ProductDescription;

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
		@SuppressWarnings("rawtypes")
		List l = cf.productDescription.getCollection();
		ProductDescription pd = null;
		for ( int i=0 ; i<l.size() ; i++  ){
			pd = (ProductDescription) l.get(i);
			if( pd.getEssenza().toString().equalsIgnoreCase(essenza)  && new MGeometria(pd.getGeometria()).toString().equalsIgnoreCase(geometria)){
				return pd;
			}
		}
		return null;
	}
	
	/**
	 * Set
	 * 
	 * @param builder
	 */
	public void setBuilder(CatalogoFornitoreBuilder builder){
		this.builder = builder;
	}
	
	/**
	 * Get
	 * @return catalogo fornitore
	 */
	public CatalogoFornitore getCatalogo(){
		return this.builder.getCatalogo();
	}
	
	/**
	 * Metodo che costruisce il catalogo fornitore a partire dal path del file in ingresso
	 * 
	 * @param filePath
	 */
	public void ConstructCatalogo(String filePath){
		this.builder.createNewCatalogo();
		try {
			this.builder.Parse(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo che crea uno nuovo catalogo fornitore tramite la sua factory
	 *  
	 * @return catalogo fornitore
	 */
	public CatalogoFornitore creaCatalogoFornitore(){
		CatalogoFornitore new_catalogo = CatalogoFornitoreFactory.createCatalogoFornitore();
		try {
			new_catalogo.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		return new_catalogo;
	}
	
	/**
	 * Metodo che controlla se il controllore e' stato precedentemente instanziato
	 * 
	 * @return boolean
	 */
	public static boolean isInstanciated(){
		return GestisciFornitoreHandler.instance == null;
	}
	
	/**
	 * Metodo che ricarica l'array dei fornitori. Questo e' reso necessario quando mi varia il numero di fornitori a run time
	 * 
	 */
	public void reloadFornitori(){
		try {
			this.arrayFornitori = new ArrayList<CatalogoFornitore>(Arrays.asList(CatalogoFornitoreFactory.listCatalogoFornitoreByQuery(null, "ID")));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
