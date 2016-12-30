package com.springboot.controller;

import com.springboot.Helper.api.ModelConverterServiceApi;
import com.springboot.dto.*;
import com.springboot.model.entity.Tweet;
import com.springboot.model.entity.TweetBuilder;
import com.springboot.service.api.TweetServiceApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by eko.j.manurung on 9/26/2016.
 */
@RestController
@RequestMapping(value = "/tweet")
@Api(value = "Tweet Controller", description = "tweet operation")
public class TweetController extends AbstractController {

    @Autowired
    private TweetServiceApi tweetServiceApi;

    @Autowired
    private ModelConverterServiceApi converterServiceApi;

    @PostMapping
    @ApiOperation(value = "create post", notes = "member create post")
    public BaseResponse<PostResponse> createPost(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                                 @Valid @RequestBody @ApiParam PostRequest request,
                                                 @Valid @RequestParam @ApiParam Integer memberId) {

        Tweet tweet = new TweetBuilder()
                .withTweetDesc(request.getTweetDesc())
                .build();

        Tweet createdTweet = tweetServiceApi.createPost(tweet, memberId);

        return new BaseResponseBuilder<PostResponse>()
                .withValue(createdTweet.toResponse())
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @DeleteMapping
    @ApiOperation(value = "delete member post", notes = "delete member post")
    public BaseResponse deletePost(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                   @Valid @RequestParam @ApiParam Integer idPost) {

        tweetServiceApi.deletePost(idPost);

        return new BaseResponseBuilder<>()
                .withValue(null)
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @PutMapping
    @ApiOperation(value = "edit member post", notes = "edit member post")
    public BaseResponse editPost(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                 @Valid @RequestBody @ApiParam PostRequest request,
                                 @Valid @RequestParam @ApiParam Integer idPost) {

        Tweet tweet = new TweetBuilder()
                .withTweetDesc(request.getTweetDesc())
                .build();

        Boolean editPost = tweetServiceApi.editPost(idPost, tweet);

        return new BaseResponseBuilder<>()
                .withValue(editPost)
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @GetMapping("/find-one")
    @ApiOperation(value = "get one member post", notes = "get one member post")
    public BaseResponse<PostResponse> findPost(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                               @Valid @RequestParam @ApiParam Integer idPost) {

        Tweet tweet = tweetServiceApi.findTweet(idPost);

        return new BaseResponseBuilder<PostResponse>()
                .withValue(tweet.toResponse())
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @GetMapping("find-all")
    @ApiOperation(value = "find all member post", notes = "find all member post")
    public BaseResponse<List<PostResponse>> findMemberPosts(@ApiIgnore @Valid
                                                            @ModelAttribute MandatoryParameterRequest parameter,
                                                            @Valid @RequestParam @ApiParam Integer memberId) {

        List<Tweet> tweets = tweetServiceApi.findMemberPost(memberId);

        return new BaseResponseBuilder<List<PostResponse>>()
                .withValue(converterServiceApi.toListPostResponse(tweets))
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @GetMapping("get-TimeLine")
    @ApiOperation(value = "find all post", notes = "find all post")
    public BaseResponse<List<PostResponse>> getTimeLine(@ApiIgnore @Valid @ModelAttribute
                                                                MandatoryParameterRequest parameter) {

        List<Tweet> tweets = tweetServiceApi.getTimeLine();

        return new BaseResponseBuilder<List<PostResponse>>()
                .withValue(converterServiceApi.toListPostResponse(tweets))
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }
}
