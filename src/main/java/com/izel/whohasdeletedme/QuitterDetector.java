package com.izel.whohasdeletedme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class QuitterDetector {

	private HashMap<String, List<String>> map;
	private InstagramDataExtractor instagramDataExtractor;
	private ArrayList<String> newFollowerList;

	public QuitterDetector() {
		this.map = UserAndHisFollowers.getMap();
		instagramDataExtractor = new InstagramDataExtractor();
		newFollowerList = new ArrayList<String>();
	}

	public HashMap<String, ArrayList<String>> findQuittersOfAllUsers() {
		HashMap<String, ArrayList<String>> usersAndTheirQuitters = new HashMap<String, ArrayList<String>>();
		ArrayList<String> singleUserQuitters = new ArrayList<String>();
		for (Entry<String, List<String>> entry : map.entrySet()) {
			singleUserQuitters = findQuittersForAUser(entry.getKey());
			if (singleUserQuitters.size() != 0) {
				usersAndTheirQuitters.put(instagramDataExtractor
						.getUserNameFromUserId(entry.getKey()),
						singleUserQuitters);
			}

		}
		System.out.println(usersAndTheirQuitters);
		return usersAndTheirQuitters;

	}

	public ArrayList<String> findQuittersForAUser(String userID) {
		newFollowerList = instagramDataExtractor.getFollowers(userID);
		List<String> pastFollowerList = map.get(userID);
		ArrayList<String> deletions = new ArrayList<String>();
		for (String followerUserID : pastFollowerList) {
			if (!newFollowerList.contains(followerUserID)) {
				deletions.add(followerUserID);
			}
		}
		map.put(userID, newFollowerList);
		System.out.println(deletions);
		return convertToUserName(deletions);

	}

	public ArrayList<String> convertToUserName(ArrayList<String> followerlist) {
		String userid;
		String username;
		for (int i = 0; i < followerlist.size(); i++) {
			userid = followerlist.get(i);
			username = instagramDataExtractor.getUserNameFromUserId(userid);
			followerlist.set(i, username);
		}
		return followerlist;
	}

}
