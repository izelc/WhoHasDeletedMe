package com.izel.whohasdeletedme;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class InstagramDataExtractor {

    private String accesstoken="2035726963.1677ed0.61fcec45960647f2909c294fa1bab62e";
	private InstagramPageExtractor instagramPageExtractor;

	public InstagramDataExtractor() {
         instagramPageExtractor = new InstagramPageExtractor();
	}

	/**
	 * @param uri
	 * @return JSON of page that uri points.
	 */
	private JsonObject getPageWithUserId(String userId) {

		String pageLink = "https://api.instagram.com/v1/users/"
				+ userId
				+ "/followed-by?access_token="+accesstoken;
		return instagramPageExtractor.getPage(pageLink);
	}

	public ArrayList<String> getFollowers(String userId) {

		JsonObject page = getPageWithUserId(userId);
		JsonObject pagination = page.get("pagination").getAsJsonObject();
		JsonArray friends = page.get("data").getAsJsonArray();
		String nextUrl;

		while (!pagination.toString().equals("{}")) {
			nextUrl = pagination.get("next_url").getAsString();
			page = instagramPageExtractor.getPage(nextUrl);
			friends.addAll(page.get("data").getAsJsonArray());
			pagination = page.get("pagination").getAsJsonObject();
		}
		return convertToArrayList(friends);
	}

	public ArrayList<String> convertToArrayList(JsonArray jArray) {
		ArrayList<String> listdata = new ArrayList<String>();
		if (jArray != null) {
			for (int i = 0; i < jArray.size(); i++) {
				listdata.add(jArray.get(i).getAsJsonObject().get("id").getAsString());
			}
		}
		return listdata;
	}
	
	public String getUserNameFromUserId(String userid) {
		JsonObject page = instagramPageExtractor.getPage("https://api.instagram.com/v1/users/"+userid+"/?access_token="+accesstoken);
	     String username= page.get("data").getAsJsonObject().get("username").getAsString();
	     return username;
	}
	
	public String getUserId(String userName) {

		String userId = null;

		try {
			JsonObject page = instagramPageExtractor
					.getPage("https://api.instagram.com/v1/users/search?q="
							+ userName
							+ "&access_token="+accesstoken);

			JsonElement data = page.get("data");
			if (data.toString().equals("[]")) {
				throw new UserNameDoesntFoundException();
			}

			userId = data.getAsJsonArray().get(0).getAsJsonObject().get("id")
					.getAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
}
