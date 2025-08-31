//package com.example.Digital.Library.controller;
//
//import com.example.Digital.Library.Exception.IncorrectCredentialException;
//import com.example.Digital.Library.dto.AuthDTO;
//import com.example.Digital.Library.entity.Member;
//import com.example.Digital.Library.service.AuthenticationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//    private final AuthenticationService authenticationService;
//    @Autowired
//    public AuthController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//    @PostMapping("/login")
//    private ResponseEntity<Member>login(@RequestBody AuthDTO authDTO){
//        try{
//            Member member=this.authenticationService.login(authDTO);
//            return new ResponseEntity<>(member, HttpStatus.OK);
//        }
//        catch(UsernameNotFoundException| IncorrectCredentialException exception){
//            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
//        }
//    }
//}
