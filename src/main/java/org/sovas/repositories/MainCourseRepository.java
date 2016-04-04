package org.sovas.repositories;

import org.sovas.models.lunchParts.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface MainCourseRepository extends JpaRepository<MainCourse,Long>{

    @Query("from MainCourse")
    Collection<MainCourse> getAll();

}
