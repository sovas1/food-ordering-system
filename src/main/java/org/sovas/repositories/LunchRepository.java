package org.sovas.repositories;

import org.sovas.models.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface LunchRepository extends JpaRepository<Lunch,Long>{

    @Query("from Lunch")
    List<Lunch> getAllLunches();

}
