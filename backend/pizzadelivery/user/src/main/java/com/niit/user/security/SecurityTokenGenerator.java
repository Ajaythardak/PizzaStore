package com.niit.user.security;



import com.niit.user.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(User user);

}
