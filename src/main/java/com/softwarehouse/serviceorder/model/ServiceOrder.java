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
@Table(name = "serviceOrder")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String clientName;
    private String channelSale;
    private String attendant;
    private String expert;

    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status;

    private LocalDate startDate;
    private LocalDate endDate;

    private String equipmentName;
    private String brand;
    private String model;
    private String seriesNumber;
    private String condition;
    private String flaw;
    private String fittings;
    private String solution;
    private String technicalReport;
    private String warrantyTerms;

    private BigDecimal discountAmount;
    private BigDecimal discountPercent;
    private BigDecimal total;

    @OneToMany
    @JoinColumn(name = "service_order_id")
    private List<ServiceOrderService> serviceOrderServices;

    @OneToMany
    @JoinColumn(name = "service_order_id")
    private List<ServiceOrderEquipment> serviceOrderEquipments;

    @OneToOne
    @JoinTable(
            name = "service_order_cost_center",
            joinColumns = @JoinColumn(name = "service_order_id"),
            inverseJoinColumns = @JoinColumn(name = "cost_center_id")
    )
    private CostCenter costCenter;

    @JoinColumn(name = "client_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;
}
