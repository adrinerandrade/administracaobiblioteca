package test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import model.emprestimo.Emprestimo;
import model.emprestimo.EmprestimoController;
import model.obra.Livro;
import model.obra.MaterialDigital;
import model.obra.RepositorioObras;
import model.obra.Revista;
import model.obra.TipoMaterialDigital;
import model.usuario.Aluno;
import model.usuario.Professor;
import model.usuario.RepositorioUsuarios;

public class BilbiotecaTeste {

	@Test
	public void testInserindoCorretamenteUsuarios() {
		RepositorioUsuarios repositorio = RepositorioUsuarios.instance();

		String nomeAluno = "José";
		int matricula = 1;
		Aluno aluno = new Aluno(nomeAluno, matricula);
		repositorio.adicionaUsuario(aluno);

		String nomeProfessor = "Miguel";
		Date dataAdmissao = new Date();
		Professor professor = new Professor(nomeProfessor, dataAdmissao);

		repositorio.adicionaUsuario(professor);

		assertEquals(2, repositorio.getUsuarios().size());

		repositorio.remove(aluno);

		assertEquals(1, repositorio.getUsuarios().size());

	}

	@Test
	public void testInserindoCorretamenteObras() {
		RepositorioObras repositorio = RepositorioObras.instance();

		String nomeLivro = "O vento levou";
		String nomeAutor = "João";
		int anoPublicacao = 2001;
		int qtdDisponivelLivro = 1;
		int numeroEdicaoLivro = 1;

		Livro livro = new Livro(nomeLivro, qtdDisponivelLivro, nomeAutor, numeroEdicaoLivro, anoPublicacao);

		String nomeMd = "Como programar - aula 1";
		int qtdDisponivelMd = 1;
		int anoPublicacaoMd = 2002;
		TipoMaterialDigital tipoMd = TipoMaterialDigital.VIDEO;

		MaterialDigital materialDigital = new MaterialDigital(nomeMd, qtdDisponivelMd, anoPublicacaoMd, tipoMd);

		String nomeRevista = "Mundo Extranho";
		Date dataPublicacaoRevista = new Date();
		int edicaoRevista = 2;
		int qtdDisponivelRevista = 1;
		Revista revista = new Revista(nomeRevista, qtdDisponivelRevista, dataPublicacaoRevista, edicaoRevista);

		repositorio.addObra(revista);
		repositorio.addObra(livro);
		repositorio.addObra(materialDigital);

		assertEquals(3, repositorio.getObras().size());

		repositorio.remove(livro);

		assertEquals(2, repositorio.getObras().size());
	}

	@Test
	public void testEstaFazendoEmprestimo() {
		String nomeAluno = "José";
		int matricula = 1;
		Aluno aluno = new Aluno(nomeAluno, matricula);

		String nomeLivro = "O vento levou";
		String nomeAutor = "João";
		int anoPublicacao = 2001;
		int qtdDisponivelLivro = 1;
		int numeroEdicaoLivro = 1;
		Livro livro = new Livro(nomeLivro, qtdDisponivelLivro, nomeAutor, numeroEdicaoLivro, anoPublicacao);

		String nomeMd = "Como programar - aula 1";
		int qtdDisponivelMd = 1;
		int anoPublicacaoMd = 2002;
		TipoMaterialDigital tipoMd = TipoMaterialDigital.VIDEO;
		MaterialDigital materialDigital = new MaterialDigital(nomeMd, qtdDisponivelMd, anoPublicacaoMd, tipoMd);

		Date dataEmprestimo = new Date();

		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(aluno, livro, dataEmprestimo);
		ctrl.novoEmprestimo(aluno, materialDigital, dataEmprestimo);

		assertEquals(2, ctrl.listarEmprestimos().size());
		assertEquals(2, ctrl.listarEmprestimos(aluno).size());
	}

	@Test
	public void testValorDevolucao() throws ParseException {
		String nomeAluno = "José";
		int matricula = 1;
		Aluno aluno = new Aluno(nomeAluno, matricula);

		String nomeLivro = "O vento levou";
		String nomeAutor = "João";
		int anoPublicacao = 2001;
		int qtdDisponivelLivro = 1;
		int numeroEdicaoLivro = 1;
		Livro livro = new Livro(nomeLivro, qtdDisponivelLivro, nomeAutor, numeroEdicaoLivro, anoPublicacao);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataEmprestimo = format.parse("10/06/2017");
		Date dataDevolucao = format.parse("20/06/2017");

		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(aluno, livro, dataEmprestimo);

		Emprestimo emprestimo = ctrl.listarEmprestimos(aluno).get(0);

		double valor = ctrl.devolucao(emprestimo, dataDevolucao);
		assertEquals(10, valor, 2);
	}

}
