package com.kaidike.account.domain.model.user;

public interface UserRepository {

    User findUser(Long id);

    void save(User user);
}
