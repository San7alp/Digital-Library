//package com.example.Digital.Library.service;
//
//import com.example.Digital.Library.entity.Member;
//import com.example.Digital.Library.repository.MemberRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.awt.*;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    private final MemberRepo memberRepo;
//    @Autowired
//    public MyUserDetailsService(MemberRepo memberRepo) {
//        this.memberRepo = memberRepo;
//    }
//
//    //    private final String PASSWORD="$2a$12$54x/Tc5HpD9ocQObiRrK2ORbzGlbJgEdpKBXu1BHjQOCGb16njjAy";
////    private List<User> userList= Arrays.asList(
////            new User("member",PASSWORD, Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER"))),
////            new User("Librarian", PASSWORD, List.of(new SimpleGrantedAuthority("ROLE_LIBRARIAN")))
////
////    );
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Member>member=this.memberRepo.findByUsername(username);
//        if(member.isEmpty()){
//            throw new UsernameNotFoundException(String.format("Username: %s is not found",username));
//        }
//        Member m=member.get();
//        return User.builder()
//                .username(m.getUsername())
//                .password(m.getPassword())
//                .roles(m.getRole())
//                .build();
//
//    }
//}
