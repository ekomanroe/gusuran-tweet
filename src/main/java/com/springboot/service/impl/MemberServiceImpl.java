package com.springboot.service.impl;

import com.springboot.Helper.BusinessExceptionBuilder;
import com.springboot.dao.api.AccountRepository;
import com.springboot.dao.api.MemberRepository;
import com.springboot.dto.MemberRequest;
import com.springboot.model.entity.Account;
import com.springboot.model.Enum.ErrorCode;
import com.springboot.model.entity.Member;
import com.springboot.service.api.MemberServiceApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eko.j.manurung on 10/14/2016.
 */
@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberServiceApi {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = false)
    @Override
    public boolean registerMember(Member newMember, Account account) {
        Member result = memberRepository.save(newMember);

        account.setMember(result);

        Account regAccount = accountRepository.save(account);

        return (result != null && regAccount != null);
    }

    @Transactional(readOnly = false)
    @Override
    public Member editMemberProfile(MemberRequest currentMember, Integer memberId) {
        Member existingMember = findMemberData(memberId);
        if (existingMember == null) {
            throw new BusinessExceptionBuilder()
                    .withErrorCode(ErrorCode.MEMBER_NOT_FOUND.code())
                    .withErrorMessage(ErrorCode.MEMBER_NOT_FOUND.getErrorMessage())
                    .build();
        }

        BeanUtils.copyProperties(currentMember, existingMember);

        Member modifyMember = memberRepository.save(existingMember);

        return modifyMember;
    }

    @Override
    public Member findMemberData(Integer memberId) {

        Member response = memberRepository.findOne(memberId);

        if (response == null) {
            throw new BusinessExceptionBuilder()
                    .withErrorCode(ErrorCode.MEMBER_NOT_FOUND.code())
                    .withErrorMessage(ErrorCode.MEMBER_NOT_FOUND.getErrorMessage())
                    .build();
        }
        return response;
    }
}
