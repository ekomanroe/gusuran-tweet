package com.springboot.service.api;

import com.springboot.model.entity.Tweet;

import java.util.List;

/**
 * Created by eko.j.manurung on 10/14/2016.
 */
public interface TweetServiceApi {

    Tweet createPost(Tweet tweet, Integer memberId);

    void deletePost(Integer tweetId);

    Tweet findTweet(Integer tweetId);

    boolean editPost(Integer tweetId, Tweet tweet);

    List<Tweet> getTimeLine();

    List<Tweet> findMemberPost(Integer memberId);
}
