package com.bca.ocrms.dto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDto {
    private int id;
    private String name;
    private String email;
    private String mobileNumber;
    private String password;
}
