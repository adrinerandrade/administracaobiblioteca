package model.emprestimo;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.obra.Obra;
import model.obra.ResultadoConsultaObras;
import model.usuario.EstrategiaNegocio;
import model.usuario.Usuario;

public final class EmprestimoController {

	private RepositorioEmprestimo repositorio = RepositorioEmprestimo.instance();
	
	public void novoEmprestimo(Usuario usuario, Obra obra, Date dataEmprestimo) {
		if (obra.getQtdeDisponivel() < 1) {
			throw new RuntimeException(String.format("Obra '%s' não está disponível no estoque."));
		}
		
		EstrategiaNegocio estrategiaNegocio = usuario.getTipo().getEstrategiaNegocio();
		long qtdeEmprestimos = repositorio.getEmprestimosUsuario(usuario).size();
		if (estrategiaNegocio.atingiuLimiteEmprestimos(qtdeEmprestimos)) {
			throw new RuntimeException(String.format("Usuário '%s' atingiu limite de empréstimos."));
		}
		
		obra.setQtdeDisponivel(obra.getQtdeDisponivel() - 1);
		
		repositorio.add(new Emprestimo(obra, usuario, dataEmprestimo));
	}
	
	public List<Emprestimo> listarEmprestimos(Usuario usuario) {
		return repositorio.getEmprestimosUsuario(usuario);
	}
	
	public ResultadoConsultaObras listarObrasEmprestadas(Usuario usuario) {
		return repositorio.getObrasEmprestadas(usuario);
	}
	
	public double devolucao(Emprestimo emprestimo, Date dataDevolucao) {
		if (!listarEmprestimos().contains(emprestimo)) {
			throw new RuntimeException("Empréstimo realizado não foi encontrado!");
		}
		
		repositorio.remove(emprestimo);
		
		long difference = dataDevolucao.getTime() - emprestimo.getDataEmprestimo().getTime();
		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
	}
	
	public List<Emprestimo> listarEmprestimos() {
		return repositorio.getEmprestimos();
	}
	
}
