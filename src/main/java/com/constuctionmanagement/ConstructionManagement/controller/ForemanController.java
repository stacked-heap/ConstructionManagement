package com.constuctionmanagement.ConstructionManagement.controller;

import com.constuctionmanagement.ConstructionManagement.model.Foreman;
import com.constuctionmanagement.ConstructionManagement.model.ForemanEntry;
import com.constuctionmanagement.ConstructionManagement.model.ForemanEntryRequest;
import com.constuctionmanagement.ConstructionManagement.model.LabourType;
import com.constuctionmanagement.ConstructionManagement.service.ForemanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.constuctionmanagement.ConstructionManagement.util.ConstructionMgmtUtil.*;

@RestController
@CrossOrigin(origins="*")
public class ForemanController {

    private final ForemanService foremanService;

    public ForemanController(ForemanService foremanService) {
        this.foremanService = foremanService;
    }

    @PostMapping("/labourType")
    @ResponseBody
    public ResponseEntity<?> createLabourType(@RequestBody LabourType labour){
        foremanService.createLabourType(labour);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/labourType")
    @ResponseBody
    public ResponseEntity<?> editLabourType(@RequestBody LabourType labour){
        foremanService.saveLabourType(labour);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/labourType/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteLabourType(@PathVariable String id){
        foremanService.deleteLabourType(id);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/labourType/all")
    @ResponseBody
    public List<LabourType> getAllLabourTypes(){
        return foremanService.getAllLabourType();
    }

    @PostMapping("/entry")
    public ResponseEntity<?> createEntry(@RequestBody ForemanEntry entry){
        foremanService.createEntry(entry);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/entry")
    @ResponseBody
    public ResponseEntity<?> editEntry(@RequestBody ForemanEntry labour){
        foremanService.saveEntry(labour);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/entry/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteEntry(@PathVariable String id){
        foremanService.deleteEntry(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/entries")
    public List<ForemanEntry> getEntries(@RequestBody ForemanEntryRequest request) throws ParseException {
        Date fromDate = request.getFromDate() == null ? getFromDate() : getParsed(request.getFromDate() + " 00:00:00");
        Date toDate = request.getToDate() == null ? getToDate() : getParsed(request.getToDate() + " 23:59:59");
        return foremanService.getEntries(fromDate, toDate, request);
    }

    @GetMapping("/entry/all")
    public List<ForemanEntry> getAllEntries(){
        return foremanService.getAllEntries();
    }

    @PostMapping("/foreman")
    @ResponseBody
    public ResponseEntity<?> createForeman(@RequestBody Foreman foreman){
        foremanService.createForeman(foreman);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/foreman")
    @ResponseBody
    public ResponseEntity<?> editForeman(@RequestBody Foreman foreman){
        foremanService.saveForeman(foreman);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/foreman/id/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteForeman(@PathVariable String id){
        foremanService.deleteForeman(id);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/foreman/all")
    @ResponseBody
    public List<Foreman> getAllForeman(){
        return foremanService.getAllForeman();
    }

}
