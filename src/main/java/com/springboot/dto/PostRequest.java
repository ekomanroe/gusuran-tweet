package com.springboot.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by eko.j.manurung on 11/18/2016.
 */
@GeneratePojoBuilder
public class PostRequest {

    private static final long serialVersionUID = 2410345910783045433L;

    @NotEmpty
    private String tweetDesc;

    public String getTweetDesc() {
        return tweetDesc;
    }

    public void setTweetDesc(String tweetDesc) {
        this.tweetDesc = tweetDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostRequest)) return false;

        PostRequest postRequest = (PostRequest) o;

        return getTweetDesc() != null ? getTweetDesc().equals(postRequest.getTweetDesc()) : postRequest.getTweetDesc() == null;

    }

    @Override
    public int hashCode() {
        return getTweetDesc() != null ? getTweetDesc().hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PostRequest{");
        sb.append("tweetDesc='").append(tweetDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
