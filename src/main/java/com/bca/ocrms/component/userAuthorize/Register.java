package com.bca.ocrms.component.userAuthorize;

public class Register {
    private static com.bca.ocrms.model.user.register.Register register;
   //user get the login id
    public static com.bca.ocrms.model.user.register.Register getRegister() {
        return register;
    }

    public static void setRegister(com.bca.ocrms.model.user.register.Register register)
    {
        Register.register = register;
    }
}
