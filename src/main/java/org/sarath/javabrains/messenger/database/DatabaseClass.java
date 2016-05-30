package org.sarath.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.sarath.javabrains.messenger.model.Message;
import org.sarath.javabrains.messenger.model.Profile;

public class DatabaseClass {
	/* Here we should connect to a database. But in this case we just created a 
	 * profiles and messages HashMap	
	 * */ 
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
