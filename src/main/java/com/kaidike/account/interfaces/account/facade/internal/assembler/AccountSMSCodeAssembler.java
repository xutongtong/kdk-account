package com.kaidike.account.interfaces.account.facade.internal.assembler;

import com.kaidike.account.domain.model.account.Account;
import com.kaidike.account.interfaces.account.facade.dto.AccountSMSCodeDTO;

import java.util.Map;

public class AccountSMSCodeAssembler {

    /**
     * model to dto
     * @param  account
     * @return AccountSMSCodeDTO dto
     */
    public AccountSMSCodeDTO toDTO(final Account account) {
        AccountSMSCodeDTO dto = new AccountSMSCodeDTO(
                account.getCountryCode(),
                account.getMobile(),
                ""
        );

        return dto;
    }

    /**
     * params to dto
     * @param params
     * @return AccountSMSCodeDTO dto
     */
    public AccountSMSCodeDTO toDTO(Map<String, String> params) {
        AccountSMSCodeDTO dto = new AccountSMSCodeDTO(
                params.get("countryCode"),
                params.get("mobile"),
                params.get("smsCode")
        );

        return dto;
    }

}
