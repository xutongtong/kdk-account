package com.kaidike.account.domain.model.sns;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WechatUserRepository extends JpaRepository<WechatUser, Long> {

    WechatUser save(WechatUser wechatUser);

}
