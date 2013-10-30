package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentModel.Cliente;
import coedil99.persistentModel.ClienteFactory;
import coedil99.persistentModel.IPersistentModel;

public class MCliente implements IModel {
	
	private Cliente cliente;
	/**
	 * Costruttore senza parametri
	 *
	 */
	public MCliente(){
		this.cliente = ClienteFactory.createCliente();
	}
	
	/**
	 * Costruttore con parametro
	 * @param ID
	 */
	public MCliente(int ID){
		try {
			this.cliente = ClienteFactory.getClienteByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.cliente = (Cliente) m;
	}
	
	public Cliente getPersistentModel(){
		return this.cliente;
	}

	@Override
	public void save() {
		try {
			this.cliente.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(){
		this.cliente.deleteAndDissociate();
	}
	
}
