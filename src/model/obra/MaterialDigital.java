package model.obra;

public final class MaterialDigital extends Obra {

	private int anoPublicação;
	private TipoMaterialDigital tipo;

	public MaterialDigital(String nome, int qtdeDisponivel, int anoPublicacao, TipoMaterialDigital tipo) {
		super(nome, qtdeDisponivel);
		setAnoPublicação(anoPublicacao);
		setTipo(tipo);
	}

	public int getAnoPublicação() {
		return anoPublicação;
	}

	public void setAnoPublicação(int anoPublicacao) {
		if (anoPublicacao < 0) {
			throw new RuntimeException("Ano de publicação não pode ser negativo");
		}
		this.anoPublicação = anoPublicacao;
	}

	public TipoMaterialDigital getTipo() {
		return tipo;
	}

	public void setTipo(TipoMaterialDigital tipo) {
		if (tipo == null) {
			throw new RuntimeException("É necessário informar um tipo do material digital");
		}
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoPublicação;
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
		if (anoPublicação != other.anoPublicação)
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

}
