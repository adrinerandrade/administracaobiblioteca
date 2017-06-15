package model.obra;

import java.util.Date;

public final class Revista extends Obra {

	private Date dataPublicação;
	private int numeroEdicao;

	public Revista(String nome, int qtdeDisponivel, Date dataPublicacao, int numeroEdicao) {
		super(nome, qtdeDisponivel);
		setDataPublicação(dataPublicacao);
		setNumeroEdicao(numeroEdicao);
	}

	public Date getDataPublicação() {
		return dataPublicação;
	}

	public void setDataPublicação(Date dataPublicacao) {
		if  (dataPublicacao == null) {
			throw new RuntimeException("É necessário informar uma data de publicação.");
		}
		this.dataPublicação = dataPublicacao;
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
		result = prime * result + ((dataPublicação == null) ? 0 : dataPublicação.hashCode());
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
		if (dataPublicação == null) {
			if (other.dataPublicação != null)
				return false;
		} else if (!dataPublicação.equals(other.dataPublicação))
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

}
