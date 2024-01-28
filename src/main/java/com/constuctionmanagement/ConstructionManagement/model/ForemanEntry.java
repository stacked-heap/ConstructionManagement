package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class ForemanEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Site site;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private LabourType labourType;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Foreman foreman;

    @Column
    private double noOfPersons;

    @Column
    private Date date;

}
