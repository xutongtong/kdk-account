package com.kaidike.account.domain.model.sms;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SMSCodeRepository extends JpaRepository<SMSCode, Long> {

    SMSCode findByCountryCodeAndMobileAndType(String countryCode, String mobile, String type);

}
