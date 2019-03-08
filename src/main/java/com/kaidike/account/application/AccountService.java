package com.kaidike.account.application;

import com.kaidike.account.interfaces.account.facade.dto.*;

public interface AccountService {

    String loginByPassword(AccountPasswordDTO account);

    String loginBySMSCode(AccountSMSCodeDTO account);

    String loginByWechat(AccountWechatDTO account);

    void changePassword(AccountPasswordForgotDTO account);

    void register(AccountRegisterDTO account);

}
