package com.bca.ocrms.service.impl.admin;

import com.bca.ocrms.components.FileStorageComponent;
import com.bca.ocrms.dto.ResponseDto;
import com.bca.ocrms.dto.admin.AdminRegisterDto;
import com.bca.ocrms.enums.UserStatus;
import com.bca.ocrms.model.admin.AdminRegister;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.repo.UserRepo;
import com.bca.ocrms.repo.admin.AdminRegisterRepo;
import com.bca.ocrms.service.admin.AdminRegisterService;
import com.bca.ocrms.service.impl.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    private final FileStorageComponent fileStorageComponent;

    public AdminRegisterServiceImpl(AdminRegisterRepo adminRegisterRepo, UserServiceImpl userService, BCryptPasswordEncoder passwordEncoder, FileStorageComponent fileStorageComponent) {
        this.adminRegisterRepo = adminRegisterRepo;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.fileStorageComponent = fileStorageComponent;
    }

    @Override
    public AdminRegisterDto save(AdminRegisterDto adminRegisterDto) throws ParseException, IOException {
        AdminRegister adminRegister=new AdminRegister();
        ResponseDto responseDto=FileStorageComponent.storeFile(adminRegisterDto.getMultipartFile());
        if(responseDto.isStatus()) {
            adminRegister.setId(adminRegisterDto.getId());
            adminRegister.setProvinceName(adminRegisterDto.getProvinceNumber());
            adminRegister.setDistrictName(adminRegisterDto.getDistrictName());
            adminRegister.setStationName(adminRegisterDto.getStationName());
            adminRegister.setEmail(adminRegisterDto.getEmail());
            adminRegister.setStationName(adminRegisterDto.getStationName());
            adminRegister.setRole(adminRegisterDto.getRole());
            adminRegister.setAdminName(adminRegisterDto.getAdminName());
            adminRegister.setPhoto(responseDto.getMessage());

            AdminRegister adminRegister1 = adminRegisterRepo.save(adminRegister);

            User user = new User();
            user.setEmail(adminRegisterDto.getEmail());
            user.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));
            user.setUserStatus(UserStatus.ADMIN);
            userService.save(user);
        }
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
    public AdminRegister findAdminByEmail(String email){
        return adminRegisterRepo.findAdminRegisterByEmail(email);
    }


}
