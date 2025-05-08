package main.service;

import main.model.Assinatura;
import main.model.Cliente;
import main.model.Endereco;
import main.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(String nome, String cpf, Endereco endereco, Assinatura assinatura) {
        Cliente cliente = new Cliente.Builder()
                .nome(nome)
                .cpf(cpf)
                .endereco(endereco)
                .assinatura(assinatura)
                .build();

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorCPF(String cpf) {
        return clienteRepository.encontrarPorCpf(String.valueOf(cpf)).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
