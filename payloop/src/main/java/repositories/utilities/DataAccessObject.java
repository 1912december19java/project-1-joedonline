package repositories.utilities;

import java.util.Properties;

import models.User;

public abstract class DataAccessObject {
	
	public abstract void addNew(Properties props);
	public abstract void update();
	public abstract void delete();
		
}
