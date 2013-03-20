/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package elaboradistinta.model;

import org.orm.*;

public class CommessaListCollection extends org.orm.util.ORMList {
	public CommessaListCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public CommessaListCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persisten objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMList
	 * @param value the persistent object
	 */
	public void add(Commessa value) {
		if (value != null) {
			super.add(value, null);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMList
	 * @param value the persistent object
	 */
	public void remove(Commessa value) {
		super.remove(value, null);
	}
	
	/**
	 * Return true if ORMList contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Commessa value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMList
	 * @return The persistent objects array
	 */
	public Commessa[] toArray() {
		return (Commessa[]) super.toArray(new Commessa[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMList
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>ID</li>
	 * <li>codiceInterno</li>
	 * <li>elementoStrutturale</li>
	 * <li>scadenzaCommessa</li>
	 * <li>emissioneCommessa</li>
	 * <li>fineCommessa</li>
	 * <li>inizioProduzione</li>
	 * <li>scadenzaProduzione</li>
	 * <li>fineProduzione</li>
	 * <li>ritardoProduzione</li>
	 * <li>primaConsegna</li>
	 * <li>ritardoConsegna</li>
	 * <li>orario</li>
	 * <li>descrizione</li>
	 * <li>responsabile</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Commessa[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMList
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>ID</li>
	 * <li>codiceInterno</li>
	 * <li>elementoStrutturale</li>
	 * <li>scadenzaCommessa</li>
	 * <li>emissioneCommessa</li>
	 * <li>fineCommessa</li>
	 * <li>inizioProduzione</li>
	 * <li>scadenzaProduzione</li>
	 * <li>fineProduzione</li>
	 * <li>ritardoProduzione</li>
	 * <li>primaConsegna</li>
	 * <li>ritardoConsegna</li>
	 * <li>orario</li>
	 * <li>descrizione</li>
	 * <li>responsabile</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Commessa[] toArray(String propertyName, boolean ascending) {
		return (Commessa[]) super.toArray(new Commessa[size()], propertyName, ascending);
	}
	
	/**
	 * Return the persistent object at the specified position in ORMList.
	 * @param index - The specified position
	 * @return - The persistent object
	 */
	public Commessa get(int index) {
		return (Commessa) super.getImpl(index);
	}
	
	/**
	 * Remove the persistent object at the specified position in ORMList.
	 * @param index The specified position
	 * @return Removed persistent object
	 */
	public Commessa remove(int index) {
		Commessa value = get(index);
		if (value != null) {
			return (Commessa) super.removeImpl(index, null);
		}
		return null;
	}
	
	/**
	 * Insert the specified persistent object at the specified position in ORMList.
	 * @param index The specified position
	 * @param value The specified persistent object
	 */
	public void add(int index, Commessa value) {
		if (value != null) {
			super.add(index, value, null);
		}
	}
	
	/**
	 * Find the specified position of specified persistent object ORMList.
	 * @param value The persistent object
	 */
	public int indexOf(Commessa value) {
		return super.indexOf(value);
	}
	
	/**
	 * Replace the persistent object at the specified position in ORMList with the specified persistent object.
	 * @param index The specified position
	 * @param value The persistent object
	 * @return Return replaced object
	 */
	public Commessa set(int index, Commessa value) {
		return (Commessa) super.set(index, value);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return elaboradistinta.model.CoedilPersistentManager.instance();
	}
	
}

