package com.example.TransilvanianRailLine.repositories;
import com.example.TransilvanianRailLine.entities.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {

    List<Traveller> findByRoute(String route);
}

