package repositories.utilities;

import java.util.Properties;

import models.User;

public abstract class DataAccessObject {
	
	public abstract Boolean addNew(Properties props);
	public abstract Boolean update(Properties props);
	public abstract Boolean delete(Properties props);
		
}
