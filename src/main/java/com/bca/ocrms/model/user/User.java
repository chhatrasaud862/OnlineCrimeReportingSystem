package com.bca.ocrms.model.user;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/5/22
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_user",uniqueConstraints = {
        @UniqueConstraint(name="unique_User_email",columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "User_seq_gen")
    @SequenceGenerator(name="User_seq_gen",sequenceName = "User_seq",allocationSize = 1)
    private Integer id;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;
}

