package com.constuctionmanagement.ConstructionManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Foreman {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String location;

}
