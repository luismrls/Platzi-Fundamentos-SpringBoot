package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final Log LOGGER = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public void saveTransactional(List<User> listUsers) {
        listUsers.stream()
                .peek(LOGGER::info)
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void remove(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User user, Long id) {
        Optional<User> userUpdated = userRepository.findById(id).map(userDB -> {
           userDB.setName(user.getName());
           userDB.setEmail(user.getEmail());
           userDB.setBirthDate(user.getBirthDate());
           return userRepository.save(user);
        });
        return userUpdated.get();
    }
}
