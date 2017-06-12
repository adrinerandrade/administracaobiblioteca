package model.usuario;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class RepositorioUsuarios {

	private static RepositorioUsuarios instance = new RepositorioUsuarios();

	private RepositorioUsuarios() {}

	private List<Aluno> alunos = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();

	public void adicionaAluno(Aluno aluno) {
		if (existeAluno(aluno)) {
			throw new RuntimeException(String.format("Aluno com n� de matr�cula %d j� existe.", aluno.getNumeroMatricula()));
		}
		alunos.add(aluno);
	}

	public void adicionaProfessor(Professor professor) {
		if (existeProfessor(professor)) {
			throw new RuntimeException(String.format("Professor '%s' com data de admiss�o %d j� existe.", professor.getNome(), professor.getDataAdmissao()));
		}
		professores.add(professor);
	}

	public void remove(Usuario usuario) {
		if (existeAluno(usuario)) {
			alunos.remove(usuario);
		} else if (existeProfessor(usuario)) {
			professores.remove(usuario);
		}
	}

	public List<Aluno> getAlunos() {
		return alunos.stream().collect(toList());
	}

	public List<Professor> getProfessores() {
		return professores.stream().collect(toList());
	}

	public List<Usuario> getTodosUsuarios() {
		return Stream.concat(alunos.stream(), professores.stream()).collect(toList());
	}

	public boolean existeAluno(Usuario usuario) {
		// Problema de infer�ncia. Sei que o tipo de Aluno � aceit�vel como Usuario, mas o compilador n�o identifica
		// este n�vel quando isso est� em um contexto gen�rico.
		return existeUsuario(alunos.stream().map(a -> (Usuario) a).collect(toList()), usuario);
	}

	public boolean existeProfessor(Usuario usuario) {
		// Problema de infer�ncia. Sei que o tipo de Professor � aceit�vel como Usuario, mas o compilador n�o identifica
		// este n�vel quando isso est� em um contexto gen�rico.
		return existeUsuario(professores.stream().map(a -> (Usuario) a).collect(toList()), usuario);
	}

	private boolean existeUsuario(List<Usuario> repositorio, Usuario usuario) {
		return repositorio.stream().anyMatch(u -> u.equals(usuario));
	}

	public static RepositorioUsuarios instance() {
		return instance;
	}

}
