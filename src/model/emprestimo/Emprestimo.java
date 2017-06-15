package model.emprestimo;

import java.util.Date;

import model.obra.Obra;
import model.usuario.Usuario;

public class Emprestimo {

	private Obra obra;
	private Usuario usuario;
	private Date dataEmprestimo;

	public Emprestimo(Obra obra, Usuario usuario, Date dataEmprestimo) {
		if (obra == null) {
			throw new RuntimeException("Uma obra deve ser informada.");
		}
		if (usuario == null) {
			throw new RuntimeException("Um usuário deve ser informado.");
		}
		if (dataEmprestimo == null) {
			throw new RuntimeException("Uma data inicial do empréstimo deve ser informada.");
		}
		this.obra = obra;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Obra getObra() {
		return obra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((obra == null) ? 0 : obra.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (obra == null) {
			if (other.obra != null)
				return false;
		} else if (!obra.equals(other.obra))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
