package com.example.Digital.Library.repository;

import com.example.Digital.Library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepo extends JpaRepository<Member, UUID> {
    Optional<Member> findByUsername(String username);
}
