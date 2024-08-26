package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
    private LocalDate date;

    @Column
    private int amount;

}
