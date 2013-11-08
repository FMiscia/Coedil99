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
package coedil99.persistentmodel;

import org.orm.*;
public class Dipendente implements coedil99.persistentmodel.IPersistentModel {
	public Dipendente() {
	}
	
	public boolean save() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private int ID;
	
	private String usr;
	
	private String pwd;
	
	private int level;
	
	private int rdacongelate_visualizzate;
	
	private int rdaattesa_visualizzate;
	
	private int rdarifiutate_visualizzate;
	
	private String name;
	
	private String familyname;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setUsr(String value) {
		this.usr = value;
	}
	
	public String getUsr() {
		return usr;
	}
	
	public void setPwd(String value) {
		this.pwd = value;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setLevel(int value) {
		this.level = value;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setRdacongelate_visualizzate(int value) {
		this.rdacongelate_visualizzate = value;
	}
	
	public int getRdacongelate_visualizzate() {
		return rdacongelate_visualizzate;
	}
	
	public void setRdaattesa_visualizzate(int value) {
		this.rdaattesa_visualizzate = value;
	}
	
	public int getRdaattesa_visualizzate() {
		return rdaattesa_visualizzate;
	}
	
	public void setRdarifiutate_visualizzate(int value) {
		this.rdarifiutate_visualizzate = value;
	}
	
	public int getRdarifiutate_visualizzate() {
		return rdarifiutate_visualizzate;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setFamilyname(String value) {
		this.familyname = value;
	}
	
	public String getFamilyname() {
		return familyname;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
