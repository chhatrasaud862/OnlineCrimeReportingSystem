package com.bca.ocrms.component.adminAuthorize;

import com.bca.ocrms.model.admin.AdminRegister;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/4/22
 */
public class AdminRegisters {
    private static AdminRegister adminRegister;
    //user get the login id
    public static AdminRegister getAdminRegister()
    {
        return adminRegister;
    }
    public static void setAdminRegister(AdminRegister adminRegister)
    {
        AdminRegisters.adminRegister=adminRegister;
    }
}
