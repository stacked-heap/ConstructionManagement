package com.constuctionmanagement.ConstructionManagement.controller;

import com.constuctionmanagement.ConstructionManagement.model.*;
import org.springframework.http.ResponseEntity;
import com.constuctionmanagement.ConstructionManagement.service.SiteService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping("/site")
    @ResponseBody
    public ResponseEntity<?> createLabour(@RequestBody Site siteDetails){
        siteService.createSite(siteDetails);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/site")
    @ResponseBody
    public ResponseEntity<?> editSite(@RequestBody Site site){
        siteService.editSite(site);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/site/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteSite(@PathVariable String id){
        siteService.deleteSite(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/site/all")
    @ResponseBody
    public List<Site> getAllSite(){
        return siteService.getAllSite();
    }


}
