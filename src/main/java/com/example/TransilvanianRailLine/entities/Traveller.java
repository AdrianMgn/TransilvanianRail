package com.example.TransilvanianRailLine.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "travellers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Traveller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 7, max = 50)
    private String route;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String comfortClass;

    @NotNull
    private Double distance;

    @JsonIgnoreProperties("traveller")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "railcard_id", referencedColumnName = "id")
    private RailCard railCard;

    public Traveller() {}

    public Traveller(Long id, String firstName, String lastName, String route, String comfortClass, Double distance, RailCard railCard) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.route = route;
        this.comfortClass = comfortClass;
        this.distance = distance;
        this.railCard = railCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getComfortClass() {
        return comfortClass;
    }

    public void setComfortClass(String comfortClass) {
        this.comfortClass = comfortClass;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public RailCard getRailCard() {
        return railCard;
    }

    public void setRailCard(RailCard railCard) {
        this.railCard = railCard;
    }
}



