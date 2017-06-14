package model.obra;

public final class MaterialDigital extends Obra {

	private int anoPublicação;
	private TipoMaterialDigital tipo;
	
	public int getAnoPublicação() {
		return anoPublicação;
	}
	public void setAnoPublicação(int anoPublicação) {
		this.anoPublicação = anoPublicação;
	}
	public TipoMaterialDigital getTipo() {
		return tipo;
	}
	public void setTipo(TipoMaterialDigital tipo) {
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
	
	@Override
	public String toString(){
		return "Material Digital: " + getTipo() + " - " + getNome();
	}
	
}
