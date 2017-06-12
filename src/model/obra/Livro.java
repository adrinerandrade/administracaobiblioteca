package model.obra;

public final class Livro extends Obra {

	private String nomeAutor;
	private int numeroEdicao;
	private int anoPublicacao;
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public int getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(int numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
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
	
}
