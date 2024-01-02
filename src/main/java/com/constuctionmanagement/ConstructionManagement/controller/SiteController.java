package com.constuctionmanagement.ConstructionManagement.controller;

import com.constuctionmanagement.ConstructionManagement.model.Entry;
import com.constuctionmanagement.ConstructionManagement.model.EntryRequest;
import com.constuctionmanagement.ConstructionManagement.model.Labour;
import com.constuctionmanagement.ConstructionManagement.model.Site;
import jakarta.websocket.server.PathParam;
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

@RestController("api/v1")
@CrossOrigin(origins="*")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping("/site")
    @ResponseBody
    public ResponseEntity createLabour(@RequestBody Site siteDetails){
        siteService.createSite(siteDetails);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/site")
    @ResponseBody
    public ResponseEntity editSite(@RequestBody Site site){
        siteService.editSite(site);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/site/id/{id}")
    @ResponseBody
    public ResponseEntity deleteSite(@PathParam("id") String id){
        siteService.deleteSite(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/labour")
    @ResponseBody
    public ResponseEntity createLabour(@RequestBody Labour labour){
        siteService.createLabour(labour);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/labour")
    @ResponseBody
    public ResponseEntity editLabour(@RequestBody Labour labour){
        siteService.saveLabour(labour);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/labour/id/{id}")
    @ResponseBody
    public ResponseEntity deleteLabour(@PathVariable String id){
        siteService.deleteLabour(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/entry")
    public ResponseEntity createEntry(@RequestBody Entry entry){
        siteService.createEntry(entry);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/entry")
    @ResponseBody
    public ResponseEntity editEntry(@RequestBody Entry labour){
        siteService.saveEntry(labour);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/entry/id/{id}")
    @ResponseBody
    public ResponseEntity deleteEntry(@PathVariable String id){
        siteService.deleteEntry(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/entries")
    public List<Entry> getEntries(@RequestBody EntryRequest request) throws ParseException {
        Date fromDate = request.getFromDate() == null ? getFromDate() : getParsed(request.getFromDate());
        Date toDate = request.getToDate() == null ? getToDate() : getParsed(request.getToDate());
        return siteService.getEntries(fromDate, toDate, request);
    }

    private Date getToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now().plusDays(7 - localDateTime.getDayOfWeek().getValue());
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    private Date getParsed(String fromDateString) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(fromDateString);
    }

    @GetMapping("/entry/all")
    public List<Entry> getAllEntries(){

        return siteService.getAllEntries();
    }

    private Date getFromDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now().minusDays(localDateTime.getDayOfWeek().getValue());
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    @GetMapping("/site/all")
    @ResponseBody
    public List<Site> getAllSite(){
        return siteService.getAllSite();
    }
    @GetMapping("/labour/all")
    @ResponseBody
    public List<Labour> getAllLabour(){
        return siteService.getAllLabour();
    }
}
