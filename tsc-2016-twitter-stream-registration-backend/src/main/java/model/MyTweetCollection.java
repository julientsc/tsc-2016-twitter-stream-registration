package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import twitter4j.Status;
import model.tweet.MyTweet;

public class MyTweetCollection {

	private HashMap<Long, MyTweet> myTweets = new HashMap<Long, MyTweet>();
	private HashMap<String, List<Long>> hashtags = new HashMap<String, List<Long>>();

	public void addTweet(String hashtag, Status tweet) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String rawContent = gson.toJson(tweet);
		new File("raw").mkdirs();
		try {
			PrintWriter pw = new PrintWriter("raw/" + tweet.getId() + "_raw.json");
			pw.write(rawContent);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		MyTweet myTweet = gson.fromJson(rawContent, MyTweet.class);
		rawContent = gson.toJson(myTweet);
		new File("tweet").mkdirs();
		try {
			PrintWriter pw = new PrintWriter("tweet/" + tweet.getId() + ".json");
			pw.write(rawContent);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
