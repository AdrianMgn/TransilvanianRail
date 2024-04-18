package com.example.TransilvanianRailLine.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "railcard",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"CNP", "isActive"}) })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RailCard {

    @Id
    @GeneratedValue
    private Long id;


    @Column(unique = true, length = 15)
    @Pattern(regexp = "^[1-9]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)(00[1-9]|0[1-9]\\d|[1-9]\\d\\d)\\d$")
    private String CNP;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotNull
    private Integer age;

    @JsonIgnoreProperties("railCard")
    @OneToOne(mappedBy = "railCard")
    private Traveller traveller;

    public RailCard() {
    }

    public RailCard(Long id, String CNP, String firstName, String lastName, Integer age, Traveller traveller) {
        this.id = id;
        this.CNP = CNP;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.traveller = traveller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }
}


