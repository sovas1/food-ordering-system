package org.sovas.repositories;

import org.sovas.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface DrinkRepository extends JpaRepository<Drink,Long>{

    @Query("from Drink")
    Collection<Drink> getAll();

}
