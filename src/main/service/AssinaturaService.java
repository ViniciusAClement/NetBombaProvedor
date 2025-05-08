package main.service;

import main.model.Assinatura;
import main.model.Cliente;
import main.model.Plano;
import main.repository.AssinaturaRepository;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public Assinatura criarAssinatura(Cliente cliente, Plano plano) {
        Assinatura assinatura = new Assinatura(cliente, plano, true);
        return assinaturaRepository.save(assinatura);
    }

    public void ativarAssinatura(Long assinaturaId) {
        Assinatura assinatura = assinaturaRepository.findByClienteId(assinaturaId).orElseThrow(() ->
                new RuntimeException("Assinatura não encontrada"));
        assinatura.ativar();
        assinaturaRepository.save(assinatura);
    }

    public void desativarAssinatura(Long assinaturaId) {
        Assinatura assinatura = assinaturaRepository.findByClienteId(assinaturaId).orElseThrow(() ->
                new RuntimeException("Assinatura não encontrada"));
        assinatura.desativar();
        assinaturaRepository.save(assinatura);
    }
}
