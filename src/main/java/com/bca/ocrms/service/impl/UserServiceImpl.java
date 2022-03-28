package com.bca.ocrms.service.impl;

import com.bca.ocrms.dto.UserDto;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.repo.UserRepo;
import com.bca.ocrms.service.user.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User entity=new User();
        entity.setId(userDto.getId());
        entity.setName(userDto.getName());
        entity.setEmail(userDto.getEmail());
        entity.setMobileNumber(userDto.getMobileNumber());
        entity.setPassword(userDto.getPassword());
        entity=userRepo.save(entity);

        return userDto;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepo.findByEmail(username);
       if(user==null)
       {
           throw new UsernameNotFoundException("Invalid userName or password");
       }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword());
    }

    private Collection<? extends GrantedAuthority> mapRolesTOAuthorities(Collection<User> users)
    {
      return  users.stream().map(
                user -> new SimpleGrantedAuthority(user.getRole))
                .collect(Collectors.toList());
    }
}
