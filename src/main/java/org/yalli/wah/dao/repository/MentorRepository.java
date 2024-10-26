package org.yalli.wah.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.yalli.wah.dao.entity.MentorEntity;

import java.util.Optional;


public interface MentorRepository extends JpaRepository<MentorEntity, Long>, JpaSpecificationExecutor<MentorEntity> {
    Optional<MentorEntity> findByEmail(String email);
}
