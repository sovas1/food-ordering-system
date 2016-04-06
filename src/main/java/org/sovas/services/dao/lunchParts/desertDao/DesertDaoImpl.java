package org.sovas.services.dao.lunchParts.desertDao;

import org.sovas.models.lunchParts.Desert;
import org.sovas.repositories.lunchParts.DesertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesertDaoImpl implements DesertDao {

    @Autowired
    DesertRepository desertRepository;

    @Override
    public List<Desert> getAll() {
        return desertRepository.findAll();
    }
}
