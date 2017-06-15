package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import model.obra.Livro;
import model.usuario.Aluno;
import model.usuario.Professor;
import model.usuario.RepositorioUsuarios;

public class BilbiotecaTeste {

	@Test
	public void testInserindoCorretamenteUsuarios() {
//		RepositorioUsuarios repositorio = RepositorioUsuarios.instance();
//		
//		Aluno aluno = new Aluno();
//		aluno.setNome("Jos�");
//		aluno.setNumeroMatricula(1);
//		repositorio.adicionaAluno(aluno);
//		
//		Professor professor = new Professor();
//		professor.setNome("Miguel");
//		
//		professor.setDataAdmissao(newDate(10, 15));
//		repositorio.adicionaProfessor(professor);
//		
//		List<Aluno> alunos = repositorio.getAlunos();
//		assertEquals(1, alunos.size());
//		assertEquals(aluno, alunos.get(0));
//		
//		List<Professor> professores = repositorio.getProfessores();
//		assertEquals(1, professores.size());
//		assertEquals(professor, professores.get(0));
	}
	
	@Test
	public void testInserindoCorretamenteObras() {
//		RepositorioObras repositorio = RepositorioObras.instance();
//		
//		Livro livro_1 = new Livro();
//		livro_1.setNome("O vento levou");
//		livro_1.setNomeAutor("Jo�o Maria Jos�");
//		livro_1.setAnoPublicacao(2001);
//		livro_1.setNumeroEdicao(1);
//		livro_1.setQtdeDisponivel(1);
//		
//		Livro livro_2 = new Livro();
//		livro_2.setNome("Levou o vento");
//		livro_2.setNomeAutor("Jos� Maria Jo�o");
//		livro_2.setAnoPublicacao(2002);
//		livro_2.setNumeroEdicao(2);
//		livro_2.setQtdeDisponivel(1);
//		
//		repositorio.addLivro(livro_1);
//		repositorio.addLivro(livro_2);
//		
//		MaterialDigital materialDigital = new MaterialDigital();
//		materialDigital.setNome("");
//		materialDigital.setQtdeDisponivel(1);
//		materialDigital.setAnoPublica��o(2005);
//		materialDigital.setTipo(TipoMaterialDigital.AUDIO);
//		
//		repositorio.addMaterialDigital(materialDigital);
//		
//		Revista revista = new Revista();
//		revista.setNome("Fuxico");
//		revista.setDataPublica��o(newDate(10, 15));
//		revista.setNumeroEdicao(1);
//		revista.setQtdeDisponivel(1);
//		
//		repositorio.addRevista(revista);
//		
//		List<Livro> livros = repositorio.getLivros();
//		assertEquals(2, livros.size());
//		assertEquals(livro_1, livros.get(0));
//		assertEquals(livro_2, livros.get(1));
//		
//		List<MaterialDigital> materiaisDigitais = repositorio.getMateriaisDigitais();
//		assertEquals(1, materiaisDigitais.size());
//		assertEquals(materialDigital, materiaisDigitais.get(0));
//		
//		List<Revista> revistas = repositorio.getRevistas();
//		assertEquals(1, revistas.size());
//		assertEquals(revista, revistas.get(0));
	}
	
	public void testEstaFazendoEmprestimo() {
//		Livro livro = new Livro();
//		livro.setNome("Vai dar boa");
//		livro.setNomeAutor("Jo�o Migu�");
//		livro.setAnoPublicacao(2001);
//		livro.setNumeroEdicao(1);
//		livro.setQtdeDisponivel(3);
//		
//		Aluno aluno = new Aluno();
//		aluno.setNome("Guilhermino");
//		aluno.setNumeroMatricula(2002);
//		
//		Professor professor = new Professor();
//		professor.setNome("Jagun�o");
//		professor.setDataAdmissao(newDate(5,5));
		
//		RepositorioUsuarios usuarios = RepositorioUsuarios.instance();
//		usuarios.adicionaAluno(aluno);
//		usuarios.adicionaProfessor(professor);
	}
	
	private Date newDate(int mes, int dia) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, mes, dia);
		return calendar.getTime();
	}
	
}
