package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import coedil99.model.MDipendente;
import coedil99.persistentmodel.Dipendente;
import coedil99.persistentmodel.DipendenteFactory;

public class GestisciDipendenteHandler {
	
	private ArrayList<MDipendente> dipendenti = null;
	private static GestisciDipendenteHandler instance;
	
	private static boolean logged = false;
	private static int level = 0;
	
    public static boolean authenticate(String username, String password) {

    	Dipendente d = GestisciDipendenteHandler.getInstance().checkPass(username,password);
        if (d != null) {
        	logged = true;
        	level = d.getLevel();
            return true;
        }
        return false;
    }
    
    public static boolean getLogged() {
    	return logged;
    }
    
    public static int getLevel() {
    	return level;
    }

	public static void logOut() {
		// TODO Auto-generated method stub
		logged = false;
	}
	/**
	 * Costruttore
	 * 
	 * Carica la lista dei dipendenti
	 */
	private GestisciDipendenteHandler() {
		this.dipendenti = new ArrayList<MDipendente>();
		try {
			ArrayList<Dipendente> persistent_dipendenti = new ArrayList<Dipendente>(Arrays.asList(DipendenteFactory.listDipendenteByQuery(null, "ID")));
			for(Dipendente d: persistent_dipendenti){
				this.dipendenti.add(new MDipendente(d.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fornisce i clienti
	 * @return clienti:ArrayList<Cliente>
	 */
	public ArrayList<MDipendente> getDipendenti(){
		return this.dipendenti;
	}
	
	/**
	 * 
	 * @param id
	 * @return MDipendente
	 */
	public MDipendente getDipendenteById(int id){
		return new MDipendente(id);
	}
	
	/**
	 * Singleton
	 * @return instance:GestisciDipendenteHandler
	 */
	public static GestisciDipendenteHandler getInstance() {
		if (GestisciDipendenteHandler.instance == null) {
			GestisciDipendenteHandler.instance = new GestisciDipendenteHandler();
		}

		return GestisciDipendenteHandler.instance;
	}

	@SuppressWarnings("unchecked")
	public Dipendente checkPass(String username, String password){
		
		List<Dipendente> dip = null;
		try {
			Criteria crit = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().createCriteria(Dipendente.class);
			crit.add( Restrictions.and(Restrictions.eq("usr", username), Restrictions.like("pwd", password)) );
			dip = crit.list();
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().close();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dip.size()>0)
			return dip.get(0);
		else
			return null;
	}
}