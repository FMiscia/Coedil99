package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.*;

public interface IModel {

	void setPersistentModel(IPersistentModel m);
	
	void save();

	void delete();
}
