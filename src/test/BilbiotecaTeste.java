package test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import org.junit.Before;
import org.junit.Test;

public class BilbiotecaTeste {

	@Before
	public void limparRepositorios() {
		RepositorioUsuarios usuarios = RepositorioUsuarios.instance();
		usuarios.getUsuarios().stream().forEach(usuarios::remove);
		
		RepositorioObras obras = RepositorioObras.instance();
		obras.getObras().stream().forEach(obras::remove);
		
		EmprestimoController emprestimos = new EmprestimoController();
		emprestimos.listarEmprestimos().forEach(e -> emprestimos.devolucao(e, new Date()));
	}
	
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

	@Test(expected = RuntimeException.class)
	public void testEstaFazendoEmprestimo2() {
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

		String nomeMd2 = "Aprenda a falar ingles";
		int qtdDisponivelMd2 = 1;
		int anoPublicacaoMd2 = 2002;
		TipoMaterialDigital tipoMd2 = TipoMaterialDigital.AUDIO;
		MaterialDigital materialDigital2 = new MaterialDigital(nomeMd2, qtdDisponivelMd2, anoPublicacaoMd2, tipoMd2);

		String nomeRevista = "Mundo Extranho";
		Date dataPublicacaoRevista = new Date();
		int edicaoRevista = 2;
		int qtdDisponivelRevista = 1;
		Revista revista = new Revista(nomeRevista, qtdDisponivelRevista, dataPublicacaoRevista, edicaoRevista);

		Date dataEmprestimo = new Date();

		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(aluno, livro, dataEmprestimo);
		ctrl.novoEmprestimo(aluno, revista, dataEmprestimo);
		ctrl.novoEmprestimo(aluno, materialDigital, dataEmprestimo);
		ctrl.novoEmprestimo(aluno, materialDigital2, dataEmprestimo);
	}

	@Test(expected = RuntimeException.class)
	public void testEstaFazendoEmprestimo3() {
		String nomeProfessor = "Miguel";
		Date dataAdmissao = new Date();
		Professor professor = new Professor(nomeProfessor, dataAdmissao);

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

		String nomeMd2 = "Aprenda a falar ingles";
		int qtdDisponivelMd2 = 1;
		int anoPublicacaoMd2 = 2002;
		TipoMaterialDigital tipoMd2 = TipoMaterialDigital.AUDIO;
		MaterialDigital materialDigital2 = new MaterialDigital(nomeMd2, qtdDisponivelMd2, anoPublicacaoMd2, tipoMd2);

		String nomeRevista = "Mundo Extranho";
		Date dataPublicacaoRevista = new Date();
		int edicaoRevista = 2;
		int qtdDisponivelRevista = 1;
		Revista revista = new Revista(nomeRevista, qtdDisponivelRevista, dataPublicacaoRevista, edicaoRevista);

		String nomeRevista2 = "Fuxico";
		Date dataPublicacaoRevista2 = new Date();
		int edicaoRevista2 = 2;
		int qtdDisponivelRevista2 = 1;
		Revista revista2 = new Revista(nomeRevista2, qtdDisponivelRevista2, dataPublicacaoRevista2, edicaoRevista2);

		String nomeRevista3 = "Capricho";
		Date dataPublicacaoRevista3 = new Date();
		int edicaoRevista3 = 2;
		int qtdDisponivelRevista3 = 1;
		Revista revista3 = new Revista(nomeRevista3, qtdDisponivelRevista3, dataPublicacaoRevista3, edicaoRevista3);

		Date dataEmprestimo = new Date();

		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(professor, livro, dataEmprestimo);
		ctrl.novoEmprestimo(professor, revista, dataEmprestimo);
		ctrl.novoEmprestimo(professor, revista2, dataEmprestimo);
		ctrl.novoEmprestimo(professor, revista3, dataEmprestimo);
		ctrl.novoEmprestimo(professor, materialDigital, dataEmprestimo);
		ctrl.novoEmprestimo(professor, materialDigital2, dataEmprestimo);
	}

	@Test(expected = RuntimeException.class)
	public void testEstaFazendoEmprestimo4() {
		String nomeProfessor = "Miguel";
		Date dataAdmissao = new Date();
		Professor professor = new Professor(nomeProfessor, dataAdmissao);

		String nomeAluno = "José";
		int matricula = 1;
		Aluno aluno = new Aluno(nomeAluno, matricula);

		String nomeLivro = "O vento levou";
		String nomeAutor = "João";
		int anoPublicacao = 2001;
		int qtdDisponivelLivro = 1;
		int numeroEdicaoLivro = 1;
		Livro livro = new Livro(nomeLivro, qtdDisponivelLivro, nomeAutor, numeroEdicaoLivro, anoPublicacao);

		Date dataEmprestimo = new Date();

		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(professor, livro, dataEmprestimo);
		ctrl.novoEmprestimo(aluno, livro, dataEmprestimo);
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
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataEmprestimo = format.parse("10/06/2017");
		Date dataDevolucao = format.parse("20/06/2017");
				
		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(aluno, livro, dataEmprestimo);

		Emprestimo emprestimo = ctrl.listarEmprestimos(aluno).get(0);

		double valor = ctrl.devolucao(emprestimo, dataDevolucao);
		assertEquals(10, valor, 2);
	}

	@Test(expected = RuntimeException.class)
	public void testValorDevolucao2() throws ParseException {
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
		Date dataDevolucao = format.parse("05/06/2017");

		EmprestimoController ctrl = new EmprestimoController();
		ctrl.novoEmprestimo(aluno, livro, dataEmprestimo);

		Emprestimo emprestimo = ctrl.listarEmprestimos(aluno).get(0);

		ctrl.devolucao(emprestimo, dataDevolucao);
	}

	@Test(expected = RuntimeException.class)
	public void testConstrutorLivro() {
		String nomeLivro = "O vento levou";
		String nomeAutor = "João";
		int anoPublicacao = 2001;
		int qtdDisponivelLivro = 1;
		int numeroEdicaoLivro = -1;
		new Livro(nomeLivro, qtdDisponivelLivro, nomeAutor, numeroEdicaoLivro, anoPublicacao);
	}

	@Test(expected = RuntimeException.class)
	public void testContrutorMaterialDigital() {
		String nomeMd = "Como programar - aula 1";
		int qtdDisponivelMd = 1;
		int anoPublicacaoMd = -2002;
		TipoMaterialDigital tipoMd = TipoMaterialDigital.VIDEO;
		new MaterialDigital(nomeMd, qtdDisponivelMd, anoPublicacaoMd, tipoMd);
	}

	@Test(expected = RuntimeException.class)
	public void testContrutorRevista() {
		String nomeRevista = "Mundo Extranho";
		Date dataPublicacaoRevista = new Date();
		int edicaoRevista = -2;
		int qtdDisponivelRevista = 1;
		new Revista(nomeRevista, qtdDisponivelRevista, dataPublicacaoRevista, edicaoRevista);
	}

	@Test(expected = RuntimeException.class)
	public void testContrutorProfessor() {
		String nomeProfessor = "Miguel";
		Date dataAdmissao = null;
		new Professor(nomeProfessor, dataAdmissao);
	}

	@Test(expected = RuntimeException.class)
	public void testContrutorAluno() {
		String nomeAluno = "José";
		int matricula = -1;
		new Aluno(nomeAluno, matricula);
	}

}
