package model.obra;

import java.util.Collections;
import java.util.List;

public class ResultadoConsultaObras {
	
	private List<Livro> livros = Collections.emptyList();
	private List<Revista> revistas = Collections.emptyList();
	private List<MaterialDigital> materiaisDigitais = Collections.emptyList();
	
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public List<Revista> getRevistas() {
		return revistas;
	}
	public void setRevistas(List<Revista> revistas) {
		this.revistas = revistas;
	}
	public List<MaterialDigital> getMateriaisDigitais() {
		return materiaisDigitais;
	}
	public void setMateriaisDigitais(List<MaterialDigital> materiaisDigitais) {
		this.materiaisDigitais = materiaisDigitais;
	}
	
}
