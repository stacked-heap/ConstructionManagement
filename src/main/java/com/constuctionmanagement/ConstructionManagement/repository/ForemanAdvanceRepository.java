package com.constuctionmanagement.ConstructionManagement.repository;

import com.constuctionmanagement.ConstructionManagement.model.ForemanAdvance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForemanAdvanceRepository extends JpaRepository<ForemanAdvance, String> {

    List<ForemanAdvance> findByForeman_Id(String foremanId);
}

