package com.izel.whohasdeletedme;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class InstagramPageExtractor {
	private HttpClient client;

	public InstagramPageExtractor() {
		client = new HttpClient(new SslContextFactory(true));
		try {
			client.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JsonObject getPage(String uri) throws JsonSyntaxException {
		String result = null;
		try {
			result = client.newRequest(uri).send().getContentAsString();
		} catch (InterruptedException | TimeoutException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Gson().fromJson(result, JsonObject.class);
	}
}
