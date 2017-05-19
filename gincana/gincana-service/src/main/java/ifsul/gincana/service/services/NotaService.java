package ifsul.gincana.service.services;

import ifsul.gincana.entity.entities.Nota;
import ifsul.gincana.service.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Henrique
 */
@Service
public class NotaService {
    
    @Autowired
    private NotaRepository repository;
    
    public Nota save(Nota nota){
        return repository.save(nota);
    }
}
