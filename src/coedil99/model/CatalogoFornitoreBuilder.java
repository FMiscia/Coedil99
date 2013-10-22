package coedil99.model;

import java.io.File;
import java.io.IOException;

import coedil99.controller.GestisciFornitoreHandler;

/**
 * Pattern Builder: un catalogo può essere caricato da vari
 * formati di testo (cvs, excel, ecc...)
 * 
 * @author francesco
 *
 */
public abstract class CatalogoFornitoreBuilder {

	protected CatalogoFornitore catalogo;
	/**
	 * Questo metodo e' resposabile del parsing del file
	 * 
	 * @param catalogo: File
	 * @throws IOException 
	 */
	public abstract void Parse(String filePath) throws IOException;
	
	
	/**
	 * Get
	 * 
	 * @return catalogo fornitore
	 */
	public CatalogoFornitore getCatalogo(){
		return catalogo;
	}

	/**
	 * Metodo che crea un nuovo catalogo fornitore
	 */
    public void createNewCatalogo()
    { 
    	this.catalogo = GestisciFornitoreHandler.getInstance().creaCatalogoFornitore();
    }

}