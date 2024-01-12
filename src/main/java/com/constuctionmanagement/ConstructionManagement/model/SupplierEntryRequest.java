package com.constuctionmanagement.ConstructionManagement.model;

import lombok.Data;

import java.util.List;

@Data
public class SupplierEntryRequest {
    private String fromDate;
    private String toDate;
    private List<String> supplierIds;
    private List<String> siteIds;
}
