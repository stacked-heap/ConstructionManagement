package com.constuctionmanagement.ConstructionManagement.controller;

import com.constuctionmanagement.ConstructionManagement.model.*;
import com.constuctionmanagement.ConstructionManagement.service.SiteService;
import com.constuctionmanagement.ConstructionManagement.service.SupplierService;
import com.constuctionmanagement.ConstructionManagement.util.ConstructionMgmtUtil;
import org.springframework.http.ResponseEntity;
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
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/material")
    @ResponseBody
    public ResponseEntity<?> createMaterial(@RequestBody Material material){
        supplierService.createMaterial(material);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/material")
    @ResponseBody
    public ResponseEntity<?> editMaterial(@RequestBody Material material){
        supplierService.editMaterial(material);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/material/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteMaterial(@PathVariable String id){
        supplierService.deleteMaterial(id);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/material/all")
    @ResponseBody
    public List<Material> getAllMaterial(){
        return supplierService.getAllMaterial();
    }
    @PostMapping("/supplierentries")
    public List<SupplierEntry> getSupplierEntries(@RequestBody SupplierEntryRequest request) throws ParseException {
        Date fromDate = request.getFromDate() == null ? ConstructionMgmtUtil.getFromDate() : ConstructionMgmtUtil.getParsed(request.getFromDate() + " 00:00:00");
        Date toDate = request.getToDate() == null ? ConstructionMgmtUtil.getToDate() : ConstructionMgmtUtil.getParsed(request.getToDate() + " 23:59:59");
        return supplierService.getSupplierEntries(fromDate, toDate, request);
    }
    @GetMapping("/supplierentries")
    public List<SupplierEntry> getSupplierEntries(@RequestParam("siteId") String siteId) throws ParseException {
        return supplierService.getSupplierEntriesForSite(siteId);
    }
    @GetMapping("/supplierentry/all")
    public List<SupplierEntry> getAllSupplierEntries(){
        return supplierService.getAllSupplierEntries();
    }

    @PostMapping("/supplierentry")
    @ResponseBody
    public ResponseEntity<?> createSupplierEntry(@RequestBody SupplierEntry entry){
        supplierService.createSupplierEntry(entry);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/supplierentry")
    @ResponseBody
    public ResponseEntity<?> editSupplierEntry(@RequestBody SupplierEntry entry){
        supplierService.editSupplierEntry(entry);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/supplierentry/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteSupplierEntry(@PathVariable String id){
        supplierService.deleteSupplierEntry(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/supplier")
    @ResponseBody
    public ResponseEntity<?> createSupplier(@RequestBody Supplier supplier){
        supplierService.createSupplier(supplier);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/supplier")
    @ResponseBody
    public ResponseEntity<?> editSupplier(@RequestBody Supplier supplier){
        supplierService.editSupplier(supplier);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/supplier/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteSupplier(@PathVariable String id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/supplier/all")
    @ResponseBody
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllSupplier();
    }

}
