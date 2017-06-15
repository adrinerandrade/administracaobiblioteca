package model.usuario;

import org.apache.commons.lang3.StringUtils;

public abstract class Usuario {

	private String nome;
	
	protected Usuario(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (StringUtils.isBlank(nome)) {
			throw new RuntimeException("Nome não pode ser vazio.");
		}
		this.nome = nome;
	}
	
	public abstract TipoUsuario getTipo();
	
}
