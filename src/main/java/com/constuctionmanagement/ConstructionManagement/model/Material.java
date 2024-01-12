package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Material {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String specification;

    @Column
    private Integer rate;
}
