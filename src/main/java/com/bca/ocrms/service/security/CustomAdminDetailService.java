package com.bca.ocrms.service.security;

import com.bca.ocrms.config.configAdmin.CustomUserDetail;
import com.bca.ocrms.model.admin.AdminRegister;
import com.bca.ocrms.repo.admin.AdminRegisterRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/4/22
 */
@Service
public class CustomAdminDetailService implements UserDetailsService {
    private final AdminRegisterRepo adminRegisterRepo;

    public CustomAdminDetailService(AdminRegisterRepo adminRegisterRepo) {
        this.adminRegisterRepo = adminRegisterRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find the user name
        AdminRegister userByEmail=adminRegisterRepo.findUserByEmail(username);
        //if user by email null
        if(userByEmail==null){
            //print the user not fount expection
            throw new UsernameNotFoundException("User not found!!!");
        }
        //return the custome user
        return new CustomUserDetail(userByEmail);
    }
}
