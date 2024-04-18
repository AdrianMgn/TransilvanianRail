package com.example.TransilvanianRailLine.controller;
import com.example.TransilvanianRailLine.entities.Traveller;
import com.example.TransilvanianRailLine.service.TransilvanianRailLineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransilvanianRailLineController {

    private TransilvanianRailLineService transilvanianRailLineService;

    @Autowired
    public TransilvanianRailLineController(TransilvanianRailLineService transilvanianRailLineService) {
        this.transilvanianRailLineService = transilvanianRailLineService;
    }

    @GetMapping("/info")
    public String info() {
        return "Server is up and running!";
    }

    @GetMapping("/travellers/{id}")
    public ResponseEntity<?> getTicketPriceById(@PathVariable Long id) {
        return transilvanianRailLineService.getTicketPriceById(id);
    }

    @PostMapping("/addtraveller")
    public ResponseEntity<?> addTraveller(@RequestBody @Valid Traveller traveller) {
        return transilvanianRailLineService.addTraveller(traveller);
    }

    @DeleteMapping("/travellers/{route}")
    public ResponseEntity<?> deleteTraveller(@PathVariable String route) {
        return transilvanianRailLineService.deleteTraveller(route);
    }
}

