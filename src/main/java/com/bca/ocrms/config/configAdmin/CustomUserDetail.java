package com.bca.ocrms.config.configAdmin;

import com.bca.ocrms.model.admin.AdminRegister;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {
 private final AdminRegister adminRegister;

    public CustomUserDetail(AdminRegister adminRegister) {
        this.adminRegister = adminRegister;
        com.bca.ocrms.component.adminAuthorize.AdminRegisters.setAdminRegister(adminRegister);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
   //get the user password
    @Override
    public String getPassword() {
        return adminRegister.getPassword();
    }
    //get teh email
    @Override
    public String getUsername() {
        return adminRegister.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
