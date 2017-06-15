package model.obra;

public final class MaterialDigital extends Obra {

	private int anoPublicacao;
	private TipoMaterialDigital tipo;

	public MaterialDigital(String nome, int qtdeDisponivel, int anoPublicacao, TipoMaterialDigital tipo) {
		super(nome, qtdeDisponivel);
		setanoPublicacao(anoPublicacao);
		setTipo(tipo);
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setanoPublicacao(int anoPublicacao) {
		if (anoPublicacao < 0) {
			throw new RuntimeException("Ano de publica��o n�o pode ser negativo");
		}
		this.anoPublicacao = anoPublicacao;
	}

	public TipoMaterialDigital getTipo() {
		return tipo;
	}

	public void setTipo(TipoMaterialDigital tipo) {
		if (tipo == null) {
			throw new RuntimeException("� necess�rio informar um tipo do material digital");
		}
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoPublicacao;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		MaterialDigital other = (MaterialDigital) obj;
		if (anoPublicacao != other.anoPublicacao)
			return false;
		if (tipo != other.tipo)
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
		return "Material Digital: " + getTipo() + " - " + getNome();
	}
	
}
