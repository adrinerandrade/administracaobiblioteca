package model.obra;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public final class RepositorioObras {

	private static RepositorioObras instance = new RepositorioObras();

	private List<Obra> obras = new ArrayList<>();

	private RepositorioObras() {}

	public void addObra(Obra obra) {
		// Erro de compila��o de infer�ncia, n�o h� nada a se fazer sen�o um cast :(
		if (obras.contains(obra)) {
			throw new RuntimeException("Obra com os mesmo valores j� existente.");
		}
		obras.add(obra);
	}

	public void remove(Obra obra) {
		obras.remove(obra);
	}

	public List<Obra> filtrarPor(String nome) {
		return obras.stream() //
					.filter(o -> o.getNome().equals(nome))
					.collect(toList());
	}
	
	public List<Obra> getObras() {
		return obras.stream().collect(toList());
	}

	public static RepositorioObras instance() {
		return instance;
	}

}
