package com.test.api.marvel_challenge.persistence.repository;

import com.test.api.marvel_challenge.persistence.entity.UserInteractionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInteractionLogRepository extends JpaRepository<UserInteractionLog, Long> {
}
