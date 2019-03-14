package com.kaidike.account.domain.model.session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KDKSessionRepository extends JpaRepository<KDKSession, Long> {

    KDKSession save(String value);

}
