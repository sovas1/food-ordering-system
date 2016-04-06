package org.sovas.repositories.lunchParts;

import org.sovas.models.lunchParts.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MainCourseRepository extends JpaRepository<MainCourse,Long>{

    @Query("from MainCourse")
    List<MainCourse> getAll();

}
