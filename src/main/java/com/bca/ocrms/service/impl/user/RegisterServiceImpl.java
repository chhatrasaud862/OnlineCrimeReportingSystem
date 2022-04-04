package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.dto.user.RegisterDto;
import com.bca.ocrms.model.user.register.Register;
import com.bca.ocrms.repo.user.RegisterRepo;
import com.bca.ocrms.service.user.RegisterService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepo registerRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegisterServiceImpl(RegisterRepo registerRepo, BCryptPasswordEncoder passwordEncoder) {
        this.registerRepo = registerRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public RegisterDto save(RegisterDto registerDto) {
        Register entity=new Register();
        entity.setId(registerDto.getId());
        entity.setName(registerDto.getName());
        entity.setNationalIdNumber(registerDto.getNationalIdNumber());
        entity.setEmail(registerDto.getEmail());
        entity.setMobileNumber(registerDto.getMobileNumber());
        entity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
         entity=registerRepo.save(entity);
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
