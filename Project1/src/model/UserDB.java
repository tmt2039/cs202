package model;

import dataStructure.LinkedList;
public class UserDB {

		 // Create a user for strings
		 LinkedList<User> user = new LinkedList<>();
		
		 public LinkedList<User> getUserDB() {
				return user;
			}

			public void setUser(LinkedList<User> user) {
				this.user = user;
			}
 
		 } 

