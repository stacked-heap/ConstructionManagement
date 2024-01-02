package com.constuctionmanagement.ConstructionManagement.model;

import lombok.Data;

import java.util.List;

@Data
public class EntryRequest {
    private String fromDate;
    private String toDate;
    private List<String> labourIds;
    private List<String> siteIds;
}
