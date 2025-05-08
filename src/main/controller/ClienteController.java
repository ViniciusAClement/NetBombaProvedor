package main.controller;

import main.dto.ClienteDto;
import main.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import main.service.ClienteService;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody ClienteDto clienteDTO) {
        return clienteService.criarCliente(
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEndereco(),
                clienteDTO.getAssinatura()
        );
    }

    @GetMapping("/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarPorCPF(cpf);
    }
}
