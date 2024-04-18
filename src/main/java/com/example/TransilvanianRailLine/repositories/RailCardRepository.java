package com.example.TransilvanianRailLine.repositories;
import com.example.TransilvanianRailLine.entities.RailCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RailCardRepository extends JpaRepository<RailCard, Long> {
}
