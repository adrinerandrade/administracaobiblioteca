package model.usuario;

public enum TipoUsuario {

	ALUNO(new EstrategiaNegocio() {
		
		@Override
		public boolean atingiuLimiteEmprestimos(long emprestimosAtuais) {
			return emprestimosAtuais >= 3;
		}
		
	}),
	PROFESSOR(new EstrategiaNegocio() {
		
		@Override
		public boolean atingiuLimiteEmprestimos(long emprestimosAtuais) {
			return emprestimosAtuais >= 5;
		}
		
	});
	
	private EstrategiaNegocio estrategia;
	
	private TipoUsuario(EstrategiaNegocio estrategia) {
		this.estrategia = estrategia;
	}
	
	public EstrategiaNegocio getEstrategiaNegocio() {
		return estrategia;
	}
	
}
