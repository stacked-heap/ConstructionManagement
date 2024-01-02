package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String clientName;
    @Column
    private String location;
    @Column
    private Integer accountNo;
    @Column
    private String bankName;

}
