package com.constuctionmanagement.ConstructionManagement.repository;

import com.constuctionmanagement.ConstructionManagement.model.SupplierEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SupplierEntryRepository extends JpaRepository<SupplierEntry, String> {
    List<SupplierEntry> findAllByDateGreaterThanEqualAndDateLessThanEqualAndSite_IdInAndSupplier_IdIn(Date fromDate, Date toDate, List<String> siteIds, List<String> supplierIds);

    List<SupplierEntry> findBySite_Id(String siteId);
}
