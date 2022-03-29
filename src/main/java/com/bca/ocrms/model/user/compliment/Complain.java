package com.bca.ocrms.model.user.compliment;

import com.bca.ocrms.model.user.register.Register;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user_complain")
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Complain_SEQ_GEN")
    @SequenceGenerator(name="Complain_SEQ_GEN",sequenceName = "Complain_SEQ",allocationSize = 1)
    private Integer id;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="natinal_id_number",nullable = false)
    private String nationIdNumber;

    @Column(name="crime_type",nullable = false)
    private String crimeType;

    @Column(name="crime_date",nullable = false)
    private Date crimeDate;

    @Column(name = "description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="register_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "Fk_register_complaint"))
    private Register register;
}
