package model.usuario;

public final class Aluno extends Usuario {

	private int numeroMatricula;

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroMatricula;
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
		Aluno other = (Aluno) obj;
		if (numeroMatricula != other.numeroMatricula)
			return false;
		return true;
	}

	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.ALUNO;
	}
	
}