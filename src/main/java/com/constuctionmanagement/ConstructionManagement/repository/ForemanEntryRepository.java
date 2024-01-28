package com.constuctionmanagement.ConstructionManagement.repository;

import com.constuctionmanagement.ConstructionManagement.model.ForemanEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ForemanEntryRepository extends CrudRepository<ForemanEntry, String> {

    List<ForemanEntry> findAllByDateGreaterThanEqualAndDateLessThanEqualAndSite_IdInAndForeman_IdIn(Date fromDate, Date toDate, List<String> siteIds, List<String> foremanIds);
}

