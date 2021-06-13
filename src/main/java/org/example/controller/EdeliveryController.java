package org.example.controller;

import org.example.entity.Edelivery;
import org.example.repository.EdeliveryRepository;
import  org.example.repository.impl.EdeliveryRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EdeliveryController {
    private EdeliveryRepository edeliveryRepository = new EdeliveryRepositoryImpl();

    public Edelivery getEdeliveryById(Long id) throws SQLException{
        return edeliveryRepository.getById(id);
    }
    public Edelivery editEdelivery(Edelivery edelivery) throws  SQLException{
        return edeliveryRepository.update(edelivery);
    }
    public List<Edelivery> getAllEdeliverys() throws SQLException {
        return edeliveryRepository.getAll();
    }

    public void saveEdelivery(Edelivery edelivery) throws SQLException {
        edeliveryRepository.add(edelivery);
    }

    public void deleteEdelivery(Long id) throws SQLException {
        edeliveryRepository.remove(id);
    }

}