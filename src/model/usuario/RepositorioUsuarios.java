package model.usuario;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public final class RepositorioUsuarios {

	private static RepositorioUsuarios instance = new RepositorioUsuarios();

	private RepositorioUsuarios() {}

	private List<Usuario> usuarios = new ArrayList<>();

	public void adicionaAluno(Usuario usuario) {
		if (usuarios.contains(usuario)) {
			throw new RuntimeException(String.format("Usuario '%s' já existente.", usuario.getNome()));
		}
		usuarios.add(usuario);
	}

	public void remove(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios.stream().collect(toList());
	}
	
	public static RepositorioUsuarios instance() {
		return instance;
	}

}
