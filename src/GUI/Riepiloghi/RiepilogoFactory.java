package GUI.Riepiloghi;

import GUI.Abstract.ARiepilogo;
import GUI.Liste.ListaFornitori;
import GUI.Liste.ListaProdotti;

/**
 * Factory per i Riepiloghi
 * 
 * @author Simone
 *
 */
public abstract class RiepilogoFactory {

	/**
	 * Metodo che crea un riepilogo
	 * @return ARiepilogo
	 */
	public abstract ARiepilogo makeRiepilogo();
	
	/**
	 * Metodo che crea un riepilogo, usato principalmente per l'RDA
	 * @param tipo: stringa che indica il tipo di RDA (congelata, In Attesa..)
	 * @return Ariepilogo
	 */
	public abstract ARiepilogo makeRiepilogo(String tipo);

}
