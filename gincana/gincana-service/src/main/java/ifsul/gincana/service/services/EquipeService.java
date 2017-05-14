/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsul.gincana.service.services;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.service.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Henrique
 */
@Service
public class EquipeService {
    @Autowired
    EquipeRepository repository;
    
    public Double getPontuacao(Equipe equipe){
        return repository.getPontuacao(equipe);
    }
    
    public Iterable<Equipe> findAllEquipes(){
        return repository.findAll();
    }
}
