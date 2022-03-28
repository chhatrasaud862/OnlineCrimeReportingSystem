package com.bca.ocrms.model.user;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_user",uniqueConstraints = {
        @UniqueConstraint(name = "unique_User_email",columnNames = "email"),
        @UniqueConstraint(name = "unique_User_mobileNumber",columnNames = "mobile_number")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_seq_gen")
    @SequenceGenerator(name="user_seq_gen",sequenceName = "user_seq",allocationSize = 1)
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="mobile_number",nullable = false)
    private String mobileNumber;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name = "roles")
    private Collection<Role> roles;

}
