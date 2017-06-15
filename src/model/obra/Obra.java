package model.obra;

import org.apache.commons.lang3.StringUtils;

/**
 * Representa uma obra dison�vel na biblioteca.
 */
public abstract class Obra {
	
	private String nome;
	private int qtdeDisponivel;
	
	protected Obra(String nome, int qtdeDisponivel) {
		setNome(nome);
		setQtdeDisponivel(qtdeDisponivel);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (StringUtils.isBlank(nome)) {
			throw new RuntimeException("Nome da obra n�o pode ser vazio.");
		}
		this.nome = nome;
	}
	
	public int getQtdeDisponivel() {
		return qtdeDisponivel;
	}
	public void setQtdeDisponivel(int exemplares) {
		if (qtdeDisponivel < 0) {
			throw new RuntimeException("Quantidade de obras n�o pode ser negativa.");
		}
		this.qtdeDisponivel = exemplares;
	}
	
}