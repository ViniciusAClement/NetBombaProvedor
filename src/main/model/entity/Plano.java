package main.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int megas;
	private BigDecimal preco;
		
	//builder da classe
	public static class Builder{
			
		private long id;
		private int megas;
		private BigDecimal preco;
			
		public Builder id ( long id ) {
			this.id = id;
			return this;
		}
			
		public Builder megas ( int megas ) {
			this.megas = megas;
			return this;
		}
			
		public Builder preco ( BigDecimal preco ) {
			this.preco = preco;
			return this;
		}
			
		public Plano builder() {
			Plano plano = new Plano();
			
			plano.megas = this.megas;
			plano.preco = this.preco;
				
			return plano;
		}
	}
		
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMegas() {
		return megas;
	}

	public void setMegas(int megas) {
		this.megas = megas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Plano [id=" + id + ", megas=" + megas + ", preco=" + preco + "]";
	}
}
