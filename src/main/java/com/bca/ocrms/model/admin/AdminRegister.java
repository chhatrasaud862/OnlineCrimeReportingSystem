package com.bca.ocrms.model.admin;

import com.bca.ocrms.enums.Gender;
import com.bca.ocrms.enums.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="admin_register",uniqueConstraints = {
        @UniqueConstraint(name="unique_Register_email",columnNames = "email"),
})
public class AdminRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO/*,generator = "Register_seq_gen"*/)
//    @SequenceGenerator(name="Register_seq_gen",sequenceName = "Register_seq",allocationSize = 1)
    private Integer id;

    @Column(name="province_name",nullable = false)
    private String provinceName;

    @Column(name="district_name",nullable = false)
    private String districtName;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="station_name",nullable = false)
    private String stationName;

    @Column(name="admin_name",nullable = false)
    private String adminName;


    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private Role role;

    private String photo;

}
