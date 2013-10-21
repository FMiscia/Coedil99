package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;
import GUI.Liste.ListaCommesse;

/**
 * 
 * @author francesco
 *
 * Implementazione di una Factory di Abstract Factory
 */
public class CardCodiceInternoFactory extends CardFactory {

	private static CardCodiceInternoFactory instance = null;

	private CardCodiceInternoFactory() {
	};

	@Override
	public ACard makeCard(ALista lista) {
		return new CardCodiceInterno((ListaCommesse) lista);
	}

	public static CardCodiceInternoFactory getInstance() {
		if (instance == null)
			instance = new CardCodiceInternoFactory();
		return instance;
	}

}
