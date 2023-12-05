package com.is1di.quoteapi.service;

import com.is1di.quoteapi.exception.NotFoundException;
import com.is1di.quoteapi.message.MessageBase;
import com.is1di.quoteapi.model.entity.User;
import com.is1di.quoteapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getByLogin(String login) {
        return userRepository.findById(login)
                .orElseThrow(() -> new NotFoundException(
                        new MessageBase(MessageBase.MessageMethod.USER_ERROR_NOT_FOUND)
                ));
    }
}
