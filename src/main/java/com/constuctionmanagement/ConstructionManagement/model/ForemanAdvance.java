package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class ForemanAdvance {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Foreman foreman;

    @Column
    private Date date;

    @Column
    private double amount;

}
