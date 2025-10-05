import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<Tweet>> posts;
    
    Integer timeStamp;
    
    /** Initialize your data structure here. */
    public Twitter() {
        follows = new HashMap<>();
        posts = new HashMap<>();
        timeStamp = 0;
    }
    
    private static class Tweet {
        Integer timeStamp;
        Integer tweetId;
        public Tweet() {}
        public Tweet(int ts, int tID) {
            timeStamp = ts;
            tweetId = tID;
        }
    }// end of Tweet class     
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(++timeStamp, tweetId);
        if ( !posts.containsKey(userId)) {
            posts.put(userId, new ArrayList<>() );
        }
        posts.get(userId).add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> user_follows = new HashSet<>();
        user_follows.add(userId);
        if(follows.containsKey(userId)) {
            user_follows.addAll(follows.get(userId));
        }
        PriorityQueue<Tweet> q = new PriorityQueue<>(10,(a,b)->(b.timeStamp-a.timeStamp));
        for (Integer f:user_follows) {
            List<Tweet> tweets = posts.get(f);
            if (tweets != null) {
                for (Tweet t:tweets) {
                    q.add(t);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().tweetId);
            if (res.size()==10) {
                break;
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!follows.containsKey(followerId)) {
            follows.put(followerId,new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if( follows.containsKey(followerId)
            &&follows.get(followerId).contains(followeeId) ) {
            follows.get(followerId).remove(followeeId);  
        }
    }// end of unfollow    
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
 
 
 
 
 
 
 
 
 
 