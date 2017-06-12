package model.obra;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class RepositorioObras {

	private static RepositorioObras instance = new RepositorioObras();

	private List<Livro> livros = new ArrayList<>();
	private List<Revista> revistas = new ArrayList<>();
	private List<MaterialDigital> materiaisDigitais = new ArrayList<>();

	private RepositorioObras() {}

	public void addLivro(Livro livro) {
		// Erro de compilação de inferência, não há nada a se fazer senão um cast :(
		if (existeLivro(livro)) {
			throw new RuntimeException("Livro com os mesmos valores já existente.");
		}
	}

	public void addRevista(Revista revista) {
		if (existeRevista(revista)) {
			throw new RuntimeException("Revista com os mesmos valores já existente.");
		}
	}

	public void addMaterialDigital(MaterialDigital materialDigital) {
		if (existeMaterialDigital(materialDigital)) {
			throw new RuntimeException("Material digital com os mesmos valores já existente.");
		}
	}

	public void remove(Obra obra) {
		if (existeLivro(obra)) {
			livros.remove(obra);
		} else if (existeRevista(obra)) {
			revistas.remove(obra);
		} else if (existeMaterialDigital(obra)) {
			materiaisDigitais.remove(obra);
		}
	}

	public ResultadoConsultaObras filtrarPor(String nome) {
		ResultadoConsultaObras resultado = new ResultadoConsultaObras();
		Predicate<Obra> filter = newFilterPredicate(nome);

		resultado.setLivros(livros.stream() //
				.filter(filter) //
				.collect(toList()));

		resultado.setRevistas(revistas.stream() //
				.filter(filter) //
				.collect(toList()));

		resultado.setMateriaisDigitais(materiaisDigitais.stream() //
				.filter(filter) //
				.collect(toList()));

		return resultado;
	}
	
	private static Predicate<Obra> newFilterPredicate(String filtro) {
		return obra -> obra.getNome().equals(filtro); 
	}
	
	public ResultadoConsultaObras converter(List<Obra> obras) {
		ResultadoConsultaObras resultado = new ResultadoConsultaObras();
		
		List<Livro> livrosEncontrados = new ArrayList<>();
		List<Revista> revistasEncontradas = new ArrayList<>();
		List<MaterialDigital> materiaisDigitaisEncontrados = new ArrayList<>();
		
		obras.forEach(o -> {
			if (existeLivro(o)) {
				livrosEncontrados.add((Livro) o);
			} else if (existeRevista(o)) {
				revistasEncontradas.add((Revista) o);
			} else if (existeMaterialDigital(o)) {
				materiaisDigitaisEncontrados.add((MaterialDigital) o);
			}
		});
		
		resultado.setLivros(livrosEncontrados);
		resultado.setRevistas(revistasEncontradas);
		resultado.setMateriaisDigitais(materiaisDigitaisEncontrados);
		
		return resultado;
	}

	private boolean existeLivro(Obra livro) {
		return existeObra(livros.stream().map(o -> (Obra) o).collect(toList()), livro);
	}

	private boolean existeRevista(Obra revista) {
		// Erro de compilação de inferência, não há nada a se fazer senão um cast :(
		return existeObra(revistas.stream().map(o -> (Obra) o).collect(toList()), revista);
	}

	private boolean existeMaterialDigital(Obra materialDigital) {
		// Erro de compilação de inferência, não há nada a se fazer senão um cast :(
		return existeObra(materiaisDigitais.stream().map(o -> (Obra) o).collect(toList()), materialDigital);
	}

	public List<Livro> getLivros() {
		return livros.stream().collect(toList());
	}

	public List<Revista> getRevistas() {
		return revistas.stream().collect(toList());
	}

	public List<MaterialDigital> getMateriaisDigitais() {
		return materiaisDigitais.stream().collect(toList());
	}

	public List<Obra> getTodasObras() {
		return Stream.concat(livros.stream(), Stream.concat(revistas.stream(), materiaisDigitais.stream())).collect(toList());
	}

	private boolean existeObra(List<Obra> repositorio, Obra obra) {
		return repositorio.contains(obra);
	}

	public static RepositorioObras instance() {
		return instance;
	}

}
