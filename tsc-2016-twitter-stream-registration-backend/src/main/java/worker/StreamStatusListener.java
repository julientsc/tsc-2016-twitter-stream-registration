package worker;

import java.util.ArrayList;

import model.MyTweetCollection;
import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class StreamStatusListener implements StatusListener {
	
	private ArrayList<String> hashtags = null;
	
	public void setHashtag(String [] hashtags) {
		this.hashtags = new ArrayList<String>();
		for(int i = 0 ; i < hashtags.length ; i++)
			this.hashtags.add(hashtags[i]);
	}
	
	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatus(Status status) {
		
		MyTweetCollection a = new MyTweetCollection();
		a.addTweet("aa", status);
		
		for(HashtagEntity hashtag : status.getHashtagEntities()) {
			String h = "#" + hashtag.getText().toLowerCase();
			if(this.hashtags.contains(h)) {
				System.out.println("+" + status.getUser().getName() + " : " + status.getText().replaceAll("\n", " "));
				return;
			}
			else {
				System.out.println("-" + status.getUser().getName() + " : " + status.getText());
			}
		}
		
//		System.out.println(status.getUser().getName() + " : " + status.getText());

	}

	@Override
	public void onException(Exception e) {
//		e.printStackTrace();
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {

	}
}
