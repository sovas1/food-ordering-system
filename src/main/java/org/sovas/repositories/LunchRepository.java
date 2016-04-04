package org.sovas.repositories;

import org.sovas.models.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface LunchRepository extends JpaRepository<Lunch,Long>{

    @Query("from Lunch")
    Collection<Lunch> getAll();

}
