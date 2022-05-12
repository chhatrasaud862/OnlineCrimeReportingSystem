package com.bca.ocrms.components;

import com.bca.ocrms.enums.UserStatus;
import com.bca.ocrms.model.admin.AdminRegister;
import com.bca.ocrms.model.user.register.Register;

/**
 * @author CHHATRA SAUD
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 2022-04-06
 */
public class AuthorizeUser {
    private static Register register;
    private static AdminRegister adminRegister;
    private static UserStatus userStatus;
    public static Register getRegister() {
        return register;
    }

    public static void setRegister(Register register) {
        AuthorizeUser.register = register;
        AuthorizeUser.userStatus=userStatus.USER;

    }

    public static AdminRegister getAdminRegister() {
        return adminRegister;
    }

    public static void setAdminRegister(AdminRegister adminRegister) {
        AuthorizeUser.adminRegister = adminRegister;
        AuthorizeUser.userStatus=userStatus.ADMIN;
    }

    public static UserStatus getUserStatus() {
        return userStatus;
    }

    public static void setUserStatus(UserStatus userStatus) {
        AuthorizeUser.userStatus = userStatus;
    }

}
