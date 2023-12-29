package com.application.webapi.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.application.webapi.model.User;
import com.application.webapi.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;
    public UserService(UserRepository userRepository,KafkaProducer kafkaProducer) {
        this.userRepository = userRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        if(userRepository.existsById(user.getId())){
            throw new RuntimeException("User ID Exist");
        }
         user.setBalance(new BigDecimal("0"));
         kafkaProducer.sendMessage("ProduceTopic", user);
         return userRepository.save(user);
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
