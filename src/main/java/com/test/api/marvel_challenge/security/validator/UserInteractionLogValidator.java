package com.test.api.marvel_challenge.security.validator;

import com.test.api.marvel_challenge.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("interactionLogValidator")
public class UserInteractionLogValidator {

    @Autowired
    private AuthenticationService authenticationService;

    public boolean validate(String username) {
        String userLoggedIn = authenticationService.getUserLoggedIn().getUsername();
        return userLoggedIn.equals(username);
    }
}
