package coedil99.model;

import java.io.File;
import java.io.IOException;

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
	 * Questo metodo sarà il resposabile del parsing del file
	 * 
	 * @param catalogo: File
	 * @return 
	 * @throws IOException 
	 */
	public abstract void Parse(String filePath) throws IOException;
	
	public CatalogoFornitore getCatalogo(){
		return catalogo;
	}

    public void createNewCatalogo()
    { 
        this.catalogo = new CatalogoFornitore(); 
    }

}