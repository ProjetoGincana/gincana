/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsul.gincana.service.services;

import ifsul.gincana.entity.entities.Prova;
import ifsul.gincana.service.repositories.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
/**
 *
 * @author eliseudaroitjr
 */
@Service
public class ProvaService {

    @Autowired
    ProvaRepository repository;

    public Iterable<Prova> findAll(){
        return repository.findAll();
    }

    public Page<Prova> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }
}
