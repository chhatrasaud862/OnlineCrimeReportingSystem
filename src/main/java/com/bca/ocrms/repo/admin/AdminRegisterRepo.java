package com.bca.ocrms.repo.admin;

import com.bca.ocrms.model.admin.AdminRegister;
import com.bca.ocrms.model.user.register.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/4/22
 */
@Repository
public interface AdminRegisterRepo extends JpaRepository<AdminRegister,Integer> {
    public AdminRegister findAdminRegisterByEmail(String email);

}
