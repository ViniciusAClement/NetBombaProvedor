package main.dto;

import main.model.Assinatura;
import main.model.Endereco;

public class ClienteDto {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Assinatura assinatura;

    public ClienteDto() {
    }

    public ClienteDto(String nome, String cpf, Endereco endereco, Assinatura assinatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.assinatura = assinatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}
