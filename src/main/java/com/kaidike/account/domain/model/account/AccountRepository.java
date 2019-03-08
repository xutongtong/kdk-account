package com.kaidike.account.domain.model.account;

public interface AccountRepository {

    Account findAccount(String countryCode, String mobile);

    Account findAccount(String unionID);

    void updatePassword(Long id, String password);

    void save(Account account);
}
