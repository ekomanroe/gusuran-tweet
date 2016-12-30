package com.springboot.dao.api;

import com.springboot.model.entity.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eko.j.manurung on 10/13/2016.
 */
public interface MemberRepository extends CrudRepository<Member, Integer> {
}
