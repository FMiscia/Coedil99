package coedil99.model;

/**
 * Pattern Builder: un catalogo puÃ² essere caricato da vari
 * formati di testo (cvs, excel, ecc...)
 * 
 * @author francesco
 */
public abstract class CatalogoFornitoreBuilder {

	protected MCatalogoFornitore catalogo;

	public MCatalogoFornitore getCatalogo() {
		return this.catalogo;
	}

	/**
	 * Questo metodo e' resposabile del parsing del file.
	 * @param filePath
	 */
	public abstract void Parse(String filePath) throws java.io.IOException;

	/**
	 * Metodo che crea un nuovo catalogo fornitore
	 * @return 
	 */
	public void createNewCatalogo() {
		throw new UnsupportedOperationException();
	}

}