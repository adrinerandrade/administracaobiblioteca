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
	
}
