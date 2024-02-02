package com.danaem.javad288.dao;

import com.danaem.javad288.entities.Excursion ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}
