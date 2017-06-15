package model.obra;

import java.util.Date;

public final class Revista extends Obra {

	private Date dataPublica��o;
	private int numeroEdicao;

	public Revista(String nome, int qtdeDisponivel, Date dataPublicacao, int numeroEdicao) {
		super(nome, qtdeDisponivel);
		setDataPublica��o(dataPublicacao);
		setNumeroEdicao(numeroEdicao);
	}

	public Date getDataPublica��o() {
		return dataPublica��o;
	}

	public void setDataPublica��o(Date dataPublicacao) {
		if  (dataPublicacao == null) {
			throw new RuntimeException("� necess�rio informar uma data de publica��o.");
		}
		this.dataPublica��o = dataPublicacao;
	}

	public int getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao(int numeroEdicao) {
		if (numeroEdicao < 0) {
			throw new RuntimeException("N�mero da edi��o n�o pode ser negativo");
		}
		this.numeroEdicao = numeroEdicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPublica��o == null) ? 0 : dataPublica��o.hashCode());
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
		if (dataPublica��o == null) {
			if (other.dataPublica��o != null)
				return false;
		} else if (!dataPublica��o.equals(other.dataPublica��o))
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
