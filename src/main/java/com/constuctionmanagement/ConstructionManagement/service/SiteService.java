package com.constuctionmanagement.ConstructionManagement.service;

import com.constuctionmanagement.ConstructionManagement.model.*;
import com.constuctionmanagement.ConstructionManagement.repository.*;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SiteService {
    private final SiteRepository siteRepo;
    private final LabourRepository labourRepo;
    private final EntryRepository entryRepo;
    private final MaterialRespository materialRepo;
    private final SupplierEntryRepository supplierEntryRepo;
    private final SupplierRepository supplierRepo;

    public SiteService(SiteRepository siteRepo, LabourRepository labourRepo, EntryRepository entryRepo, MaterialRespository materialRepo, SupplierEntryRepository supplierEntryRepo, SupplierRepository supplierRepo) {
        this.siteRepo = siteRepo;
        this.labourRepo = labourRepo;
        this.entryRepo = entryRepo;
        this.materialRepo = materialRepo;
        this.supplierEntryRepo = supplierEntryRepo;
        this.supplierRepo = supplierRepo;
    }

    public void createSite(Site siteDetails) {
        siteRepo.save(siteDetails);
    }

    public List<Site> getAllSite() {
        return siteRepo.findAll();
    }

    public void createLabour(Labour labour) {
        labourRepo.save(labour);
    }

    public void createEntry(Entry entry) {
        entryRepo.save(entry);
    }

    public List<Entry> getEntries(Date fromDate, Date toDate, EntryRequest request) {

        return entryRepo.findAllByDateGreaterThanEqualAndDateLessThanEqualAndSite_IdInAndLabour_IdIn(fromDate, toDate, request.getSiteIds(), request.getLabourIds());
    }

    public List<Labour> getAllLabour() {
       return (List<Labour>) labourRepo.findAll();
    }

    public List<Entry> getAllEntries() {
        return (List<Entry>) entryRepo.findAll();
    }

    public void deleteLabour(String id) {
        labourRepo.deleteById(id);
    }

    public void saveLabour(Labour labour) {
        labourRepo.save(labour);
    }

    public void editSite(Site site) {
        siteRepo.save(site);
    }

    public void deleteSite(String id) {
        siteRepo.deleteById(id);
    }

    public void saveEntry(Entry entry) {
        entryRepo.save(entry);
    }

    public void deleteEntry(String id) {
        entryRepo.deleteById(id);
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
