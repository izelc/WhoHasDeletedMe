package com.izel.whohasdeletedme;

import static org.junit.Assert.*;

import org.junit.Test;

import com.izel.whohasdeletedme.main.Advertisement;

public class AdvertisementTest {

	@Test
	public void allTest() throws Exception {
		Advertisement.addAdvertise("kutulin");
		Advertisement.clickOn("kutulin");
		assertEquals(Advertisement.getClickCount("kutulin").toString(), "1");

	}

}
