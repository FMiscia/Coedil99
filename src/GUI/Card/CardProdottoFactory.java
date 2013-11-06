package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;

/**
 * Factory per le card prodotto
 * 
 * @author Simone
 *
 */
public class CardProdottoFactory extends CardFactory {

	private static CardProdottoFactory instance = null;

	private CardProdottoFactory() {
	};

	/**
	 * Singleton
	 * 
	 * @return
	 */
	public static CardProdottoFactory getInstance() {
		if (instance == null)
			instance = new CardProdottoFactory();
		return instance;
	}
	@Override
	public ACard makeCard(ALista lista) {
		return new CardProdotto(lista);
	}

}

