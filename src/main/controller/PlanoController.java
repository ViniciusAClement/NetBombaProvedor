package main.controller;

import main.dto.PlanoDto;
import main.model.Plano;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import main.service.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plano criar(@RequestBody PlanoDto planoDto) {
        return planoService.criarPlano(planoDto.getNome(), planoDto.getVelocidade(), planoDto.getPreco());
    }

    @GetMapping("/{id}")
    public Plano buscarPlano(@PathVariable Long id) {
        return planoService.buscarPlanoPorId(id);
    }
}
