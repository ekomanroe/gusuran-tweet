package com.springboot.service.impl;

import com.springboot.Helper.BusinessExceptionBuilder;
import com.springboot.dao.api.TweetRepository;
import com.springboot.model.Enum.ErrorCode;
import com.springboot.model.entity.Member;
import com.springboot.model.entity.Tweet;
import com.springboot.service.api.MemberServiceApi;
import com.springboot.service.api.TweetServiceApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by eko.j.manurung on 11/18/2016.
 */
@Service
@Transactional(readOnly = true)
public class TweetServiceImpl implements TweetServiceApi {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    MemberServiceApi memberServiceApi;

    @Transactional(readOnly = false)
    @Override
    public Tweet createPost(Tweet tweet, Integer memberId) {
        Member member = memberServiceApi.findMemberData(memberId);

        tweet.setMember(member);
        Tweet savedPost = tweetRepository.save(tweet);

        return savedPost;
    }

    @Transactional(readOnly = false)
    @Override
    public void deletePost(Integer tweetId) {
        tweetRepository.delete(tweetId);
    }

    @Override
    public Tweet findTweet(Integer tweetId) {
        Tweet tweet = tweetRepository.findOne(tweetId);

        if (tweet == null) {
            throw new BusinessExceptionBuilder()
                    .withErrorCode(ErrorCode.TWEET_NOT_FOUND.code())
                    .withErrorMessage(ErrorCode.TWEET_NOT_FOUND.getErrorMessage())
                    .build();
        } else {
            return tweet;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public boolean editPost(Integer tweetId, Tweet tweet) {
        Tweet current = findTweet(tweetId);

        current.setTweetDesc(tweet.getTweetDesc());

        Tweet savedTweet = tweetRepository.save(current);
        return savedTweet != null;
    }

    @Override
    public List<Tweet> getTimeLine() {
        return tweetRepository.findAllByOrderByUpdatedDateDesc();
    }

    @Override
    public List<Tweet> findMemberPost(Integer memberId) {
        Member member = memberServiceApi.findMemberData(memberId);

        return tweetRepository.findByMemberOrderByUpdatedDateDesc(member);
    }
}
