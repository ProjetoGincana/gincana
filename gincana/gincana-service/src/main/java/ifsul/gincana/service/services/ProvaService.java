package ifsul.gincana.service.services;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Nota;
import ifsul.gincana.entity.entities.Prova;
import ifsul.gincana.service.repositories.ProvaRepository;
import ifsul.gincana.viewmodel.PontuarEquipe;
import java.util.List;
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
    private ProvaRepository repository;
    @Autowired   
    private NotaService notaService;
    @Autowired
    private ProvaService provaService;

    public Prova save(Prova nota){
        return repository.save(nota);
    }
    
    public Prova findOne(Long id){
        return repository.findOne(id);
    }
    
    public Iterable<Prova> findAll(){
        return repository.findAll();
    }

    public Page<Prova> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }
    
    public Page<Prova> findAllNotScored(Pageable pgbl) {
        return repository.findAllNotScored(pgbl);
    }
    
    public void pontuarEquipes(PontuarEquipe pontuarEquipe){
        int valorTotal = pontuarEquipe.getProva().getValorTotal();
        boolean pontuada = pontuarEquipe.getProva().getPontuada();
        
        boolean pontuacoesValidas = pontuarEquipe.getPontuacoes().stream().allMatch( (pontuacao) -> {
            return pontuacao <= valorTotal;
        });
        
        if (pontuacoesValidas && !pontuada){
            Nota nota;
            List<Equipe> equipes = pontuarEquipe.getEquipes();
            
            for (int i=0; i < equipes.size(); i++){
                nota = new Nota();
                nota.setProva(pontuarEquipe.getProva());
                nota.setEquipe(equipes.get(i));
                nota.setValor(pontuarEquipe.getPontuacoes().get(i));
                notaService.save(nota);
            }
            
            Prova prova = pontuarEquipe.getProva();
            prova.setPontuada(true);
            provaService.save(prova);
        }
    }
}
