package com.constuctionmanagement.ConstructionManagement.service;

import com.constuctionmanagement.ConstructionManagement.model.ForemanAdvance;
import com.constuctionmanagement.ConstructionManagement.model.SupplierAdvance;
import com.constuctionmanagement.ConstructionManagement.repository.ForemanAdvanceRepository;
import com.constuctionmanagement.ConstructionManagement.repository.SupplierAdvanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvanceService {

    private final ForemanAdvanceRepository foremanAdvanceRepository;
    private final SupplierAdvanceRepository supplierAdvanceRepository;

    public AdvanceService(ForemanAdvanceRepository foremanAdvanceRepository, SupplierAdvanceRepository supplierAdvanceRepository) {
        this.foremanAdvanceRepository = foremanAdvanceRepository;
        this.supplierAdvanceRepository = supplierAdvanceRepository;
    }

    public void createForemanAdvance(ForemanAdvance advanceDetails) {
        foremanAdvanceRepository.save(advanceDetails);
    }

    public void editForemanAdvance(ForemanAdvance advance) {
        foremanAdvanceRepository.save(advance);
    }

    public void deleteForemanAdvance(String id) {
        foremanAdvanceRepository.deleteById(id);
    }

    public List<ForemanAdvance> getAllForemanAdvance() {
        return foremanAdvanceRepository.findAll();
    }

    public void createSupplierAdvance(SupplierAdvance advanceDetails) {
        supplierAdvanceRepository.save(advanceDetails);
    }

    public void editSupplierAdvance(SupplierAdvance advance) {
        supplierAdvanceRepository.save(advance);
    }

    public void deleteSupplierAdvance(String id) {
        supplierAdvanceRepository.deleteById(id);
    }

    public List<SupplierAdvance> getAllSupplierAdvance() {
        return supplierAdvanceRepository.findAll();
    }

    public List<ForemanAdvance> getForemanAdvanceForForeman(String foremanId) {
        return foremanAdvanceRepository.findByForeman_Id(foremanId);
    }
}
