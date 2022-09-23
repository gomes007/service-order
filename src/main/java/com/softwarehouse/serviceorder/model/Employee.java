package com.softwarehouse.serviceorder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
@EqualsAndHashCode(callSuper = true)
public class Employee extends Entidade {
    @Embedded
    private GeneralInformation generalInformation;

    private String profilePhoto;

    private String cv;

    private Double commission;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Salary salary;

    @JoinColumn(name = "employee_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Address> addresses;
}
