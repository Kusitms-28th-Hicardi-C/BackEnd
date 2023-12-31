package com.example.hicardi.domain.user.repository;

import com.example.hicardi.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    boolean existsByBusinessNumber(String businessNumber);
    boolean existsByLoginId(String keyword);
    User findByLoginId(String loginId);

    User findByMemberId(Long memberId);
}
