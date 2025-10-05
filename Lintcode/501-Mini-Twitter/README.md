
Use a var order to indicate time. Every time a tweet is published, order increased by one and bind to the tweet. So the bigger the order, the later the tweet is published.

We need a structure called Node, and have a Node array. Need a function to return the last 10 nodes from the array, and a function to return the first 10 nodes.

We need two maps, one is for one use to all his friends, the other is for one user to all his tweets.

for postTweet, firstly create a tweet using the provided facility class, and add the user into usersTweet if it is not available.

for getNewsFeed, get the latest 10 tweets for the user, and tranversal all his friends, get the latest 10 tweets respectively, and sort by order, and return the 10 latest tweets.

for getTimeLine, get the latest 10 tweets and sort by order.

for follow, add friend to user`s friend mapping.

for unfollow, delete friend from user`s friend mapping.


