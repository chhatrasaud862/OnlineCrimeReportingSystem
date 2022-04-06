package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.dto.user.RegisterDto;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.model.user.register.Register;
import com.bca.ocrms.repo.user.RegisterRepo;
import com.bca.ocrms.service.impl.UserServiceImpl;
import com.bca.ocrms.service.user.RegisterService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepo registerRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;

    public RegisterServiceImpl(RegisterRepo registerRepo, BCryptPasswordEncoder passwordEncoder, UserServiceImpl userService) {
        this.registerRepo = registerRepo;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }
    @Override
    public RegisterDto save(RegisterDto registerDto) throws ParseException {
        Register entity=new Register();
        entity.setId(registerDto.getId());
        entity.setName(registerDto.getName());
        entity.setNationalIdNumber(registerDto.getNationalIdNumber());
        entity.setEmail(registerDto.getEmail());
        entity.setMobileNumber(registerDto.getMobileNumber());
        entity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
         entity=registerRepo.save(entity);

        User user = new User();
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        userService.save(user);
         return registerDto;
    }

    @Override
    public List<RegisterDto> findAll() {
        return null;
    }

    @Override
    public RegisterDto findById(Integer integer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
