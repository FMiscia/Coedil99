package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.persistentModel.Cliente;
import coedil99.persistentModel.ClienteFactory;

/**
 * @author francesco
 *
 */
public class GestisciClienteHandler {
	
	private ArrayList<Cliente> clienti = null;
	private static GestisciClienteHandler instance;
	
	
	/**
	 * Costruttore
	 * 
	 * Carica la lista dei clienti
	 */
	private GestisciClienteHandler() {
		try {
			this.clienti = new ArrayList<Cliente>(Arrays.asList(ClienteFactory.listClienteByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Aggiunge un Ordine effettuato da un cliente
	 * @param c:Cliente
	 */
	public void addOrdine(Cliente c) {
		this.clienti.add(c);
	}

	/**
	 * Fornisce i clienti
	 * @return clienti:ArrayList<Cliente>
	 */
	public ArrayList<Cliente> getClienti(){
		return this.clienti;
	}
	
	/**
	 * 
	 * @param id
	 * @return clienteID:int
	 */
	public Cliente getClienteById(int id){
		try {
			return ClienteFactory.getClienteByORMID(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Singleton
	 * @return instance:GestisciClienteHandler
	 */
	public static GestisciClienteHandler getInstance() {
		if (GestisciClienteHandler.instance == null) {
			GestisciClienteHandler.instance = new GestisciClienteHandler();
		}

		return GestisciClienteHandler.instance;
	}

}

