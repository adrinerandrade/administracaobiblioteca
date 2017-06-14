package model.emprestimo;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import model.obra.Obra;
import model.usuario.Usuario;

final class RepositorioEmprestimo {

	private static RepositorioEmprestimo instance = new RepositorioEmprestimo();

	private RepositorioEmprestimo() {}
	
	private List<Emprestimo> emprestimos = new ArrayList<>();

	void add(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	void remove(Emprestimo emprestimo) {
		emprestimos.remove(emprestimo);
	}
	
	List<Emprestimo> getEmprestimosUsuario(Usuario usuario) {
		return emprestimos.stream() //
				.filter(e -> e.getUsuario().equals(usuario)) //
				.collect(toList());
	}
	
	List<Obra> getObrasEmprestadas(Usuario usuario) {
		return getEmprestimosUsuario(usuario).stream() //
			.map(Emprestimo::getObra) //
			.collect(toList());
	}
	
	static RepositorioEmprestimo instance() {
		return instance;
	}
	
	List<Emprestimo> getEmprestimos() {
		return emprestimos.stream().collect(toList());
	}

}
