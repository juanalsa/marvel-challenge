package com.test.api.marvel_challenge.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtService {
    public String generateToken(UserDetails user, Map<String, Object> stringObjectMap) {
        return null;
    }
}
