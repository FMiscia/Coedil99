package coedil99.model;

import java.io.IOException;

/**
 * Pattern Builder: un catalogo può essere caricato da vari
 * formati di testo (cvs, excel, ecc...)
 * 
 * @author francesco
 *
 */
public abstract class CatalogoFornitoreBuilder {

	protected MCatalogoFornitore catalogo;
	/**
	 * Questo metodo e' resposabile del parsing del file.
	 * 
	 * @param catalogo: nome del file da parsare. Deve essere caricato nella cartella relativa [TestFile].
	 * @throws IOException 
	 */
	public abstract void Parse(String filePath) throws IOException;
	
	
	/**
	 * Get
	 * 
	 * @return catalogo fornitore
	 */
	public MCatalogoFornitore getCatalogo(){
		return catalogo;
	}

	/**
	 * Metodo che crea un nuovo catalogo fornitore
	 */
    public void createNewCatalogo()
    { 
    	this.catalogo = new MCatalogoFornitore();
    }

}