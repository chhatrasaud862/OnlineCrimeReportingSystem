package com.bca.ocrms.service.user;

import com.bca.ocrms.dto.UserDto;
import com.bca.ocrms.model.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
   UserDto saveUser(UserDto userDto);
   List<UserDto> findAll();
   UserDto findById(Integer id);
   void deleteUserById(Integer id);

}
