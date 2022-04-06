package com.bca.ocrms.service.security;


import com.bca.ocrms.config.configUser.CustomUserDetails;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.model.user.register.Register;
import com.bca.ocrms.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
   private final UserRepo userRepo;

    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find the user name
      User userByEmail=  userRepo.findUserByEmail(username);
        //if user by email null
        if(userByEmail==null){
            //print the user not fount expection
            throw new UsernameNotFoundException("User not found!!!");
        }
        //return the custome user
        return new CustomUserDetails(userByEmail);
    }
}
