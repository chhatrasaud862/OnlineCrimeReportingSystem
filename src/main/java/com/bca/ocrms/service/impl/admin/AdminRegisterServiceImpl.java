package com.bca.ocrms.service.impl.admin;

import com.bca.ocrms.dto.admin.AdminRegisterDto;
import com.bca.ocrms.model.admin.AdminRegister;
import com.bca.ocrms.repo.admin.AdminRegisterRepo;
import com.bca.ocrms.service.admin.AdminRegisterService;
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

    private final BCryptPasswordEncoder passwordEncoder;

    public AdminRegisterServiceImpl(AdminRegisterRepo adminRegisterRepo, BCryptPasswordEncoder passwordEncoder) {
        this.adminRegisterRepo = adminRegisterRepo;
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
        entity.setPassword(adminRegisterDto.getPassword());

        entity=adminRegisterRepo.save(entity);
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
