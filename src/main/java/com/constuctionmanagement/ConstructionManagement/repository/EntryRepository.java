package com.constuctionmanagement.ConstructionManagement.repository;

import com.constuctionmanagement.ConstructionManagement.model.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, String> {

    List<Entry> findAllByDateGreaterThanEqualAndDateLessThanEqualAndSite_IdInAndLabour_IdIn(Date fromDate, Date toDate, List<String> siteIds, List<String> labourIds);
}

