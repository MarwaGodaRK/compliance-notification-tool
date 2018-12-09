package com.crossover.compliance.service;

import com.crossover.compliance.security.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {

    public SecurityUserDetails getSessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (SecurityUserDetails)authentication.getPrincipal();
    }
}
