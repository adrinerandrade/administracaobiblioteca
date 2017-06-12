package model.usuario;

public abstract class Usuario {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract TipoUsuario getTipo();
	
}
