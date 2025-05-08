package main.service;

import main.model.Plano;
import main.repository.PlanoRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public Plano criarPlano(String nome, double velocidade, double preco) {
        Plano plano = new Plano(nome, velocidade, preco);
        return planoRepository.save(plano);
    }

    public Plano buscarPlanoPorId(Long id) {
        return planoRepository.findById(id).orElseThrow(() -> new RuntimeException("Plano não encontrado"));
    }
}
