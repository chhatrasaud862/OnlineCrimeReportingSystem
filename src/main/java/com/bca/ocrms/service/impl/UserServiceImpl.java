package com.bca.ocrms.service.impl;

import com.bca.ocrms.model.user.User;
import com.bca.ocrms.repo.UserRepo;
import com.bca.ocrms.service.UserService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/5/22
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) throws ParseException {
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
