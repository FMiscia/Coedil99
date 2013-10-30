package coedil99.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;

import coedil99.model.MCatalogoFornitore;
import coedil99.model.MGeometria;
import coedil99.persistentModel.CatalogoFornitore;
import coedil99.persistentModel.CatalogoFornitoreBuilder;
import coedil99.persistentModel.CatalogoFornitoreFactory;
import coedil99.persistentModel.ProductDescription;

public class GestisciFornitoreHandler {

	private ArrayList<MCatalogoFornitore> cataloghi = null;
	private CatalogoFornitoreBuilder builder;
	private static GestisciFornitoreHandler instance;
	
	/**
	 * Costruttore
	 */
	private GestisciFornitoreHandler() {
		this.cataloghi = new ArrayList<MCatalogoFornitore>();
		try {
			ArrayList<CatalogoFornitore> persistent_cataloghi = new ArrayList<CatalogoFornitore>(Arrays.asList(CatalogoFornitoreFactory.listCatalogoFornitoreByQuery(null, "ID")));
			for(CatalogoFornitore c: persistent_cataloghi){
				this.cataloghi.add(new MCatalogoFornitore(c.getID()));
			}
		} catch (PersistentException e) {
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
	public ArrayList<MCatalogoFornitore> getArrayFornitori() {
		return cataloghi;
	}
	
	/**
	 * Fornisce un catalogo da un nome
	 * @param nome:String
	 * @return catalogo:CatalogoFornitore
	 */
	public MCatalogoFornitore getFornitoreByName(String nome){
		this.cataloghi = new ArrayList<MCatalogoFornitore>();
		try {
			ArrayList<CatalogoFornitore> persistent_cataloghi = new ArrayList<CatalogoFornitore>(Arrays.asList(CatalogoFornitoreFactory.loadCatalogoFornitoreByQuery(" Name = " + "'" + nome + "'", null)));
			for(CatalogoFornitore c: persistent_cataloghi){
				this.cataloghi.add(new MCatalogoFornitore(c.getID()));
			}
		} catch (PersistentException e) {
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
		MCatalogoFornitore cf = GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore);
		@SuppressWarnings("rawtypes")
		List l = cf.getPersistentModel().productDescription.getCollection();
		ProductDescription pd = null;
		for ( int i=0 ; i<l.size() ; i++  ){
			pd = (ProductDescription) l.get(i);
			if( pd.getEssenza().toString().equalsIgnoreCase(essenza)  && new MGeometria(pd.getGeometria().getID()).toString().equalsIgnoreCase(geometria)){
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
	public MCatalogoFornitore getCatalogo(){
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
		this.cataloghi = new ArrayList<MCatalogoFornitore>();
		try {
			ArrayList<CatalogoFornitore> persistent_cataloghi = new ArrayList<CatalogoFornitore>(Arrays.asList(CatalogoFornitoreFactory.listCatalogoFornitoreByQuery(null, "ID")));
			for(CatalogoFornitore c: persistent_cataloghi){
				this.cataloghi.add(new MCatalogoFornitore(c.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
