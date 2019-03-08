package com.kaidike.account.domain.model.sms;

public interface SMSCodeRepository {

    SMSCode findOne(String countryCode, String mobile, String type);

}
