package model.obra;

import java.util.Date;

public final class Revista extends Obra {

	private Date dataPublica��o;
	private int numeroEdicao;
	
	public Date getDataPublica��o() {
		return dataPublica��o;
	}
	public void setDataPublica��o(Date dataPublica��o) {
		this.dataPublica��o = dataPublica��o;
	}
	public int getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(int numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	
}
