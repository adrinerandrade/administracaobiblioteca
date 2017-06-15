package model.obra;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public final class RepositorioObras {

	private static RepositorioObras instance = new RepositorioObras();

	private List<Obra> obras = new ArrayList<>();

	private RepositorioObras() {}

	public void addObra(Obra obra) {
		if (obras.contains(obra)) {
			throw new RuntimeException("Obra com os mesmo valores já existente.");
		}
		obras.add(obra);
	}

	public void remove(Obra obra) {
		obras.remove(obra);
	}

	public List<Obra> filtrarPor(String nome) {
		return obras.stream() //
					.filter(o -> o.getNome().contains(nome))
					.collect(toList());
	}
	
	public List<Obra> getObras() {
		return obras.stream().collect(toList());
	}

	public static RepositorioObras instance() {
		return instance;
	}

}
