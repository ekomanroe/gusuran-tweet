package com.springboot.service.api;

import com.springboot.dto.MemberRequest;
import com.springboot.model.entity.Account;
import com.springboot.model.entity.Member;

/**
 * Created by eko.j.manurung on 10/13/2016.
 */
public interface MemberServiceApi {

    boolean registerMember(Member newMember, Account account);

    Member editMemberProfile(MemberRequest currentMember, Integer memberId);

    Member findMemberData(Integer memberId);

}
