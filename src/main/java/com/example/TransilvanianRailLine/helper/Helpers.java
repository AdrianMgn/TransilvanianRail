package com.example.TransilvanianRailLine.helper;
import com.example.TransilvanianRailLine.entities.RailCard;
import com.example.TransilvanianRailLine.entities.Traveller;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Helpers {

    private static final String FIRST_CLASS = "First Class";
    private static final String BUSINESS_CLASS = "Business Class";
    private static final String TO_TIMISOARA = "Bucharest - Timisoara";
    private static final String FROM_TIMISOARA = "Timisoara - Bucharest";
    private static final String TO_CONSTANTA = "Bucharest - Constanta";
    private static final String FROM_CONSTANTA = "Constanta - Bucharest";
    private static final String TO_CLUJ = "Bucharest - Cluj";
    private static final String FROM_CLUJ = "Cluj - Bucharest";
    private static final String TO_BRASOV = "Bucharest - Brasov";
    private static final String FROM_BRASOV = "Brasov - Bucharest";
    private static final String TO_VIENNA = "Bucharest - Vienna";
    private static final String FROM_VIENNA = "Vienna - Bucharest";
    private static final String TO_PRAGUE = "Bucharest - Prague";
    private static final String FROM_PRAGUE = "Prague - Bucharest";
    public Traveller traveller;
    public RailCard railCard;

    private Double computeTicketPriceByRoute() {
        Double ticketPrice = 0d;

        if (traveller.getRoute().equalsIgnoreCase(TO_TIMISOARA)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(FROM_TIMISOARA)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(TO_CONSTANTA)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(FROM_CONSTANTA)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(TO_CLUJ)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(FROM_CLUJ)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(TO_BRASOV)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(FROM_BRASOV)) {
            ticketPrice = 0.25d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(TO_VIENNA)) {
            ticketPrice = 0.5d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(FROM_VIENNA)) {
            ticketPrice = 0.5d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(TO_PRAGUE)) {
            ticketPrice = 0.5d * traveller.getDistance();
        } else if (traveller.getRoute().equalsIgnoreCase(FROM_PRAGUE)) {
            ticketPrice = 0.5d * traveller.getDistance();
        } else {
            System.out.println("This route is not available! Please choose an available route.");
        }
        return ticketPrice;
    }

    private Double computeTicketPriceByComfortClass() {

        Double ticketPrice = 0d;
        Integer firstClassCounter = 0;
        Integer businessClassCounter = 0;

        if (!traveller.getComfortClass().equalsIgnoreCase(FIRST_CLASS) && !traveller.getComfortClass().equalsIgnoreCase(BUSINESS_CLASS)) {
            System.out.println("Please enter a valid comfort class!");
        }

        while (firstClassCounter <= 50) {
            if (traveller.getComfortClass().equalsIgnoreCase(FIRST_CLASS)) {
                ticketPrice = computeTicketPriceByRoute();;
            }
            firstClassCounter++;
        }

        while (businessClassCounter <= 250) {
            if (traveller.getComfortClass().equalsIgnoreCase(BUSINESS_CLASS)) {
                ticketPrice = computeTicketPriceByRoute() + 50d;
            }
            businessClassCounter ++;
        }

        if (firstClassCounter > 50 || businessClassCounter > 250) {
            System.out.println("There are no available seats left!");
        }
        return ticketPrice;
    }

    public Double ticketPriceIfRailCardIsPresent() {
        return computeTicketPriceByComfortClass() - (0.5d * computeTicketPriceByComfortClass());
    }

    public Double ticketPriceIfRailCardIsAbsent() {
        return computeTicketPriceByComfortClass();
    }

}

