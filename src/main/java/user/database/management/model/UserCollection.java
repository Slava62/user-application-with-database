package user.database.management.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserCollection {
	private List<User> userCollection;

	public UserCollection() {
		super();
		this.userCollection = new ArrayList<User>();
	}

	public List<User> getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(List<User> userCollection) {
		this.userCollection = userCollection;
	}
	
	

}
