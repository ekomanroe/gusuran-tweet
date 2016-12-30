package com.springboot.Helper.api;

import com.springboot.dto.PostResponse;
import com.springboot.model.entity.Tweet;

import java.util.List;

/**
 * Created by eko.j.manurung on 12/27/2016.
 */
public interface ModelConverterServiceApi {

    List<PostResponse> toListPostResponse(List<Tweet> tweets);
}
