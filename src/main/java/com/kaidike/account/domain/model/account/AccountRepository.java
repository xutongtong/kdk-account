package com.kaidike.account.domain.model.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByCountryCodeAndMobile(String countryCode, String mobile);

    Account findByUnionID(String unionID);

    @Query("UPDATE Account SET password=?2 WHERE id=?1")
    void updatePassword(Long id, String password);

    Account save(Account account);
}
