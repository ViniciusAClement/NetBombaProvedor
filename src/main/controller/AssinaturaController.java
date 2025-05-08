package main.controller;

import main.model.Assinatura;
import main.model.Plano;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import main.service.AssinaturaService;
import main.service.ClienteService;
import main.dto.AssinaturaDto;
import main.model.Cliente;
import main.service.PlanoService;

@RestController
@RequestMapping("/assinaturas")

public class AssinaturaController {

    private final AssinaturaService assinaturaService;
    private final ClienteService clienteService;
    private final PlanoService planoService;

    public AssinaturaController(AssinaturaService assinaturaService, ClienteService clienteService,
                                PlanoService planoService) {
        this.assinaturaService = assinaturaService;
        this.clienteService = clienteService;
        this.planoService = planoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Assinatura criarAssinatura(@RequestBody AssinaturaDto assinaturaDto) {
        Cliente cliente = clienteService.buscarPorCPF(assinaturaDto.getClienteCpf());
        Plano plano = planoService.buscarPlanoPorId(assinaturaDto.getPlanoId());
        return assinaturaService.criarAssinatura(cliente, plano);
    }

    @PutMapping("/{id}/ativar")
    public void ativarAssinatura(@PathVariable Long id) {
        assinaturaService.ativarAssinatura(id);
    }

    @PutMapping("/{id}/desativar")
    public void desativarAssinatura(@PathVariable Long id) {
        assinaturaService.desativarAssinatura(id);
    }
}
