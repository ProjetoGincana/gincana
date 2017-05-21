package ifsul.gincana.service.services;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.service.repositories.EquipeRepository;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.util.Map.Entry;

/**
 *
 * @author Marcelo Henrique
 */
@Service
public class EquipeService {

    @Autowired
    EquipeRepository repository;

    public Integer getPontuacao(Equipe equipe){
        return repository.getPontuacao(equipe);
    }

    public Iterable<Equipe> findAll(){
        return repository.findAll();
    }

    public Page<Equipe> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }
    
    public List<Entry<Equipe, Integer>> getEquipesRanqueadas(){
        // equipes e pontuacoes
        List<Entry<Equipe, Integer>> equipesRanqueadas = new ArrayList<>();

        for (Equipe equipe : repository.findAll()) {
            Integer pontuacao = repository.getPontuacao(equipe);

            equipesRanqueadas.add(new AbstractMap.SimpleEntry<>(equipe, pontuacao));
        }
        
        ordenarEquipesPorPontuacao(equipesRanqueadas);

        return equipesRanqueadas;
    }
    
    /**
     * Ordena Equipes pela sua pontuação.
     * 
     * @param equipesRanqueadas equipes a serem ordenadas.
     * @return List<Entry<Equipe, Integer>> equipes ordenadas.
   */
    private List<Entry<Equipe, Integer>> ordenarEquipesPorPontuacao(List<Entry<Equipe, Integer>> equipesRanqueadas){
        equipesRanqueadas.sort((Entry<Equipe, Integer> a, Entry<Equipe, Integer> b) -> {
            if (b.getValue() != null && a.getValue() != null){
                return b.getValue() - a.getValue();
            }
            return 1;
        });
        
        return equipesRanqueadas;
    }
}
