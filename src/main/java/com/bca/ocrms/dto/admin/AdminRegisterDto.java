package com.bca.ocrms.dto.admin;

import com.bca.ocrms.enums.Gender;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRegisterDto {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String contact;
    private String dateOfBirth;
    private Gender gender;
    private String idNumber;
    private String post;
    private String photo;
    private MultipartFile multipartFile;
    private String password;
}
