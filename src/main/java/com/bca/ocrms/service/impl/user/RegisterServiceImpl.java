package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.dto.user.RegisterDto;
import com.bca.ocrms.enums.UserStatus;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.model.user.complain.Complain;
import com.bca.ocrms.model.user.register.Register;
import com.bca.ocrms.repo.user.RegisterRepo;
import com.bca.ocrms.service.impl.UserServiceImpl;
import com.bca.ocrms.service.user.RegisterService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Register register = Register.builder()
                .id(registerDto.getId())
                .name(registerDto.getName())
                .nationalIdNumber(registerDto.getNationalIdNumber())
                .gender(registerDto.getGender())
                .email(registerDto.getEmail())
                .mobileNumber(registerDto.getMobileNumber())
                .build();
        //save into database
        Register register1=registerRepo.save(register);

        //save into user table
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setUserStatus(UserStatus.USER);
        userService.save(user);

        return RegisterDto.builder().id(register1.getId()).build();
    }

    @Override
    public List<RegisterDto> findAll() {
        List<RegisterDto> registerList = new ArrayList<>();
        List<Register> registerList1 = registerRepo.findAll();
        for (Register register : registerList1){
            registerList.add(RegisterDto.builder()
                    .id(register.getId())
                    .name(register.getName())
                    .mobileNumber(register.getMobileNumber())
                    .email(register.getEmail())
                    .gender(register.getGender())
                    .nationalIdNumber(register.getNationalIdNumber())
                    .build());

        }
        return registerList;
    }

    @Override
    public RegisterDto findById(Integer integer) {
        Register register;
        Optional<Register>optionalRegister=registerRepo.findById(integer);
        if (optionalRegister.isPresent())
        {
            register=optionalRegister.get();
            return RegisterDto.builder()
                    .id(register.getId())
                    .name(register.getName())
                    .mobileNumber(register.getMobileNumber())
                    .email(register.getEmail())
                    .gender(register.getGender())
                    .nationalIdNumber(register.getNationalIdNumber())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
    public Register findRegisterByEmail(String email){
        return registerRepo.findUserByEmail(email);
    }
}
