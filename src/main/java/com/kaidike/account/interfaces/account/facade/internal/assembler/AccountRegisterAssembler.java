package com.kaidike.account.interfaces.account.facade.internal.assembler;

import com.kaidike.account.interfaces.account.facade.dto.AccountRegisterDTO;

import java.util.Map;

public class AccountRegisterAssembler {

    /**
     * params to dto
     * @param params
     * @return
     */
    public AccountRegisterDTO toDTO(Map<String, String> params) {

        AccountRegisterDTO dto = new AccountRegisterDTO(
            params.get("countryCode"),
            params.get("mobile"),
            params.get("smsCode"),
            params.get("password"),
            params.get("confirmPassword")
        );

        return dto;
    }

}
