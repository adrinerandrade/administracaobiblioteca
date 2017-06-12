package model.obra;

/**
 * Representa uma obra disonível na biblioteca.
 */
public abstract class Obra {
	
	private String nome;
	private int qtdeDisponivel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQtdeDisponivel() {
		return qtdeDisponivel;
	}
	public void setQtdeDisponivel(int exemplares) {
		this.qtdeDisponivel = exemplares;
	}
	
}