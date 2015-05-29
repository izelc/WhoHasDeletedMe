package com.izel.whohasdeletedme.main;

import java.util.HashMap;

public class Advertisement {

	static Advertisement advertisement = new Advertisement();
	private static HashMap<String, Integer> advertisementList;

	private Advertisement() {
		advertisementList = new HashMap<String, Integer>();
		getAdvertisementList().put("eti", 0);
		getAdvertisementList().put("penti", 0);
		getAdvertisementList().put("ulker", 0);
		getAdvertisementList().put("dardanel", 0);
		getAdvertisementList().put("sozcu", 0);
	}

	public static void clickOn(String advertise) {
		Integer integer;

		integer = Advertisement.getAdvertisementList().get(advertise);
		integer = integer + 1;
		getAdvertisementList().put(advertise, integer);

	}

	public static void addAdvertise(String advertise) {

		Advertisement.getAdvertisementList().put(advertise, 0);
	}

	public static Integer getClickCount(String advertise) {
		Integer integer = null;
		integer = Advertisement.getAdvertisementList().get(advertise);
		return integer;
	}

	public static HashMap<String, Integer> getAdvertisementList() {
		return advertisementList;
	}

	public static void setAdvertisementList(
			HashMap<String, Integer> advertisementList) {
		Advertisement.advertisementList = advertisementList;
	}

}
