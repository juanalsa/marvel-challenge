package com.test.api.marvel_challenge.persistence.repository;

import com.test.api.marvel_challenge.persistence.entity.UserInteractionLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInteractionLogRepository extends JpaRepository<UserInteractionLog, Long> {
    Page<UserInteractionLog> findByUsername(Pageable pageable, String username);
}
