package main.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String rua;
	private int numero;
		
	//Builder da classe Endereco
	public static class Builder{
			
		private long id;
		private String rua;
		private int numero;
			
		public Builder id ( long id ) {
			this.id = id;
			return this;
		}
		public Builder rua ( String rua ) {
			this.rua = rua;
			return this;
		}
			
		public Builder numero ( int numero ) {
			this.numero = numero;
			return this;
		}
			
		public Endereco build () {
			Endereco endereco = new Endereco();
				
			endereco.id = this.id;
			endereco.rua = this.rua;
			endereco.numero = this.numero;
				
			return endereco;
		}
	}
		//Getters e Setters da Classe Endereco
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + "]";
	}	
}
