package com.crossover.compliance.service;

import com.crossover.compliance.domain.User;
import com.crossover.compliance.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getManagers(){
        List<User> users = userRepository.findAll();
        return users.stream().filter(user -> user.getRoles().contains("MANAGER")).collect(Collectors.toList());
    }
}
