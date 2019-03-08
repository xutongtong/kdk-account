package com.kaidike.account.interfaces.account.facade.internal.assembler;

import com.kaidike.account.domain.model.account.Account;
import com.kaidike.account.interfaces.account.facade.dto.AccountPasswordDTO;

import java.util.Map;

public class AccountPasswordAssembler {

    /**
     * model to dto
     * @param  account
     * @return AccountPasswordDTO dto
     */
    public AccountPasswordDTO toDTO(final Account account) {
        final AccountPasswordDTO dto = new AccountPasswordDTO(
                account.getCountryCode(),
                account.getMobile(),
                account.getPassword()
        );

        return dto;
    }

    /**
     * requestParams to dto
     * @param params
     * @return AccountPasswordDTO dto
     */
    public AccountPasswordDTO toDTO(final Map<String, String> params) {
        final AccountPasswordDTO dto = new AccountPasswordDTO(
                params.get("countryCode"),
                params.get("mobile"),
                params.get("password")
        );

        return dto;
    }

}
