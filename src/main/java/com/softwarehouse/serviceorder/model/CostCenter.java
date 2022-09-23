package com.softwarehouse.serviceorder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cost_center")
@EqualsAndHashCode(callSuper = true)
public class CostCenter extends Entidade {
    private String name;
    private CostCenterStatus status;
}
