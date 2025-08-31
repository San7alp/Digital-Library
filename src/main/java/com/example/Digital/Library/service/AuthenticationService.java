//package com.example.Digital.Library.service;
//
//import com.example.Digital.Library.Exception.IncorrectCredentialException;
//import com.example.Digital.Library.dto.AuthDTO;
//import com.example.Digital.Library.entity.Member;
//import com.example.Digital.Library.repository.MemberRepo;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
//@Slf4j
//public class AuthenticationService {
//  private final MemberRepo memberRepo;
//  private final PasswordEncoder passwordEncoder;
//    @Autowired
//    public AuthenticationService(MemberRepo memberRepo, PasswordEncoder passwordEncoder) {
//        this.memberRepo = memberRepo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public Member login(AuthDTO authDTO){
//
//        Optional<Member>memberOptional=this.memberRepo.findByUsername(authDTO.getUsername());
//        if(memberOptional.isEmpty()){
//            throw new UsernameNotFoundException("User not found");
//        }
//        Member m=memberOptional.get();
//        if(!this.passwordEncoder.matches(authDTO.getPassword(), m.getPassword())){
//                log.info("Password is incorrect");
//                throw new IncorrectCredentialException("Incorrect Password");
//        }
//        return m;
//    }
//}
