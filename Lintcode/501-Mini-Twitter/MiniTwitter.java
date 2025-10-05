import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Tweet {
	public int id;
	public int user_id;
	public String text;

	private static int order = 0;
	public static Tweet create(int user_id, String tweet_text) {
		return new Tweet(order++, user_id, tweet_text);
	}
	
	private Tweet(int id, int uId, String tText) {
		this.id = id;
		user_id = uId;
		this.text = tText;
	}
}

public class MiniTwitter {
	private List<Tweet> tweetList = new ArrayList<Tweet>();
	private HashMap<Integer, HashSet<Integer>> followList = new HashMap<>();

	public MiniTwitter() {
		// initialize your data structure here.
	}

	// @param user_id an integer
	// @param tweet a string
	// return a tweet
	public Tweet postTweet(int user_id, String tweet_text) {
		Tweet t = Tweet.create(user_id, tweet_text);
		tweetList.add(t);
		return t;
	}

	// @param user_id an integer
	// return a list of 10 new feeds recently
	// and sort by timeline
	public List<Tweet> getNewsFeed(int user_id) {
		List<Tweet> newsFeed = new ArrayList<Tweet>();
		HashSet<Integer> follows = followList.get(user_id);
		for (int i = tweetList.size() - 1, count = 0; i >= 0 && count < 10; i--) {
			if (tweetList.get(i).user_id == user_id
					|| (follows != null && follows
							.contains(tweetList.get(i).user_id))) {
				count++;
				newsFeed.add(tweetList.get(i));
			}
		}

		return newsFeed;
	}

	// @param user_id an integer
	// return a list of 10 new posts recently
	// and sort by timeline
	public List<Tweet> getTimeline(int user_id) {
		List<Tweet> timeline = new ArrayList<Tweet>();
		for (int i = tweetList.size() - 1, count = 0; i >= 0 && count < 10; i--) {
			if (tweetList.get(i).user_id == user_id) {
				count++;
				timeline.add(tweetList.get(i));
			}
		}
		return timeline;
	}

	// @param from_user_id an integer
	// @param to_user_id an integer
	// from user_id follows to_user_id
	public void follow(int from_user_id, int to_user_id) {
		if (followList.get(from_user_id) == null) {
			followList.put(from_user_id, new HashSet<Integer>());
		}
		HashSet<Integer> follows = followList.get(from_user_id);
		if (!follows.contains(to_user_id)) {
			follows.add(to_user_id);
		}
	}

	// @param from_user_id an integer
	// @param to_user_id an integer
	// from user_id unfollows to_user_id
	public void unfollow(int from_user_id, int to_user_id) {
		if (followList.get(from_user_id) == null) {
			return;
		}
		HashSet<Integer> follows = followList.get(from_user_id);
		if (follows.contains(to_user_id)) {
			follows.remove(to_user_id);
		}
	}
}
