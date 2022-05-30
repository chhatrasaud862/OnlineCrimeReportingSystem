package com.bca.ocrms.dto.admin;

import com.bca.ocrms.enums.Gender;
import com.bca.ocrms.enums.Role;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRegisterDto {
    private Integer id;
    private String provinceNumber;
    private String districtName;
    private String email;
    private String stationName;
    private String adminName;
    private Role role;
    private String photo;
    private MultipartFile multipartFile;
    private String password;
}
