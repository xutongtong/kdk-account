package com.kaidike.account.interfaces.account.facade;

import com.kaidike.account.interfaces.account.facade.dto.*;

import java.rmi.RemoteException;
import java.util.Map;

public interface AccountServiceFacade {

    String loginByPassword(AccountPasswordDTO account) throws RemoteException;

    String loginBySMSCode(AccountSMSCodeDTO account) throws RemoteException;

    String loginByWechat(AccountWechatDTO account) throws RemoteException;

    void changePassword(AccountPasswordForgotDTO account) throws RemoteException;

    void register(AccountRegisterDTO account) throws RemoteException;
}
