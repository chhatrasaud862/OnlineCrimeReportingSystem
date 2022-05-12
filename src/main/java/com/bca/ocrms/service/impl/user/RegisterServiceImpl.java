package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.components.FileStorageComponent;
import com.bca.ocrms.dto.ResponseDto;
import com.bca.ocrms.dto.user.RegisterDto;
import com.bca.ocrms.enums.UserStatus;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.model.user.register.Register;
import com.bca.ocrms.repo.user.RegisterRepo;
import com.bca.ocrms.service.impl.UserServiceImpl;
import com.bca.ocrms.service.user.RegisterService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    private final FileStorageComponent fileStorageComponent;

    public RegisterServiceImpl(RegisterRepo registerRepo, BCryptPasswordEncoder passwordEncoder, UserServiceImpl userService, FileStorageComponent fileStorageComponent) {
        this.registerRepo = registerRepo;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.fileStorageComponent = fileStorageComponent;
    }
    @Override
    public RegisterDto save(RegisterDto registerDto) throws ParseException, IOException {
        Register register = new Register();
        ResponseDto responseDto = fileStorageComponent.storeFile(registerDto.getMultipartFile());
        User user = new User();
        if (responseDto.isStatus()) {
            register.setId(registerDto.getId());
            register.setName(registerDto.getName());
            register.setNationalIdNumber(registerDto.getNationalIdNumber());
            register.setEmail(registerDto.getEmail());
            register.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(registerDto.getDateOfBirth()));
            register.setGender(registerDto.getGender());
            register.setMobileNumber(registerDto.getMobileNumber());
            register.setPhoto(responseDto.getMessage());
            register = registerRepo.save(register);
            user.setEmail(registerDto.getEmail());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            user.setUserStatus(UserStatus.USER);
            userService.save(user);
        }
//        return RegisterDto.builder()
//                .id(register.getId())
//                .name(register.getName())
//                .nationalIdNumber(register.getNationalIdNumber())
//                .dateOfBirth(String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(register.getDateOfBirth()))))
//                .gender(register.getGender())
//                .mobileNumber(register.getMobileNumber())
//                .photo(register.getPhoto())
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .build();
        return registerDto;

    }

    @Override
    public List<RegisterDto> findAll() throws IOException {
        List<RegisterDto> registerList = new ArrayList<>();
        List<Register> registerList1 = registerRepo.findAll();
        for (Register register : registerList1){
            registerList.add(RegisterDto.builder()
                    .id(register.getId())
                    .name(register.getName())
                    .mobileNumber(register.getMobileNumber())
                    .dateOfBirth(String.valueOf(register.getDateOfBirth()))
                    .photo(fileStorageComponent.base64Encoded(register.getPhoto()))
                    .email(register.getEmail())
                    .gender(register.getGender())
                    .nationalIdNumber(register.getNationalIdNumber())
                    .build());

        }
        return registerList;
    }

    @Override
    public RegisterDto findById(Integer integer) throws IOException {
        Register register = null;
        Optional<Register>optionalRegister=registerRepo.findById(integer);
        if (optionalRegister.isPresent())
        {
            register=optionalRegister.get();
            return RegisterDto.builder()
                    .id(register.getId())
                    .name(register.getName())
                    .mobileNumber(register.getMobileNumber())
                    .dateOfBirth(String.valueOf(register.getDateOfBirth()))
                    .photo(fileStorageComponent.base64Encoded(register.getPhoto()))
                    .email(register.getEmail())
                    .gender(register.getGender())
                    .nationalIdNumber(register.getNationalIdNumber())
                    .build();
        }
        return RegisterDto.builder().id(register.getId()).build();
    }

    @Override
    public void deleteById(Integer integer) {

    }
    public Register findRegisterByEmail(String email){
        return registerRepo.findUserByEmail(email);
    }
}
