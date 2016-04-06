package org.sovas.repositories.lunchParts;

import org.sovas.models.lunchParts.Desert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface DesertRepository extends JpaRepository<Desert,Long>{

    @Query("from Desert")
    List<Desert> getAll();

}
