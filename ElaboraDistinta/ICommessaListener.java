package ElaboraDistinta;

public interface ICommessaListener {

	/**
	 * 
	 * @param commessa
	 * @param value
	 * @return 
	 */
	abstract void onPropertyEvent(Commessa commessa, String value);

}