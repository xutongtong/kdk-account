package com.kaidike.account.interfaces.account.facade.internal.assembler;

import com.kaidike.account.interfaces.account.facade.dto.AccountPasswordForgotDTO;

import java.util.Map;

public class AccountPasswordForgotAssembler {

    /**
     * params to dto
     * @param params
     * @return dto
     */
    public AccountPasswordForgotDTO toDTO(Map<String, String> params) {

        AccountPasswordForgotDTO dto = new AccountPasswordForgotDTO(
                params.get("countryCode"),
                params.get("mobile"),
                params.get("smsCode"),
                params.get("password"),
                params.get("confirmPassword")
        );

        return dto;
    }

}
