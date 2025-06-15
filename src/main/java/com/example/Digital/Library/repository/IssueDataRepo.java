package com.example.Digital.Library.repository;

import com.example.Digital.Library.entity.IssueData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IssueDataRepo extends JpaRepository<IssueData, UUID> {
}
