package com.kaidike.account.interfaces.account.web;


import com.kaidike.account.interfaces.account.facade.AccountServiceFacade;
import com.kaidike.account.interfaces.account.facade.dto.*;
import com.kaidike.account.interfaces.account.facade.internal.assembler.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AccountController {

    private AccountServiceFacade accountServiceFacade;



    @RequestMapping(value = "/loginByPassword", method = RequestMethod.POST)
    public String loginByPassword(@RequestParam Map<String,String> params) {
        AccountPasswordAssembler assembler = new AccountPasswordAssembler();
        AccountPasswordDTO account = assembler.toDTO(params);

        String token = "";
        // Execute business logic
        try {
            token = accountServiceFacade.loginByPassword(account);
        } catch (Exception e) {
            // throw new AccountLoginFailedException();
        }

        return token;
    }

    @RequestMapping(value = "/loginBySMSCode", method = RequestMethod.POST)
    public String loginBySMSCode(@RequestParam Map<String, String> params) {
        AccountSMSCodeAssembler assembler = new AccountSMSCodeAssembler();
        AccountSMSCodeDTO accountSMSCodeDTO = assembler.toDTO(params);

        String token = "";
        try {
            token = accountServiceFacade.loginBySMSCode(accountSMSCodeDTO);

        } catch (Exception e) {
            //
        }

        return token;
    }

    @RequestMapping(value = "/loginByWechat", method = RequestMethod.POST)
    public String loginByWechat(@RequestParam Map<String, String> params) {

        AccountWechatAssembler assembler = new AccountWechatAssembler();
        AccountWechatDTO accountWechatDTO = assembler.toDTO(params);

        String token = "";
        try {
            token = accountServiceFacade.loginByWechat(accountWechatDTO);
        } catch (Exception e) {


        }

        return token;
    }

    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    public void forgetPassword(@RequestParam Map<String, String> params) {

        AccountPasswordForgotAssembler assembler = new AccountPasswordForgotAssembler();
        AccountPasswordForgotDTO accountPasswordForgotDTO = assembler.toDTO(params);

        try {
            accountServiceFacade.changePassword(accountPasswordForgotDTO);
        } catch (Exception e) {
            //
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestParam Map<String, String> params) {

        AccountRegisterAssembler assembler = new AccountRegisterAssembler();
        AccountRegisterDTO accountRegisterDTO = assembler.toDTO(params);

        try {
            accountServiceFacade.register(accountRegisterDTO);
        } catch (Exception e) {
            //
        }

    }

    public void setAccountServiceFacade(AccountServiceFacade accountServiceFacade) {
        this.accountServiceFacade = accountServiceFacade;
    }

}
