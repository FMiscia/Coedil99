package coedil99.model;

import coedil99.persistentModel.*;

public interface IModel {

	void setPersistentModel(IPersistentModel m);
	
	void save();
	
	void delete();
}