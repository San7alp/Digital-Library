package com.example.Digital.Library.entity;

import com.example.Digital.Library.enums.Subscription;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;
@Getter
@Setter
@Entity
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String fname;
    private String lname;
    private String mobile;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;
    @Email
    @Column(unique = true)
    private String email;
    @Builder.Default
    private Subscription status=Subscription.INACTIVE;


}
