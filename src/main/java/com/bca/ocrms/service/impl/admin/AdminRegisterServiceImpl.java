package com.bca.ocrms.service.impl.admin;

import com.bca.ocrms.dto.admin.AdminRegisterDto;
import com.bca.ocrms.dto.user.RegisterDto;
import com.bca.ocrms.enums.UserStatus;
import com.bca.ocrms.model.admin.AdminRegister;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.repo.admin.AdminRegisterRepo;
import com.bca.ocrms.service.admin.AdminRegisterService;
import com.bca.ocrms.service.impl.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/4/22
 */
@Service
public class AdminRegisterServiceImpl implements AdminRegisterService {
    private final AdminRegisterRepo adminRegisterRepo;
    private final UserServiceImpl userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminRegisterServiceImpl(AdminRegisterRepo adminRegisterRepo, UserServiceImpl userService, BCryptPasswordEncoder passwordEncoder) {
        this.adminRegisterRepo = adminRegisterRepo;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AdminRegisterDto save(AdminRegisterDto adminRegisterDto) throws ParseException {
        AdminRegister adminRegister=new AdminRegister();
        adminRegister.setId(adminRegisterDto.getId());
        adminRegister.setName(adminRegisterDto.getName());
        adminRegister.setAddress(adminRegisterDto.getAddress());
        adminRegister.setGender(adminRegisterDto.getGender());
        adminRegister.setEmail(adminRegisterDto.getEmail());
        adminRegister.setContact(adminRegisterDto.getContact());
        adminRegister.setPost(adminRegisterDto.getPost());
        adminRegister.setIdNumber(adminRegisterDto.getIdNumber());

       AdminRegister adminRegister1=adminRegisterRepo.save(adminRegister);

        User user = new User();
        user.setEmail(adminRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));
        user.setUserStatus(UserStatus.ADMIN);
        userService.save(user);
        return AdminRegisterDto.builder().id(adminRegister1.getId()).build();
    }

    @Override
    public List<AdminRegisterDto> findAll() {
        return null;
    }

    @Override
    public AdminRegisterDto findById(Integer integer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
    public AdminRegister findAdminByEmail(String email){
        return adminRegisterRepo.findAdminRegisterByEmail(email);
    }
}
