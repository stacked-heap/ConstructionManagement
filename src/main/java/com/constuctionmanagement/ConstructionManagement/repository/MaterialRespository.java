package com.constuctionmanagement.ConstructionManagement.repository;

import com.constuctionmanagement.ConstructionManagement.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRespository extends JpaRepository<Material, String> {

}
