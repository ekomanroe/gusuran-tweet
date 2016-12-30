package com.springboot.service.impl;

import com.springboot.Helper.BusinessExceptionBuilder;
import com.springboot.dao.api.AccountRepository;
import com.springboot.model.entity.Account;
import com.springboot.model.Enum.ErrorCode;
import com.springboot.service.api.AccountServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eko.j.manurung on 10/14/2016.
 */
@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountServiceApi {

    private String KAMUS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public int login(String username, String password) {

        Account existingAccount = accountRepository.findByUsernameAndPassword(username, password);

        if (existingAccount != null) {
            return existingAccount.getMember().getMemberId();
        } else {
            throw new BusinessExceptionBuilder()
                    .withErrorCode(ErrorCode.INVALID_USERNAME_PASSWORD.code())
                    .withErrorMessage(ErrorCode.INVALID_USERNAME_PASSWORD.getErrorMessage())
                    .build();
        }
    }

    @Transactional(readOnly = false)
    @Override
    public boolean changePassword(Integer id, String old_password, String new_password) {
        Account existingAccount = accountRepository.findOne(id);

        if (existingAccount != null && existingAccount.getPassword().equals(old_password)) {
            existingAccount.setPassword(new_password);

            Account updatedAccount = accountRepository.save(existingAccount);

            return updatedAccount != null;
        } else {
            throw new BusinessExceptionBuilder()
                    .withErrorCode(ErrorCode.INVALID_USERNAME_PASSWORD.code())
                    .withErrorMessage(ErrorCode.INVALID_USERNAME_PASSWORD.getErrorMessage())
                    .build();
        }
    }

    @Transactional(readOnly = false)
    @Override
    public String resetPassword(Integer id) {
        Account existingAccount = accountRepository.findOne(id);

        if (existingAccount != null) {
            String defaultPassword = generateDefaultPassword();
            existingAccount.setPassword(defaultPassword);

            accountRepository.save(existingAccount);

            return defaultPassword;
        } else {
            throw new BusinessExceptionBuilder()
                    .withErrorCode(ErrorCode.ACCOUNT_NOT_FOUND.code())
                    .withErrorMessage(ErrorCode.ACCOUNT_NOT_FOUND.getErrorMessage())
                    .build();
        }
    }

    private String generateDefaultPassword() {
        int length = 6;
        StringBuilder str = new StringBuilder();

        while (length-- != 0) {
            int randomChar = (int) (Math.random() * KAMUS.length());
            str.append(KAMUS.charAt(randomChar));
        }
        return str.toString();
    }
}
