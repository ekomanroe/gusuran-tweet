package com.springboot.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by eko.j.manurung on 11/18/2016.
 */
@GeneratePojoBuilder
public class PostResponse {

    private static final long serialVersionUID = 2410345910783045433L;

    private Integer idTweet;
    private String tweetDesc;
    private Date createdDate;
    private Date updatedDate;

    public Integer getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(Integer idTweet) {
        this.idTweet = idTweet;
    }

    public String getTweetDesc() {
        return tweetDesc;
    }

    public void setTweetDesc(String tweetDesc) {
        this.tweetDesc = tweetDesc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof PostResponse)) return false;

        PostResponse that = (PostResponse) o;

        if (getIdTweet() != null ? !getIdTweet().equals(that.getIdTweet()) : that.getIdTweet() != null) return false;
        if (getTweetDesc() != null ? !getTweetDesc().equals(that.getTweetDesc()) : that.getTweetDesc() != null)
            return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
            return false;
        return getUpdatedDate() != null ? getUpdatedDate().equals(that.getUpdatedDate()) : that.getUpdatedDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getIdTweet() != null ? getIdTweet().hashCode() : 0;
        result = 31 * result + (getTweetDesc() != null ? getTweetDesc().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getUpdatedDate() != null ? getUpdatedDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PostResponse{");
        sb.append("idTweet=").append(idTweet);
        sb.append(", tweetDesc='").append(tweetDesc).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append('}');
        return sb.toString();
    }
}
