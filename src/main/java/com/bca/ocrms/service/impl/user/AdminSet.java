package com.bca.ocrms.service.impl.user;

import com.bca.ocrms.enums.UserStatus;
import com.bca.ocrms.model.user.User;
import com.bca.ocrms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author CHHATRA SAUD
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 17/06/2022
 */
@Component
public class AdminSet {
    @Autowired
    private UserRepo usrRepo;
    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        usrRepo.save(new User(1,"admin@gmail.com","$2a$10$beUMhB2cw981iZtl3c5tbeNA60XGl/asbKYDqpaP0UDaLip81M4xi", UserStatus.ADMIN));
    }

}
