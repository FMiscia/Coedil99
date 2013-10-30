package coedil99.operation;

import coedil99.model.*;

public interface IOperation {

	IModelComponent model = null;
	
	IModelComponent getModel();
	
	void setModel(IModelComponent m);
}