package model.usuario;

import java.util.Date;

public final class Professor extends Usuario {

	private Date dataAdmissao;

	public Professor(String nome, Date dataAdmissao) {
		super(nome);
		setDataAdmissao(dataAdmissao);
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		if (dataAdmissao == null) {
			throw new RuntimeException("A data de admissão deve ser informada");
		}
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
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
		Professor other = (Professor) obj;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		return true;
	}

	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.PROFESSOR;
	}
	
	@Override
	public String toString(){
		return getTipo() + ": " + getNome();
	}
	
}
