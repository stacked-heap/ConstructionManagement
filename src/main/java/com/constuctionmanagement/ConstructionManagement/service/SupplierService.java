package com.constuctionmanagement.ConstructionManagement.service;

import com.constuctionmanagement.ConstructionManagement.model.*;
import com.constuctionmanagement.ConstructionManagement.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SupplierService {
    private final MaterialRespository materialRepo;
    private final SupplierEntryRepository supplierEntryRepo;
    private final SupplierRepository supplierRepo;

    public SupplierService(MaterialRespository materialRepo, SupplierEntryRepository supplierEntryRepo, SupplierRepository supplierRepo) {
        this.materialRepo = materialRepo;
        this.supplierEntryRepo = supplierEntryRepo;
        this.supplierRepo = supplierRepo;
    }

    public void createMaterial(Material material) {
        materialRepo.save(material);
    }

    public void editMaterial(Material material) {
        materialRepo.save(material);
    }

    public void deleteMaterial(String id) {
        materialRepo.deleteById(id);
    }

    public List<Material> getAllMaterial() {
        return materialRepo.findAll();
    }

    public List<SupplierEntry> getAllSupplierEntries() {
        return supplierEntryRepo.findAll();
    }

    public void createSupplierEntry(SupplierEntry entry) {
        supplierEntryRepo.save(entry);
    }

    public void editSupplierEntry(SupplierEntry entry) {
        supplierEntryRepo.save(entry);
    }

    public void deleteSupplierEntry(String id) {
        supplierEntryRepo.deleteById(id);
    }

    public void createSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    public void editSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    public void deleteSupplier(String id) {
        supplierRepo.deleteById(id);
    }

    public List<Supplier> getAllSupplier() {
        return supplierRepo.findAll();
    }

    public List<SupplierEntry> getSupplierEntries(Date fromDate, Date toDate, SupplierEntryRequest request) {

        return supplierEntryRepo.findAllByDateGreaterThanEqualAndDateLessThanEqualAndSite_IdInAndSupplier_IdIn(fromDate, toDate, request.getSiteIds(), request.getSupplierIds());
    }

    public List<SupplierEntry> getSupplierEntriesForSite(String siteId) {
        return supplierEntryRepo.findBySite_Id(siteId);
    }
}
