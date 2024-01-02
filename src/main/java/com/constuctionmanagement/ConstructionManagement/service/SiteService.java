package com.constuctionmanagement.ConstructionManagement.service;

import com.constuctionmanagement.ConstructionManagement.model.Entry;
import com.constuctionmanagement.ConstructionManagement.model.EntryRequest;
import com.constuctionmanagement.ConstructionManagement.model.Labour;
import com.constuctionmanagement.ConstructionManagement.model.Site;
import com.constuctionmanagement.ConstructionManagement.repository.EntryRepository;
import com.constuctionmanagement.ConstructionManagement.repository.LabourRepository;
import org.springframework.stereotype.Service;
import com.constuctionmanagement.ConstructionManagement.repository.SiteRepository;

import java.util.Date;
import java.util.List;

@Service
public class SiteService {
    private final SiteRepository siteRepo;
    private final LabourRepository labourRepo;
    private final EntryRepository entryRepo;
    public SiteService(SiteRepository siteRepo, LabourRepository labourRepo, EntryRepository entryRepo) {
        this.siteRepo = siteRepo;
        this.labourRepo = labourRepo;
        this.entryRepo = entryRepo;
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
}
