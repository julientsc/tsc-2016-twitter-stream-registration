package worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import model.Config;

public class StreamManager {

	private static StreamManager instance = null;
	private StreamStatusListener listener ;

	public static StreamManager getInstance() {
		if(instance==null) {
			instance = new StreamManager();
		}
		return instance;
	}

	private TwitterStream twitterStream = null;
	private boolean isWorking = false;

	private StreamManager() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("fPZObUh20Etmgd3EOiFe8Cc31")
		.setOAuthConsumerSecret("KvtcoNWyLrJyUEwGKrni7zMXSAlnpso8I8FtFv1YwA5LJBxR2K")
		.setOAuthAccessToken("286388280-WIk9xAM4LnYW4KuVOGkv2Cr1uz1T0U1GSSzGDpdj")
		.setOAuthAccessTokenSecret("tWO3TTtFDCKXpdiAYV8kT1wjivcnQaH590UposkkxDq20");


		 listener = new StreamStatusListener();
		
		this.twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		this.twitterStream.addListener(listener);

	}

	private static String [] extractHashtagFromConfig(Config config) {
		ArrayList<String> hashtags = new ArrayList<String>();
		HashMap<String, List<String>> mainHashtags = config.getHashtags();
		for (String mainHashtag : mainHashtags.keySet()) {
			if(!hashtags.contains(mainHashtag)) {
				hashtags.add(mainHashtag);
			}
			for (String subHashtag : mainHashtags.get(mainHashtag)) {
				if(!hashtags.contains(subHashtag))
					hashtags.add(subHashtag);
			}
		}

		String []  r = new String[hashtags.size()];
		int count = 0;
		for (String hashtag : hashtags) {
			r[count++] = "#" + hashtag.toLowerCase();
		}
		return r;
	}
	public void startStream(Config config) {
		if(isWorking)
			return;
		isWorking = true;
		
		System.out.println("Start Stream");
		String[] hashtags = extractHashtagFromConfig(config);
		this.listener.setHashtag(hashtags);
        
		for(int i = 0 ; i < hashtags.length ; i++) {
			System.out.println(" + " + hashtags[i]);
		}
		
		FilterQuery fq = new FilterQuery();
        fq.track(hashtags);
       

		twitterStream.filter(fq);
	
		
		System.out.println("=> Stream started !");

	}

	public void stopStream() {
		if(!isWorking)
			return;
		isWorking = false;
		
		System.out.println("Stop Stream");

		twitterStream.shutdown();
		
		System.out.println("=> Stream Stopped");
	}

	public void changeConfig(Config config) {
		System.out.println("Change Config");
		stopStream();
		startStream(config);
	}
}
