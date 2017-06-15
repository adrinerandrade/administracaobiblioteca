package model.obra;

import java.util.Date;

public final class Revista extends Obra {

	private Date dataPublicacao;
	private int numeroEdicao;

	public Revista(String nome, int qtdeDisponivel, Date dataPublicacao, int numeroEdicao) {
		super(nome, qtdeDisponivel);
		setDataPublicacao(dataPublicacao);
		setNumeroEdicao(numeroEdicao);
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		if  (dataPublicacao == null) {
			throw new RuntimeException("É necessário informar uma data de publicação.");
		}
		this.dataPublicacao = dataPublicacao;
	}

	public int getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao(int numeroEdicao) {
		if (numeroEdicao < 0) {
			throw new RuntimeException("Número da edição não pode ser negativo");
		}
		this.numeroEdicao = numeroEdicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
		result = prime * result + numeroEdicao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		if (dataPublicacao == null) {
			if (other.dataPublicacao != null)
				return false;
		} else if (!dataPublicacao.equals(other.dataPublicacao))
			return false;
		if (numeroEdicao != other.numeroEdicao)
			return false;
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "Revista: " + getNome() + " - Ed." + getNumeroEdicao(); 
	}
	
}
