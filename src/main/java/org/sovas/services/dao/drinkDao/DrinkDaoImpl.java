package org.sovas.services.dao.drinkDao;

import org.sovas.models.Drink;
import org.sovas.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkDaoImpl implements DrinkDao {

    @Autowired
    DrinkRepository drinkRepository;

    @Override
    public List<Drink> getAll() {
        return drinkRepository.findAll();
    }
}
