package com.constuctionmanagement.ConstructionManagement.service;

import com.constuctionmanagement.ConstructionManagement.model.*;
import com.constuctionmanagement.ConstructionManagement.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ForemanService {
    private final LabourTypeRepository labourRepo;
    private final ForemanEntryRepository entryRepo;
    private final ForemanRepository foremanRepo;

    public ForemanService(LabourTypeRepository labourRepo, ForemanEntryRepository entryRepo, ForemanRepository foremanRepo) {
        this.labourRepo = labourRepo;
        this.entryRepo = entryRepo;
        this.foremanRepo = foremanRepo;
    }

    public void createLabourType(LabourType labour) {
        labourRepo.save(labour);
    }

    public void createEntry(ForemanEntry entry) {
        entryRepo.save(entry);
    }

    public List<ForemanEntry> getEntries(Date fromDate, Date toDate, ForemanEntryRequest request) {

        return entryRepo.findAllByDateGreaterThanEqualAndDateLessThanEqualAndSite_IdInAndForeman_IdIn(fromDate, toDate, request.getSiteIds(), request.getForemanIds());
    }

    public List<LabourType> getAllLabourType() {
       return (List<LabourType>) labourRepo.findAll();
    }

    public List<ForemanEntry> getAllEntries() {
        return (List<ForemanEntry>) entryRepo.findAll();
    }

    public void deleteLabourType(String id) {
        labourRepo.deleteById(id);
    }

    public void saveLabourType(LabourType labour) {
        labourRepo.save(labour);
    }


    public void saveEntry(ForemanEntry entry) {
        entryRepo.save(entry);
    }

    public void deleteEntry(String id) {
        entryRepo.deleteById(id);
    }

    public void createForeman(Foreman foreman) {
        foremanRepo.save(foreman);
    }

    public void saveForeman(Foreman foreman) {
        foremanRepo.save(foreman);
    }

    public void deleteForeman(String id) {
        foremanRepo.deleteById(id);
    }

    public List<Foreman> getAllForeman() {
        return foremanRepo.findAll();
    }
}
