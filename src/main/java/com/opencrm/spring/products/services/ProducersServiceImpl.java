package com.opencrm.spring.products.services;

import com.opencrm.spring.products.dao.ProducersDAO;
import com.opencrm.spring.products.model.Producers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class ProducersServiceImpl implements ProducersService {
    private ProducersDAO producersDAO;

    public void setProducersDAO(ProducersDAO producersDAO) { this.producersDAO = producersDAO; }

    @Override
    @Transactional
    public List<Producers> listProducers() {
        return this.producersDAO.listProducers();
    }

    @Override
    @Transactional
    public void addProducer(Producers p) {
        this.producersDAO.addProducers(p);
    }

    @Override
    @Transactional
    public void updateProducer(Producers p) {
        this.producersDAO.updateProducers(p);
    }

    @Override
    @Transactional
    public void removeProducer(int id) {
        this.producersDAO.removeProducers(id);
    }

    @Override
    @Transactional
    public Producers getProducerById(int id) {
        return this.producersDAO.getProducersById(id);
    }
}
