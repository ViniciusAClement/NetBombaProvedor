package main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cpf;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    private Assinatura assinatura;

    protected Cliente() {}

    private Cliente(Builder builder){
        this.id = builder.id;
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.endereco = builder.endereco;
        this.assinatura = builder.assinatura;
    }

    public static class Builder{
        private Long id;
        private String nome;
        private String cpf;
        private Endereco endereco;
        private Assinatura assinatura;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public Builder endereco(Endereco endereco){
            this.endereco = endereco;
            return this;
        }

        public Builder assinatura(Assinatura assinatura){
            this.assinatura = assinatura;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();
            cliente.id = this.id;
            cliente.nome = this.nome;
            cliente.cpf = this.cpf;
            cliente.endereco = this.endereco;
            cliente.assinatura = this.assinatura;
            return cliente;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", " +
                "assinatura=" + assinatura + '}';
    }

}
