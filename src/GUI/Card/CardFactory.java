package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;

/**
 * 
 * @author francesco
 *
 * Abstract Factory
 */
public abstract class CardFactory {

	public abstract ACard makeCard(ALista lista);
	
}
