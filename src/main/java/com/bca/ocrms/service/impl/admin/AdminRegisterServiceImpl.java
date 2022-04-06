package com.bca.ocrms.service.impl.admin;

import com.bca.ocrms.dto.admin.AdminRegisterDto;
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
        AdminRegister entity=new AdminRegister();
        entity.setId(adminRegisterDto.getId());
        entity.setName(adminRegisterDto.getName());
        entity.setEmail(adminRegisterDto.getEmail());
        entity.setContact(adminRegisterDto.getContact());
        entity.setPost(adminRegisterDto.getPost());
        entity.setIdNumber(adminRegisterDto.getIdNumber());
        entity.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));

        entity=adminRegisterRepo.save(entity);

        User user = new User();
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        userService.save(user);

        return adminRegisterDto;
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
}
