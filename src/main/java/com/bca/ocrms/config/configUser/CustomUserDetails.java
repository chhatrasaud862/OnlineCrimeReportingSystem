package com.bca.ocrms.config.configUser;

import com.bca.ocrms.model.user.register.Register;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final Register register;

    public CustomUserDetails(Register register) {
        this.register = register;
        com.bca.ocrms.component.userAuthorize.Register.setRegister(register);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Role_USER"));
    }
   //get the user password
    @Override
    public String getPassword() {
        return register.getPassword();
    }
    //get teh email
    @Override
    public String getUsername() {
        return register.getEmail();
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
