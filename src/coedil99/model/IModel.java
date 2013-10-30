package coedil99.model;

import coedil99.persistentModel.*;

public interface IModel {

	IPersistentModel getPersistentModel();
	
	void setPersistentModel(IPersistentModel m);
	
	void save();
}