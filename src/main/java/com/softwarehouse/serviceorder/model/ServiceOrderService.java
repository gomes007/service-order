package com.softwarehouse.serviceorder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "service_order_service")
public class ServiceOrderService extends Entidade {
    @OneToOne
    @JoinTable(
            name = "service_order_service",
            joinColumns = @JoinColumn(name = "service_order_service_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Service service;

    private String details;
    private int quantity;
    private BigDecimal discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal totalValue;
}
