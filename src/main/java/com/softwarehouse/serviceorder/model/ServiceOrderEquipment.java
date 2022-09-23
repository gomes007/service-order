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
@Table(name = "service_order_equipment")
public class ServiceOrderEquipment extends Entidade {
    @OneToOne
    @JoinTable(
            name = "service_order_equipments",
            joinColumns = @JoinColumn(name = "service_order_equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Product product;

    private String details;
    private int quantity;
    private BigDecimal discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal totalValue;
}
