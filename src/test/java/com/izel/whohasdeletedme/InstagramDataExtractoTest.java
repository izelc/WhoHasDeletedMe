package com.izel.whohasdeletedme;

import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.JsonArray;

public class InstagramDataExtractoTest {

	@Test
	public void testName() throws Exception {
		InstagramDataExtractor instagramDataExtractor = new InstagramDataExtractor();
		ArrayList<String> friends = instagramDataExtractor
				.getFollowers("239984780");
		System.out.println(friends);
		System.err.println(instagramDataExtractor.getUserNameFromUserId("239984780"));
		System.err.println(instagramDataExtractor.getUserNameFromUserId("626252091"));
	}

}
