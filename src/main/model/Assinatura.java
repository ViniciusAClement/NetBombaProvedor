package main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assinaturas")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    protected Assinatura() {}

    public Assinatura(Cliente cliente, Plano plano, boolean ativa) {
        this.cliente = cliente;
        this.plano = plano;
        this.ativa = ativa;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Plano getPlano() {
        return plano;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void ativar() {
        this.ativa = true;
    }

    public void desativar() {
        this.ativa = false;
    }
}
