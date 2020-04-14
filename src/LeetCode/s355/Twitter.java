package LeetCode.s355;

import java.util.*;

/*设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户*/
public class Twitter {
    /*优化存取速度*/
    public class User {
        int UserId;
        Set<Integer> usertweetlist = new HashSet<>();
        Set<User> followeelist = new HashSet<>();

        public User(int userId) {
            UserId = userId;
        }

        public void postTweet(int tweetId) {
            usertweetlist.add(tweetId);
        }

        public void follow(User followee) {
            if(!followeelist.contains(followee))
            followeelist.add(followee);
        }

        public void unfollow(User followee) {
            Iterator<User> iterator=followeelist.iterator();
            while (iterator.hasNext()){
                User curr=iterator.next();
                if(curr.UserId==followee.UserId){
                    followeelist.remove(curr);
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
    public Twitter() {

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
            if(curr.usertweetlist.contains(tweet)){
                ans.add(tweet);
                j++;
                continue;
            }
            Set<User> followee=curr.followeelist;
            for (User user : followee) {
                if(user.usertweetlist.contains(tweet)){
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

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
