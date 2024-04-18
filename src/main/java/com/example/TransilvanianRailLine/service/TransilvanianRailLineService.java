package com.example.TransilvanianRailLine.service;
import com.example.TransilvanianRailLine.entities.RailCard;
import com.example.TransilvanianRailLine.entities.Traveller;
import com.example.TransilvanianRailLine.helper.Helpers;
import com.example.TransilvanianRailLine.repositories.RailCardRepository;
import com.example.TransilvanianRailLine.repositories.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransilvanianRailLineService {

    private TravellerRepository travellerRepository;
    private RailCardRepository railCardRepository;
    private Helpers helpers;

    @Autowired
    public TransilvanianRailLineService(TravellerRepository travellerRepository,
                                        RailCardRepository railCardRepository, Helpers helpers) {
        this.travellerRepository = travellerRepository;
        this.railCardRepository = railCardRepository;
        this.helpers = helpers;
    }

    public ResponseEntity<?> getTicketPriceById(Long id) {
        ResponseEntity<?> response = null;
        Optional<Traveller> optionalTraveller = travellerRepository.findById(id);

        if(optionalTraveller.isPresent()) {
            response = new ResponseEntity<>((helpers.ticketPriceIfRailCardIsPresent() + " lei"), HttpStatus.OK);
        } else {
            response = new ResponseEntity<>((helpers.ticketPriceIfRailCardIsAbsent() + " lei"), HttpStatus.OK);
        }
        return response;
    }

    public ResponseEntity<?> addTraveller(Traveller traveller) {
        ResponseEntity<?> response = null;

        try {
            Traveller savedTraveller = travellerRepository.saveAndFlush(traveller);
            response = new ResponseEntity<>(savedTraveller, HttpStatus.CREATED);
        } catch (Exception e){
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    public ResponseEntity<?> addRailCard(Long id, RailCard railCard) {
        ResponseEntity<?> response = null;
        Optional<RailCard> optionalRailCard = railCardRepository.findById(id);

        if(optionalRailCard.isPresent() && (railCard.getAge() >= 20 && railCard.getAge() <= 25) || railCard.getAge() > 55) {
            RailCard savedRailCard = railCardRepository.saveAndFlush(railCard);
            response = new ResponseEntity<>(savedRailCard, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Enter a valid age between 20 and 25 or over 55 or railcard is not found!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    public ResponseEntity<?> deleteTraveller(String route) {
        ResponseEntity<?> response = null;

        List<Traveller> travellerList = travellerRepository.findByRoute(route);
        Traveller traveller = travellerList.stream().filter(tr -> tr.getRoute() == route).toList().get(0);
        travellerList.removeIf(tr -> tr.getRoute() == route);

        if(travellerList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(traveller + " was successfully removed!", HttpStatus.OK);
        }
        return response;
    }

}

