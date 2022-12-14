package com.softwarehouse.serviceorder.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "clientType", nullable = false)
    private Type type;

    private LocalDate birthDate;

    private BigDecimal creditLimit;

    private boolean creditLimitExceeded;

    @Embedded
    private GeneralInformation generalInformation;

    @JoinColumn(name = "client_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;
}
