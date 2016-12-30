package com.springboot.controller;

import com.springboot.dto.BaseResponse;
import com.springboot.dto.BaseResponseBuilder;
import com.springboot.dto.ChangePasswordRequest;
import com.springboot.dto.MandatoryParameterRequest;
import com.springboot.service.api.AccountServiceApi;
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
@RequestMapping(value = "/account")
@Api(value = "Account Controller", description = "account operation")
public class AccountController extends AbstractController {

    @Autowired
    private AccountServiceApi accountServiceApi;

    @PostMapping
    @ApiOperation(value = "Login for registered member", notes = "login member")
    public BaseResponse login(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                              @Valid @RequestParam @ApiParam String username,
                              @Valid @RequestParam @ApiParam String password) {

        int memberId = accountServiceApi.login(username, password);

        return new BaseResponseBuilder<>()
                .withValue(memberId)
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @PutMapping("/change-password")
    @ApiOperation(value = "change password user", notes = "change password user")
    public BaseResponse changePassword(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                       @Valid @RequestBody @ApiParam ChangePasswordRequest request,
                                       @Valid @RequestParam @ApiParam Integer id) {

        boolean result = accountServiceApi.changePassword(id, request.getOldPassword(),
                request.getNewPassword());

        return new BaseResponseBuilder<>()
                .withValue(null)
                .withSuccess(result)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }

    @PutMapping("/reset-password")
    @ApiOperation(value = "reset password user", notes = "reset password user")
    public BaseResponse resetPassword(@ApiIgnore @Valid @ModelAttribute MandatoryParameterRequest parameter,
                                      @Valid @RequestParam @ApiParam int accountId) {

        String default_password = accountServiceApi.resetPassword(accountId);

        return new BaseResponseBuilder<>()
                .withValue(default_password)
                .withSuccess(true)
                .withErrorCode("")
                .withErrorMessage("")
                .build();
    }
}
