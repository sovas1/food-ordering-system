package org.sovas.services.dao.lunchDao;

import org.sovas.models.Lunch;
import org.sovas.repositories.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunchDaoImpl implements LunchDao {

    @Autowired
    LunchRepository lunchRepository;

    @Override
    public List<Lunch> getAll() {
        return lunchRepository.findAll();
    }
}
