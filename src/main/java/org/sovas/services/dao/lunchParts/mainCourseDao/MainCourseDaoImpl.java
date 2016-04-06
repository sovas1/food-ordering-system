package org.sovas.services.dao.lunchParts.mainCourseDao;

import org.sovas.models.lunchParts.MainCourse;
import org.sovas.repositories.lunchParts.MainCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCourseDaoImpl implements MainCourseDao {

    @Autowired
    MainCourseRepository mainCourseRepository;

    @Override
    public List<MainCourse> getAll() {
        return mainCourseRepository.findAll();
    }
}
