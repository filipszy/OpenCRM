package com.opencrm.spring.products.services;

import com.opencrm.spring.products.model.Producers;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public interface ProducersService {
    public List<Producers> listProducers();
    public void addProducer(Producers p);
    public void updateProducer(Producers p);
    public void removeProducer(int id);
    public Producers getProducerById(int id);
}
