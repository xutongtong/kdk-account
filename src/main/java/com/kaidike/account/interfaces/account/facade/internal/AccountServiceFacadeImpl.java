package com.kaidike.account.interfaces.account.facade.internal;

import com.kaidike.account.interfaces.account.facade.AccountServiceFacade;
import com.kaidike.account.application.AccountService;
import com.kaidike.account.interfaces.account.facade.dto.*;

import java.rmi.RemoteException;

public class AccountServiceFacadeImpl implements AccountServiceFacade {

    private AccountService accountService;

    @Override
    public String loginByPassword(AccountPasswordDTO account) throws RemoteException {
        return accountService.loginByPassword(account);
    }

    @Override
    public String loginBySMSCode(AccountSMSCodeDTO account) throws RemoteException {
        return accountService.loginBySMSCode(account);
    }

    @Override
    public String loginByWechat(AccountWechatDTO account) throws RemoteException {
        return accountService.loginByWechat(account);
    }

    @Override
    public void changePassword(AccountPasswordForgotDTO account) throws RemoteException {
        accountService.changePassword(account);
    }

    @Override
    public void register(AccountRegisterDTO account) throws RemoteException {
        accountService.register(account);
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
