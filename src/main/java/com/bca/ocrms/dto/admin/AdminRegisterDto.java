package com.bca.ocrms.dto.admin;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRegisterDto {
    private Integer id;
    private String name;
    private String email;
    private String contact;
    private String idNumber;
    private String post;
    private String password;
}
