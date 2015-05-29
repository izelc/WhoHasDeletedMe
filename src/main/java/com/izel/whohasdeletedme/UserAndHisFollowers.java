package com.izel.whohasdeletedme;

import java.util.HashMap;
import java.util.List;

public class UserAndHisFollowers {

	private static HashMap<String, List<String>> map = new HashMap<String, List<String>>();


	public static HashMap<String, List<String>> getMap() {
		return map;
	}

	public static void addNewUser(String userName) {
		
		InstagramDataExtractor instagramDataExtractor = new InstagramDataExtractor();
		String userId=instagramDataExtractor.getUserId(userName);
		map.put(userId, instagramDataExtractor.getFollowers(userId));
	}

}
