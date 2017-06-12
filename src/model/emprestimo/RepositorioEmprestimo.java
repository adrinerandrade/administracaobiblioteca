package model.emprestimo;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import model.obra.Obra;
import model.obra.RepositorioObras;
import model.obra.ResultadoConsultaObras;
import model.usuario.Usuario;

final class RepositorioEmprestimo {

	private static RepositorioEmprestimo instance = new RepositorioEmprestimo();

	private RepositorioEmprestimo() {}
	
	private List<Emprestimo> emprestimos = new ArrayList<>();
	private RepositorioObras repositorioObras = RepositorioObras.instance();

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
	
	ResultadoConsultaObras getObrasEmprestadas(Usuario usuario) {
		List<Obra> obras = getEmprestimosUsuario(usuario).stream() //
			.map(Emprestimo::getObra) //
			.collect(toList());
		
		return repositorioObras.converter(obras);
	}
	
	static RepositorioEmprestimo instance() {
		return instance;
	}
	
	List<Emprestimo> getEmprestimos() {
		return emprestimos.stream().collect(toList());
	}

}
