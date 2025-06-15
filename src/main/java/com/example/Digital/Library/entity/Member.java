package com.example.Digital.Library.entity;

import com.example.Digital.Library.enums.Subscription;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @Email
    @Column(unique = true)
    private String email;

    private Subscription status=Subscription.INACTIVE;
}
