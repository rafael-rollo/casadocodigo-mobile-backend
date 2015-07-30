package br.com.caelum.casadocodigo.builders;

import br.com.caelum.casadocodigo.modelo.Autor;

public class AutorBuiler {

	private Autor autor;

	public AutorBuiler novoAutor() {
		this.autor = new Autor();
		return this;
	}

	public Autor constroiAutor() {
		return this.autor;
	}

	public AutorBuiler setIdAutor(int id) {
		this.autor.setIdAutor(id);
		return this;
	}

	public AutorBuiler setNomeAutor(String nomeAutor) {
		this.autor.setNomeAutor(nomeAutor);
		return this;
	}

	public AutorBuiler setDetalhesAutor(String detalhesAutor) {
		this.autor.setDetalhesAutor(detalhesAutor);
		return this;
	}

	public AutorBuiler setImagemAutor(String imagemAutor) {
		this.autor.setImagemAutor(imagemAutor);
		return this;
	}

}