package com.example.Digital.Library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Entity
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String fname;
    private String lname;
    private String mobile;
    private String email;
    private enum Sstatus{
        ACTIVE,
        NOT_ACTIVE
    }
}
