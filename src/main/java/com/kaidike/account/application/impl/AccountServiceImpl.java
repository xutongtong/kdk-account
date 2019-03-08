package com.kaidike.account.application.impl;

import com.kaidike.account.application.AccountService;
import com.kaidike.account.domain.model.account.Account;
import com.kaidike.account.domain.model.account.AccountRepository;
import com.kaidike.account.domain.model.session.KDKSessionRepository;
import com.kaidike.account.domain.model.sms.SMSCode;
import com.kaidike.account.domain.model.sms.SMSCodeRepository;
import com.kaidike.account.domain.model.sns.WechatUser;
import com.kaidike.account.domain.model.sns.WechatUserRepository;
import com.kaidike.account.domain.model.user.User;
import com.kaidike.account.domain.model.user.UserRepository;
import com.kaidike.account.domain.utils.KDKNumber;
import com.kaidike.account.interfaces.account.facade.dto.*;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private KDKSessionRepository kdkSessionRepository;

    private SMSCodeRepository smsCodeRepository;

    private WechatUserRepository wechatUserRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository, KDKSessionRepository kdkSessionRepository, SMSCodeRepository smsCodeRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.kdkSessionRepository = kdkSessionRepository;
        this.smsCodeRepository = smsCodeRepository;
    }

    @Override
    public String loginByPassword(AccountPasswordDTO accountPasswordDTO) {

        String countryCode = accountPasswordDTO.getCountryCode();
        String mobile = accountPasswordDTO.getMobile();
        String password = accountPasswordDTO.getPassword();

        Account account = accountRepository.findAccount(countryCode, mobile);

        if ( !account.isPasswordEqual(password) ) {
            // throw new Exception();
        }

        String token = this.login(countryCode, mobile);

        return token;
    }

    @Override
    public String loginBySMSCode(AccountSMSCodeDTO accountSMSCodeDTO) {

        String countryCode = accountSMSCodeDTO.getCountryCode();
        String mobile = accountSMSCodeDTO.getMobile();
        String code = accountSMSCodeDTO.getSmsCode();
        String type = "login";

        SMSCode smsCode = smsCodeRepository.findOne(countryCode, mobile, type);

        if (smsCode.isExpired()) {
            // throw new Exception();
        }

        if ( !smsCode.isEqual(code) ) {
            // throw new Exception();
        }

        String token = this.login(countryCode, mobile);

        return token;
    }

    @Override
    public String loginByWechat(AccountWechatDTO accountWechatDTO) {

        String unionID = accountWechatDTO.getUnionID();

        Account account = accountRepository.findAccount(unionID);
        Long accountID = account.getId();

        if (accountID != 0) {
            User user = userRepository.findUser(accountID);

            // Serializable user
            String value = user.toString();
            String token = kdkSessionRepository.save(value);

            return token;
        }

        // create account
        Account newAccount = new Account();

        newAccount.setUnionID(unionID);

        accountRepository.save(newAccount);

        String nickName = accountWechatDTO.getNickname();
        String avatar = accountWechatDTO.getAvatar();
        String sex = accountWechatDTO.getSex();
        String country = accountWechatDTO.getCountry();
        String province = accountWechatDTO.getProvince();
        String city = accountWechatDTO.getCity();


        WechatUser wechatUser = new WechatUser(
            accountWechatDTO.getOpenid(),
            accountWechatDTO.getUnionID(),
            nickName,
            avatar,
            sex,
            country,
            province,
            city
        );

        wechatUserRepository.save(wechatUser);

        User user = new User(nickName, avatar);
        user.setSex(sex);
        user.setCountry(country);
        user.setProvince(province);
        user.setCity(city);

        userRepository.save(user);

        String loginToken = kdkSessionRepository.save(user.toString());

        return loginToken;
    }

    @Override
    public void changePassword(AccountPasswordForgotDTO accountPasswordForgotDTO) {

        String countryCode = accountPasswordForgotDTO.getCountryCode();
        String mobile = accountPasswordForgotDTO.getMobile();
        String code = accountPasswordForgotDTO.getSmsCode();
        String password = accountPasswordForgotDTO.getPassword();
        String type = "changePassword";


        SMSCode smsCode = smsCodeRepository.findOne(countryCode, mobile, type);

        if (smsCode.isExpired()) {
            // throw new Exception();
        }

        if ( !smsCode.isEqual(code) ) {
            // throw new Exception();
        }

        Account account = accountRepository.findAccount(countryCode, mobile);
        Long accountID = account.getId();

        if ( accountID == 0 ) {
            // throw new Exception();
        }

        try {
            accountRepository.updatePassword(accountID, password);
        } catch (Exception e) {
            //
        }
    }

    @Override
    public void register(AccountRegisterDTO accountRegisterDTO) {
        String countryCode = accountRegisterDTO.getCountryCode();
        String mobile = accountRegisterDTO.getMobile();
        String code = accountRegisterDTO.getSmsCode();
        String password = accountRegisterDTO.getPassword();
        String type = "register";

        SMSCode smsCode = smsCodeRepository.findOne(countryCode, mobile, type);

        if (smsCode.isExpired()) {
            // throw new Exception();
        }

        if ( !smsCode.isEqual(code) ) {
            // throw new Exception();
        }

        try {
            Account account = new Account();

            int length = 4;
            String salt = KDKNumber.randomStr(length);

            account.setCountryCode(countryCode);
            account.setMobile(mobile);
            account.setSalt(salt);

            String encryptedPassword = account.encryptPassword(password);
            account.setPassword(encryptedPassword);

            accountRepository.save(account);

            String nickname = "";
            String avatar = "";

            // 这里有及连关系
            User user = new User(nickname, avatar);
            userRepository.save(user);

        } catch (Exception e) {

        }

    }

    private String login(String countryCode, String mobile) {
        Account account = accountRepository.findAccount(countryCode, mobile);

        Long id = account.getId();
        User user = userRepository.findUser(id);

        // Serializable user
        String value = user.toString();
        String token = kdkSessionRepository.save(value);

        return token;
    }

}
