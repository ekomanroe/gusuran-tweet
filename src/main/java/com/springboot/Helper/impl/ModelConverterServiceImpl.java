package com.springboot.Helper.impl;

import com.springboot.Helper.api.ModelConverterServiceApi;
import com.springboot.dto.PostResponse;
import com.springboot.model.entity.Tweet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eko.j.manurung on 12/27/2016.
 */
@Service
public class ModelConverterServiceImpl implements ModelConverterServiceApi {

    @Override
    public List<PostResponse> toListPostResponse(List<Tweet> tweets) {

        List<PostResponse> postResponses = new ArrayList<PostResponse>();

        for (Tweet tweet : tweets) {
            postResponses.add(tweet.toResponse());
        }

        return postResponses;
    }
}
