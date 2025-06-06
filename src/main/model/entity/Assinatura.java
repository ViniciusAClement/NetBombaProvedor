package main.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assinatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @ManyToOne
    @JoinColumn(name = "plano_id")
	private Plano plano;
	private boolean status;
	
	public static class Builder{
		
		private int id;
		private Plano plano;
		private boolean status;
		
		public Builder id ( int id ) {
			this.id = id;
			return this;
		}
		
		public Builder plano ( Plano plano ) {
			this.plano = plano;
			return this;
		}
		
		public Builder status ( boolean status ) {
			this.status = status;
			return this;
		}
		
		public Assinatura build() {
			Assinatura assinatura = new Assinatura();
			
			assinatura.id = id;
			assinatura.plano = plano;
			assinatura.status = status;
			
			return assinatura;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Assinatura [id=" + id + ", plano=" + plano + ", status=" + status + "]";
	}
	
}
