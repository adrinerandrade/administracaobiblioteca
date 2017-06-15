package model.obra;

import org.apache.commons.lang3.StringUtils;

public final class Livro extends Obra {

	private String nomeAutor;
	private int numeroEdicao;
	private int anoPublicacao;

	public Livro(String nome, int qtdeDisponivel, String nomeAutor, int numeroEdicao, int anoPublicacao) {
		super(nomeAutor, qtdeDisponivel);
		setNome(nomeAutor);
		setNumeroEdicao(numeroEdicao);
		setAnoPublicacao(anoPublicacao);
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		if (StringUtils.isBlank(nomeAutor)) {
			throw new RuntimeException("Nome do autor não pode ser vazio.");
		}
		this.nomeAutor = nomeAutor;
	}

	public int getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao(int numeroEdicao) {
		if (numeroEdicao < 0) {
			throw new RuntimeException("Numero da edição não pode ser negativo.");
		}
		this.numeroEdicao = numeroEdicao;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		if (anoPublicacao < 0) {
			throw new RuntimeException("Ano de publicação não pode ser negativo.");
		}
		this.anoPublicacao = anoPublicacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoPublicacao;
		result = prime * result + ((nomeAutor == null) ? 0 : nomeAutor.hashCode());
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
		Livro other = (Livro) obj;
		if (anoPublicacao != other.anoPublicacao)
			return false;
		if (nomeAutor == null) {
			if (other.nomeAutor != null)
				return false;
		} else if (!nomeAutor.equals(other.nomeAutor))
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
		return "Livro: " + getNome(); 
	}
	
}
