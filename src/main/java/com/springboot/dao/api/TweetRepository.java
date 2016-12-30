package com.springboot.dao.api;

import com.springboot.model.entity.Member;
import com.springboot.model.entity.Tweet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eko.j.manurung on 10/13/2016.
 */
@Repository
public interface TweetRepository extends CrudRepository<Tweet, Integer> {

    List<Tweet> findByMemberOrderByUpdatedDateDesc(Member member);

    List<Tweet> findAllByOrderByUpdatedDateDesc();
}
