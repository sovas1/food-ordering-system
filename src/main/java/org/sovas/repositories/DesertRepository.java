package org.sovas.repositories;

import org.sovas.models.lunchParts.Desert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface DesertRepository extends JpaRepository<Desert,Long>{

    @Query("from Desert")
    Collection<Desert> getAll();

}
