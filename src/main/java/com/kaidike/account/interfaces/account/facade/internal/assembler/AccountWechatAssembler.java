package com.kaidike.account.interfaces.account.facade.internal.assembler;

import com.kaidike.account.interfaces.account.facade.dto.AccountWechatDTO;

import java.util.Map;

public class AccountWechatAssembler {

    /**
     * params to dto
     * @param params
     * @return
     */
    public AccountWechatDTO toDTO(Map<String, String> params) {

        AccountWechatDTO dto = new AccountWechatDTO(
                params.get("nickname"),
                params.get("avatar"),
                params.get("sex"),
                params.get("country"),
                params.get("province"),
                params.get("city"),
                params.get("openid"),
                params.get("unionID")
        );

        return dto;
    }

}
