package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class SupplierEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Site site;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Material material;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;

    @Column
    private Date date;

    @Column
    private Integer units;

}
