package com.constuctionmanagement.ConstructionManagement.controller;

import com.constuctionmanagement.ConstructionManagement.model.ForemanAdvance;
import com.constuctionmanagement.ConstructionManagement.model.SupplierAdvance;
import com.constuctionmanagement.ConstructionManagement.service.AdvanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class AdvanceController {

    private final AdvanceService advanceService;

    public AdvanceController(AdvanceService advanceService) {
        this.advanceService = advanceService;
    }

    @PostMapping("/foreman/advance")
    @ResponseBody
    public ResponseEntity<?> createforemanAdvance(@RequestBody ForemanAdvance advanceDetails){
        advanceService.createForemanAdvance(advanceDetails);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/foreman/advance")
    @ResponseBody
    public ResponseEntity<?> editForemanAdvance(@RequestBody ForemanAdvance advance){
        advanceService.editForemanAdvance(advance);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/foreman/advance/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteForemanAdvance(@PathVariable String id){
        advanceService.deleteForemanAdvance(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/foreman/advance/all")
    @ResponseBody
    public List<ForemanAdvance> getAllForemanAdvance(){
        return advanceService.getAllForemanAdvance();
    }

    @GetMapping("/foreman/advance")
    @ResponseBody
    public List<ForemanAdvance> getForemanAdvance(@RequestParam String foremanId){
        return advanceService.getForemanAdvanceForForeman(foremanId);
    }

    @PostMapping("/supplier/advance")
    @ResponseBody
    public ResponseEntity<?> createsupplierAdvance(@RequestBody SupplierAdvance advanceDetails){
        advanceService.createSupplierAdvance(advanceDetails);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/supplier/advance")
    @ResponseBody
    public ResponseEntity<?> editSupplierAdvance(@RequestBody SupplierAdvance advance){
        advanceService.editSupplierAdvance(advance);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/supplier/advance/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteSupplierAdvance(@PathVariable String id){
        advanceService.deleteSupplierAdvance(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/supplier/advance/all")
    @ResponseBody
    public List<SupplierAdvance> getAllSupplierAdvance(){
        return advanceService.getAllSupplierAdvance();
    }

}
