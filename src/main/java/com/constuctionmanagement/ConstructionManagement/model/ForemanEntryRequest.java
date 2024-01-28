package com.constuctionmanagement.ConstructionManagement.model;

import lombok.Data;

import java.util.List;

@Data
public class ForemanEntryRequest {
    private String fromDate;
    private String toDate;
    private List<String> foremanIds;
    private List<String> siteIds;
}
