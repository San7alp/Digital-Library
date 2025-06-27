package com.example.Digital.Library.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final String PASSWORD="$2a$12$54x/Tc5HpD9ocQObiRrK2ORbzGlbJgEdpKBXu1BHjQOCGb16njjAy";
    private List<User> userList= Arrays.asList(
            new User("member",PASSWORD, Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER"))),
            new User("Librarian", PASSWORD, List.of(new SimpleGrantedAuthority("ROLE_LIBRARIAN")))

    );
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userList.stream().filter(user->user.getUsername().equals(username)).findFirst().orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
