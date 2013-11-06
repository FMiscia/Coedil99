package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.MCantiere;
import coedil99.model.MCliente;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.ClienteFactory;

/**
 * @author francesco
 *
 */
public class GestisciClienteHandler {
	
	private ArrayList<MCliente> clienti = null;
	private static GestisciClienteHandler instance;
	
	
	/**
	 * Costruttore
	 * 
	 * Carica la lista dei clienti
	 */
	private GestisciClienteHandler() {
		this.clienti = new ArrayList<MCliente>();
		try {
			ArrayList<Cliente> persistent_clienti = new ArrayList<Cliente>(Arrays.asList(ClienteFactory.listClienteByQuery(null, "ID")));
			for(Cliente c: persistent_clienti){
				this.clienti.add(new MCliente(c.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Aggiunge un Ordine effettuato da un cliente
	 * @param c:Cliente
	 */
	public void addOrdine(MCliente c) {
		this.clienti.add(c);
	}

	/**
	 * Fornisce i clienti
	 * @return clienti:ArrayList<Cliente>
	 */
	public ArrayList<MCliente> getClienti(){
		return this.clienti;
	}
	
	/**
	 * 
	 * @param id
	 * @return clienteID:int
	 */
	public MCliente getClienteById(int id){
		return new MCliente(id);
	}
	
	/**
	 * Fornisce un cliente dal nome
	 */
	public MCliente getClienteByName(String name){
		MCliente result = null;
		for(MCliente temp : this.clienti)
			if(temp.getPersistentModel().getName().equals(name)){
				result = temp;
				break;
			}
		return result;
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

