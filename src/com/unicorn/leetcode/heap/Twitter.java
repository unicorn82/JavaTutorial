package com.unicorn.leetcode.heap;

import com.unicorn.utils.AppUtils;
import com.unicorn.utils.CollectionsUtils;

import java.util.*;

public class Twitter {
    class TwitterInfo {
        public TwitterInfo(int tweetId, int userId, int count, int index){
            this.count = count;
            this.tweetId = tweetId;
            this.userId = userId;
            this.index = index;

        }
        public int tweetId;
        public int userId;
        public int count;
        public int index;
    }
    Map<Integer, HashSet> followerMap;
    Map<Integer, List<TwitterInfo>> tweetMap;
    int count;
    PriorityQueue<TwitterInfo> pg;



    public Twitter() {
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
        pg = new PriorityQueue<>(new Comparator<TwitterInfo>() {
            @Override
            public int compare(TwitterInfo o1, TwitterInfo o2) {
                return o2.count - o1.count;
            }
        });
    }


    public void postTweet(int userId, int tweetId) {

        List<TwitterInfo> tweetList = tweetMap.get(userId);
        if(tweetList == null){
            tweetList = new ArrayList<>();
            tweetMap.put(userId, tweetList);
        }
        int index = tweetList.size();
        tweetList.add(new TwitterInfo(tweetId, userId, count, index));
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        pg.clear();
        if(tweetMap.containsKey(userId)){
            List<TwitterInfo> tweets = tweetMap.get(userId);
            pg.add(tweets.get(tweets.size()-1));
        }
        HashSet followerList = followerMap.getOrDefault(userId, new HashSet<>());
        Iterator<Integer> iterator = followerList.iterator();

        List<Integer> results = new ArrayList<>();
        while(iterator.hasNext()){
            int user = iterator.next();
            if(tweetMap.containsKey(user)){
                List<TwitterInfo> tweets = tweetMap.get(user);
                pg.add(tweets.get(tweets.size()-1));
            }

        }
        while(results.size() < 10 && !pg.isEmpty()){
            TwitterInfo twitterInfo = pg.poll();
            results.add(twitterInfo.tweetId);
            List<TwitterInfo> tweets = tweetMap.get(twitterInfo.userId);
            if(twitterInfo.index >0) {
                pg.add(tweets.get(twitterInfo.index - 1));
            }

        }
        return results;


    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> hashSet = followerMap.get(followerId);
        if(hashSet == null){
            hashSet = new HashSet<>();
            followerMap.put(followerId, hashSet);
        }
        hashSet.add(followeeId);



    }

    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)) {
            followerMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 205);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        CollectionsUtils.printList(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        CollectionsUtils.printList(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        CollectionsUtils.printList(twitter.getNewsFeed(1));











    }


}
