package coedil99.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import org.orm.PersistentException;

import GUI.Utilities.CataloghiFilter;

import coedil99.model.CatalogoCSVBuilder;
import coedil99.model.CatalogoXMLBuilder;
import coedil99.model.MCatalogoFornitore;
import coedil99.model.MGeometria;
import coedil99.model.MProductDescription;
import coedil99.model.MCatalogoFornitore;
import coedil99.persistentmodel.CatalogoFornitore;
import coedil99.model.CatalogoFornitoreBuilder;
import coedil99.persistentmodel.CatalogoFornitoreFactory;
import coedil99.persistentmodel.ProductDescription;

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
			ArrayList<CatalogoFornitore> persistent_cataloghi = new ArrayList<CatalogoFornitore>(
					Arrays.asList(CatalogoFornitoreFactory
							.listCatalogoFornitoreByQuery(null, "ID")));
			for (CatalogoFornitore c : persistent_cataloghi) {
				this.cataloghi.add(new MCatalogoFornitore(c.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Singleton
	 * 
	 * @return instance:GestisciFornitoreHandler
	 */
	public static GestisciFornitoreHandler getInstance() {
		if (GestisciFornitoreHandler.instance == null) {
			GestisciFornitoreHandler.instance = new GestisciFornitoreHandler();
		}
		return GestisciFornitoreHandler.instance;
	}

	public static HashMap<String, CatalogoFornitoreBuilder> cataloghiBuilders;
	{
		cataloghiBuilders = new HashMap<String, CatalogoFornitoreBuilder>();
		cataloghiBuilders.put(CataloghiFilter.csv, new CatalogoCSVBuilder());
		cataloghiBuilders.put(CataloghiFilter.xml, new CatalogoXMLBuilder());
	}

	/**
	 * Fornisce i fornitori dell'azienda
	 * 
	 * @return arrayFornitori:ArrayList<CatalogoFornitore>
	 */
	public ArrayList<MCatalogoFornitore> getArrayFornitori() {
		return cataloghi;
	}

	/**
	 * Fornisce un catalogo da un nome
	 * 
	 * @param nome
	 *            :String
	 * @return catalogo:CatalogoFornitore
	 */
	public MCatalogoFornitore getFornitoreByName(String nome) {
		try {
			if(CatalogoFornitoreFactory.loadCatalogoFornitoreByQuery(" Name = " + "'" + nome + "'", null) != null)
				return new MCatalogoFornitore(CatalogoFornitoreFactory
					.loadCatalogoFornitoreByQuery(
							" Name = " + "'" + nome + "'", null).getID());
			else
				return null;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;

	}

	public MCatalogoFornitore getFornitoreByID(int ID) {
		return new MCatalogoFornitore(ID);
	}

	/**
	 * Fornisce la descrizione di un prodotto
	 * 
	 * @param essenza
	 *            :String
	 * @param geometria
	 *            :Geometria
	 * @param fornitore
	 *            :String
	 * @return pd:ProductDescription
	 */
	public MProductDescription getMProductDescription(String essenza,
			String geometria, String fornitore) {
		MCatalogoFornitore cf = GestisciFornitoreHandler.getInstance()
				.getFornitoreByName(fornitore);
		@SuppressWarnings("rawtypes")
		List l = cf.getPersistentModel().productDescription.getCollection();
		MProductDescription mpd = null;
		for (int i = 0; i < l.size(); i++) {
			mpd = new MProductDescription(
					((ProductDescription) l.get(i)).getID());
			if (mpd.getPersistentModel().getEssenza().toString()
					.equalsIgnoreCase(essenza)
					&& new MGeometria(mpd.getPersistentModel().getGeometria()
							.getID()).toString().equalsIgnoreCase(geometria)) {
				return mpd;
			}
		}
		return null;
	}
	
	public ArrayList<MProductDescription> getMProductDescriptions(String fornitore){
		ArrayList<MProductDescription> prodotti = new ArrayList<MProductDescription>();
		MCatalogoFornitore cf = GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore);
		List l = cf.getPersistentModel().productDescription.getCollection();
		MProductDescription mpd = null;
		for ( int i=0 ; i<l.size() ; i++  ){
			mpd = new MProductDescription(((ProductDescription)l.get(i)).getID());
			prodotti.add(mpd);
		}
		return prodotti;
	}

	/**
	 * Set
	 * 
	 * @param builder
	 */
	public void setBuilder(CatalogoFornitoreBuilder builder) {
		this.builder = builder;
	}

	/**
	 * Get
	 * 
	 * @return catalogo fornitore
	 */
	public MCatalogoFornitore getCatalogo() {
		return this.builder.getCatalogo();
	}

	/**
	 * Metodo che costruisce il catalogo fornitore a partire dal path del file
	 * in ingresso
	 * 
	 * @param filePath
	 */
	public boolean ConstructCatalogo(String filePath) {
		this.builder.createNewCatalogo();
		try {
			this.builder.Parse(filePath);
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore nella lettura del catalogo fornitore! \nSe il problema persiste contatta il servizio clienti Coedil \nal numero 899-166892");
			return false;
		}
	}

	/**
	 * Metodo che controlla se il controllore e' stato precedentemente
	 * instanziato
	 * 
	 * @return boolean
	 */
	public static boolean isInstanciated() {
		return GestisciFornitoreHandler.instance == null;
	}

	/**
	 * Metodo che ricarica l'array dei fornitori. Questo e' reso necessario
	 * quando mi varia il numero di fornitori a run time
	 * 
	 */
	public void reloadFornitori() {
		this.cataloghi = new ArrayList<MCatalogoFornitore>();
		try {
			ArrayList<CatalogoFornitore> persistent_cataloghi = new ArrayList<CatalogoFornitore>(
					Arrays.asList(CatalogoFornitoreFactory
							.listCatalogoFornitoreByQuery(null, "ID")));
			for (CatalogoFornitore c : persistent_cataloghi) {
				this.cataloghi.add(new MCatalogoFornitore(c.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public MCatalogoFornitore creaCatalogoFornitore() {
		this.builder.createNewCatalogo();
		return this.builder.getCatalogo();
	}
	
	public TreeSet<String> getEssenze(MCatalogoFornitore fornitore){
		TreeSet<String> essenze = new TreeSet<String>();
		for (int i = 0; i < fornitore.getPersistentModel().productDescription.size(); ++i) {
			essenze.add(fornitore.getPersistentModel().productDescription.get(i).getEssenza());
		}
		
		return essenze;
	}
	
	public ArrayList<ProductDescription> getProductDescription(MCatalogoFornitore fornitore) {
		@SuppressWarnings("unchecked")
		ArrayList<ProductDescription> pd = new ArrayList<ProductDescription>(
				fornitore.getPersistentModel().productDescription
						.getCollection());
		
		return pd;
	}
	
	public void saveCatalogoFornitore(MCatalogoFornitore mcf){
		mcf.save();
	}

}
