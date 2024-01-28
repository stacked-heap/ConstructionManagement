package com.constuctionmanagement.ConstructionManagement.service;

import com.constuctionmanagement.ConstructionManagement.model.*;
import com.constuctionmanagement.ConstructionManagement.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SiteService {
    private final SiteRepository siteRepo;
    public SiteService(SiteRepository siteRepo) {
        this.siteRepo = siteRepo;
    }

    public void createSite(Site siteDetails) {
        siteRepo.save(siteDetails);
    }

    public List<Site> getAllSite() {
        return siteRepo.findAll();
    }


    public void editSite(Site site) {
        siteRepo.save(site);
    }

    public void deleteSite(String id) {
        siteRepo.deleteById(id);
    }


}
