//package com.example.Digital.Library.service;
//
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//public class AuthenticationService {
//    private static final String AUTH_TOKEN_HEADER_NAME="LIB-API_KEY";
//    private static final String AUTH_TOKEN="E-Lib-Gfg-JDBL-75";
//    public static Authentication getAuthetication(HttpServletRequest req){
//        String apiKey=req.getHeader("some-name");
//        if(apiKey==null|| !apiKey.equals("ABC")){
//            throw new RuntimeException("Exception");
//        }
//        return new UsernamePasswordAuthenticationToken();
//    }
//}
