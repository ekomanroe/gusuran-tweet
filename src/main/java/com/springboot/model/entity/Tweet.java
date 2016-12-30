package com.springboot.model.entity;

import com.springboot.dto.PostResponse;
import com.springboot.dto.PostResponseBuilder;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eko.j.manurung on 9/26/2016.
 */
@GeneratePojoBuilder
@Entity
@Table(name = "tweet")
public class Tweet extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2410345206783043723L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tweetId;
    private String tweetDesc;
    @ManyToOne()
    @JoinColumn(name = "memberId")
    private Member member;

    public PostResponse toResponse() {
        return new PostResponseBuilder()
                .withTweetDesc(getTweetDesc())
                .withIdTweet(getTweetId())
                .withCreatedDate(getCreatedDate())
                .withUpdatedDate(getUpdatedDate())
                .build();
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetDesc() {
        return tweetDesc;
    }

    public void setTweetDesc(String tweetDesc) {
        this.tweetDesc = tweetDesc;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;
        if (!super.equals(o)) return false;

        Tweet tweet = (Tweet) o;

        if (getTweetId() != null ? !getTweetId().equals(tweet.getTweetId()) : tweet.getTweetId() != null) return false;
        if (getTweetDesc() != null ? !getTweetDesc().equals(tweet.getTweetDesc()) : tweet.getTweetDesc() != null)
            return false;
        return getMember() != null ? getMember().equals(tweet.getMember()) : tweet.getMember() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTweetId() != null ? getTweetId().hashCode() : 0);
        result = 31 * result + (getTweetDesc() != null ? getTweetDesc().hashCode() : 0);
        result = 31 * result + (getMember() != null ? getMember().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tweet{");
        sb.append("tweetId=").append(tweetId);
        sb.append(", tweetDesc='").append(tweetDesc).append('\'');
        sb.append(", member=").append(member);
        sb.append('}');
        return sb.toString();
    }
}
