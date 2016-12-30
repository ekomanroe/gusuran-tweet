package com.springboot.controller;

import com.springboot.dto.*;
import com.springboot.model.entity.Account;
import com.springboot.model.entity.AccountBuilder;
import com.springboot.model.entity.Member;
import com.springboot.model.entity.MemberBuilder;
import com.springboot.service.api.MemberServiceApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * Created by eko.j.manurung on 9/26/2016.
 */
@RestController
@RequestMapping(value = "/member")
@Api(value = "Member Controller", description = "member operation")
public class MemberController extends AbstractController {

    @Autowired
    private MemberServiceApi memberServiceApi;

    @PostMapping
    @ApiOperation(value = "Register Member", notes = "Register new Member")
    public BaseResponse registerMember(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                       @Valid @RequestBody @ApiParam RegisterMemberRequest request) {

        Member member = new MemberBuilder()
                .withAddress(request.getAddress())
                .withLastName(request.getLastName())
                .withDateOfBirth(request.getDateOfBirth())
                .withPhoneNumber(request.getPhoneNumber())
                .withMaritalStatus(request.getMaritalStatus())
                .withEmailAddress(request.getEmailAddress())
                .withFirstName(request.getFirstName())
                .withGender(request.getGender())
                .build();

        Account account = new AccountBuilder()
                .withUsername(request.getUsername())
                .withPassword(request.getPassword())
                .build();

        boolean response = memberServiceApi.registerMember(member, account);

        return new BaseResponseBuilder<>()
                .withValue(null)
                .withSuccess(response)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @PutMapping
    @ApiOperation(value = "Edit current Member", notes = "Edit current Member")
    public BaseResponse<MemberResponse> editProfile(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                                    @Valid @RequestBody @ApiParam MemberRequest request,
                                                    @Valid @RequestParam @ApiParam Integer memberId) {

        Member response = memberServiceApi.editMemberProfile(request, memberId);

        return new BaseResponseBuilder<MemberResponse>()
                .withValue(response.toMemberResponse())
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @GetMapping
    @ApiOperation(value = "Get Data Member", notes = "Get data Member")
    public BaseResponse<MemberResponse> findMember(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                                   @Valid @RequestParam @ApiParam Integer id) {

        Member result = memberServiceApi.findMemberData(id);

        return new BaseResponseBuilder<MemberResponse>()
                .withValue(result.toMemberResponse())
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }
}
