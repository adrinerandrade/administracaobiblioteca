package model.obra;

import java.util.Date;

public final class Revista extends Obra {

	private Date dataPublicação;
	private int numeroEdicao;
	
	public Date getDataPublicação() {
		return dataPublicação;
	}
	public void setDataPublicação(Date dataPublicação) {
		this.dataPublicação = dataPublicação;
	}
	public int getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(int numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	
}
