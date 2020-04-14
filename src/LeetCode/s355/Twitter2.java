package LeetCode.s355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter2 {
    public class User {
        int UserId;
        List<Integer> tweetlist = new ArrayList<>();
        List<User> followeelist = new ArrayList<>();

        public User(int userId) {
            UserId = userId;
        }

        public void postTweet(int tweetId) {
            tweetlist.add(tweetId);
        }

        public void follow(User followee) {
            if(!followeelist.contains(followee))
                followeelist.add(followee);
        }

        public void unfollow(User followeeId) {
            for (int i = 0; i < followeelist.size(); i++)  {
                if(followeeId.UserId==followeelist.get(i).UserId){
                    followeelist.remove(i);
                    break;
                }
            }
        }

    }
    Map<Integer,User> usermap = new HashMap<>();
    List<Integer> tweetList = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter2() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if(usermap.containsKey(userId)){
            usermap.get(userId).postTweet(tweetId);
            tweetList.add(tweetId);
        }else {
            User curr=new User(userId);
            usermap.put(userId,curr);
            curr.postTweet(tweetId);
            tweetList.add(tweetId);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        //输出10次
        List<Integer> ans=new ArrayList<>();
        if(!usermap.containsKey(userId)){
            return ans;
        }
        if(tweetList.isEmpty()){
            return ans;
        }

        User curr=usermap.get(userId);
        for (int i = tweetList.size() - 1,j=0; i >= 0&&j<10; i--) {
            int tweet=tweetList.get(i);
            if(curr.tweetlist.contains(tweet)){
                ans.add(tweet);
                j++;
                continue;
            }
            List<User> followee=curr.followeelist;
            for (User user : followee) {
                if(user.tweetlist.contains(tweet)){
                    ans.add(tweet);
                    j++;
                }
            }
        }
        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
//先看这个用户是否存在,
        User follower;
        User followee;
        if(!usermap.containsKey(followerId)&&!usermap.containsKey(followeeId)){
            follower=new User(followerId);
            followee=new User(followeeId);
            usermap.put(followerId,follower);
            usermap.put(followeeId,followee);
        }
        if(!usermap.containsKey(followerId)){
            follower=new User(followerId);
            usermap.put(followerId,follower);
        }
        if(!usermap.containsKey(followeeId)){
            followee=new User(followeeId);
            usermap.put(followeeId,followee);
        }
        followee=usermap.get(followeeId);
        follower=usermap.get(followerId);
        follower.follow(followee);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId)||!usermap.containsKey(followeeId)){
            return;
        }
        User followee=usermap.get(followeeId);
        User follower=usermap.get(followerId);
        follower.unfollow(followee);
    }

}
