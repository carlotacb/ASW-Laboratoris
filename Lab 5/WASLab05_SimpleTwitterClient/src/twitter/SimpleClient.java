package twitter;

import java.util.Date;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		
		//final Twitter twitter = new TwitterFactory().getInstance();
		/*
		Date now = new Date();
		String latestStatus = "I want to increase the Klout score of @cfarre [task #4 completed "+now+"]";
		Status status = twitter.updateStatus(latestStatus);
		System.out.println("Successfully updated the status to: " + status.getText());
		
		List<Status> statusList = null;
		try {
	        statusList = twitter.getUserTimeline("@fib_was");
	    } catch (TwitterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    System.out.println(statusList.get(0).getText());
	    twitter.retweetStatus(statusList.get(0).getId());
	    */
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

		StatusListener statusListener = new StatusListener() {
			

			@Override
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub
				
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
			public void onStatus(Status arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0.getUser().getName() + " (@" + arg0.getUser().getScreenName() + "): " + arg0.getText());
			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};

        FilterQuery fq = new FilterQuery();        

        String keywords[] = {"#barcelona"};

        fq.track(keywords);        

        twitterStream.addListener(statusListener);
        twitterStream.filter(fq);    
	}
}
