package com.opencrm.spring.products.dao;

import com.opencrm.spring.products.model.Producers;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public interface ProducersDAO {
    public List<Producers> listProducers();
    public void addProducers(Producers p);
    public void updateProducers(Producers p);
    public void removeProducers(int id);
    public Producers getProducersById(int id);
}
